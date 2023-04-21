# chat-room-web-server

exported at 2023-04-21 15:38:17

## Project name(项目名称)：netty_chat_room

Project name(项目名称)：netty_chat_room
Package(包名): mao.chat_room_web_server.controller
Class(类名): NettyController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/4/1
Time(创建时间)： 19:35
Version(版本): 1.0
Description(描述)： 无


---
### 通过负载均衡方式得到netty服务的一个实例地址

> BASIC

**Path:** /serverAddress

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─ip | string | 服务ip |
| &ensp;&ensp;&#124;─port | integer | 端口 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "ip": "",
    "port": 0
  },
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```







# auth-server

exported at 2023-04-21 15:38:17

## Project name(项目名称)：authority

Project name(项目名称)：authority
Package(包名): mao.auth_server.controller.auth
Class(类名): RoleController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2022/11/12
Time(创建时间)： 20:29
Version(版本): 1.0
Description(描述)： 无


---
### 分页查询角色

> BASIC

**Path:** /role/page

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| name |  | NO | 角色名称 |
| code |  | NO | 角色编码 |
| describe |  | NO | 功能描述 |
| status | NO | NO | 状态 |
| readonly | NO | NO | 是否内置角色 |
| startCreateTime |  | NO | 数据权限类型<br>#DataScopeType{ALL:1,全部;THIS_LEVEL:2,本级;THIS_LEVEL_CHILDREN:3,本级以及子级;CUSTOMIZE:4,自定义;SELF:5,个人;} |
| endCreateTime |  | NO |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {},
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 查询角色

> BASIC

**Path:** /role/{id}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| id |  |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─name | string | 角色名称 |
| &ensp;&ensp;&#124;─code | string | 角色编码 |
| &ensp;&ensp;&#124;─describe | string | 功能描述 |
| &ensp;&ensp;&#124;─status | boolean | 状态 |
| &ensp;&ensp;&#124;─readonly | boolean | 是否内置角色 |
| &ensp;&ensp;&#124;─orgList | array | 关联的组织id |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "name": "",
    "code": "",
    "describe": "",
    "status": false,
    "readonly": false,
    "orgList": [
      0
    ]
  },
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### check

> BASIC

**Path:** /role/check/{code}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| code |  |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 新增角色

> BASIC

**Path:** /role

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| name | string | 角色名称 |
| code | string | 角色编码 |
| describe | string | 功能描述 |
| status | boolean | 状态 |
| orgList | array | 关联的组织id |
| &ensp;&ensp;&#124;─ | integer |  |

**Request Demo:**

```json
{
  "name": "",
  "code": "",
  "describe": "",
  "status": false,
  "orgList": [
    0
  ]
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─name | string | 角色名称 |
| &ensp;&ensp;&#124;─code | string | 角色编码 |
| &ensp;&ensp;&#124;─describe | string | 功能描述 |
| &ensp;&ensp;&#124;─status | boolean | 状态 |
| &ensp;&ensp;&#124;─orgList | array | 关联的组织id |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "name": "",
    "code": "",
    "describe": "",
    "status": false,
    "orgList": [
      0
    ]
  },
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 修改角色

> BASIC

**Path:** /role

**Method:** PUT

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer |  |
| name | string | 角色名称 |
| code | string | 角色编码 |
| describe | string | 功能描述 |
| status | boolean | 状态 |
| orgList | array | 关联的组织id |
| &ensp;&ensp;&#124;─ | integer |  |

**Request Demo:**

```json
{
  "id": 0,
  "name": "",
  "code": "",
  "describe": "",
  "status": false,
  "orgList": [
    0
  ]
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─name | string | 角色名称 |
| &ensp;&ensp;&#124;─code | string | 角色编码 |
| &ensp;&ensp;&#124;─describe | string | 功能描述 |
| &ensp;&ensp;&#124;─status | boolean | 状态 |
| &ensp;&ensp;&#124;─orgList | array | 关联的组织id |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "name": "",
    "code": "",
    "describe": "",
    "status": false,
    "orgList": [
      0
    ]
  },
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 删除角色

> BASIC

**Path:** /role

**Method:** DELETE

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| ids[] |  | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 给用户分配角色

> BASIC

**Path:** /role/user

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| roleId | integer | 角色ID<br>#auth_role |
| userIdList | array | 用户ID |
| &ensp;&ensp;&#124;─ | integer |  |

**Request Demo:**

```json
{
  "roleId": 0,
  "userIdList": [
    0
  ]
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 查询角色的用户

> BASIC

**Path:** /role/user/{roleId}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| roleId |  |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    0
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 查询角色拥有的资源id

> BASIC

**Path:** /role/authority/{roleId}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| roleId |  |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─menuIdList | array | 菜单ID<br>#auth_menu |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | integer |  |
| &ensp;&ensp;&#124;─resourceIdList | array | 资源id<br>#auth_resource |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | integer |  |
| &ensp;&ensp;&#124;─roleId | integer | 角色id<br>#auth_role |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "menuIdList": [
      0
    ],
    "resourceIdList": [
      0
    ],
    "roleId": 0
  },
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 给角色配置权限

> BASIC

**Path:** /role/authority

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| menuIdList | array | 菜单ID<br>#auth_menu |
| &ensp;&ensp;&#124;─ | integer |  |
| resourceIdList | array | 资源id<br>#auth_resource |
| &ensp;&ensp;&#124;─ | integer |  |
| roleId | integer | 角色id<br>#auth_role |

**Request Demo:**

```json
{
  "menuIdList": [
    0
  ],
  "resourceIdList": [
    0
  ],
  "roleId": 0
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 根据角色编码查询用户ID

> BASIC

**Path:** /role/codes

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| codes |  | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    0
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```





## Project name(项目名称)：authority

Project name(项目名称)：authority
Package(包名): mao.auth_server.controller.auth
Class(类名): LoginController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2022/11/10
Time(创建时间)： 19:50
Version(版本): 1.0
Description(描述)： 登录Controller


---
### captcha

> BASIC

**Path:** /anno/captcha

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| key |  | YES |  |




---
### 登录认证

> BASIC

**Path:** /anno/login

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| key | string | 验证码KEY |
| code | string | 验证码 |
| account | string | 账号 |
| password | string | 密码 |

**Request Demo:**

```json
{
  "key": "",
  "code": "",
  "account": "",
  "password": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─user | object | 用户信息 |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─account | string | 账号 |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 姓名 |
| &ensp;&ensp;&ensp;&ensp;&#124;─orgId | integer | 组织ID<br>#core_org |
| &ensp;&ensp;&ensp;&ensp;&#124;─stationId | integer | 岗位ID<br>#core_station |
| &ensp;&ensp;&ensp;&ensp;&#124;─email | string | 邮箱 |
| &ensp;&ensp;&ensp;&ensp;&#124;─mobile | string | 手机 |
| &ensp;&ensp;&ensp;&ensp;&#124;─sex | string | 性别<br>#Sex{W:女;M:男;N:未知}<br>W :W="女"<br>M :M="男"<br>N :N="未知" |
| &ensp;&ensp;&ensp;&ensp;&#124;─status | boolean | 启用状态 1启用 0禁用 |
| &ensp;&ensp;&ensp;&ensp;&#124;─avatar | string | 照片 |
| &ensp;&ensp;&ensp;&ensp;&#124;─workDescribe | string | 工作描述<br>比如：  市长、管理员、局长等等   用于登陆展示 |
| &ensp;&ensp;&ensp;&ensp;&#124;─lastLoginTime | string | 最后登录时间 |
| &ensp;&ensp;&#124;─token | object | token令牌 |
| &ensp;&ensp;&ensp;&ensp;&#124;─token | string | token |
| &ensp;&ensp;&ensp;&ensp;&#124;─expire | integer | 有效时间：单位：秒 |
| &ensp;&ensp;&#124;─permissionsList | array | 权限列表 |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | string |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "user": {
      "id": 0,
      "account": "",
      "name": "",
      "orgId": 0,
      "stationId": 0,
      "email": "",
      "mobile": "",
      "sex": "",
      "status": false,
      "avatar": "",
      "workDescribe": "",
      "lastLoginTime": ""
    },
    "token": {
      "token": "",
      "expire": 0
    },
    "permissionsList": [
      ""
    ]
  },
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 校验验证码是否正确

> BASIC

**Path:** /anno/check

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| key | string | 验证码KEY |
| code | string | 验证码 |
| account | string | 账号 |
| password | string | 密码 |

**Request Demo:**

```json
{
  "key": "",
  "code": "",
  "account": "",
  "password": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | boolean | boolean |

**Response Demo:**

```json
false
```





## Project name(项目名称)：authority

Project name(项目名称)：authority
Package(包名): mao.auth_server.controller.common
Class(类名): TestController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2022/11/12
Time(创建时间)： 12:31
Version(版本): 1.0
Description(描述)： 无


---
### ping

> BASIC

**Path:** /test/ping

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | string | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": "",
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### test

> BASIC

**Path:** /test/test

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | boolean |  |

**Response Demo:**

```json
false
```





## Project name(项目名称)：authority

Project name(项目名称)：authority
Package(包名): mao.auth_server.controller.auth
Class(类名): UserController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2022/11/12
Time(创建时间)： 20:35
Version(版本): 1.0
Description(描述)： 无


---
### 分页查询用户

> BASIC

**Path:** /user/page

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| account |  | NO | 账号 |
| name |  | NO | 姓名 |
| orgId |  | NO | 组织ID<br>#core_org |
| stationId |  | NO | 岗位ID<br>#core_station |
| mobile |  | NO | 手机 |
| email |  | NO |  |
| sex |  | NO | 性别<br>#Sex{W:女;M:男}<br>W :W="女"<br>M :M="男"<br>N :N="未知" |
| status | NO | NO |  |
| isCanLogin | NO | NO | 是否可登陆 |
| photo |  | NO | 照片 |
| workDescribe |  | NO | 工作描述<br>比如：  市长、管理员、局长等等   用于登陆展示 |
| loginCount |  | NO | 登录次数<br>一直累计，记录了此账号总共登录次数 |
| startCreateTime |  | NO |  |
| endCreateTime |  | NO |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {},
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 查询用户

> BASIC

**Path:** /user/{id}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| id |  | id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| &ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&#124;─account | string | 账号 |
| &ensp;&ensp;&#124;─name | string | 姓名 |
| &ensp;&ensp;&#124;─orgId | integer | 组织ID<br>#core_org |
| &ensp;&ensp;&#124;─stationId | integer | 岗位ID<br>#core_station |
| &ensp;&ensp;&#124;─email | string | 邮箱 |
| &ensp;&ensp;&#124;─mobile | string | 手机 |
| &ensp;&ensp;&#124;─sex | string | 性别<br>#Sex{W:女;M:男;N:未知}<br>W :W="女"<br>M :M="男"<br>N :N="未知" |
| &ensp;&ensp;&#124;─status | boolean | 启用状态 1启用 0禁用 |
| &ensp;&ensp;&#124;─avatar | string | 头像 |
| &ensp;&ensp;&#124;─workDescribe | string | 工作描述<br>比如：  市长、管理员、局长等等   用于登陆展示 |
| &ensp;&ensp;&#124;─passwordErrorLastTime | string | 最后一次输错密码时间 |
| &ensp;&ensp;&#124;─passwordErrorNum | integer | 密码错误次数 |
| &ensp;&ensp;&#124;─passwordExpireTime | string | 密码过期时间 |
| &ensp;&ensp;&#124;─password | string | 密码 |
| &ensp;&ensp;&#124;─lastLoginTime | string | 最后登录时间 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "createTime": "",
    "createUser": 0,
    "updateTime": "",
    "updateUser": 0,
    "account": "",
    "name": "",
    "orgId": 0,
    "stationId": 0,
    "email": "",
    "mobile": "",
    "sex": "",
    "status": false,
    "avatar": "",
    "workDescribe": "",
    "passwordErrorLastTime": "",
    "passwordErrorNum": 0,
    "passwordExpireTime": "",
    "password": "",
    "lastLoginTime": ""
  },
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### findAllUserId

