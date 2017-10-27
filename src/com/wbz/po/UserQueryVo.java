package com.wbz.po;

import java.util.List;

/*
* pojo包装类型
*
* */
public class UserQueryVo {
    //使用foreach 传入多个id在其中
    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    private UserCustomer userCustomer;

    public UserCustomer getUserCustomer() {
        return userCustomer;
    }

    public void setUserCustomer(UserCustomer userCustomer) {
        this.userCustomer = userCustomer;
    }

}
