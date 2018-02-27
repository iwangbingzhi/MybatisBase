package com.wbz.po;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable{
    private int id;
    private String username;
    private String sex;
    private Date birthday;
    private String address;
    //订单列表属性,将用户创建的订单映射到orderslist 查询用户及用户购买商品信息
    private List<Orders> orderslist;


    public List<Orders> getOrderslist() {
        return orderslist;
    }

    public void setOrderslist(List<Orders> orderslist) {
        this.orderslist = orderslist;
    }


    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public void setAddress(String adress) {
        this.address = adress;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", adress='" + address + '\'' +
                '}';
    }
}
