# 后端技术说明

*  技术版本说明

| 技术 | 版本 | 说明 |
| :-----: | :----: | :----: |
| Spring Boot | 2.4.1 | 容器+MVC框架 |
| MyBatis | 3.5.3 | ORM框架 |
| PageHelper| 5.1.8 |MyBatis物理分页插件|
|Swagger-UI	| 2.7.0	|文档生产工具|
|Druid | 1.1.10 |数据库连接池|
|Lombok |1.18.12 |简化对象封装工具|
|logback |1.2.3 | 日志收集|
|hutool | 4.5.7 | Java工具包|
|fastjson|1.2.47|JSON tools
|validation|6.1.6|参数校验|
|itextpdf|5.5.6|PDF导出工具|
|mysql|5.1.40|数据库驱动|
|mysql|5.7|数据库|
|annotations|13.0|注解支持|
|httpclient|4.5.13|HTTP通讯|
|Process|xml报文交互|进程通讯
|JWT|3.4.0|JWT(Json Web Token)登录支持|
---
* 项目结构
---
```java
├─src  
│  ├─main  
│  │  ├─java  
│  │  │  └─com  
│  │  │      └─security  
│  │  │          └─toolskit  
│  │  │              ├─aspect   --切面类  
│  │  │              ├─common   -- 工具类及通用代码
│  │  │              ├─component    --组件类  
│  │  │              ├─config   --通用配置  
│  │  │              ├─controller   --控制层  
│  │  │              ├─exception    --全局异常配置  
│  │  │              ├─mapper   --数据层  
│  │  │              ├─model    --实体层  
│  │  │              ├─service  --服务层  
│  │  │              │  └─impl  --服务实现层  
│  │  │              └─utils    --全局工具类及通讯工具等  

``` 

---

```java
打包GO:  go build -o D:\PersonResource\个人工具\mysql_markdown mysql_markdown.go
```

* 数据库表结构
  
#### 1、 ums_admin
后台用户表

| 序号 | 名称 | 描述 | 类型 | 键 | 为空 | 额外 | 默认值 |
| :--: | :--: | :--: | :--: | :--: | :--: | :--: | :--: |
| 1 | `id` | 自增主键 | bigint(20) | PRI | NO | auto_increment |  |
| 2 | `username` | 用户名 | varchar(64) |  | YES |  |  |
| 3 | `password` | 密码 | varchar(64) |  | YES |  |  |
| 4 | `icon` | 头像 | varchar(255) |  | YES |  |  |
| 5 | `email` | 邮箱 | varchar(100) |  | YES |  |  |
| 6 | `nick_name` | 昵称 | varchar(255) |  | YES |  |  |
| 7 | `note` | 备注信息 | varchar(255) |  | YES |  |  |
| 8 | `create_time` | 创建时间 | datetime |  | YES |  |  |
| 9 | `login_time` | 最后登录时间 | datetime |  | YES |  |  |
| 10 | `status` | 帐号启用状态：0->禁用；1->启用 | int(2) |  | YES |  | 1 |
| 11 | `is_first` | 是否为新用户；新用户可修改账号一次 0->否；1->是 | int(2) |  | YES |  |  |
| 12 | `identity` | 身份码标识 | varchar(50) |  | YES |  |  |
| 13 | `role` | 身份:1->超级用户；2->普通用户 | varchar(2) |  | YES |  |  |


#### 2、 ums_admin_login_log
后台用户登录日志表

| 序号 | 名称 | 描述 | 类型 | 键 | 为空 | 额外 | 默认值 |
| :--: | :--: | :--: | :--: | :--: | :--: | :--: | :--: |
| 1 | `id` | 自增主键 | bigint(20) | PRI | NO | auto_increment |  |
| 2 | `admin_id` | 用户主键 | bigint(20) |  | YES |  |  |
| 3 | `create_time` | 创建时间 | datetime |  | YES |  |  |
| 4 | `ip` | IP地址 | varchar(64) |  | YES |  |  |
| 5 | `address` | IP对应的实际地址:中国\|华中\|湖南省\|长沙市\|电信 | varchar(100) |  | YES |  |  |
| 6 | `user_agent` | 浏览器登录类型 | varchar(100) |  | YES |  |  |
| 7 | `system` | 操作系统类型 | varchar(100) |  | YES |  |  |







---

* 项目地址

[ipaddr]:127.0.0.1:8095

  1. IP地址： [ipaddr]

  2. 接口文档:`http://127.0.0.1:8095/toolskit/swagger-ui.html`   账号:admin/123456

1. web访问地址:``
2. 服务器存放地址:



---

* 数据库资料:

1. 名称:toolskit
  
2. 账号密码:`root/123456`
  
3. 服务器存放地址:



temp:
pdf参考:https://gitee.com/xsxgit/x-easypdf?_from=gitee_search