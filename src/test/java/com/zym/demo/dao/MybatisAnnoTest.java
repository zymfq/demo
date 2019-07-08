package com.zym.demo.dao;

import com.zym.demo.entity.Area;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author zym
 * @Date 2019-07-07-20:43
 */
public class MybatisAnnoTest {

    /**
     * 测试基于注解的mybatis的使用
     * @param args
     */
    public static void main(String[] args) throws IOException {
        // 1.获取字节输入流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.根据字节输入流构建
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 3.根据SqlSessionFactory生产一个SqlSession
        SqlSession session = factory.openSession();
        // 4.使用SqlSession获取Dao的代理对象
        AreaDao areaDao = session.getMapper(AreaDao.class);
        // 5.执行Dao的方法
        List<Area> areaList = areaDao.queryArea();
        for (Area area : areaList){
            System.out.println(area);
        }
        // 6.释放资源
        session.close();
        in.close();
    }
}
