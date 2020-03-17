package com.hx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hx.dao.AccessDao;
import com.hx.dao.CementLastcountMapper;
import com.hx.dao.CementStrengthMapper;
import com.hx.entity.CementLastcount;
import com.hx.entity.CementStrength;
import com.hx.entity.CementStrengthExample;
import com.hx.service.CementStrengthService;
import com.hx.utils.DateUtil;
import com.hx.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service
@Transactional
public class CementStrengthServiceImpl implements CementStrengthService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    CementStrengthMapper cementStrengthMapper;
    @Autowired
    CementLastcountMapper cementLastcountMapper;
    @Autowired
    AccessDao accessDao;
    @Autowired
    CementLastcount cementLastcount;


    @Override
    public PageInfo<CementStrength> findByPage(Integer pageNum, Integer pageSize,Integer status,String sampleNo) {
        CementStrengthExample example = new CementStrengthExample();
        CementStrengthExample.Criteria criteria = example.createCriteria();
        if (null!=status){
            criteria.andStatusEqualTo(status);
        }
        if (null!=sampleNo&&StringUtils.isNotBlank(sampleNo)){
            criteria.andSampleNoLike("%"+sampleNo+"%");
        }
        String orderBy = "createTime desc ";  //排序字段 排序方法 降序
        PageHelper.startPage(pageNum,pageSize,orderBy);//第1步，设置分页的参数 pageNum 当前页 pageSize 每页的数量
        List<CementStrength> list = cementStrengthMapper.selectByExample(example);//第2步：查询的集合
        PageInfo<CementStrength> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public boolean dataSynchronize() {
        try {
            CementLastcount lastCount = cementLastcountMapper.getLastCount();
            if (lastCount == null){
                lastCount = new CementLastcount(0);
            }
            //同步匀加荷压力数据
            //从mdb读取数据
            logger.info("开始同步匀加荷iso表数据......");
            List<CementStrength> lists = null;
            try {
                lists = accessDao.resolverMdb();
            } catch (Exception e) {
                logger.error("匀加荷iso表数据......",e);
                return false;
            }
            if (lists!=null){
                logger.info("lists.size:"+lists.size());
            }
            saveOrUpdate(lists);

            //更新CementLastcount
            if (lists!=null&&lists.size()>0){
                lastCount.setCementcount(lists.get(lists.size() - 1).getSampleID());
            }

            if (lastCount.getId()!=null){
                //设置新记录并更新
                cementLastcountMapper.updateByPrimaryKeySelective(lastCount);
            }else {
                //插入一条新记录
                cementLastcountMapper.insert(lastCount);
            }

        }catch (Exception e){
            logger.error("系统错误",e);
            return false;
        }
        return true;
    }
    @Override
    public boolean saveOrUpdate(List<CementStrength> lists) {
        if (lists == null){
            return true;
        }
        String keyNo = null;
        String duration1 = null;
        for (CementStrength data:lists){
            //样品编号不存在或为空 数据不在上传到MySQL
            keyNo = data.getSampleNo();
            duration1 = data.getDuration();
            if (keyNo == null || "".equals(keyNo)||duration1 == null || ".".equals(duration1)) {
                continue;
            }
           // 判断样品编号期龄相同 在表中是否存在
            int count = cementStrengthMapper.selectCountBySampleNo(keyNo,duration1);
            if (count>0){
                //样品编号记录和期龄相同，执行更新操作
                cementStrengthMapper.updateBySampleNoSelective(keyNo,data);
                logger.info("更新数据...keyNo【\" + keyNo + \"】");
            }else {
                //样品编号记录不存在,执行插入操作
                data.setCreateTime(DateUtil.StrToDate(data.getSampleTime()));
                String duration = data.getDuration();
                boolean flag;
                //期龄等于1时，抗折可以没有数据
                if (duration.equals("1")){
                    flag = StringUtil.isEmptyOrTrim(data.getSampleNo())
                            ||StringUtil.isEmptyOrTrim(data.getPressure1())||StringUtil.isEmptyOrTrim(data.getPressure2())|| StringUtil.isEmptyOrTrim(data.getPressure3());
                }else {
                    flag = StringUtil.isEmptyOrTrim(data.getSampleNo())
                            ||StringUtil.isEmptyOrTrim(data.getFlexure1())|| StringUtil.isEmptyOrTrim(data.getFlexure2()) || StringUtil.isEmptyOrTrim(data.getFlexure3())
                            ||StringUtil.isEmptyOrTrim(data.getPressure1())||StringUtil.isEmptyOrTrim(data.getPressure2())|| StringUtil.isEmptyOrTrim(data.getPressure3());
                }
                boolean flag1 = !duration.equals("1") && !duration.equals("3") && !duration.equals("7") && !duration.equals("28") && !duration.equals("90") && !duration.equals("180");
                if (flag||flag1){
                    data.setStatus(0);// 0 异常 1 未上传 2 已上传
                }else {
                    data.setStatus(1);// 0 异常 1 未上传 2 已上传
                }
                cementStrengthMapper.insertSelective(data);
                logger.info("插入数据...keyNo【" + keyNo + "】");
            }
        }
        return true;

    }

    @Override
    public boolean createFile(String[] ids) {
        CementStrength cementStrength = null;
        for (int i = 0;i<ids.length;i++){
            try {
                logger.debug("id:" + ids[i]);
                cementStrength = cementStrengthMapper.selectByPrimaryKey(Integer.valueOf(ids[i]));
                logger.info("生成文件:" +cementStrength.toString());
                accessDao.createFile(cementStrength);
                cementStrengthMapper.updateStatusById(ids[i]);
            }catch (Exception e){
                logger.error("生成文件出错...",e);
                return false;
            }
        }
        return true;
    }
}
