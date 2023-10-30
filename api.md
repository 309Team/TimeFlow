# 前言

## 发送数据需要的请求头

因为涉及到用户数据的修改，除了**登录**和**注册**请求，其他请求的请求头必须附带**token**。

token从登录请求的返回获得。

## 返回的结果

格式

* 结果代码（code）: 0为成功，其他为失败
* 提示信息（msg） : 操作的提示
* 数据（data）        : 返回的数据

# 用户

## 注册

### 请求方式

* POST

### 请求路径

* /register

### 请求参数

* name: 用户名
* password: 用户密码

``` json
{
	"name" : "USER_A",
	"password" : "user_A_123"
}
```

### 响应数据

* code(状态码)：0(成功)，1(失败)
* msg(返回信息)：提示信息
* data(返回数据)：空

```json
{
  "code": 0,
  "msg": "Success",
  "data": null
}
```

## 登录

### 请求方式

* POST

### 请求路径

* /login

### 请求参数

* name: 用户名
* password: 用户密码

``` json
{
	"name" : "USER_A",
	"password" : "user_A_123"
}
```

### 响应数据

* code(状态码)：0(成功)，1(失败)
* msg(返回信息)：提示信息
* data(返回数据)：token

```json
{
  "code": 0,
  "msg": "Success",
  "data": {
    "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2OTg1MTA0MjcsInVzZXJJZCI6IjEifQ.N6mWZpSRaUn25eYzVx6NSjSOAeARvQWQXOAcw4NYJdA"
  }
}
```

## 注销

### 请求方式

* DELETE

### 请求路径

* /user

### 请求参数

* 无(必须先登录拿到token,将token作为请求头)

### 响应数据

* code(状态码)：0(成功)，1(失败)
* msg(返回信息)：提示信息
* data(返回数据)：无

```json
{
  "code": 0,
  "msg": "Success",
  "data": null
}
```

## 更新用户信息

### 请求方式

* PATCH

### 请求路径

* /user

### 请求参数

* name: 用户名
* uid:不用传，为null
* password: 用户密码

```json
{
  "name": "USER_A",
  "uid": null,
  "password": "USER_A_123"
}
```

### 响应数据

* code(状态码)：0(成功)，1(失败)
* msg(返回信息)：提示信息
* data(返回数据)：无

```json
{
  "code": 0,
  "msg": "Success",
  "data": null
}
```

# 事项

## TE(时段事项)

### 添加

#### 请求方式

* POST

#### 请求路径

* /event/te

#### 请求参数

* id: 事项id
* name: 事项名称
* startTime: 日期
* overTime: 日期
* setInViewPage: 是否纳入视图
* text: 事项备注
* isCompleted: 是否完成

``` JSON
{
	"id": 5,
	"name": "ADG",
	"startTime": "2023-10-28T16:52:05",
	"overTime": "2023-10-28T16:52:05",
	"setInViewPage": true,
	"text": null,
	"isCompleted": true
}
```

#### 响应数据

* code(状态码)：0(成功)，1(失败)
* msg(返回信息)：提示信息
* data(返回数据)：空

```json
{
  "code": 0,
  "msg": "Success",
  "data": null
}
```

### 按日期查找

#### 请求方式

* GET

#### 请求路径

* /event/te

#### 请求参数

* dateSTR: 日期字符串

``` json
{
    "dateSTR" : "2023-10-24"
}
```

#### 响应数据

* code(状态码)：0(成功)，1(失败)
* msg(返回信息)：提示信息
* data(返回数据)：事项列表

```json
{
  "code": 0,
  "msg": "Success",
  "data": [
    {
      "id": 1,
      "name": "吃饭",
      "startTime": "2023-10-22T17:30:00",
      "overTime": "2023-10-22T19:30:00",
      "setInViewPage": true,
      "text": null,
      "completed": false
    },
    {
      "id": 2,
      "name": "睡觉",
      "startTime": "2023-10-22T19:30:00",
      "overTime": "2023-10-22T21:30:00",
      "setInViewPage": true,
      "text": null,
      "completed": false
    }
  ]
}
```

### 删除

#### 请求方式

* DELETE

#### 请求路径

* /event/te

#### 请求参数

* id: 待删除事项id

``` json
{
    "id" : "5"
}
```

#### 响应数据

* code(状态码)：0(成功)，1(失败)
* msg(返回信息)：提示信息
* data(返回数据)：空

```json
{
  "code": 0,
  "msg": "Success",
  "data": null
}
```

### 更新

#### 请求方式

* PATCH

#### 请求路径

* /event/te

#### 请求参数

* id: 事项id
* name: 事项名称
* startTime: 日期
* overTime: 日期
* setInViewPage: 是否纳入视图
* text: 事项备注
* isCompleted: 是否完成

``` json
{
	"id": 5,
	"name": "ADG",
	"startTime": "2023-10-28T16:52:05",
	"overTime": "2023-10-28T16:52:05",
	"setInViewPage": true,
	"text": null,
	"isCompleted": true
}
```

