# 服务


**简介**:服务


**HOST**:127.0.0.1:19726


**联系人**:


**Version**:1.0


**接口路径**:/v2/api-docs?group=服务


[TOC]






# netty相关


## 得到netty服务实例地址


**接口地址**:`/serverAddress`


**请求方式**:`GET`


**请求数据类型**:`*`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|R«Server»|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|响应编码:0/200-请求处理成功|integer(int32)|integer(int32)|
|data|响应数据|Server|Server|
|&emsp;&emsp;ip||string||
|&emsp;&emsp;port||integer(int32)||
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
		"ip": "",
		"port": 0
	},
	"extra": {},
	"isError": true,
	"isSuccess": true,
	"msg": "",
	"path": "",
	"timestamp": 0
}
```