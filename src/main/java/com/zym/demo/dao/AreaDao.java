package com.zym.demo.dao;

import com.zym.demo.entity.Area;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zym
 * @Date 2019-06-17-20:54
 */
public interface AreaDao {
    /**
     * 列出区域列表
     * @return
     */
    @Select("select * from tb_area order by priority desc")
    @Results(id = "AreadaoMap",value = {
            @Result(id = true ,column ="area_id" ,property = "areaId"),
            @Result(column ="area_name" ,property = "areaName"),
            @Result(column ="priority" ,property = "priority"),
            @Result(column ="create_time" ,property = "createTime"),
            @Result(column ="last_edit_time" ,property = "lastEditTime")
    })
    List<Area> queryArea();

    /**
     * 根据id列出具体区域
     * @param areaId
     * @return
     */
    Area queryAreaById(int areaId);

    /**
     * 插入区域
     * @param area
     * @return
     */
    @Insert("insert into tb_area(area_name,priority,create_time,last_edit_time) values " +
            "(#{areaName},#{priority},#{createTime},#{lastEditTime}) ")
    int insertArea(Area area);

    /**
     * 更新区域信息
     * @param area
     * @return
     */
    @Update("update tb_area set area_name=#{areaName},priority=#{priority},create_time=#{createTime}," +
            "last_edit_time=#{lastEditTime} where area_id=#{areaId}")
    int updateArea(Area area);

    /**
     * 根据id删除区域
     * @param areaId
     * @return
     */
    @Delete("delete from tb_area where area_id=#{areaId}")
    int deleteArea(int areaId);

    /**
     * 根据id查询区域
     * @param areaId
     * @return
     */
    @Select("select * from tb_area where area_id=#{areaId}")
    @ResultMap("AreadaoMap")
    Area findById(Integer areaId);

    /**
     * 根据名称模糊查询
     * @param areaName
     * @return
     */
    @Select("select * from tb_area where area_name like #{areaName}")
    //@Select("select * from tb_area where area_name like '%${value}%'")
    @ResultMap("AreadaoMap")
    List<Area> findByName(String areaName);

    /**
     * 查询总地域数量
     * @return
     */
    @Select("select count(*) from tb_area")
    int findTotalArea();
}
