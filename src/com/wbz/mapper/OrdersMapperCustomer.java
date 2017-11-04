package com.wbz.mapper;

import com.wbz.po.Orderdetail;
import com.wbz.po.Orders;
import com.wbz.po.OrdersCustomer;

import java.util.List;

public interface OrdersMapperCustomer {
    //查询订单关联用户信息
    public List<OrdersCustomer> findOrdersUser() throws Exception;

    //resultmap查询订单关联用户信息
    public List<Orders> findOrdersUserResultMap() throws Exception;

    //resultmap配置订单明细信息
    public List<Orders> findOrdersAndOrderDetailResultMap() throws Exception;
}
