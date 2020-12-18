package com.security.toolskit.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 后台用户表
    */
@ApiModel(value="com-security-toolskit-model-UmsAdmin")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UmsAdmin implements Serializable {
    /**
    * 自增主键
    */
    @ApiModelProperty(value="自增主键")
    private Long id;

    /**
    * 用户名
    */
    @ApiModelProperty(value="用户名")
    private String username;

    /**
    * 密码
    */
    @ApiModelProperty(value="密码")
    private String password;

    /**
    * 头像
    */
    @ApiModelProperty(value="头像")
    private String icon;

    /**
    * 邮箱
    */
    @ApiModelProperty(value="邮箱")
    private String email;

    /**
    * 昵称
    */
    @ApiModelProperty(value="昵称")
    private String nickName;

    /**
    * 备注信息
    */
    @ApiModelProperty(value="备注信息")
    private String note;

    /**
    * 创建时间
    */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
    * 最后登录时间
    */
    @ApiModelProperty(value="最后登录时间")
    private Date loginTime;

    /**
    * 帐号启用状态：0->禁用；1->启用
    */
    @ApiModelProperty(value="帐号启用状态：0->禁用；1->启用")
    private Integer status;

    /**
    * 是否为新用户；新用户可修改账号一次 0->否；1->是
    */
    @ApiModelProperty(value="是否为新用户；新用户可修改账号一次 0->否；1->是")
    private Integer isFirst;

    /**
    * 身份码标识
    */
    @ApiModelProperty(value="身份码标识")
    private String identity;

    /**
    * 身份:1->超级用户；2->普通用户
    */
    @ApiModelProperty(value="身份:1->超级用户；2->普通用户")
    private String role;

    private static final long serialVersionUID = 1L;
}