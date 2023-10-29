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
	"code" : 0,
	"msg" : "Success",
	"data" : null
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
    "code": 0,
    "msg": "Success",
    "data": {
        "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2OTg1MTA0MjcsInVzZXJJZCI6IjEifQ.N6mWZpSRaUn25eYzVx6NSjSOAeARvQWQXOAcw4NYJdA"
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
	"code" : 0,
	"msg" : "Success",
	"data" : null
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
	"name" : "USER_A",
	"uid" : null,
	"password" : "USER_A_123"
}
```

### 响应数据

* code(状态码)：0(成功)，1(失败)
* msg(返回信息)：提示信息
* data(返回数据)：无

```json
{
	"code" : 0,
	"msg" : "Success",
	"data" : null
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
	"code" : 0,
	"msg" : "Success",
	"data" : null
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
    "code": 0,
    "msg": "Success",
    "data": [
        {
            "id": 1,
            "name": "吃饭",
            "startTime": "2023-10-22T17:30:00",
            "overTime": "2023-10-22T19:30:00",
            "setInViewPage": true,
            "text": null,
            "completed": false
        },
        {
            "id": 2,
            "name": "睡觉",
            "startTime": "2023-10-22T19:30:00",
            "overTime": "2023-10-22T21:30:00",
            "setInViewPage": true,
            "text": null,
            "completed": false
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
	"code" : 0,
	"msg" : "Success",
	"data" : null
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
	"code" : 0,
	"msg" : "Success",
	"data" : null
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
	"code" : 0,
	"msg" : "Success",
	"data" : null
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
    "code": 0,
    "msg": "Success",
    "data": [
        {
            "id": 1,
            "name": "AA",
            "deadline": "2023-10-22T19:30:00",
            "setInViewPage": true,
            "text": null,
            "completed": false
        },
        {
           "id": 2,
            "name": "BB",
            "deadline": "2023-10-22T21:30:00",
            "setInViewPage": true,
            "text": null,
            "completed": false
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
	"code" : 0,
	"msg" : "Success",
	"data" : null
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
	"code" : 0,
	"msg" : "Success",
	"data" : null
}
```

## LE(标签事项)

# 类别

# 统计
