package com.security.toolskit.controller;

import com.security.toolskit.common.CommonPage;
import com.security.toolskit.common.CommonResult;
import com.security.toolskit.model.UmsAdmin;
import com.security.toolskit.model.UmsAdminLoginLog;
import com.security.toolskit.service.UmsAdminLoginLogService;
import com.security.toolskit.service.UmsAdminService;
import com.security.toolskit.vo.UmsAdminLoginParam;
import com.security.toolskit.vo.UmsAdminRegisterParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@Api(tags = "用户模块",value = "用户管理")
@RequestMapping(value = "/user")
public class UmsAdminController {

    @Resource
    UmsAdminService userService;
    @Resource
    UmsAdminLoginLogService userLoginService;

    @ApiOperation(value = "用户登录")
    @PostMapping(value = "/login")
    public CommonResult login(@RequestBody @Valid UmsAdminLoginParam user){
        String token = userService.login(user.getUsername(),user.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        return CommonResult.success(tokenMap);
    }

    @GetMapping(value = "/getmessage")
    public CommonResult getmessage(){
        return CommonResult.success("你已经通过验证");
    }

    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/register")
    public CommonResult register(@RequestBody @Valid UmsAdminRegisterParam umsAdminParam) {
        String identity = UUID.randomUUID().toString();
        boolean result = userService.register(umsAdminParam,identity);
        if (!result) {
            return  CommonResult.failed("账号已存在");
        }
        return CommonResult.success("注册成功");
    }

    @ApiOperation(value = "分页查询用户列表 {根据用户名 keyword}")
    @GetMapping(value = "/userList")
    public CommonResult<CommonPage<UmsAdmin>> userList(@RequestParam(value = "keyword",required = false) String keyword,
                                         @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                         @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize){
        List<UmsAdmin> umsAdminList = userService.getUmsAdminListData(keyword, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(umsAdminList));

    }
    @ApiOperation(value = "分页查询登录日志列表")
    @GetMapping(value = "/loginLoginList")
    public CommonResult<CommonPage<UmsAdminLoginLog>> loginLoginList(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                                                                     @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize){
        List<UmsAdminLoginLog> umsAdminLoginLogList = userLoginService.getUmsLoginLogList(pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(umsAdminLoginLogList));

    }
}
