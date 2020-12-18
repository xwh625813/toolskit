package com.security.toolskit.mapper;

import com.security.toolskit.model.UmsAdminLoginLog;

import java.util.List;

public interface UmsAdminLoginLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsAdminLoginLog record);

    int insertSelective(UmsAdminLoginLog record);

    UmsAdminLoginLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsAdminLoginLog record);

    int updateByPrimaryKey(UmsAdminLoginLog record);

    List<UmsAdminLoginLog> selectUmsLoginLogList();
}