> BASIC

**Path:** /user/find

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    0
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 新增用户

> BASIC

**Path:** /user

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer |  |
| account | string | 账号 |
| name | string | 姓名 |
| orgId | integer | 组织ID<br>#core_org |
| stationId | integer | 岗位ID<br>#core_station |
| email | string | 邮箱 |
| mobile | string | 手机 |
| sex | string | 性别<br>#Sex{W:女;M:男;N:未知}<br>W :W="女"<br>M :M="男"<br>N :N="未知" |
| status | boolean | 启用状态 1启用 0禁用 |
| avatar | string | 头像 |
| workDescribe | string | 工作描述<br>比如：  市长、管理员、局长等等   用于登陆展示 |
| password | string | 密码 |

**Request Demo:**

```json
{
  "id": 0,
  "account": "",
  "name": "",
  "orgId": 0,
  "stationId": 0,
  "email": "",
  "mobile": "",
  "sex": "",
  "status": false,
  "avatar": "",
  "workDescribe": "",
  "password": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| &ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&#124;─account | string | 账号 |
| &ensp;&ensp;&#124;─name | string | 姓名 |
| &ensp;&ensp;&#124;─orgId | integer | 组织ID<br>#core_org |
| &ensp;&ensp;&#124;─stationId | integer | 岗位ID<br>#core_station |
| &ensp;&ensp;&#124;─email | string | 邮箱 |
| &ensp;&ensp;&#124;─mobile | string | 手机 |
| &ensp;&ensp;&#124;─sex | string | 性别<br>#Sex{W:女;M:男;N:未知}<br>W :W="女"<br>M :M="男"<br>N :N="未知" |
| &ensp;&ensp;&#124;─status | boolean | 启用状态 1启用 0禁用 |
| &ensp;&ensp;&#124;─avatar | string | 头像 |
| &ensp;&ensp;&#124;─workDescribe | string | 工作描述<br>比如：  市长、管理员、局长等等   用于登陆展示 |
| &ensp;&ensp;&#124;─passwordErrorLastTime | string | 最后一次输错密码时间 |
| &ensp;&ensp;&#124;─passwordErrorNum | integer | 密码错误次数 |
| &ensp;&ensp;&#124;─passwordExpireTime | string | 密码过期时间 |
| &ensp;&ensp;&#124;─password | string | 密码 |
| &ensp;&ensp;&#124;─lastLoginTime | string | 最后登录时间 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "createTime": "",
    "createUser": 0,
    "updateTime": "",
    "updateUser": 0,
    "account": "",
    "name": "",
    "orgId": 0,
    "stationId": 0,
    "email": "",
    "mobile": "",
    "sex": "",
    "status": false,
    "avatar": "",
    "workDescribe": "",
    "passwordErrorLastTime": "",
    "passwordErrorNum": 0,
    "passwordExpireTime": "",
    "password": "",
    "lastLoginTime": ""
  },
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 修改用户

> BASIC

**Path:** /user

**Method:** PUT

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer |  |
| account | string | 账号 |
| name | string | 姓名 |
| orgId | integer | 组织ID<br>#core_org |
| stationId | integer | 岗位ID<br>#core_station |
| email | string | 邮箱 |
| mobile | string | 手机 |
| sex | string | 性别<br>#Sex{W:女;M:男;N:未知}<br>W :W="女"<br>M :M="男"<br>N :N="未知" |
| status | boolean | 启用状态 1启用 0禁用 |
| avatar | string | 头像 |
| workDescribe | string | 工作描述<br>比如：  市长、管理员、局长等等   用于登陆展示 |

**Request Demo:**

```json
{
  "id": 0,
  "account": "",
  "name": "",
  "orgId": 0,
  "stationId": 0,
  "email": "",
  "mobile": "",
  "sex": "",
  "status": false,
  "avatar": "",
  "workDescribe": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| &ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&#124;─account | string | 账号 |
| &ensp;&ensp;&#124;─name | string | 姓名 |
| &ensp;&ensp;&#124;─orgId | integer | 组织ID<br>#core_org |
| &ensp;&ensp;&#124;─stationId | integer | 岗位ID<br>#core_station |
| &ensp;&ensp;&#124;─email | string | 邮箱 |
| &ensp;&ensp;&#124;─mobile | string | 手机 |
| &ensp;&ensp;&#124;─sex | string | 性别<br>#Sex{W:女;M:男;N:未知}<br>W :W="女"<br>M :M="男"<br>N :N="未知" |
| &ensp;&ensp;&#124;─status | boolean | 启用状态 1启用 0禁用 |
| &ensp;&ensp;&#124;─avatar | string | 头像 |
| &ensp;&ensp;&#124;─workDescribe | string | 工作描述<br>比如：  市长、管理员、局长等等   用于登陆展示 |
| &ensp;&ensp;&#124;─passwordErrorLastTime | string | 最后一次输错密码时间 |
| &ensp;&ensp;&#124;─passwordErrorNum | integer | 密码错误次数 |
| &ensp;&ensp;&#124;─passwordExpireTime | string | 密码过期时间 |
| &ensp;&ensp;&#124;─password | string | 密码 |
| &ensp;&ensp;&#124;─lastLoginTime | string | 最后登录时间 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "createTime": "",
    "createUser": 0,
    "updateTime": "",
    "updateUser": 0,
    "account": "",
    "name": "",
    "orgId": 0,
    "stationId": 0,
    "email": "",
    "mobile": "",
    "sex": "",
    "status": false,
    "avatar": "",
    "workDescribe": "",
    "passwordErrorLastTime": "",
    "passwordErrorNum": 0,
    "passwordExpireTime": "",
    "password": "",
    "lastLoginTime": ""
  },
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 修改头像

> BASIC

**Path:** /user/avatar

**Method:** PUT

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer |  |
| avatar | string | 头像 |

**Request Demo:**

