package com.wbz.mapper;

import com.wbz.po.User;
import com.wbz.po.UserCustomer;
import com.wbz.po.UserQueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws Exception {
        String resource = "com/wbz/config/SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testfindUserById() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //调用userMapper方法
        User user = userMapper.findUserById(5);

        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testfindUserByName() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //调用userMapper方法
        List<User> list = userMapper.findUserByName("小");
        System.out.println(list);
        sqlSession.close();
    }
    //用户信息中和查询
    @Test
    public void testfindUserList() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //创建包装对象 设置查询条件
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustomer userCustomer = new UserCustomer();
        //userCustomer.setSex("男");
        userCustomer.setUsername("小");
        //传入多个id
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(3);
        ids.add(5);
        ids.add(6);
        //将ids通过userQueryVo传入statement中
        userQueryVo.setIds(ids);
        userQueryVo.setUserCustomer(userCustomer);
        List<UserCustomer> list = userMapper.findUserList(userQueryVo);
        System.out.println(list);

    }

    //用户信息综合查询总数
    @Test
    public void testfindUserCount() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //创建包装对象 设置查询条件
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustomer userCustomer = new UserCustomer();
        userCustomer.setSex("男");
        userCustomer.setUsername("王");
        userQueryVo.setUserCustomer(userCustomer);

        int count = userMapper.findUserCount(userQueryVo);
        System.out.println(count);
    }

    //使用resultMap进行输出
    @Test
    public void testfindUserByIdResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //调用userMapper方法
        User user = userMapper.findUserByIdResultMap(5);

        System.out.println(user);
        sqlSession.close();
    }

}