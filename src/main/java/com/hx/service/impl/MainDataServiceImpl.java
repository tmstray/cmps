package com.hx.service.impl;

import com.hx.config.AccessConfig;
import com.hx.config.Constants;
import com.hx.dao.AccessDao;
import com.hx.dao.LastCountMapper;
import com.hx.dao.MainDataMapper;
import com.hx.entity.LastCount;
import com.hx.entity.MainData;
import com.hx.model.MainDataModel;
import com.hx.service.MainDataService;
import com.hx.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * @program: eqds-ms
 * @description:
 * @author: yangyue
 * @create: 2019/12/19 11:27
 */
@Service
@Transactional
public class MainDataServiceImpl<saveOrUpdate> implements MainDataService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    MainDataMapper mainDataDao;

    @Autowired
    AccessDao accessDao;

    @Autowired
    AccessConfig accessConfig;

    @Autowired
    LastCountMapper lastCountDao;

    @Override
    public List<MainData> findByPage(MainDataModel model) {
        return mainDataDao.findByPage(model);
    }

    @Override
    public boolean dataSynchronize(boolean simpled) {
        try {
            LastCount lastCount = lastCountDao.getLastCount();
            if (lastCount == null) {
                lastCount = new LastCount(0, 0, 0);
            }
            //同步工业分析仪数据
            //从mdb读取数据
            logger.info("开始同步工业分析仪 TValue 表数据...");
            HashMap<String, Object> gMap = new HashMap<String, Object>();
            gMap.put("password", accessConfig.getGpassword());
            gMap.put("tableFlag", 1);
            gMap.put("mdbPath", accessConfig.getGpath());
            gMap.put("sql", "select * from TValue where Id > ? order by Id asc");
            gMap.put("condition", lastCount.getGcount());
            List<MainData> glist = null;
            try {
                glist = accessDao.resolverMdb(gMap);
            } catch (Exception e) {
                logger.error("工业分析仪TValue表数据同步出错...", e);
            }

            //同步定硫仪数据
            logger.info("开始同步定硫仪 stdata 表数据...");
            HashMap<String, Object> yMap = new HashMap<String, Object>();
            yMap.put("password", accessConfig.getYpassword());
            yMap.put("tableFlag", 2);
            yMap.put("mdbPath", accessConfig.getYpath());
            yMap.put("sql", "select * from stdata where ID > ? order by ID asc");
            yMap.put("condition", lastCount.getYcount());
            List<MainData> ylist = null;
            try {
                ylist = accessDao.resolverMdb(yMap);
            } catch (Exception e) {
                logger.error("定硫仪stdata表数据同步出错", e);
            }

            //同步量热仪数据
            List<MainData> llist = null;
            if (!simpled) {
                logger.info("开始同步量热仪 发热量数据 表数据...");
                HashMap<String, Object> lMap = new HashMap<String, Object>();
                lMap.put("password", accessConfig.getLpassword());
                lMap.put("tableFlag", 3);
                lMap.put("mdbPath", accessConfig.getLpath());
                lMap.put("sql", "select * from 发热量数据 where 序号 > ? order by 序号 asc");
                lMap.put("condition", lastCount.getLcount());
                try {
                    llist = accessDao.resolverMdb(lMap);
                } catch (Exception e) {
                    logger.error("量热仪发热量数据表数据同步出错", e);
                }
            }

            //输出判断
            if (glist != null) {
                logger.info("glist.size:" + glist.size());
            }
            if (ylist != null) {
                logger.info("ylist.size:" + ylist.size());
            }
            if (llist != null) {
                logger.info("llist.size:" + llist.size());
            }

            //将数据插入或者更新到数据库
            saveOrUpdate(glist, simpled);
            saveOrUpdate(ylist, simpled);
            saveOrUpdate(llist, simpled);

            //如果没有获取到更新数据则不更新计数表
            LastCount newCount = new LastCount();
            if ((glist != null && glist.size() > 0) ||
                    (ylist != null && ylist.size() > 0) ||
                    (llist != null && llist.size() > 0)) {
                //更新最大记录配置表
                if (glist != null && glist.size() > 0) {
                    newCount.setGcount(glist.get(glist.size() - 1).getGid());
                }
                if (ylist != null && ylist.size() > 0) {
                    newCount.setYcount(ylist.get(ylist.size() - 1).getYid());
                }
                if (llist != null && llist.size() > 0) {
                    newCount.setLcount(llist.get(llist.size() - 1).getLid());
                }
                if (lastCount.getId() != null) {
                    //设置新记录并更新
                    newCount.setId(lastCount.getId());
                    lastCountDao.updateSelectiveById(newCount);
                } else {
                    //插入一条新纪录
                    lastCountDao.insert(newCount);
                }
            }
        } catch (Exception e) {
            logger.error("系统错误", e);
            return false;
        }
        return true;
    }

    @Override
    public boolean saveOrUpdate(List<MainData> list, boolean simpled) {
        if (list == null) {
            return true;
        }
        String keyNo = null;
        try {

            for (MainData data : list) {
                keyNo = (data.getSamplenog() == null ? data.getSamplenoy() : data.getSamplenog()) == null ?
                        data.getSamplenol() : (data.getSamplenog() == null ? data.getSamplenoy() : data.getSamplenog());
                if (keyNo == null || "".equals(keyNo)) {
                    continue;
                }
                //判断样品编号在表中是否存在
                int count = mainDataDao.selectCountBySampleNo(keyNo);
                if (count > 0) {
                    //样品编号记录存在,执行更新操作
                    mainDataDao.updateBySampleNoSelective(keyNo, data);
                    logger.info("更新数据...keyNo【" + keyNo + "】");
                    //更新完毕后检查数据完整性
                    MainData checkData = null;
                    if (simpled) {
                        checkData = mainDataDao.checkBySampleNoForSimpled(keyNo);
                    } else {
                        checkData = mainDataDao.checkBySampleNo(keyNo);
                    }
                    if (checkData != null) {
                        //更新数据后新数据处于异常状态
                        MainData resData = null;
                        if (simpled && (checkData.getKeed() == null || checkData.getDrags() == null || checkData.getDrags().trim().equals(""))) {
                            //异常情况不计算并将之前计算结果更新为空
                            resData = new MainData();
                            resData.setId(checkData.getId());
                            resData.setStatus(0);//设置状态为异常
                            mainDataDao.clearResultById(resData);
                        } else {
                            //更新计算结果和状态为未上传
                            resData = calculateResult(checkData, simpled);
                            resData.setId(checkData.getId());
                            resData.setStatus(1);
                            mainDataDao.updateByPrimaryKeySelective(resData);
                        }
                    }
                } else {
                    //样品编号记录不存在,执行插入操作
                    data.setId(StringUtil.getUuid());
                    data.setStatus(0);//设置状态为不完整(异常)数据
                    if (simpled && data.getSamplenog() != null && data.getKeed() != null
                            && data.getDrags() != null && !(data.getDrags().trim().equals(""))) {
                        data.setStatus(1);//此场景下没有定硫仪数据也算正常数据
                        //正常数据计算
                        MainData resData = calculateResult(data, simpled);
                        data.setFcad(resData.getFcad());
                        data.setQgrd(resData.getQgrd());
                        data.setQnetar(resData.getQnetar());
                        data.setQnetad(resData.getQnetad());
                    }
                    mainDataDao.insertSelective(data);
                    logger.info("插入数据...keyNo【" + keyNo + "】");
                }
            }
        } catch (Exception e) {
            logger.error("系统错误", e);
            return false;
        }
        return true;
    }

    @Override
    public boolean createFile(String[] ids, boolean simpled) {
        MainData mainData = null;
        for (int i = 0; i < ids.length; i++) {
            try {
                logger.debug("id:" + ids[i]);
                mainData = mainDataDao.selectByPrimaryKey(ids[i]);
                logger.info("生成文件:" + mainData.toString());
                accessDao.createFile(mainData, simpled);
                mainDataDao.updateStatusById(ids[i]);
            } catch (Exception e) {
                logger.error("生成文件出错...", e);
                return false;
            }
        }
        return true;
    }

    //计算最终结果
    public MainData calculateResult(MainData mainData, boolean simpled) throws Exception {
        /*String [] coun1 ={"Dr:Drags","Mar","Mad","Vad","Aad","Had"};
        Map<String,String> gmap = new HashMap<>();
        gmap.put("Drags",mainData.getDrags());
        gmap.put("Mar", mainData.getMar());
        gmap.put("Mad", mainData.getMad());
        gmap.put("Vad", mainData.getVad());
        gmap.put("Aad", mainData.getAad());
        gmap.put("Had", mainData.getHad());

        String [] coun2={"Sad:Stad"};
        Map<String,String> ymap = new HashMap<>();
        ymap.put("Stad",mainData.getStad().toString());

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        String newtime = sdf.format(date);
        String subtime = newtime.substring(2);
        BufferedOutputStream bf = new BufferedOutputStream(new FileOutputStream(accessConfig.getFilePath() +"\\" +"LG"+subtime+".qan"));
        //输出第一行
        bf.write(rightFormatStr("S",2).getBytes());
        bf.write(rightFormatStr(mainData.getSamplenol(),41).getBytes());
        bf.write(subtime.getBytes());
        bf.write("\r\n".getBytes());*/
        //输出第一行结束
        //输出第二行
        /*bf.write(rightFormatStr("D",2).getBytes());
        bf.write(rightFormatStr("12",3).getBytes());
        bf.write(rightFormatStr("Autocoal",10).getBytes());
        bf.write(rightFormatStr("9000",20).getBytes());
        bf.write(rightFormatStr("10.00",7).getBytes());
        bf.write("10.20".getBytes());
        bf.write("\r\n".getBytes());
        //输出第二行结束
        //部分循环输出
        writeStr(gmap, coun1,bf);
        //输出fcad计算行
        bf.write(rightFormatStr("C",2).getBytes());
        bf.write(rightFormatStr("Fad",5).getBytes());*/

        double Vad = (mainData.getVad() == null || mainData.getVad().trim().equals("")) ? 0 : Double.parseDouble(mainData.getVad());
        double Mad = (mainData.getMad() == null || mainData.getMad().trim().equals("")) ? 0 : Double.parseDouble(mainData.getMad());
        double Aad = (mainData.getAad() == null || mainData.getAad().trim().equals("")) ? 0 : Double.parseDouble(mainData.getAad());
        double Had = (mainData.getHad() == null || mainData.getHad().trim().equals("")) ? 0 : Double.parseDouble(mainData.getHad());
        double Mar = (mainData.getMar() == null || mainData.getMar().trim().equals("")) ? 0 : Double.parseDouble(mainData.getMar());
        double Stad = mainData.getStad() == null ? 0 : Double.parseDouble(mainData.getStad().toString());

        double fcad = (100 - Aad - Mad - Vad);
        /*bf.write(formatStr(String.format("%.2f",fcad),8).getBytes());
        bf.write("\t".getBytes());
        bf.write(rightFormatStr("%",5).getBytes());
        bf.write(rightFormatStr("Fcad",40).getBytes());
        bf.write(rightFormatStr("8000",4).getBytes());
        bf.write("\r\n".getBytes());
        //部分循环输出
        writeStr(ymap, coun2,bf);
        //弹筒发热量行输出qbad*/

        double Qgrad = 0;
        double Qgrd = 0;
        if (!simpled) {
            String qbad = mainData.getQbad().toString();
            double Qbad = Double.parseDouble(qbad);
            double a = 0;
            if (Qbad <= 16.7) {
                a = 0.001;
            } else if (Qbad > 16.7 && Qbad <= 25.1) {
                a = 0.0012;
            } else if (Qbad >= 25.1) {
                a = 0.0016;
            }
            Qgrad = (Qbad * 1000) - (94.1 * Stad) - (a * Qbad * 1000);
            logger.debug("qgrad:" + Qgrad);
            Qgrd = (Qgrad * (100 / (100 - Mad))) / 4.1816;
        }
        double Qnetad;
        if (simpled && mainData.getKeed() != null) {
            if (mainData.getKeed() == Constants.BITUMINOUS) {
                //烟煤
                Qnetad = 8575.63 - (17.63 * Vad) - (94.64 * Aad) - (167.89 * Mad) + (41.52 * Float.parseFloat((mainData.getDrags() == null || mainData.getDrags().trim().equals("")) ? "1" : mainData.getDrags()));
            } else if (mainData.getKeed() == Constants.ANTHRACITE) {
                //无烟煤
                Qnetad = 7735.52 - (38.63 * Vad) - (82.70 * Aad) - (86.16 * Mad) + (249.27 * Had);
            } else if (mainData.getKeed() == Constants.LIGNITE) {
                //褐煤
                Qnetad = 7588.69 - (16.58 * Vad) - (76.91 * Aad) - (92.88 * Mad);
            } else {
                logger.warn("煤种异常,请确认!!!");
                Qnetad = 0;
            }
        } else {
            Qnetad = ((Qgrad - (206 * Had)) - (23 * Mad)) / 4.1816;
        }
        Double Qnetar = null;
        if (simpled) {
            if(mainData.getMar() != null && !(mainData.getMar().trim().equals(""))){
                Qnetar = Qnetad * (((100 - Mar) / (100 - Mad))) - (5.4 * (Mar - (Mad * ((100 - Mar) / (100 - Mad)))));
            }/*else{
                Qnetar = 0.0;
            }*/
        } else {
            Qnetar = ((Qgrad - (206 * Had)) * ((100 - Mar) / (100 - Mad)) - (23 * Mar)) / 4.1816;
        }

        MainData resData = new MainData();
        resData.setFcad(String.format("%.2f", fcad));
        resData.setQgrd(String.format("%.2f", Qgrd));
        resData.setQnetad(String.format("%.2f", Qnetad));
        if(Qnetar != null){
            resData.setQnetar(String.format("%.2f", Qnetar));
        }
        return resData;
    }
}