```json
{
  "id": 0,
  "avatar": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| &ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&#124;─account | string | 账号 |
| &ensp;&ensp;&#124;─name | string | 姓名 |
| &ensp;&ensp;&#124;─orgId | integer | 组织ID<br>#core_org |
| &ensp;&ensp;&#124;─stationId | integer | 岗位ID<br>#core_station |
| &ensp;&ensp;&#124;─email | string | 邮箱 |
| &ensp;&ensp;&#124;─mobile | string | 手机 |
| &ensp;&ensp;&#124;─sex | string | 性别<br>#Sex{W:女;M:男;N:未知}<br>W :W="女"<br>M :M="男"<br>N :N="未知" |
| &ensp;&ensp;&#124;─status | boolean | 启用状态 1启用 0禁用 |
| &ensp;&ensp;&#124;─avatar | string | 头像 |
| &ensp;&ensp;&#124;─workDescribe | string | 工作描述<br>比如：  市长、管理员、局长等等   用于登陆展示 |
| &ensp;&ensp;&#124;─passwordErrorLastTime | string | 最后一次输错密码时间 |
| &ensp;&ensp;&#124;─passwordErrorNum | integer | 密码错误次数 |
| &ensp;&ensp;&#124;─passwordExpireTime | string | 密码过期时间 |
| &ensp;&ensp;&#124;─password | string | 密码 |
| &ensp;&ensp;&#124;─lastLoginTime | string | 最后登录时间 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "createTime": "",
    "createUser": 0,
    "updateTime": "",
    "updateUser": 0,
    "account": "",
    "name": "",
    "orgId": 0,
    "stationId": 0,
    "email": "",
    "mobile": "",
    "sex": "",
    "status": false,
    "avatar": "",
    "workDescribe": "",
    "passwordErrorLastTime": "",
    "passwordErrorNum": 0,
    "passwordExpireTime": "",
    "password": "",
    "lastLoginTime": ""
  },
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 修改密码

> BASIC

**Path:** /user/password

**Method:** PUT

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer |  |
| oldPassword | string | 密码 |
| password | string | 密码 |
| confirmPassword | string | 密码 |

**Request Demo:**

```json
{
  "id": 0,
  "oldPassword": "",
  "password": "",
  "confirmPassword": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 重置密码

> BASIC

**Path:** /user/reset

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| ids[] |  | YES | id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 删除用户

> BASIC

**Path:** /user

**Method:** DELETE

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| ids[] |  | YES | id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 单体查询用户

> BASIC

**Path:** /user/anno/id/{id}

**Method:** POST

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| id |  | id |

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| full | boolean | 是否查询SysUser对象所有信息，true则通过rpc接口查询 |
| roles | boolean | 是否只查询角色信息，true则通过rpc接口查询 |
| org | boolean | 是否只查询组织信息，true则通过rpc接口查询 |
| station | boolean | 是否只查询岗位信息，true则通过rpc接口查询 |

**Request Demo:**

```json
{
  "full": false,
  "roles": false,
  "org": false,
  "station": false
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&#124;─account | string | 账号 |
| &ensp;&ensp;&#124;─name | string | 姓名 |
| &ensp;&ensp;&#124;─orgId | integer | 组织ID<br>#pd_core_org |
| &ensp;&ensp;&#124;─stationId | integer | 岗位ID<br>#pd_core_station |
| &ensp;&ensp;&#124;─mobile | string | 手机<br>启用条件： LoginUser.isFull = true \|\| LoginUser.isUser = true |
| &ensp;&ensp;&#124;─photo | string | 照片<br>启用条件： LoginUser.isFull = true \|\| LoginUser.isUser = true |
| &ensp;&ensp;&#124;─workDescribe | string | 工作描述<br>比如：  市长、管理员、局长等等   用于登陆展示<br>启用条件： LoginUser.isFull = true \|\| LoginUser.isUser = true |
| &ensp;&ensp;&#124;─loginCount | integer | 登录次数<br>一直累计，记录了此账号总共登录次数<br>启用条件： LoginUser.isFull = true \|\| LoginUser.isUser = true |
| &ensp;&ensp;&#124;─roles | array | 当前登录用户的角色编码<br>启用条件： LoginUser.isFull = true \|\| LoginUser.isRole = true |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─name | string | 角色名称 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─code | string | 角色编码 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─describe | string | 功能描述 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─isEnable | boolean | 是否启用 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─isReadonly | boolean | 是否只读角色 |
| &ensp;&ensp;&#124;─org | object | 当前登录用户的组织架构<br>启用条件： LoginUser.isFull = true \|\| LoginUser.isOrg = true |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─abbreviation | string | 简称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─parentId | integer | 父ID |
| &ensp;&ensp;&ensp;&ensp;&#124;─sortValue | integer | 排序 |
| &ensp;&ensp;&ensp;&ensp;&#124;─status | boolean | 状态 |
| &ensp;&ensp;&ensp;&ensp;&#124;─describe | string | 描述 |
| &ensp;&ensp;&#124;─station | object | 当前登录用户的 岗位<br>启用条件： LoginUser.isFull = true \|\| LoginUser.isStation = true |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─orgId | integer | 组织ID<br>#pd_core_org |
| &ensp;&ensp;&ensp;&ensp;&#124;─sortValue | integer | 排序 |
| &ensp;&ensp;&ensp;&ensp;&#124;─status | boolean | 状态 |
| &ensp;&ensp;&ensp;&ensp;&#124;─describe | string | 描述 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "account": "",
    "name": "",
    "orgId": 0,
    "stationId": 0,
    "mobile": "",
    "photo": "",
    "workDescribe": "",
    "loginCount": 0,
    "roles": [
      {
        "id": 0,
        "name": "",
        "code": "",
        "describe": "",
        "isEnable": false,
        "isReadonly": false
      }
    ],
    "org": {
      "id": 0,
      "name": "",
      "abbreviation": "",
      "parentId": 0,
      "sortValue": 0,
      "status": false,
      "describe": ""
    },
    "station": {
      "id": 0,
      "name": "",
      "orgId": 0,
      "sortValue": 0,
      "status": false,
      "describe": ""
    }
  },
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 查询角色的已关联用户

> BASIC

**Path:** /user/role/{roleId}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| roleId |  | 角色id |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| keyword |  | NO | 账号account或名称name |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─idList | array |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | integer |  |
| &ensp;&ensp;&#124;─userList | array |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createUser | integer |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─account | string | 账号 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─name | string | 姓名 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─orgId | integer | 组织ID<br>#core_org |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─stationId | integer | 岗位ID<br>#core_station |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─email | string | 邮箱 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─mobile | string | 手机 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─sex | string | 性别<br>#Sex{W:女;M:男;N:未知}<br>W :W="女"<br>M :M="男"<br>N :N="未知" |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─status | boolean | 启用状态 1启用 0禁用 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─avatar | string | 头像 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─workDescribe | string | 工作描述<br>比如：  市长、管理员、局长等等   用于登陆展示 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─passwordErrorLastTime | string | 最后一次输错密码时间 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─passwordErrorNum | integer | 密码错误次数 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─passwordExpireTime | string | 密码过期时间 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─password | string | 密码 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─lastLoginTime | string | 最后登录时间 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "idList": [
      0
    ],
    "userList": [
      {
        "id": 0,
        "createTime": "",
        "createUser": 0,
        "updateTime": "",
        "updateUser": 0,
        "account": "",
        "name": "",
        "orgId": 0,
        "stationId": 0,
        "email": "",
        "mobile": "",
        "sex": "",
        "status": false,
        "avatar": "",
        "workDescribe": "",
        "passwordErrorLastTime": "",
        "passwordErrorNum": 0,
        "passwordExpireTime": "",
        "password": "",
        "lastLoginTime": ""
      }
    ]
  },
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```





## Project name(项目名称)：authority

Project name(项目名称)：authority
Package(包名): mao.auth_server.controller.core
Class(类名): OrgController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2022/11/12
Time(创建时间)： 13:43
Version(版本): 1.0
Description(描述)： 无


---
### 分页查询组织

> BASIC

**Path:** /org/page

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| id |  | YES |  |
| createTime |  | NO |  |
| createUser |  | NO |  |
| updateTime |  | NO |  |
| updateUser |  | NO |  |
| name |  | YES | 名称 |
| abbreviation |  | NO | 简称 |
| parentId |  | NO | 父ID |
| treePath |  | NO | 树结构 |
| sortValue |  | NO | 排序 |
| status | NO | NO | 状态 |
| describe |  | NO | 描述 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {},
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 查询组织

> BASIC

**Path:** /org/{id}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| id |  |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| &ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&#124;─name | string | 名称 |
| &ensp;&ensp;&#124;─abbreviation | string | 简称 |
| &ensp;&ensp;&#124;─parentId | integer | 父ID |
| &ensp;&ensp;&#124;─treePath | string | 树结构 |
| &ensp;&ensp;&#124;─sortValue | integer | 排序 |
| &ensp;&ensp;&#124;─status | boolean | 状态 |
| &ensp;&ensp;&#124;─describe | string | 描述 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "createTime": "",
    "createUser": 0,
    "updateTime": "",
    "updateUser": 0,
    "name": "",
    "abbreviation": "",
    "parentId": 0,
    "treePath": "",
    "sortValue": 0,
    "status": false,
    "describe": ""
  },
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 新增组织

> BASIC

**Path:** /org

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| name | string | 名称 |
| abbreviation | string | 简称 |
| parentId | integer | 父ID |
| sortValue | integer | 排序 |
| status | boolean | 状态 |
| describe | string | 描述 |

**Request Demo:**

```json
{
  "name": "",
  "abbreviation": "",
  "parentId": 0,
  "sortValue": 0,
  "status": false,
  "describe": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| &ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&#124;─name | string | 名称 |
| &ensp;&ensp;&#124;─abbreviation | string | 简称 |
| &ensp;&ensp;&#124;─parentId | integer | 父ID |
| &ensp;&ensp;&#124;─treePath | string | 树结构 |
| &ensp;&ensp;&#124;─sortValue | integer | 排序 |
| &ensp;&ensp;&#124;─status | boolean | 状态 |
| &ensp;&ensp;&#124;─describe | string | 描述 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "createTime": "",
    "createUser": 0,
    "updateTime": "",
    "updateUser": 0,
    "name": "",
    "abbreviation": "",
    "parentId": 0,
    "treePath": "",
    "sortValue": 0,
    "status": false,
    "describe": ""
  },
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 修改组织

> BASIC

**Path:** /org

**Method:** PUT

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer |  |
| name | string | 名称 |
| abbreviation | string | 简称 |
| parentId | integer | 父ID |
| sortValue | integer | 排序 |
| status | boolean | 状态 |
| describe | string | 描述 |

**Request Demo:**

```json
{
  "id": 0,
  "name": "",
  "abbreviation": "",
  "parentId": 0,
  "sortValue": 0,
  "status": false,
  "describe": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| &ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&#124;─name | string | 名称 |
| &ensp;&ensp;&#124;─abbreviation | string | 简称 |
| &ensp;&ensp;&#124;─parentId | integer | 父ID |
| &ensp;&ensp;&#124;─treePath | string | 树结构 |
| &ensp;&ensp;&#124;─sortValue | integer | 排序 |
| &ensp;&ensp;&#124;─status | boolean | 状态 |
| &ensp;&ensp;&#124;─describe | string | 描述 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "createTime": "",
    "createUser": 0,
    "updateTime": "",
    "updateUser": 0,
    "name": "",
    "abbreviation": "",
    "parentId": 0,
    "treePath": "",
    "sortValue": 0,
    "status": false,
    "describe": ""
  },
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 删除组织

> BASIC

**Path:** /org

**Method:** DELETE

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| ids[] |  | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 查询系统所有的组织树

> BASIC

**Path:** /org/tree

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| name |  | NO |  |
| status | NO | NO |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─createUser | integer |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─abbreviation | string | 简称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─parentId | integer | 父ID |
| &ensp;&ensp;&ensp;&ensp;&#124;─treePath | string | 树结构 |
| &ensp;&ensp;&ensp;&ensp;&#124;─sortValue | integer | 排序 |
| &ensp;&ensp;&ensp;&ensp;&#124;─status | boolean | 状态 |
| &ensp;&ensp;&ensp;&ensp;&#124;─describe | string | 描述 |
| &ensp;&ensp;&ensp;&ensp;&#124;─children | array |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createUser | integer |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─name | string | 名称 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─abbreviation | string | 简称 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─parentId | integer | 父ID |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─treePath | string | 树结构 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─sortValue | integer | 排序 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─status | boolean | 状态 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─describe | string | 描述 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─children | array |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─label | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─label | string |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "id": 0,
      "createTime": "",
      "createUser": 0,
      "updateTime": "",
      "updateUser": 0,
      "name": "",
      "abbreviation": "",
      "parentId": 0,
      "treePath": "",
      "sortValue": 0,
      "status": false,
      "describe": "",
      "children": [
        {
          "id": 0,
          "createTime": "",
          "createUser": 0,
          "updateTime": "",
          "updateUser": 0,
          "name": "",
          "abbreviation": "",
          "parentId": 0,
          "treePath": "",
          "sortValue": 0,
          "status": false,
          "describe": "",
          "children": [],
          "label": ""
        }
      ],
      "label": ""
    }
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```





## Project name(项目名称)：authority

Project name(项目名称)：authority
Package(包名): mao.auth_server.controller.core
Class(类名): StationController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2022/11/12
Time(创建时间)： 19:42
Version(版本): 1.0
Description(描述)： 无


---
### 分页查询岗位

> BASIC

**Path:** /station/page

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| name |  | NO | 名称 |
| orgId |  | NO | 组织ID<br>#core_org |
| status | NO | NO | 状态 |
| describe |  | NO | 描述 |
| startCreateTime |  | NO |  |
| endCreateTime |  | NO |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {},
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 根据id查询岗位

> BASIC

**Path:** /station/{id}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| id |  |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| &ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&#124;─name | string | 名称 |
| &ensp;&ensp;&#124;─orgId | integer | 组织ID<br>#core_org |
| &ensp;&ensp;&#124;─status | boolean | 状态 |
| &ensp;&ensp;&#124;─describe | string | 描述 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "createTime": "",
    "createUser": 0,
    "updateTime": "",
    "updateUser": 0,
    "name": "",
    "orgId": 0,
    "status": false,
    "describe": ""
  },
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 新增岗位

> BASIC

**Path:** /station

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| name | string | 名称 |
| orgId | integer | 组织ID<br>#core_org |
| status | boolean | 状态 |
| describe | string | 描述 |

**Request Demo:**

```json
{
  "name": "",
  "orgId": 0,
  "status": false,
  "describe": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| &ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&#124;─name | string | 名称 |
| &ensp;&ensp;&#124;─orgId | integer | 组织ID<br>#core_org |
| &ensp;&ensp;&#124;─status | boolean | 状态 |
| &ensp;&ensp;&#124;─describe | string | 描述 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "createTime": "",
    "createUser": 0,
    "updateTime": "",
    "updateUser": 0,
    "name": "",
    "orgId": 0,
    "status": false,
    "describe": ""
  },
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 修改岗位

