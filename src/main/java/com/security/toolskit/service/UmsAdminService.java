package com.security.toolskit.service;

import com.security.toolskit.model.UmsAdmin;
public interface UmsAdminService{


    int deleteByPrimaryKey(Long id);

    int insert(UmsAdmin record);

    int insertSelective(UmsAdmin record);

    UmsAdmin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsAdmin record);

    int updateByPrimaryKey(UmsAdmin record);


    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    String login(String username,String password);

}
