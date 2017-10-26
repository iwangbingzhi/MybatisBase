package com.wbz.mapper;

/*
mapper开发规范：
1.mapper.xml中 namespace等于mapper接口地址
2.mapper.java接口中的方法名和mapper.xml中statement一致
3.mapper.java接口中的方法输入参数类型和mapper.xml中的statement的parametertype指定的类型一致
4.mapper.java接口中的方法返回值类型和mapper.xml中statement的resulttype指定的类型一致


*/


import com.wbz.po.User;

public interface UserMapper {
    public User findUserById(int id) throws Exception;
}