> BASIC

**Path:** /station

**Method:** PUT

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer |  |
| name | string | 名称 |
| orgId | integer | 组织ID<br>#core_org |
| status | boolean | 状态 |
| describe | string | 描述 |

**Request Demo:**

```json
{
  "id": 0,
  "name": "",
  "orgId": 0,
  "status": false,
  "describe": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| &ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&#124;─name | string | 名称 |
| &ensp;&ensp;&#124;─orgId | integer | 组织ID<br>#core_org |
| &ensp;&ensp;&#124;─status | boolean | 状态 |
| &ensp;&ensp;&#124;─describe | string | 描述 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "createTime": "",
    "createUser": 0,
    "updateTime": "",
    "updateUser": 0,
    "name": "",
    "orgId": 0,
    "status": false,
    "describe": ""
  },
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 删除岗位

> BASIC

**Path:** /station

**Method:** DELETE

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| ids[] |  | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```





## Project name(项目名称)：authority

Project name(项目名称)：authority
Package(包名): mao.auth_server.controller.common
Class(类名): OptLogController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2022/11/12
Time(创建时间)： 13:33
Version(版本): 1.0
Description(描述)： 无


---
### 分页查询系统操作日志

> BASIC

**Path:** /optLog/page

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| id |  | YES |  |
| createTime |  | NO |  |
| createUser |  | NO |  |
| requestIp |  | NO | 操作IP |
| type |  | NO | 日志类型<br>#LogType{OPT:操作类型;EX:异常类型}<br>OPT :OPT="操作类型"<br>EX :EX="异常类型" |
| userName |  | NO | 操作人 |
| description |  | NO | 操作描述 |
| classPath |  | NO | 类路径 |
| actionMethod |  | NO | 请求方法 |
| requestUri |  | NO | 请求地址 |
| httpMethod |  | NO | 请求类型<br>#HttpMethod{GET:GET请求;POST:POST请求;PUT:PUT请求;DELETE:DELETE请求;PATCH:PATCH请求;TRACE:TRACE请求;HEAD:HEAD请求;OPTIONS:OPTIONS请求;}<br>GET :GET:GET<br>POST :POST:POST<br>PUT :PUT:PUT<br>DELETE :DELETE:DELETE<br>PATCH :PATCH:PATCH<br>TRACE :TRACE:TRACE<br>HEAD :HEAD:HEAD<br>OPTIONS :OPTIONS:OPTIONS |
| params |  | NO | 请求参数 |
| result |  | NO | 返回值 |
| exDesc |  | NO | 异常详情信息 |
| exDetail |  | NO | 异常描述 |
| startTime |  | NO | 开始时间 |
| finishTime |  | NO | 完成时间 |
| consumingTime |  | NO | 消耗时间 |
| ua |  | NO | 浏览器 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {},
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 查询系统操作日志

> BASIC

**Path:** /optLog/{id}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| id |  |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| &ensp;&ensp;&#124;─requestIp | string | 操作IP |
| &ensp;&ensp;&#124;─type | string | 日志类型<br>#LogType{OPT:操作类型;EX:异常类型}<br>OPT :OPT="操作类型"<br>EX :EX="异常类型" |
| &ensp;&ensp;&#124;─userName | string | 操作人 |
| &ensp;&ensp;&#124;─description | string | 操作描述 |
| &ensp;&ensp;&#124;─classPath | string | 类路径 |
| &ensp;&ensp;&#124;─actionMethod | string | 请求方法 |
| &ensp;&ensp;&#124;─requestUri | string | 请求地址 |
| &ensp;&ensp;&#124;─httpMethod | string | 请求类型<br>#HttpMethod{GET:GET请求;POST:POST请求;PUT:PUT请求;DELETE:DELETE请求;PATCH:PATCH请求;TRACE:TRACE请求;HEAD:HEAD请求;OPTIONS:OPTIONS请求;}<br>GET :GET:GET<br>POST :POST:POST<br>PUT :PUT:PUT<br>DELETE :DELETE:DELETE<br>PATCH :PATCH:PATCH<br>TRACE :TRACE:TRACE<br>HEAD :HEAD:HEAD<br>OPTIONS :OPTIONS:OPTIONS |
| &ensp;&ensp;&#124;─params | string | 请求参数 |
| &ensp;&ensp;&#124;─result | string | 返回值 |
| &ensp;&ensp;&#124;─exDesc | string | 异常详情信息 |
| &ensp;&ensp;&#124;─exDetail | string | 异常描述 |
| &ensp;&ensp;&#124;─startTime | string | 开始时间 |
| &ensp;&ensp;&#124;─finishTime | string | 完成时间 |
| &ensp;&ensp;&#124;─consumingTime | integer | 消耗时间 |
| &ensp;&ensp;&#124;─ua | string | 浏览器 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "createTime": "",
    "createUser": 0,
    "requestIp": "",
    "type": "",
    "userName": "",
    "description": "",
    "classPath": "",
    "actionMethod": "",
    "requestUri": "",
    "httpMethod": "",
    "params": "",
    "result": "",
    "exDesc": "",
    "exDetail": "",
    "startTime": "",
    "finishTime": "",
    "consumingTime": 0,
    "ua": ""
  },
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 删除系统操作日志

> BASIC

**Path:** /optLog

**Method:** DELETE

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| ids[] |  | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```





## Project name(项目名称)：authority

Project name(项目名称)：authority
Package(包名): mao.auth_server.controller.auth
Class(类名): RoleAuthorityController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2022/11/12
Time(创建时间)： 20:28
Version(版本): 1.0
Description(描述)： 无


---
### 查询指定角色关联的菜单和资源

> BASIC

**Path:** /roleAuthority/{roleId}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| roleId |  |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─createUser | integer |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─authorityId | integer | 资源id<br>#auth_resource<br>#auth_menu |
| &ensp;&ensp;&ensp;&ensp;&#124;─authorityType | string | 权限类型<br>#AuthorizeType{MENU:菜单;RESOURCE:资源;}<br>MENU :MENU="菜单"<br>RESOURCE :RESOURCE="资源" |
| &ensp;&ensp;&ensp;&ensp;&#124;─roleId | integer | 角色id<br>#auth_role |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "id": 0,
      "createTime": "",
      "createUser": 0,
      "authorityId": 0,
      "authorityType": "",
      "roleId": 0
    }
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```





## Project name(项目名称)：authority

Project name(项目名称)：authority
Package(包名): mao.auth_server.controller.common
Class(类名): DashboardController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2022/11/12
Time(创建时间)： 13:40
Version(版本): 1.0
Description(描述)： 无


---
### 最近10天访问记录

> BASIC

**Path:** /dashboard/visit

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| id |  | NO | id |
| account |  | NO | 账号 |
| name |  | NO | 姓名 |
| orgId |  | NO | 组织ID<br>#pd_core_org |
| stationId |  | NO | 岗位ID<br>#pd_core_station |
| mobile |  | NO | 手机<br>启用条件： LoginUser.isFull = true \|\| LoginUser.isUser = true |
| photo |  | NO | 照片<br>启用条件： LoginUser.isFull = true \|\| LoginUser.isUser = true |
| workDescribe |  | NO | 工作描述<br>比如：  市长、管理员、局长等等   用于登陆展示<br>启用条件： LoginUser.isFull = true \|\| LoginUser.isUser = true |
| loginCount |  | NO | 登录次数<br>一直累计，记录了此账号总共登录次数<br>启用条件： LoginUser.isFull = true \|\| LoginUser.isUser = true |
| roles[0].id |  | NO | id |
| roles[0].name |  | NO | 角色名称 |
| roles[0].code |  | NO | 角色编码 |
| roles[0].describe |  | NO | 功能描述 |
| roles[0].isEnable | NO | NO | 是否启用 |
| roles[0].isReadonly | NO | NO | 是否只读角色 |
| org.id |  | NO | id |
| org.name |  | NO | 名称 |
| org.abbreviation |  | NO | 简称 |
| org.parentId |  | NO | 父ID |
| org.sortValue |  | NO | 排序 |
| org.status | NO | NO | 状态 |
| org.describe |  | NO | 描述 |
| station.id |  | NO | id |
| station.name |  | NO | 名称 |
| station.orgId |  | NO | 组织ID<br>#pd_core_org |
| station.sortValue |  | NO | 排序 |
| station.status | NO | NO | 状态 |
| station.describe |  | NO | 描述 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─key | object |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "": {}
  },
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 生成id

> BASIC

**Path:** /common/generateId

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | integer | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": 0,
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```





## Project name(项目名称)：authority

Project name(项目名称)：authority
Package(包名): mao.auth_server.controller.common
Class(类名): LoginLogController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2022/11/12
Time(创建时间)： 13:37
Version(版本): 1.0
Description(描述)： 无


---
### 分页查询登录日志

> BASIC

**Path:** /loginLog/page

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| id |  | YES |  |
| createTime |  | NO |  |
| createUser |  | NO |  |
| requestIp |  | NO | 操作IP |
| userId |  | NO | 登录人ID |
| userName |  | NO | 登录人姓名 |
| account |  | NO | 登录人账号 |
| description |  | NO | 登录描述 |
| loginDate |  | NO | 登录时间 |
| ua |  | NO | 浏览器请求头 |
| browser |  | NO | 浏览器名称 |
| browserVersion |  | NO | 浏览器版本 |
| operatingSystem |  | NO | 操作系统 |
| location |  | NO | 登录地点 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {},
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 查询登录日志

> BASIC

**Path:** /loginLog/{id}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| id |  |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| &ensp;&ensp;&#124;─requestIp | string | 操作IP |
| &ensp;&ensp;&#124;─userId | integer | 登录人ID |
| &ensp;&ensp;&#124;─userName | string | 登录人姓名 |
| &ensp;&ensp;&#124;─account | string | 登录人账号 |
| &ensp;&ensp;&#124;─description | string | 登录描述 |
| &ensp;&ensp;&#124;─loginDate | string | 登录时间 |
| &ensp;&ensp;&#124;─ua | string | 浏览器请求头 |
| &ensp;&ensp;&#124;─browser | string | 浏览器名称 |
| &ensp;&ensp;&#124;─browserVersion | string | 浏览器版本 |
| &ensp;&ensp;&#124;─operatingSystem | string | 操作系统 |
| &ensp;&ensp;&#124;─location | string | 登录地点 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "createTime": "",
    "createUser": 0,
    "requestIp": "",
    "userId": 0,
    "userName": "",
    "account": "",
    "description": "",
    "loginDate": "",
    "ua": "",
    "browser": "",
    "browserVersion": "",
    "operatingSystem": "",
    "location": ""
  },
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 新增登录日志

> BASIC

**Path:** /loginLog/anno/login/{account}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| account |  |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| description | 登陆成功 | NO |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| &ensp;&ensp;&#124;─requestIp | string | 操作IP |
| &ensp;&ensp;&#124;─userId | integer | 登录人ID |
| &ensp;&ensp;&#124;─userName | string | 登录人姓名 |
| &ensp;&ensp;&#124;─account | string | 登录人账号 |
| &ensp;&ensp;&#124;─description | string | 登录描述 |
| &ensp;&ensp;&#124;─loginDate | string | 登录时间 |
| &ensp;&ensp;&#124;─ua | string | 浏览器请求头 |
| &ensp;&ensp;&#124;─browser | string | 浏览器名称 |
| &ensp;&ensp;&#124;─browserVersion | string | 浏览器版本 |
| &ensp;&ensp;&#124;─operatingSystem | string | 操作系统 |
| &ensp;&ensp;&#124;─location | string | 登录地点 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "createTime": "",
    "createUser": 0,
    "requestIp": "",
    "userId": 0,
    "userName": "",
    "account": "",
    "description": "",
    "loginDate": "",
    "ua": "",
    "browser": "",
    "browserVersion": "",
    "operatingSystem": "",
    "location": ""
  },
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 删除登录日志

> BASIC

**Path:** /loginLog

**Method:** DELETE

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| ids[] |  | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```





