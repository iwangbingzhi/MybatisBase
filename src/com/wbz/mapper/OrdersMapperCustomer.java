package com.wbz.mapper;

import com.wbz.po.Orderdetail;
import com.wbz.po.Orders;
import com.wbz.po.OrdersCustomer;
import com.wbz.po.User;

import java.util.List;

public interface OrdersMapperCustomer {
    //查询订单关联用户信息
    public List<OrdersCustomer> findOrdersUser() throws Exception;

    //通过resultmap查询订单关联用户信息
    public List<Orders> findOrdersUserResultMap() throws Exception;

    //resultmap配置订单明细信息
    public List<Orders> findOrdersAndOrderDetailResultMap() throws Exception;

    //查询用户购买的商品信息
    public List<User> findUserAndItemsResultMap() throws Exception;
}
