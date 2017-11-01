package com.wbz.po;


//订单的扩展类，通过此类能够映射订单和用户的查询结果，让此类继承包括字段较多的pojo类

public class OrdersCustomer extends Orders {
    private String username;
    private String sex;
    private String address;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