## Project name(项目名称)：authority

Project name(项目名称)：authority
Package(包名): mao.auth_server.controller.auth
Class(类名): MenuController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2022/11/12
Time(创建时间)： 20:09
Version(版本): 1.0
Description(描述)： 无


---
### 分页查询菜单

> BASIC

**Path:** /menu/page

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| id |  | YES |  |
| createTime |  | NO |  |
| createUser |  | NO |  |
| updateTime |  | NO |  |
| updateUser |  | NO |  |
| name |  | YES | 菜单名称 |
| describe |  | NO | 功能描述 |
| isPublic | NO | NO | 是否公开菜单<br>就是无需分配就可以访问的。所有人可见 |
| path |  | NO | 对应路由path |
| component |  | NO | 对应路由组件component |
| isEnable | NO | NO | 是否启用 |
| sortValue |  | NO | 排序 |
| icon |  | NO | 菜单图标 |
| group |  | NO | 菜单分组 |
| parentId |  | NO | 父级菜单id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {},
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 查询菜单

> BASIC

**Path:** /menu/{id}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| id |  |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| &ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&#124;─name | string | 菜单名称 |
| &ensp;&ensp;&#124;─describe | string | 功能描述 |
| &ensp;&ensp;&#124;─isPublic | boolean | 是否公开菜单<br>就是无需分配就可以访问的。所有人可见 |
| &ensp;&ensp;&#124;─path | string | 对应路由path |
| &ensp;&ensp;&#124;─component | string | 对应路由组件component |
| &ensp;&ensp;&#124;─isEnable | boolean | 是否启用 |
| &ensp;&ensp;&#124;─sortValue | integer | 排序 |
| &ensp;&ensp;&#124;─icon | string | 菜单图标 |
| &ensp;&ensp;&#124;─group | string | 菜单分组 |
| &ensp;&ensp;&#124;─parentId | integer | 父级菜单id |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "createTime": "",
    "createUser": 0,
    "updateTime": "",
    "updateUser": 0,
    "name": "",
    "describe": "",
    "isPublic": false,
    "path": "",
    "component": "",
    "isEnable": false,
    "sortValue": 0,
    "icon": "",
    "group": "",
    "parentId": 0
  },
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 新增菜单

> BASIC

**Path:** /menu

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| name | string | 菜单名称 |
| describe | string | 功能描述 |
| isPublic | boolean | 是否公开菜单<br>就是无需分配就可以访问的。所有人可见 |
| path | string | 对应路由path |
| component | string | 对应路由组件component |
| isEnable | boolean | 是否启用 |
| sortValue | integer | 排序 |
| icon | string | 菜单图标 |
| group | string | 菜单分组 |
| parentId | integer | 父级菜单id |

**Request Demo:**

```json
{
  "name": "",
  "describe": "",
  "isPublic": false,
  "path": "",
  "component": "",
  "isEnable": false,
  "sortValue": 0,
  "icon": "",
  "group": "",
  "parentId": 0
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| &ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&#124;─name | string | 菜单名称 |
| &ensp;&ensp;&#124;─describe | string | 功能描述 |
| &ensp;&ensp;&#124;─isPublic | boolean | 是否公开菜单<br>就是无需分配就可以访问的。所有人可见 |
| &ensp;&ensp;&#124;─path | string | 对应路由path |
| &ensp;&ensp;&#124;─component | string | 对应路由组件component |
| &ensp;&ensp;&#124;─isEnable | boolean | 是否启用 |
| &ensp;&ensp;&#124;─sortValue | integer | 排序 |
| &ensp;&ensp;&#124;─icon | string | 菜单图标 |
| &ensp;&ensp;&#124;─group | string | 菜单分组 |
| &ensp;&ensp;&#124;─parentId | integer | 父级菜单id |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "createTime": "",
    "createUser": 0,
    "updateTime": "",
    "updateUser": 0,
    "name": "",
    "describe": "",
    "isPublic": false,
    "path": "",
    "component": "",
    "isEnable": false,
    "sortValue": 0,
    "icon": "",
    "group": "",
    "parentId": 0
  },
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 修改菜单

> BASIC

**Path:** /menu

**Method:** PUT

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer |  |
| name | string | 菜单名称 |
| describe | string | 功能描述 |
| isPublic | boolean | 是否公开菜单<br>就是无需分配就可以访问的。所有人可见 |
| path | string | 对应路由path |
| component | string | 对应路由组件component |
| isEnable | boolean | 是否启用 |
| sortValue | integer | 排序 |
| icon | string | 菜单图标 |
| group | string | 菜单分组 |
| parentId | integer | 父级菜单id |

**Request Demo:**

```json
{
  "id": 0,
  "name": "",
  "describe": "",
  "isPublic": false,
  "path": "",
  "component": "",
  "isEnable": false,
  "sortValue": 0,
  "icon": "",
  "group": "",
  "parentId": 0
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| &ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&#124;─name | string | 菜单名称 |
| &ensp;&ensp;&#124;─describe | string | 功能描述 |
| &ensp;&ensp;&#124;─isPublic | boolean | 是否公开菜单<br>就是无需分配就可以访问的。所有人可见 |
| &ensp;&ensp;&#124;─path | string | 对应路由path |
| &ensp;&ensp;&#124;─component | string | 对应路由组件component |
| &ensp;&ensp;&#124;─isEnable | boolean | 是否启用 |
| &ensp;&ensp;&#124;─sortValue | integer | 排序 |
| &ensp;&ensp;&#124;─icon | string | 菜单图标 |
| &ensp;&ensp;&#124;─group | string | 菜单分组 |
| &ensp;&ensp;&#124;─parentId | integer | 父级菜单id |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "createTime": "",
    "createUser": 0,
    "updateTime": "",
    "updateUser": 0,
    "name": "",
    "describe": "",
    "isPublic": false,
    "path": "",
    "component": "",
    "isEnable": false,
    "sortValue": 0,
    "icon": "",
    "group": "",
    "parentId": 0
  },
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 删除菜单

> BASIC

**Path:** /menu

**Method:** DELETE

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| ids[] |  | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 查询用户可用的所有资源

> BASIC

**Path:** /menu

**Method:** GET

**Desc:**

 「已废弃」

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| group |  | NO | 菜单分组 |
| userId |  | NO | 指定用户id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─createUser | integer |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 菜单名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─describe | string | 功能描述 |
| &ensp;&ensp;&ensp;&ensp;&#124;─isPublic | boolean | 是否公开菜单<br>就是无需分配就可以访问的。所有人可见 |
| &ensp;&ensp;&ensp;&ensp;&#124;─path | string | 对应路由path |
| &ensp;&ensp;&ensp;&ensp;&#124;─component | string | 对应路由组件component |
| &ensp;&ensp;&ensp;&ensp;&#124;─isEnable | boolean | 是否启用 |
| &ensp;&ensp;&ensp;&ensp;&#124;─sortValue | integer | 排序 |
| &ensp;&ensp;&ensp;&ensp;&#124;─icon | string | 菜单图标 |
| &ensp;&ensp;&ensp;&ensp;&#124;─group | string | 菜单分组 |
| &ensp;&ensp;&ensp;&ensp;&#124;─parentId | integer | 父级菜单id |
| &ensp;&ensp;&ensp;&ensp;&#124;─children | array |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createUser | integer |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─name | string | 菜单名称 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─describe | string | 功能描述 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─isPublic | boolean | 是否公开菜单<br>就是无需分配就可以访问的。所有人可见 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─path | string | 对应路由path |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─component | string | 对应路由组件component |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─isEnable | boolean | 是否启用 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─sortValue | integer | 排序 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─icon | string | 菜单图标 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─group | string | 菜单分组 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─parentId | integer | 父级菜单id |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─children | array |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─label | string | 标签 |
| &ensp;&ensp;&ensp;&ensp;&#124;─label | string | 标签 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "id": 0,
      "createTime": "",
      "createUser": 0,
      "updateTime": "",
      "updateUser": 0,
      "name": "",
      "describe": "",
      "isPublic": false,
      "path": "",
      "component": "",
      "isEnable": false,
      "sortValue": 0,
      "icon": "",
      "group": "",
      "parentId": 0,
      "children": [
        {
          "id": 0,
          "createTime": "",
          "createUser": 0,
          "updateTime": "",
          "updateUser": 0,
          "name": "",
          "describe": "",
          "isPublic": false,
          "path": "",
          "component": "",
          "isEnable": false,
          "sortValue": 0,
          "icon": "",
          "group": "",
          "parentId": 0,
          "children": [],
          "label": ""
        }
      ],
      "label": ""
    }
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 查询用户可用的所有菜单路由树

> BASIC

