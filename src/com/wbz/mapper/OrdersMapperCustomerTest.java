package com.wbz.mapper;

import com.wbz.po.Orders;
import com.wbz.po.OrdersCustomer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class OrdersMapperCustomerTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws Exception {
        String resource = "com/wbz/config/SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }


    @Test
    public void testFindOrdersUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建代理对象
        OrdersMapperCustomer ordersMapperCustomer = sqlSession.getMapper(OrdersMapperCustomer.class);
        //调用mapper的方法
        List<OrdersCustomer> list = ordersMapperCustomer.findOrdersUser();

        System.out.println(list);
        sqlSession.close();
    }

    @Test
    public void testFindOrdersUserResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建代理对象
        OrdersMapperCustomer ordersMapperCustomer = sqlSession.getMapper(OrdersMapperCustomer.class);
        //调用mapper的方法
        List<Orders> list = ordersMapperCustomer.findOrdersUserResultMap();
        System.out.println(list);
        sqlSession.close();
    }

    @Test
    public void testFindOrdersAndOrderDetailResultMap() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建代理对象
        OrdersMapperCustomer ordersMapperCustomer = sqlSession.getMapper(OrdersMapperCustomer.class);
        //调用mapper的方法
        List<Orders> list = ordersMapperCustomer.findOrdersAndOrderDetailResultMap();
        for (Orders o : list) {
            System.out.println(o);
        }

        sqlSession.close();
    }
}