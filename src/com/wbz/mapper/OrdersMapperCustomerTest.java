package com.wbz.mapper;

import com.wbz.po.Orders;
import com.wbz.po.OrdersCustomer;
import com.wbz.po.User;
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
    //查询用户购买的商品信息
    @Test
    public void testfindUserAndItemsResultMap() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建代理对象
        OrdersMapperCustomer ordersMapperCustomer = sqlSession.getMapper(OrdersMapperCustomer.class);
        //调用mapper的方法
        List<User> list = ordersMapperCustomer.findUserAndItemsResultMap();
        System.out.println(list);
        sqlSession.close();
    }

    //查询订单关联查询用户，用户信息是延迟加载
    @Test
    public void testfindOrdersUserLazyLoading() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapperCustomer ordersMapperCustomer = sqlSession.getMapper(OrdersMapperCustomer.class);
        //查询订单信息(单表)
        List<Orders> list = ordersMapperCustomer.findOrdersUserLazyLoading();
        //遍历上边的订单列表
        for (Orders o: list) {
            //执行getUser去查询用户信息，这里实现按需加载
            User u = o.getUser();
            System.out.println(u);
        }
    }

    //测试一级缓存
    @Test
    public void testCache1() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);

        //第一次读取数据
        User user1 = usermapper.findUserById(1);
        System.out.println(user1);

        //如果sqlsession去执行curd操作，会清空sqlsession一级缓存，并且重新读取
        user1.setUsername("黄麻子");
        usermapper.updateUser(user1);
        sqlSession.commit();

        //第2次读取数据
        User user2 = usermapper.findUserById(1);
        System.out.println(user2);

        sqlSession.close();

    }
    //测试二级缓存
    @Test
    public void testCache2() throws Exception{
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        SqlSession sqlSession3 = sqlSessionFactory.openSession();

        UserMapper usermapper1 = sqlSession1.getMapper(UserMapper.class);
        //第一次读取数据
        User user1 = usermapper1.findUserById(1);
        System.out.println(user1);

        //这里执行关闭操作，将sqlsession中的数据写到二级缓存区域
        sqlSession1.close();


       //如果sqlsession3去执行curd操作，会清空sqlsession二级缓存，并且重新读取
        UserMapper usermapper3 = sqlSession3.getMapper(UserMapper.class);
        User user3 = usermapper3.findUserById(1);
        user3.setUsername("李老板");
        usermapper3.updateUser(user3);
        //执行提交，清空usermapper下面的二级缓存
        sqlSession3.commit();
        sqlSession3.close();


        UserMapper usermapper2 = sqlSession2.getMapper(UserMapper.class);
        //第2次读取数据
        User user2 = usermapper2.findUserById(1);
        System.out.println(user2);
        sqlSession2.close();



    }
}