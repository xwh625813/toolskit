package com.security.toolskit.service;

import com.security.toolskit.model.UmsAdminLoginLog;

import java.util.List;

public interface UmsAdminLoginLogService{


    int deleteByPrimaryKey(Long id);

    int insert(UmsAdminLoginLog record);

    int insertSelective(UmsAdminLoginLog record);

    UmsAdminLoginLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsAdminLoginLog record);

    int updateByPrimaryKey(UmsAdminLoginLog record);

    List<UmsAdminLoginLog> getUmsLoginLogList(Integer pageNum,Integer pageSize);
}
