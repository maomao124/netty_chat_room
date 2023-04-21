# 服务


**简介**:服务


**HOST**:127.0.0.1:9092


**联系人**:


**Version**:1.0


**接口路径**:/v2/api-docs?group=服务


[TOC]






# netty相关


## 得到当前实例在线用户数量


**接口地址**:`/getOnlineUserCount`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«int»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|响应编码:0/200-请求处理成功|integer(int32)|integer(int32)|
|data|响应数据|integer(int32)|integer(int32)|
|extra|附加数据|object||
|isError||boolean||
|isSuccess||boolean||
|msg|提示消息|string||
|path|请求路径|string||
|timestamp|响应时间戳|integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"data": 0,
	"extra": {},
	"isError": true,
	"isSuccess": true,
	"msg": "",
	"path": "",
	"timestamp": 0
}
```


## 成员加入本地群聊


**接口地址**:`/joinMember`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|member|member|query|true|string||
|name|name|query|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«boolean»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|响应编码:0/200-请求处理成功|integer(int32)|integer(int32)|
|data|响应数据|boolean||
|extra|附加数据|object||
|isError||boolean||
|isSuccess||boolean||
|msg|提示消息|string||
|path|请求路径|string||
|timestamp|响应时间戳|integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"data": true,
	"extra": {},
	"isError": true,
	"isSuccess": true,
	"msg": "",
	"path": "",
	"timestamp": 0
}
```


## 得到当前实例的netty的端口号


**接口地址**:`/port`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«int»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|响应编码:0/200-请求处理成功|integer(int32)|integer(int32)|
|data|响应数据|integer(int32)|integer(int32)|
|extra|附加数据|object||
|isError||boolean||
|isSuccess||boolean||
|msg|提示消息|string||
|path|请求路径|string||
|timestamp|响应时间戳|integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"data": 0,
	"extra": {},
	"isError": true,
	"isSuccess": true,
	"msg": "",
	"path": "",
	"timestamp": 0
}
```


## 成员退出本地群聊


**接口地址**:`/removeMember`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|member|member|query|true|string||
|name|name|query|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«boolean»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|响应编码:0/200-请求处理成功|integer(int32)|integer(int32)|
|data|响应数据|boolean||
|extra|附加数据|object||
|isError||boolean||
|isSuccess||boolean||
|msg|提示消息|string||
|path|请求路径|string||
|timestamp|响应时间戳|integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"data": true,
	"extra": {},
	"isError": true,
	"isSuccess": true,
	"msg": "",
	"path": "",
	"timestamp": 0
}
```


## 发送聊天消息


**接口地址**:`/send`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
	"content": "",
	"from": "",
	"messageType": 0,
	"sequenceId": 0,
	"time": "",
	"to": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|chatRequestMessage|chatRequestMessage|body|true|ChatRequestMessage|ChatRequestMessage|
|&emsp;&emsp;content|||false|string||
|&emsp;&emsp;from|||false|string||
|&emsp;&emsp;messageType|||false|integer(int32)||
|&emsp;&emsp;sequenceId|||false|integer(int32)||
|&emsp;&emsp;time|||false|string(date-time)||
|&emsp;&emsp;to|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«boolean»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|响应编码:0/200-请求处理成功|integer(int32)|integer(int32)|
|data|响应数据|boolean||
|extra|附加数据|object||
|isError||boolean||
|isSuccess||boolean||
|msg|提示消息|string||
|path|请求路径|string||
|timestamp|响应时间戳|integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"data": true,
	"extra": {},
	"isError": true,
	"isSuccess": true,
	"msg": "",
	"path": "",
	"timestamp": 0
}
```


## 发送群聊聊天消息


**接口地址**:`/sendGroupChatMessage`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
	"additionalProperties1": {
		"content": "",
		"from": "",
		"groupName": "",
		"messageType": 0,
		"reason": "",
		"sequenceId": 0,
		"success": true,
		"time": ""
	}
}
```


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|map|map|body|true|||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«boolean»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|响应编码:0/200-请求处理成功|integer(int32)|integer(int32)|
|data|响应数据|boolean||
|extra|附加数据|object||
|isError||boolean||
|isSuccess||boolean||
|msg|提示消息|string||
|path|请求路径|string||
|timestamp|响应时间戳|integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"data": true,
	"extra": {},
	"isError": true,
	"isSuccess": true,
	"msg": "",
	"path": "",
	"timestamp": 0
}
```


## 发送群聊创建消息


**接口地址**:`/sendGroupCreateMessage`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
[
	{
		"members": [],
		"messageType": 0,
		"reason": "",
		"sequenceId": 0,
		"success": true,
		"time": ""
	}
]
```


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|groupCreateResponseMessages|groupCreateResponseMessages|body|true|array|GroupCreateResponseMessage|
|&emsp;&emsp;members|||false|array|string|
|&emsp;&emsp;messageType|||false|integer(int32)||
|&emsp;&emsp;reason|||false|string||
|&emsp;&emsp;sequenceId|||false|integer(int32)||
|&emsp;&emsp;success|||false|boolean||
|&emsp;&emsp;time|||false|string(date-time)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«boolean»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|响应编码:0/200-请求处理成功|integer(int32)|integer(int32)|
|data|响应数据|boolean||
|extra|附加数据|object||
|isError||boolean||
|isSuccess||boolean||
|msg|提示消息|string||
|path|请求路径|string||
|timestamp|响应时间戳|integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"data": true,
	"extra": {},
	"isError": true,
	"isSuccess": true,
	"msg": "",
	"path": "",
	"timestamp": 0
}
```


# reBalance


## ReBalance处理


**接口地址**:`/reBalance/handler`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|host|host|query|true|string||
|reBalanceNumber|reBalanceNumber|query|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«boolean»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|响应编码:0/200-请求处理成功|integer(int32)|integer(int32)|
|data|响应数据|boolean||
|extra|附加数据|object||
|isError||boolean||
|isSuccess||boolean||
|msg|提示消息|string||
|path|请求路径|string||
|timestamp|响应时间戳|integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"data": true,
	"extra": {},
	"isError": true,
	"isSuccess": true,
	"msg": "",
	"path": "",
	"timestamp": 0
}
```