**Path:** /menu/router

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| group |  | NO | 组 |
| userId |  | NO | 用户id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─path | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─component | string | @ApiModelProperty(value = "功能描述") |
| &ensp;&ensp;&ensp;&ensp;&#124;─redirect | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─meta | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─title | string | 标题 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─icon | string | 图标 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─breadcrumb | boolean | 面包屑 |
| &ensp;&ensp;&ensp;&ensp;&#124;─hidden | boolean |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─alwaysShow | boolean |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─children | array |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─path | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─name | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─component | string | @ApiModelProperty(value = "功能描述") |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─redirect | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─meta | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─title | string | 标题 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─icon | string | 图标 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─breadcrumb | boolean | 面包屑 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─hidden | boolean |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─alwaysShow | boolean |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─children | array |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "path": "",
      "name": "",
      "component": "",
      "redirect": "",
      "meta": {
        "title": "",
        "icon": "",
        "breadcrumb": "true"
      },
      "hidden": "false",
      "alwaysShow": "false",
      "children": [
        {
          "path": "",
          "name": "",
          "component": "",
          "redirect": "",
          "meta": {
            "title": "",
            "icon": "",
            "breadcrumb": "true"
          },
          "hidden": "false",
          "alwaysShow": "false",
          "children": []
        }
      ]
    }
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### adminRouter

> BASIC

**Path:** /menu/admin/router

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─path | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─component | string | @ApiModelProperty(value = "功能描述") |
| &ensp;&ensp;&ensp;&ensp;&#124;─redirect | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─meta | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─title | string | 标题 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─icon | string | 图标 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─breadcrumb | boolean | 面包屑 |
| &ensp;&ensp;&ensp;&ensp;&#124;─hidden | boolean |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─alwaysShow | boolean |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─children | array |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─path | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─name | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─component | string | @ApiModelProperty(value = "功能描述") |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─redirect | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─meta | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─title | string | 标题 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─icon | string | 图标 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─breadcrumb | boolean | 面包屑 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─hidden | boolean |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─alwaysShow | boolean |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─children | array |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "path": "",
      "name": "",
      "component": "",
      "redirect": "",
      "meta": {
        "title": "",
        "icon": "",
        "breadcrumb": "true"
      },
      "hidden": "false",
      "alwaysShow": "false",
      "children": [
        {
          "path": "",
          "name": "",
          "component": "",
          "redirect": "",
          "meta": {
            "title": "",
            "icon": "",
            "breadcrumb": "true"
          },
          "hidden": "false",
          "alwaysShow": "false",
          "children": []
        }
      ]
    }
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 查询系统中所有的的菜单树结构， 不用缓存，因为该接口很少会使用，就算使用，也会管理员维护菜单时使用

> BASIC

**Path:** /menu/tree

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─createUser | integer |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 菜单名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─describe | string | 功能描述 |
| &ensp;&ensp;&ensp;&ensp;&#124;─isPublic | boolean | 是否公开菜单<br>就是无需分配就可以访问的。所有人可见 |
| &ensp;&ensp;&ensp;&ensp;&#124;─path | string | 对应路由path |
| &ensp;&ensp;&ensp;&ensp;&#124;─component | string | 对应路由组件component |
| &ensp;&ensp;&ensp;&ensp;&#124;─isEnable | boolean | 是否启用 |
| &ensp;&ensp;&ensp;&ensp;&#124;─sortValue | integer | 排序 |
| &ensp;&ensp;&ensp;&ensp;&#124;─icon | string | 菜单图标 |
| &ensp;&ensp;&ensp;&ensp;&#124;─group | string | 菜单分组 |
| &ensp;&ensp;&ensp;&ensp;&#124;─parentId | integer | 父级菜单id |
| &ensp;&ensp;&ensp;&ensp;&#124;─children | array |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createUser | integer |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─name | string | 菜单名称 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─describe | string | 功能描述 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─isPublic | boolean | 是否公开菜单<br>就是无需分配就可以访问的。所有人可见 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─path | string | 对应路由path |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─component | string | 对应路由组件component |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─isEnable | boolean | 是否启用 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─sortValue | integer | 排序 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─icon | string | 菜单图标 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─group | string | 菜单分组 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─parentId | integer | 父级菜单id |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─children | array |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─label | string | 标签 |
| &ensp;&ensp;&ensp;&ensp;&#124;─label | string | 标签 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "id": 0,
      "createTime": "",
      "createUser": 0,
      "updateTime": "",
      "updateUser": 0,
      "name": "",
      "describe": "",
      "isPublic": false,
      "path": "",
      "component": "",
      "isEnable": false,
      "sortValue": 0,
      "icon": "",
      "group": "",
      "parentId": 0,
      "children": [
        {
          "id": 0,
          "createTime": "",
          "createUser": 0,
          "updateTime": "",
          "updateUser": 0,
          "name": "",
          "describe": "",
          "isPublic": false,
          "path": "",
          "component": "",
          "isEnable": false,
          "sortValue": 0,
          "icon": "",
          "group": "",
          "parentId": 0,
          "children": [],
          "label": ""
        }
      ],
      "label": ""
    }
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```





## Project name(项目名称)：authority

Project name(项目名称)：authority
Package(包名): mao.auth_server.controller.auth
Class(类名): ResourceController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2022/11/12
Time(创建时间)： 20:25
Version(版本): 1.0
Description(描述)： 无


---
### 分页查询资源

> BASIC

**Path:** /resource/page

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| id |  | YES |  |
| createTime |  | NO |  |
| createUser |  | NO |  |
| updateTime |  | NO |  |
| updateUser |  | NO |  |
| code |  | NO | 资源编码<br>规则：<br>链接：<br>数据列：<br>按钮： |
| name |  | YES | 接口名称 |
| menuId |  | NO | 菜单ID<br>#auth_menu |
| describe |  | NO | 接口描述 |
| method |  | NO |  |
| url |  | NO |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {},
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 查询资源

> BASIC

**Path:** /resource/{id}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| id |  |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| &ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&#124;─code | string | 资源编码<br>规则：<br>链接：<br>数据列：<br>按钮： |
| &ensp;&ensp;&#124;─name | string | 接口名称 |
| &ensp;&ensp;&#124;─menuId | integer | 菜单ID<br>#auth_menu |
| &ensp;&ensp;&#124;─describe | string | 接口描述 |
| &ensp;&ensp;&#124;─method | string |  |
| &ensp;&ensp;&#124;─url | string |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "createTime": "",
    "createUser": 0,
    "updateTime": "",
    "updateUser": 0,
    "code": "",
    "name": "",
    "menuId": 0,
    "describe": "",
    "method": "",
    "url": ""
  },
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 新增资源

> BASIC

**Path:** /resource

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | string | 资源编码<br>规则：<br>链接：<br>数据列：<br>按钮： |
| name | string | 接口名称 |
| menuId | integer | 菜单ID<br>#auth_menu |
| describe | string | 接口描述 |

**Request Demo:**

```json
{
  "code": "",
  "name": "",
  "menuId": 0,
  "describe": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| &ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&#124;─code | string | 资源编码<br>规则：<br>链接：<br>数据列：<br>按钮： |
| &ensp;&ensp;&#124;─name | string | 接口名称 |
| &ensp;&ensp;&#124;─menuId | integer | 菜单ID<br>#auth_menu |
| &ensp;&ensp;&#124;─describe | string | 接口描述 |
| &ensp;&ensp;&#124;─method | string |  |
| &ensp;&ensp;&#124;─url | string |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "createTime": "",
    "createUser": 0,
    "updateTime": "",
    "updateUser": 0,
    "code": "",
    "name": "",
    "menuId": 0,
    "describe": "",
    "method": "",
    "url": ""
  },
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 修改资源

> BASIC

**Path:** /resource

**Method:** PUT

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer |  |
| name | string | 接口名称 |
| menuId | integer | 菜单ID<br>#auth_menu |
| describe | string | 接口描述 |

**Request Demo:**

```json
{
  "id": 0,
  "name": "",
  "menuId": 0,
  "describe": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| &ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&#124;─code | string | 资源编码<br>规则：<br>链接：<br>数据列：<br>按钮： |
| &ensp;&ensp;&#124;─name | string | 接口名称 |
| &ensp;&ensp;&#124;─menuId | integer | 菜单ID<br>#auth_menu |
| &ensp;&ensp;&#124;─describe | string | 接口描述 |
| &ensp;&ensp;&#124;─method | string |  |
| &ensp;&ensp;&#124;─url | string |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "createTime": "",
    "createUser": 0,
    "updateTime": "",
    "updateUser": 0,
    "code": "",
    "name": "",
    "menuId": 0,
    "describe": "",
    "method": "",
    "url": ""
  },
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 删除资源

> BASIC

**Path:** /resource

**Method:** DELETE

**Desc:**

 链接类型的资源 只清空 menu_id
按钮和数据列 则物理删除

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| ids[] |  | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 查询用户可用的所有资源

> BASIC

**Path:** /resource

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| menuId |  | NO | 父资源id， 用于查询按钮 |
| userId |  | NO | 登录人用户id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─createUser | integer |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─code | string | 资源编码<br>规则：<br>链接：<br>数据列：<br>按钮： |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 接口名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─menuId | integer | 菜单ID<br>#auth_menu |
| &ensp;&ensp;&ensp;&ensp;&#124;─describe | string | 接口描述 |
| &ensp;&ensp;&ensp;&ensp;&#124;─method | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─url | string |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "id": 0,
      "createTime": "",
      "createUser": 0,
      "updateTime": "",
      "updateUser": 0,
      "code": "",
      "name": "",
      "menuId": 0,
      "describe": "",
      "method": "",
      "url": ""
    }
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 查询所有资源

> BASIC

**Path:** /resource/list

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {}
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```







# chat-room-netty-server

exported at 2023-04-21 15:38:17

## Project name(项目名称)：netty_chat_room

Project name(项目名称)：netty_chat_room
Package(包名): mao.chat_room_netty_server.controller
Class(类名): NettyController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/4/1
Time(创建时间)： 16:41
Version(版本): 1.0
Description(描述)： netty消息接收controller


---
### 发送聊天消息

> BASIC

**Path:** /send

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| sequenceId | integer | 序列id |
| time | string | 时间 |
| messageType | integer | 消息类型 |
| content | string | 消息内容 |
| to | string | 消息到哪里去（发给谁） |
| from | string | 消息来自哪里（谁发的） |

**Request Demo:**

```json
{
  "sequenceId": 0,
  "time": "",
  "messageType": 0,
  "content": "",
  "to": "",
  "from": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 得到当前实例的netty的端口号

> BASIC

**Path:** /port

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | integer | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": 0,
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 发送群聊创建消息

> BASIC

**Path:** /sendGroupCreateMessage

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | array | 群聊创建响应消息集合 |
|  | object |  |
| &ensp;&ensp;&#124;─sequenceId | integer | 序列id |
| &ensp;&ensp;&#124;─time | string | 时间 |
| &ensp;&ensp;&#124;─messageType | integer | 消息类型 |
| &ensp;&ensp;&#124;─success | boolean | 是否是成功的消息 |
| &ensp;&ensp;&#124;─reason | string | 如果失败，失败的原因 |
| &ensp;&ensp;&#124;─members | array | 群成员 |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | string |  |

**Request Demo:**

```json
[
  {
    "sequenceId": 0,
    "time": "",
    "messageType": 0,
    "success": false,
    "reason": "",
    "members": [
      ""
    ]
  }
]
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 发送群聊聊天消息

