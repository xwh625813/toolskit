package com.security.toolskit.service.impl;

import com.github.pagehelper.PageHelper;
import com.security.toolskit.mapper.UmsAdminLoginLogMapper;
import com.security.toolskit.model.UmsAdminLoginLog;
import com.security.toolskit.utils.HttpContextUtil;
import com.security.toolskit.utils.IpUtil;
import com.security.toolskit.utils.MD5Util;
import com.security.toolskit.utils.TokenUtil;
import com.security.toolskit.vo.UmsAdminRegisterParam;
import com.security.toolskit.vo.UmsLoginLogParam;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.security.toolskit.mapper.UmsAdminMapper;
import com.security.toolskit.model.UmsAdmin;
import com.security.toolskit.service.UmsAdminService;

import java.util.Date;
import java.util.List;

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
        UmsAdmin user = umsAdminMapper.selectByUserName(username);
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
        user.setLoginTime(new Date());
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
    @Override
    public boolean register(UmsAdminRegisterParam umsAdminParam,String identity) {
        boolean flag = false;
        //查询是否有相同用户名的用户
        UmsAdmin user = umsAdminMapper.selectByUserName(umsAdminParam.getUsername());
        if(user!=null && user.getUsername()!=null){
            return flag;
        }
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);
        umsAdmin.setIsFirst(1);
        umsAdmin.setRole("2");
        umsAdmin.setIdentity(identity);
        //将密码进行加密操作
        String encodePassword =MD5Util.formEncryption(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);
        // 新增用户
        umsAdminMapper.insert(umsAdmin);
        return flag=true;
    }

    @Override
    public List<UmsAdmin> getUmsAdminListData(String username,Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<UmsAdmin> umsAdminList = umsAdminMapper.selectUmsAdminList(username);
        return umsAdminList;
    }


}
