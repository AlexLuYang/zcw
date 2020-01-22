package com.alex.api;

import com.alex.bean.TAdmin;

public interface AdminService {

    /**
     * 用户登录
     * @param
     * @return
     */
    public TAdmin login(String name , String password);
}