# 用户相关


## 分页查询角色


**接口地址**:`/user/page`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:分页查询角色


**请求示例**:


```javascript
{
	"lastLoginTime": "",
	"passwordErrorLastTime": "",
	"passwordErrorNum": 0,
	"registerTime": "",
	"status": true,
	"username": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|param|param|body|true|用户DTO|用户DTO|
|&emsp;&emsp;lastLoginTime|最后登录时间||false|string(date-time)||
|&emsp;&emsp;passwordErrorLastTime|最后一次输错密码时间||false|string(date-time)||
|&emsp;&emsp;passwordErrorNum|密码错误次数||false|integer(int32)||
|&emsp;&emsp;registerTime|注册时间||false|string(date-time)||
|&emsp;&emsp;status|启用状态 1启用 0禁用||false|boolean||
|&emsp;&emsp;username|用户名||false|string||
|current|当前页|query|false|integer(int64)||
|size|每页显示几条|query|false|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«IPage«用户DTO»»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|响应编码:0/200-请求处理成功|integer(int32)|integer(int32)|
|data|响应数据|IPage«用户DTO»|IPage«用户DTO»|
|&emsp;&emsp;current||integer(int64)||
|&emsp;&emsp;pages||integer(int64)||
|&emsp;&emsp;records||array|用户DTO|
|&emsp;&emsp;&emsp;&emsp;lastLoginTime|最后登录时间||false|string(date-time)||
|&emsp;&emsp;&emsp;&emsp;passwordErrorLastTime|最后一次输错密码时间||false|string(date-time)||
|&emsp;&emsp;&emsp;&emsp;passwordErrorNum|密码错误次数||false|integer(int32)||
|&emsp;&emsp;&emsp;&emsp;registerTime|注册时间||false|string(date-time)||
|&emsp;&emsp;&emsp;&emsp;status|启用状态 1启用 0禁用||false|boolean||
|&emsp;&emsp;&emsp;&emsp;username|用户名||false|string||
|&emsp;&emsp;searchCount||boolean||
|&emsp;&emsp;size||integer(int64)||
|&emsp;&emsp;total||integer(int64)||
|extra|附加数据|object||
|isError||boolean||
|isSuccess||boolean||
|msg|提示消息|string||
|path|请求路径|string||
|timestamp|响应时间戳|integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"current": 0,
		"pages": 0,
		"records": [
			{
				"lastLoginTime": "",
				"passwordErrorLastTime": "",
				"passwordErrorNum": 0,
				"registerTime": "",
				"status": true,
				"username": ""
			}
		],
		"searchCount": true,
		"size": 0,
		"total": 0
	},
	"extra": {},
	"isError": true,
	"isSuccess": true,
	"msg": "",
	"path": "",
	"timestamp": 0
}
```


## 设置用户状态


**接口地址**:`/user/setUserStatus/{username}/{status}`


**请求方式**:`PUT`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|status|状态，false表示禁用，ture表示启用|path|true|boolean||
|username|用户名|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«boolean»|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|响应编码:0/200-请求处理成功|integer(int32)|integer(int32)|
|data|响应数据|boolean||
|extra|附加数据|object||
|isError||boolean||
|isSuccess||boolean||
|msg|提示消息|string||
|path|请求路径|string||
|timestamp|响应时间戳|integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"data": true,
	"extra": {},
	"isError": true,
	"isSuccess": true,
	"msg": "",
	"path": "",
	"timestamp": 0
}
```


## 通过用户名得到用户信息


**接口地址**:`/user/{username}`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | in    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|username|username|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«用户DTO»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|响应编码:0/200-请求处理成功|integer(int32)|integer(int32)|
|data|响应数据|用户DTO|用户DTO|
|&emsp;&emsp;lastLoginTime|最后登录时间|string(date-time)||
|&emsp;&emsp;passwordErrorLastTime|最后一次输错密码时间|string(date-time)||
|&emsp;&emsp;passwordErrorNum|密码错误次数|integer(int32)||
|&emsp;&emsp;registerTime|注册时间|string(date-time)||
|&emsp;&emsp;status|启用状态 1启用 0禁用|boolean||
|&emsp;&emsp;username|用户名|string||
|extra|附加数据|object||
|isError||boolean||
|isSuccess||boolean||
|msg|提示消息|string||
|path|请求路径|string||
|timestamp|响应时间戳|integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"data": {
		"lastLoginTime": "",
		"passwordErrorLastTime": "",
		"passwordErrorNum": 0,
		"registerTime": "",
		"status": true,
		"username": ""
	},
	"extra": {},
	"isError": true,
	"isSuccess": true,
	"msg": "",
	"path": "",
	"timestamp": 0
}
```