> BASIC

**Path:** /sendGroupChatMessage

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| key | object |  |
| &ensp;&ensp;&#124;─sequenceId | integer | 序列id |
| &ensp;&ensp;&#124;─time | string | 时间 |
| &ensp;&ensp;&#124;─messageType | integer | 消息类型 |
| &ensp;&ensp;&#124;─success | boolean | 是否是成功的消息 |
| &ensp;&ensp;&#124;─reason | string | 如果失败，失败的原因 |
| &ensp;&ensp;&#124;─from | string | 谁发的消息 |
| &ensp;&ensp;&#124;─content | string | 内容 |
| &ensp;&ensp;&#124;─groupName | string | 群聊名称 |

**Request Demo:**

```json
{
  "": {
    "sequenceId": 0,
    "time": "",
    "messageType": 0,
    "success": false,
    "reason": "",
    "from": "",
    "content": "",
    "groupName": ""
  }
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 成员加入本地群聊

> BASIC

**Path:** /joinMember

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| name |  | YES | 群聊名字 |
| member |  | YES | 群聊成员 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 成员退出本地群聊

> BASIC

**Path:** /removeMember

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| name |  | YES | 群聊名字 |
| member |  | YES | 群聊成员 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 得到当前实例在线用户数量，不包括未登录但是已经连接上的

> BASIC

**Path:** /getOnlineUserCount

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | integer | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": 0,
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```





## Project name(项目名称)：netty_chat_room

Project name(项目名称)：netty_chat_room
Package(包名): mao.chat_room_netty_server.controller
Class(类名): ReBalanceController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/4/13
Time(创建时间)： 15:33
Version(版本): 1.0
Description(描述)： 负载均衡相关


---
### ReBalance处理

> BASIC

**Path:** /reBalance/handler

**Method:** POST

**Desc:**

 随机从用户列表中抽 reBalanceNumber 的数量的用户，让他们重新负载均衡到 host 这个新实例上
比如reBalanceNumber为7，host为56.87.28.29:2457 ，随机抽7个用户让他们重新连接到56.87.28.29:2457这个host上

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| host |  | YES | 实例的地址 |
| reBalanceNumber |  | YES | 重新平衡的数量 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```





## Project name(项目名称)：netty_chat_room

Project name(项目名称)：netty_chat_room
Package(包名): mao.chat_room_netty_server.controller
Class(类名): UserController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/4/10
Time(创建时间)： 23:57
Version(版本): 1.0
Description(描述)： 用户相关


---
### 设置用户状态

> BASIC

**Path:** /user/setUserStatus/{username}/{status}

**Method:** PUT

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| username |  | 用户名 |
| status |  | 状态，false表示禁用，ture表示启用 |

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 通过用户名得到用户信息

> BASIC

**Path:** /user/{username}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| username |  | 用户名 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─username | string | 用户名 |
| &ensp;&ensp;&#124;─status | boolean | 启用状态 1启用 0禁用 |
| &ensp;&ensp;&#124;─lastLoginTime | string | 最后登录时间 |
| &ensp;&ensp;&#124;─registerTime | string | 注册时间 |
| &ensp;&ensp;&#124;─passwordErrorLastTime | string | 最后一次输错密码时间 |
| &ensp;&ensp;&#124;─passwordErrorNum | integer | 密码错误次数 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "username": "",
    "status": false,
    "lastLoginTime": "",
    "registerTime": "",
    "passwordErrorLastTime": "",
    "passwordErrorNum": 0
  },
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 分页查询角色

> BASIC

**Path:** /user/page

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| current |  | YES | 当前页 |
| size |  | YES | 页面大小 |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| username | string | 用户名 |
| status | boolean | 启用状态 1启用 0禁用 |
| lastLoginTime | string | 最后登录时间 |
| registerTime | string | 注册时间 |
| passwordErrorLastTime | string | 最后一次输错密码时间 |
| passwordErrorNum | integer | 密码错误次数 |

**Request Demo:**

```json
{
  "username": "",
  "status": false,
  "lastLoginTime": "",
  "registerTime": "",
  "passwordErrorLastTime": "",
  "passwordErrorNum": 0
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {},
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```







# chat-room-manage

exported at 2023-04-21 15:38:17

## Project name(项目名称)：netty_chat_room

Project name(项目名称)：netty_chat_room
Package(包名): mao.chat_room_manage.controller
Class(类名): ServerController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/4/5
Time(创建时间)： 14:41
Version(版本): 1.0
Description(描述)： 服务实例相关


---
### getNettyServers

> BASIC

**Path:** /server/nettyServer

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {}
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```





## Project name(项目名称)：netty_chat_room

Project name(项目名称)：netty_chat_room
Package(包名): mao.chat_room_manage.controller
Class(类名): GroupCreateStatisticsController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/4/12
Time(创建时间)： 13:19
Version(版本): 1.0
Description(描述)： 群聊创建统计


---
### 得到最近一个月每天群聊创建的次数

> BASIC

**Path:** /statistics/group/create/getRecentMonthGroupCreateDayCount

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─time | string | 时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─count | integer | 统计结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "time": "",
      "count": 0
    }
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 得到最近一年每个月群聊创建的次数

> BASIC

**Path:** /statistics/group/create/getRecentYearGroupCreateMonthCount

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─time | string | 时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─count | integer | 统计结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "time": "",
      "count": 0
    }
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 得到用户某些天群聊创建的次数

> BASIC

**Path:** /statistics/group/create/getCreateDayGroupCountList

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| startYear |  | YES | 起始年 |
| startMonth |  | YES | 起始月 |
| startDay |  | YES | 起始天 |
| endYear |  | YES | 结束年 |
| endMonth |  | YES | 结束月 |
| endDay |  | YES | 结束天 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─time | string | 时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─count | integer | 统计结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "time": "",
      "count": 0
    }
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 得到用户某些月群聊创建的次数

> BASIC

**Path:** /statistics/group/create/getCreateMonthGroupCountList

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| startYear |  | YES | 起始年 |
| startMonth |  | YES | 起始月 |
| endYear |  | YES | 结束年 |
| endMonth |  | YES | 结束月 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─time | string | 时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─count | integer | 统计结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "time": "",
      "count": 0
    }
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```





## Project name(项目名称)：netty_chat_room

Project name(项目名称)：netty_chat_room
Package(包名): mao.chat_room_manage.controller
Class(类名): LoginStatisticsController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/4/11
Time(创建时间)： 14:32
Version(版本): 1.0
Description(描述)： 登录统计


---
### 得到最近一个月用户每天登录的次数

> BASIC

**Path:** /statistics/login/getRecentMonthLoginDayCount

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─time | string | 时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─count | integer | 统计结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "time": "",
      "count": 0
    }
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 得到最近一年每个月用户登录的次数

> BASIC

**Path:** /statistics/login/getRecentYearLoginMonthCount

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─time | string | 时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─count | integer | 统计结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "time": "",
      "count": 0
    }
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 得到最近一个月用户每天登录的大致人数 （一个人可能登录多次，但是只记录一次）

> BASIC

**Path:** /statistics/login/getRecentMonthLoginDayUVCount

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─time | string | 时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─count | integer | 统计结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "time": "",
      "count": 0
    }
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 得到最近一年每个月用户登录的大致人数 （一个人可能登录多次，但是只记录一次）

> BASIC

**Path:** /statistics/login/getRecentYearLoginMonthUVCount

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─time | string | 时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─count | integer | 统计结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "time": "",
      "count": 0
    }
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 得到用户某些天用户登录的次数

> BASIC

**Path:** /statistics/login/getLoginDayCountList

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| startYear |  | YES | 起始年 |
| startMonth |  | YES | 起始月 |
| startDay |  | YES | 起始天 |
| endYear |  | YES | 结束年 |
| endMonth |  | YES | 结束月 |
| endDay |  | YES | 结束天 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─time | string | 时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─count | integer | 统计结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "time": "",
      "count": 0
    }
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 得到用户某些月用户登录的次数

> BASIC

**Path:** /statistics/login/getLoginMonthCountList

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| startYear |  | YES | 起始年 |
| startMonth |  | YES | 起始月 |
| endYear |  | YES | 结束年 |
| endMonth |  | YES | 结束月 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─time | string | 时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─count | integer | 统计结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "time": "",
      "count": 0
    }
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 得到用户某些天用户登录的大致人数

> BASIC

**Path:** /statistics/login/getLoginDayUVCountList

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| startYear |  | YES | 起始年 |
| startMonth |  | YES | 起始月 |
| startDay |  | YES | 起始天 |
| endYear |  | YES | 结束年 |
| endMonth |  | YES | 结束月 |
| endDay |  | YES | 结束天 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─time | string | 时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─count | integer | 统计结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "time": "",
      "count": 0
    }
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 得到用户某些月用户登录的大致人数

> BASIC

**Path:** /statistics/login/getLoginMonthUVCountList

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| startYear |  | YES | 起始年 |
| startMonth |  | YES | 起始月 |
| endYear |  | YES | 结束年 |
| endMonth |  | YES | 结束月 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─time | string | 时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─count | integer | 统计结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "time": "",
      "count": 0
    }
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```





## Project name(项目名称)：netty_chat_room

Project name(项目名称)：netty_chat_room
Package(包名): mao.chat_room_manage.controller
Class(类名): RegisterStatisticsController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/4/11
Time(创建时间)： 20:38
Version(版本): 1.0
Description(描述)： 注册统计


---
### 得到最近一个月用户每天注册的次数

> BASIC

**Path:** /statistics/register/getRecentMonthRegisterDayCount

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─time | string | 时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─count | integer | 统计结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "time": "",
      "count": 0
    }
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 得到最近一年每个月用户注册的次数

> BASIC

**Path:** /statistics/register/getRecentYearRegisterMonthCount

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─time | string | 时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─count | integer | 统计结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "time": "",
      "count": 0
    }
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 得到用户某些天用户注册的次数

> BASIC

**Path:** /statistics/register/getRegisterDayCountList

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| startYear |  | YES | 起始年 |
| startMonth |  | YES | 起始月 |
| startDay |  | YES | 起始天 |
| endYear |  | YES | 结束年 |
| endMonth |  | YES | 结束月 |
| endDay |  | YES | 结束天 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─time | string | 时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─count | integer | 统计结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "time": "",
      "count": 0
    }
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 得到用户某些月用户注册的次数

> BASIC

