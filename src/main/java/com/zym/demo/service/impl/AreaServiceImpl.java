package com.zym.demo.service.impl;

import com.zym.demo.dao.AreaDao;
import com.zym.demo.entity.Area;
import com.zym.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * @author zym
 * @Date 2019-06-30-21:35
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

    @Override
    public Area getAreaById(int areaId) {
        return areaDao.queryAreaById(areaId);
    }

    @Transactional  //事务控制 出现异常 事务就回滚
    @Override
    public boolean addArea(Area area) {
        if (area.getAreaName() != null && !"".equals(area.getAreaName())){
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());

            try {
                int effectedNum = areaDao.insertArea(area);
                if(effectedNum > 0 ){
                    return true;
                }else{
                    throw new RuntimeException("插入区域信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入信息失败：" + e.getMessage());
            }
        }else{
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    public boolean modifyArea(Area area) {
        //空值判断，主要是areaId不为空
        if(area.getAreaId() != null && area.getAreaId() > 0){
            //设置默认值
            area.setLastEditTime(new Date());

            try {
                //更新区域信息
                int effectedNum = areaDao.updateArea(area);
                if(effectedNum > 0){
                    return true;
                }else{
                    throw new RuntimeException("更新区域信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新区域信息失败：" + e.toString());
            }
        }else {
            throw new RuntimeException("数据不能为空！");
        }
    }

    @Override
    public boolean deleteArea(int areaId) {
        if(areaId > 0){
            try {
                //删除区域信息
                int effectedNum = areaDao.deleteArea(areaId);
                if(effectedNum > 0){
                    return true;
                }else{
                    throw new RuntimeException("删除区域信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除区域失败："+ toString());
            }
        }else{
            throw new RuntimeException("区域Id能为空或者负数！");
        }
    }
}
