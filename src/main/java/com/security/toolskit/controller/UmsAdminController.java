package com.security.toolskit.controller;

import com.security.toolskit.common.CommonResult;
import com.security.toolskit.service.UmsAdminService;
import com.security.toolskit.vo.UmsAdminLoginParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Api(tags = "用户模块",value = "用户管理")
@RequestMapping(value = "/user")
public class UmsAdminController {

    @Autowired
    UmsAdminService userService;

    @ApiOperation(value = "用户登录")
    @PostMapping(value = "/login")
    public CommonResult login(@RequestBody UmsAdminLoginParam user){
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

}
