package com.wbz.dao;

import com.wbz.po.User;
//这个文件是用来现实用户dao层信息的 1111111
public interface UserDao {
    //根据id查询用户信息
    public User findUserById(int id) throws Exception;

    //添加用户信息
    public void insertUser(User user) throws Exception;

    //删除用户信息
    public void deleteUser(int id) throws Exception;



}
