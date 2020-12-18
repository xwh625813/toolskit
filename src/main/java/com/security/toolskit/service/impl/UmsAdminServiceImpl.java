package com.security.toolskit.service.impl;

import com.security.toolskit.mapper.UmsAdminLoginLogMapper;
import com.security.toolskit.model.UmsAdminLoginLog;
import com.security.toolskit.utils.HttpContextUtil;
import com.security.toolskit.utils.IpUtil;
import com.security.toolskit.utils.MD5Util;
import com.security.toolskit.utils.TokenUtil;
import com.security.toolskit.vo.UmsLoginLogParam;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.security.toolskit.mapper.UmsAdminMapper;
import com.security.toolskit.model.UmsAdmin;
import com.security.toolskit.service.UmsAdminService;

import java.util.Date;

@Service
public class UmsAdminServiceImpl implements UmsAdminService{

    @Resource
    private UmsAdminMapper umsAdminMapper;
    @Resource
    private UmsAdminLoginLogMapper loginLogMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return umsAdminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UmsAdmin record) {
        return umsAdminMapper.insert(record);
    }

    @Override
    public int insertSelective(UmsAdmin record) {
        return umsAdminMapper.insertSelective(record);
    }

    @Override
    public UmsAdmin selectByPrimaryKey(Long id) {
        return umsAdminMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UmsAdmin record) {
        return umsAdminMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UmsAdmin record) {
        return umsAdminMapper.updateByPrimaryKey(record);
    }

    @Override
    public String login(String username, String password) {
        UmsAdmin user = umsAdminMapper.login(username);
        String token=null;
        if(user.getPassword()!=null && user.getPassword().equals(MD5Util.formEncryption(password))){
            token = TokenUtil.sign(username);
            //修改最后登录时间
            updateLoginTimeByUsername(user);
            //记录登录日志信息
            insertLoginLog(user);
        }
        return token;
    }

    public void updateLoginTimeByUsername(UmsAdmin user) {
        UmsAdmin record = new UmsAdmin();
        record.setLoginTime(new Date());
        umsAdminMapper.updateByPrimaryKeySelective(user);
    }
    public void insertLoginLog(UmsAdmin user) {
        UmsLoginLogParam loginLog = new UmsLoginLogParam();
        loginLog.setAdminId(user.getId());
        loginLog.setCreateTime(new Date());
        // 获取当前请求
        HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
        String ip = IpUtil.getIpAddr(request);
        loginLog.setIp(ip);
        loginLog.setAddress(IpUtil.getCityInfo(ip));
        // 开始获取 当前用户的 系统+浏览器型号
        loginLog.setSystemUserAgent();
        loginLogMapper.insert(loginLog);
    }

}
