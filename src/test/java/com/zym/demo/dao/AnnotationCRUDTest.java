package com.zym.demo.dao;

import com.zym.demo.entity.Area;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * @author zym
 * @Date 2019-07-08-11:26
 */
public class AnnotationCRUDTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private AreaDao areaDao;

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        areaDao = session.getMapper(AreaDao.class);
    }

    @After
    public void destory() throws Exception {
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void testQueryArea(){
        List<Area> areaList = areaDao.queryArea();
        for (Area area : areaList) {
            System.out.println(area);
        }
    }

    @Test
    public void testInsert(){
        Area area = new Area();
        area.setAreaName("芜湖");
        area.setPriority(4);
        area.setCreateTime(new Date());
        int effectedNum = areaDao.insertArea(area);
        assertEquals(1,effectedNum);
    }

    @Test
    public void testUpdate(){
        Area area = new Area();
        area.setAreaId(3);
        area.setAreaName("南京update");
        area.setPriority(7);
        area.setLastEditTime(new Date());

        int effectedNum = areaDao.updateArea(area);
        assertEquals(1, effectedNum);

    }

    @Test
    public void testDelete(){
        int effectedNum = areaDao.deleteArea(4);
        assertEquals(1, effectedNum);
    }

    @Test
    public void testFindOne(){
        Area area = areaDao.findById(3);
        System.out.println(area);
    }

    @Test
    public void testFindByName(){
        List<Area> areaList = areaDao.findByName("%北%");
        //List<Area> areaList = areaDao.findByName("北");
        for (Area area : areaList) {
            System.out.println("--------信息--------");
            System.out.println(area);
        }
    }

    @Test
    public void testFindTotal(){
        int total = areaDao.findTotalArea();
        System.out.println(total);
    }
}