#### 响应数据

* code(状态码)：0(成功)，1(失败)
* msg(返回信息)：提示信息
* data(返回数据)：空

```json
{
  "code": 0,
  "msg": "Success",
  "data": null
}
```

## ME(时刻事项)

### 添加

#### 请求方式

* POST

#### 请求路径

* /event/me

#### 请求参数

* id: 事项id
* name: 事项名称
* deadline: 日期
* setInViewPage: 是否纳入视图
* text: 事项备注
* isCompleted: 是否完成

``` json
{
	"id": 5,
	"name": "ADG",
	"deadlilne": "2023-10-28T16:52:05",
	"setInViewPage": true,
	"text": null,
	"isCompleted": true
}
```

#### 响应数据

* code(状态码)：0(成功)，1(失败)
* msg(返回信息)：提示信息
* data(返回数据)：空

```json
{
  "code": 0,
  "msg": "Success",
  "data": null
}
```

### 按日期查找

#### 请求方式

* GET

#### 请求路径

* /event/te

#### 请求参数

* dateSTR: 日期字符串

``` json
{
    "dateSTR" : "2023-10-24"
}
```

#### 响应数据

* code(状态码)：0(成功)，1(失败)
* msg(返回信息)：提示信息
* data(返回数据)：事项列表

```json
{
  "code": 0,
  "msg": "Success",
  "data": [
    {
      "id": 1,
      "name": "AA",
      "deadline": "2023-10-22T19:30:00",
      "setInViewPage": true,
      "text": null,
      "completed": false
    },
    {
      "id": 2,
      "name": "BB",
      "deadline": "2023-10-22T21:30:00",
      "setInViewPage": true,
      "text": null,
      "completed": false
    }
  ]
}
```

### 删除

#### 请求方式

* DELETE

#### 请求路径

* /event/me

#### 请求参数

* id: 待删除事项id

``` json
{
    "id" : "1"
}
```

#### 响应数据

* code(状态码)：0(成功)，1(失败)
* msg(返回信息)：提示信息
* data(返回数据)：空

```json
{
  "code": 0,
  "msg": "Success",
  "data": null
}
```

### 更新

#### 请求方式

* PATCH

#### 请求路径

* /event/me

#### 请求参数

* id: 事项id
* name: 事项名称
* deadline: 日期
* setInViewPage: 是否纳入视图
* text: 事项备注
* isCompleted: 是否完成

``` json
{
	"id": 2,
	"name": "ADDD",
	"deadlilne": "2023-10-28T16:52:05",
	"setInViewPage": true,
	"text": null,
	"isCompleted": true
}
```

#### 响应数据

* code(状态码)：0(成功)，1(失败)
* msg(返回信息)：提示信息
* data(返回数据)：空

```json
{
  "code": 0,
  "msg": "Success",
  "data": null
}
```

## LE(标签事项)

### 添加

#### 请求方式

* POST

#### 请求路径

* /event/le

#### 请求参数

* 参数存在JSON请求体中
* id: 事项id（一般不传，由库自动生成）
* name: 事项名称
* attachDate: 日期
* setInViewPage: 是否纳入视图
* text: 事项备注
* isCompleted: 是否完成

``` json
{
	"id": 5,
	"name": "ADG",
	"attachDate": "2023-10-28T16:52:05",
	"setInViewPage": true,
	"text": null,
	"isCompleted": true
}
```

#### 响应数据

* code(状态码)：0(成功)，1(失败)
* msg(返回信息)：提示信息
* data(返回数据)：空

```json
{
  "code": 0,
  "msg": "Success",
  "data": null
}
```

### 按日期查找

#### 请求方式

* GET

#### 请求路径

* /event/le/{date}

#### 请求参数

* 地址路径传值
* date：日期字符串

eg:

```
website/event/le/2023-10-26
```

#### 响应数据

* code(状态码)：0(成功)，1(失败)
* msg(返回信息)：提示信息
* data(返回数据)：事项列表

```json
{
  "code": 0,
  "msg": "Success",
  "data": [
    {
      "id": 1,
      "name": "帮haha找npy",
      "attachDate": "2023-10-26",
      "setInViewPage": true,
      "text": "haha什么时候发一区啊",
      "completed": false
    }
  ]
}
```

### 查找所有标签事项

#### 请求方式

* GET

#### 请求路径

* /event/le

#### 请求参数

无

#### 响应数据

* code(状态码)：0(成功)，1(失败)
* msg(返回信息)：提示信息
* data(返回数据)：事项列表

```json
{
  "code": 0,
  "msg": "Success",
  "data": [
    {
      "id": 2,
      "name": "帮haha找npy",
      "attachDate": "2023-10-26",
      "setInViewPage": true,
      "text": "haha什么时候发一区啊",
      "completed": false
    },
    {
      "id": 4,
      "name": "帮haha发论文",
      "attachDate": "2023-10-26",
      "setInViewPage": true,
      "text": "haha什么时候发一区啊",
      "completed": false
    }
  ]
}
```

