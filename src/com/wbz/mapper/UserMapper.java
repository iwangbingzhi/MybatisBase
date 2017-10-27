package com.wbz.mapper;

/*
mapper开发规范：
1.mapper.xml中 namespace等于mapper接口地址
2.mapper.java接口中的方法名和mapper.xml中statement一致
3.mapper.java接口中的方法输入参数类型和mapper.xml中的statement的parametertype指定的类型一致
4.mapper.java接口中的方法返回值类型和mapper.xml中statement的resulttype指定的类型一致


*/


import com.wbz.po.User;
import com.wbz.po.UserCustomer;
import com.wbz.po.UserQueryVo;

import java.util.List;

public interface UserMapper {
    //根据id查询用户
    public User findUserById(int id) throws Exception;
    //插入用户
    public void insertUser(User user) throws Exception;
    //删除用户
    public void deleteUser(int id) throws Exception;
    //根据用户名查询用户列表
    public List<User> findUserByName(String name) throws Exception;

    //用户信息综合查询
    public List<UserCustomer> findUserList(UserQueryVo userQueryVo) throws Exception;


    //用户信息综合查询总数
    public int findUserCount(UserQueryVo userQueryVo) throws Exception;

    //根据id查询用户信息，然后使用resultMap输出
    public User findUserByIdResultMap(int id) throws Exception;
}
