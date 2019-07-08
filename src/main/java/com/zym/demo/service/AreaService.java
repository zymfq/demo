package com.zym.demo.service;

import com.zym.demo.entity.Area;

import java.util.List;

/**
 * @author zym
 * @Date 2019-06-30-21:29
 */
public interface AreaService {

    /**
     * 获取区域列表
     * @return
     */
    List<Area> getAreaList();

    /**
     * 根据id获取具体区域信息
     * @param areaId
     * @return
     */
    Area getAreaById(int areaId);

    /**
     * 增加区域信息
     * @param area
     * @return
     */
    boolean addArea(Area area);

    /**
     * 更新区域信息
     * @param area
     * @return
     */
    boolean modifyArea(Area area);

    /**
     * 根据id删除区域
     * @param areaId
     * @return
     */
    boolean deleteArea(int areaId);

}