### 删除

#### 请求方式

* DELETE

#### 请求路径

* /event/le/{eid}

#### 请求参数

* eid: 待删除事项id
  eg:

```
website/event/le/2
```

#### 响应数据

* code(状态码)：0(成功)，1(失败)
* msg(返回信息)：提示信息
* data(返回数据)：空

```json
{
  "code": 0,
  "msg": "Success",
  "data": null
}
```

### 更新

#### 请求方式

* PATCH

#### 请求路径

* /event/le

#### 请求参数

* 请求体：json
* id: 事项id
* name: 事项名称
* attachDate: 日期
* setInViewPage: 是否纳入视图
* text: 事项备注
* isCompleted: 是否完成

``` json
{
	"id": 5,
	"name": "哈哈发一区了",
	"attachDate": "2023-10-29",
	"setInViewPage": true,
	"text": null,
	"isCompleted": true
}
```

#### 响应数据

* code(状态码)：0(成功)，1(失败)
* msg(返回信息)：提示信息
* data(返回数据)：空

```json
{
  "code": 0,
  "msg": "Success",
  "data": null
}
```

# 类别

## 时段事项分类

### 添加

#### 请求方式

* POST

#### 请求路径

* /cls

#### 请求参数

* id: 分类id（非必须，建议让数据库自行生成）
* name: 分类名称
* text: 事项备注

``` json
{
	"id": "2",
    "name": "学习",
    "text": "ttxx"
}
```

#### 响应数据

* code(状态码)：0(成功)，1(失败)
* msg(返回信息)：提示信息
* data(返回数据)：空

```json
{
  "code": 0,
  "msg": "Success",
  "data": null
}
```

### 查询所有分类

#### 请求方式

* GET

#### 请求路径

* /cls

#### 请求参数

* 无

#### 响应数据

* code(状态码)：0(成功)，1(失败)
* msg(返回信息)：提示信息
* data(返回数据)：分类列表

```json
{
  "code": 0,
  "msg": "Success",
  "data": [
    {
      "id": 1,
      "name": "学习",
      "text": "ttxx"
    }
  ]
}
```

### 删除

#### 请求方式

* DELETE

#### 请求路径

* /cls

#### 请求参数

* id: 待删除分类id

``` json
{
    "id" : "1"
}
```

#### 响应数据

* code(状态码)：0(成功)，1(失败)
* msg(返回信息)：提示信息
* data(返回数据)：空

```json
{
  "code": 0,
  "msg": "Success",
  "data": null
}
```

## 时段事项中间表（关系映射）

### 从类中添加事项

#### 请求方式

* POST

#### 请求路径

* /class

#### 请求参数

* 参数存在JSON请求体中
* id: 分类的id
* list: 要添加的事项的id**列表**

``` json
{
	"id": 1,
	"list": [1, 2, 3]
}
```

#### 响应数据

* code(状态码)：0(成功)，1(失败)
* msg(返回信息)：提示信息
* data(返回数据)：空

```json
{
  "code": 0,
  "msg": "Success",
  "data": null
}
```

### 从类中删除事项

#### 请求方式

* DETELE

#### 请求路径

* /class

#### 请求参数

* 参数存在JSON请求体中
* id: 分类的id
* list: 要删除的事项的id**列表**

``` json
{
	"id": 1,
	"list": [1, 2, 3]
}
```

#### 响应数据

* code(状态码)：0(成功)，1(失败)
* msg(返回信息)：提示信息
* data(返回数据)：空

```json
{
  "code": 0,
  "msg": "Success",
  "data": null
}
```

### 给事项添加分类

#### 请求方式

* POST

#### 请求路径

* /event

#### 请求参数

* 参数存在JSON请求体中
* id: 事项的id
* list: 要添加的分类的id**列表**

``` json
{
	"id": 1,
	"list": [1, 2, 3]
}
```

#### 响应数据

* code(状态码)：0(成功)，1(失败)
* msg(返回信息)：提示信息
* data(返回数据)：空

```json
{
  "code": 0,
  "msg": "Success",
  "data": null
}
```

### 删除事项的分类

#### 请求方式

* DETELE

#### 请求路径

* /event

#### 请求参数

* 参数存在JSON请求体中
* id: 事项的id
* list: 要删除的分类的id**列表**

``` json
{
	"id": 1,
	"list": [1, 2, 3]
}
```

#### 响应数据

* code(状态码)：0(成功)，1(失败)
* msg(返回信息)：提示信息
* data(返回数据)：空

```json
{
  "code": 0,
  "msg": "Success",
  "data": null
}
```

### 根据事项获取分类

#### 请求方式

* GET

#### 请求路径

* /event

#### 请求参数

* 参数存在JSON请求体中
* id: 事项的id

``` json
{
	"id": 1,
}
```

#### 响应数据

* code(状态码)：0(成功)，1(失败)
* msg(返回信息)：提示信息
* data(返回数据)：分类列表

```json

```

# 统计
