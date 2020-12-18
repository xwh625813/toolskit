package com.security.toolskit.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.security.toolskit.model.UmsAdminLoginLog;
import com.security.toolskit.mapper.UmsAdminLoginLogMapper;
import com.security.toolskit.service.UmsAdminLoginLogService;

import java.util.List;

@Service
public class UmsAdminLoginLogServiceImpl implements UmsAdminLoginLogService{

    @Resource
    private UmsAdminLoginLogMapper umsAdminLoginLogMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return umsAdminLoginLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UmsAdminLoginLog record) {
        return umsAdminLoginLogMapper.insert(record);
    }

    @Override
    public int insertSelective(UmsAdminLoginLog record) {
        return umsAdminLoginLogMapper.insertSelective(record);
    }

    @Override
    public UmsAdminLoginLog selectByPrimaryKey(Long id) {
        return umsAdminLoginLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UmsAdminLoginLog record) {
        return umsAdminLoginLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UmsAdminLoginLog record) {
        return umsAdminLoginLogMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<UmsAdminLoginLog> getUmsLoginLogList(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return umsAdminLoginLogMapper.selectUmsLoginLogList();
    }

}
