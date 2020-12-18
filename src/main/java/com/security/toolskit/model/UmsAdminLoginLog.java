package com.security.toolskit.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 后台用户登录日志表
    */
@ApiModel(value="com-security-toolskit-model-UmsAdminLoginLog")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UmsAdminLoginLog implements Serializable {
    /**
    * 自增主键
    */
    @ApiModelProperty(value="自增主键")
    private Long id;

    /**
    * 用户主键
    */
    @ApiModelProperty(value="用户主键")
    private Long adminId;

    /**
    * 创建时间
    */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
    * IP地址
    */
    @ApiModelProperty(value="IP地址")
    private String ip;

    /**
    * IP对应的实际地址:中国|华中|湖南省|长沙市|电信
    */
    @ApiModelProperty(value="IP对应的实际地址:中国|华中|湖南省|长沙市|电信")
    private String address;

    /**
    * 浏览器登录类型
    */
    @ApiModelProperty(value="浏览器登录类型")
    private String userAgent;

    /**
    * 操作系统类型
    */
    @ApiModelProperty(value="操作系统类型")
    private String system;

    private static final long serialVersionUID = 1L;
}