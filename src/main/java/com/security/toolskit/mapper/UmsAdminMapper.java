package com.security.toolskit.mapper;

import com.security.toolskit.model.UmsAdmin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UmsAdminMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UmsAdmin record);

    int insertSelective(UmsAdmin record);

    UmsAdmin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsAdmin record);

    int updateByPrimaryKey(UmsAdmin record);

    UmsAdmin login(String username);
}