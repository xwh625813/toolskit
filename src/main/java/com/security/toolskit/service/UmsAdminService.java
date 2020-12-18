package com.security.toolskit.service;

import com.security.toolskit.model.UmsAdmin;
import com.security.toolskit.vo.UmsAdminRegisterParam;

import java.util.List;

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
    /**
     * 注册功能
     */
    boolean register(UmsAdminRegisterParam umsAdminParam, String identity);

    /**
     * 查询所有用户
     * @param username
     * @return
     */
    List<UmsAdmin> getUmsAdminListData(String username,Integer pageNum,Integer pageSize);
}
