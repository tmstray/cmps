package com.hx.service;

import com.hx.entity.MainData;
import com.hx.model.MainDataModel;

import java.util.List;

/**
 * @program: eqds-ms
 * @description:
 * @author: yangyue
 * @create: 2019/12/19 11:26
 */
public interface MainDataService {
    List<MainData> findByPage(MainDataModel model);

    //同步数据
    boolean dataSynchronize(boolean simpled);

    boolean saveOrUpdate(List<MainData> list, boolean simpled);

    boolean createFile(String[] ids, boolean simpled);
}