**Path:** /statistics/register/getRegisterMonthCountList

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| startYear |  | YES | 起始年 |
| startMonth |  | YES | 起始月 |
| endYear |  | YES | 结束年 |
| endMonth |  | YES | 结束月 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─time | string | 时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─count | integer | 统计结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "time": "",
      "count": 0
    }
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```





## Project name(项目名称)：netty_chat_room

Project name(项目名称)：netty_chat_room
Package(包名): mao.chat_room_manage.controller
Class(类名): NettyController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/4/5
Time(创建时间)： 14:38
Version(版本): 1.0
Description(描述)： 无


---
### 得到各实例以及总在线用户数量

> BASIC

**Path:** /netty/getOnlineUserCount

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─instanceList | array | 实例列表 |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─host | string | 实例的地址 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─count | integer | 统计计数 |
| &ensp;&ensp;&#124;─totalCount | integer | 当前在线人数总数 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "instanceList": [
      {
        "host": "",
        "count": 0
      }
    ],
    "totalCount": 0
  },
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```





## Project name(项目名称)：netty_chat_room

Project name(项目名称)：netty_chat_room
Package(包名): mao.chat_room_manage.controller
Class(类名): StatisticsController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/4/5
Time(创建时间)： 14:39
Version(版本): 1.0
Description(描述)： 统计


---
### 得到某一天用户登录的总次数（一个人可能登录多次）

> BASIC

**Path:** /statistics/getLoginDayCount

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| year |  | YES | 年 |
| month |  | YES | 月 |
| day |  | YES | 天 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | integer | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": 0,
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 得到某月用户登录的总次数（一个人可能登录多次）

> BASIC

**Path:** /statistics/getLoginMonthCount

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| year |  | YES | 年 |
| month |  | YES | 月 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | integer | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": 0,
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 得到某一天用户登录的大致人数（一个人可能登录多次，但是只记录一次）

> BASIC

**Path:** /statistics/getLoginDayUVCount

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| year |  | YES | 年 |
| month |  | YES | 月 |
| day |  | YES | 天 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | integer | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": 0,
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 得到某一月用户登录的大致人数（一个人可能登录多次，但是只记录一次）

> BASIC

**Path:** /statistics/getLoginMonthUVCount

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| year |  | YES | 年 |
| month |  | YES | 月 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | integer | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": 0,
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 得到某一天用户注册的总次数（一个人可能登录多次）

> BASIC

**Path:** /statistics/getRegisterDayCount

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| year |  | YES | 年 |
| month |  | YES | 月 |
| day |  | YES | 天 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | integer | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": 0,
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 得到某一月用户注册的总次数（一个人可能登录多次）

> BASIC

**Path:** /statistics/getRegisterMonthCount

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| year |  | YES | 年 |
| month |  | YES | 月 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | integer | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": 0,
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 得到某一天聊天发送的条数（一个人可能发送多次聊天）

> BASIC

**Path:** /statistics/getChatDayCount

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| year |  | YES | 年 |
| month |  | YES | 月 |
| day |  | YES | 天 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | integer | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": 0,
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 得到某一月聊天发送的条数（一个人可能发送多次聊天）

> BASIC

**Path:** /statistics/getChatMonthCount

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| year |  | YES | 年 |
| month |  | YES | 月 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | integer | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": 0,
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 得到某一天群聊聊天发送的条数

> BASIC

**Path:** /statistics/getGroupChatDayCount

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| year |  | YES | 年 |
| month |  | YES | 月 |
| day |  | YES | 天 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | integer | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": 0,
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 得到某一月群聊聊天发送的条数

> BASIC

**Path:** /statistics/getGroupChatMonthCount

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| year |  | YES | 年 |
| month |  | YES | 月 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | integer | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": 0,
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 得到某一天群聊创建的次数

> BASIC

**Path:** /statistics/getGroupCreateDayCount

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| year |  | YES | 年 |
| month |  | YES | 月 |
| day |  | YES | 天 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | integer | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": 0,
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 得到某一月群聊创建的次数

> BASIC

**Path:** /statistics/getGroupCreateMonthCount

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| year |  | YES | 年 |
| month |  | YES | 月 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | integer | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": 0,
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```





## Project name(项目名称)：netty_chat_room

Project name(项目名称)：netty_chat_room
Package(包名): mao.chat_room_manage.controller
Class(类名): GroupChatStatisticsController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/4/11
Time(创建时间)： 21:16
Version(版本): 1.0
Description(描述)： 群聊聊天消息统计


---
### 得到最近一个月每天发送群聊聊天消息的总数

> BASIC

**Path:** /statistics/group/chat/getRecentMonthGroupChatDayCount

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─time | string | 时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─count | integer | 统计结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "time": "",
      "count": 0
    }
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 得到最近一年每个月发送群聊聊天消息的总数

> BASIC

**Path:** /statistics/group/chat/getRecentYearGroupChatMonthCount

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─time | string | 时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─count | integer | 统计结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "time": "",
      "count": 0
    }
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 得到用户某些天发送群聊聊天消息的总数

> BASIC

**Path:** /statistics/group/chat/getChatDayGroupCountList

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| startYear |  | YES | 起始年 |
| startMonth |  | YES | 起始月 |
| startDay |  | YES | 起始天 |
| endYear |  | YES | 结束年 |
| endMonth |  | YES | 结束月 |
| endDay |  | YES | 结束天 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─time | string | 时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─count | integer | 统计结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "time": "",
      "count": 0
    }
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 得到用户某些月发送群聊聊天消息的总数

> BASIC

**Path:** /statistics/group/chat/getChatMonthGroupCountList

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| startYear |  | YES | 起始年 |
| startMonth |  | YES | 起始月 |
| endYear |  | YES | 结束年 |
| endMonth |  | YES | 结束月 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─time | string | 时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─count | integer | 统计结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "time": "",
      "count": 0
    }
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```





## Project name(项目名称)：netty_chat_room

Project name(项目名称)：netty_chat_room
Package(包名): mao.chat_room_manage.controller
Class(类名): UserController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/4/8
Time(创建时间)： 15:01
Version(版本): 1.0
Description(描述)： 用户Controller


---
### 设置用户状态

> BASIC

**Path:** /user/setUserStatus/{username}/{status}

**Method:** PUT

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| username |  | 用户名 |
| status |  | 状态，false表示禁用，ture表示启用 |

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | string | boolean |

**Response Demo:**

```json

```




---
### 通过用户名得到用户信息

> BASIC

**Path:** /user/{username}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| username |  | 用户名 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | string | [Project name(项目名称)：authority<br>Package(包名): mao.tools_core.base<br>Class(类名): R<br>Author(作者）: mao<br>Author QQ：1296193245<br>GitHub：https://github.com/maomao124/<br>Date(创建日期)： 2022/11/4<br>Time(创建时间)： 13:54<br>Version(版本): 1.0<br>Description(描述)： 前后端统一数据交互格式的类]<[Project name(项目名称)：netty_chat_room<br>Package(包名): mao.chat_room_server_api.dto<br>Class(类名): UserDTO<br>Author(作者）: mao<br>Author QQ：1296193245<br>GitHub：https://github.com/maomao124/<br>Date(创建日期)： 2023/4/13<br>Time(创建时间)： 13:15<br>Version(版本): 1.0<br>Description(描述)： 无]><br>系统繁忙，请稍候再试 :DEF_ERROR_MESSAGE<br>请求超时，请稍候再试 :HYSTRIX_ERROR_MESSAGE<br>0 :SUCCESS_CODE<br>-1 :FAIL_CODE<br>-2 :TIMEOUT_CODE<br>-9 :统一参数验证异常<br>-10 :OPERATION_EX_CODE |

**Response Demo:**

```json

```




---
### 分页查询角色

> BASIC

**Path:** /user/page

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| current |  | YES | 当前页 |
| size |  | YES | 页面大小 |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| username | string | 用户名 |
| status | boolean | 启用状态 1启用 0禁用 |
| lastLoginTime | string | 最后登录时间 |
| registerTime | string | 注册时间 |
| passwordErrorLastTime | string | 最后一次输错密码时间 |
| passwordErrorNum | integer | 密码错误次数 |

**Request Demo:**

```json
{
  "username": "",
  "status": false,
  "lastLoginTime": "",
  "registerTime": "",
  "passwordErrorLastTime": "",
  "passwordErrorNum": 0
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | string | [Project name(项目名称)：authority<br>Package(包名): mao.tools_core.base<br>Class(类名): R<br>Author(作者）: mao<br>Author QQ：1296193245<br>GitHub：https://github.com/maomao124/<br>Date(创建日期)： 2022/11/4<br>Time(创建时间)： 13:54<br>Version(版本): 1.0<br>Description(描述)： 前后端统一数据交互格式的类]<[IPage]<[Project name(项目名称)：netty_chat_room<br>Package(包名): mao.chat_room_server_api.dto<br>Class(类名): UserDTO<br>Author(作者）: mao<br>Author QQ：1296193245<br>GitHub：https://github.com/maomao124/<br>Date(创建日期)： 2023/4/13<br>Time(创建时间)： 13:15<br>Version(版本): 1.0<br>Description(描述)： 无]>><br>系统繁忙，请稍候再试 :DEF_ERROR_MESSAGE<br>请求超时，请稍候再试 :HYSTRIX_ERROR_MESSAGE<br>0 :SUCCESS_CODE<br>-1 :FAIL_CODE<br>-2 :TIMEOUT_CODE<br>-9 :统一参数验证异常<br>-10 :OPERATION_EX_CODE |

**Response Demo:**

```json

```





## Project name(项目名称)：netty_chat_room

Project name(项目名称)：netty_chat_room
Package(包名): mao.chat_room_manage.controller
Class(类名): ChatStatisticsController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/4/11
Time(创建时间)： 21:02
Version(版本): 1.0
Description(描述)： 聊天消息统计


---
### 得到最近一个月用户每天发送聊天消息的总数

> BASIC

**Path:** /statistics/chat/getRecentMonthChatDayCount

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─time | string | 时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─count | integer | 统计结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "time": "",
      "count": 0
    }
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 得到最近一年用户每个月发送聊天消息的总数

> BASIC

**Path:** /statistics/chat/getRecentYearChatMonthCount

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─time | string | 时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─count | integer | 统计结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "time": "",
      "count": 0
    }
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 得到用户某些天用户发送聊天消息的总数

> BASIC

**Path:** /statistics/chat/getChatDayCountList

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| startYear |  | YES | 起始年 |
| startMonth |  | YES | 起始月 |
| startDay |  | YES | 起始天 |
| endYear |  | YES | 结束年 |
| endMonth |  | YES | 结束月 |
| endDay |  | YES | 结束天 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─time | string | 时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─count | integer | 统计结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "time": "",
      "count": 0
    }
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```




---
### 得到用户某些月用户发送聊天消息的总数

> BASIC

**Path:** /statistics/chat/getChatMonthCountList

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| startYear |  | YES | 起始年 |
| startMonth |  | YES | 起始月 |
| endYear |  | YES | 结束年 |
| endMonth |  | YES | 结束月 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─time | string | 时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─count | integer | 统计结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "time": "",
      "count": 0
    }
  ],
  "msg": "ok",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": "System.currentTimeMillis()"
}
```







