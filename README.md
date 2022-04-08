# Xiang の Web



![Xiang](http://q1.qlogo.cn/g?b=qq&nk=2089642063&s=100)

您好~这里是Xiang的个人基地，很高兴您的观看本篇文章

关于【Xiang の Web】

### 1. 开发思路

首先我需要知道我的这个网站想要些什么功能，数据库的设计，以及页面的样式等等一些。

前端css，我优先考虑我接触过的css库  [bootstrap中文网 ](https://www.bootcss.com/) && [mdui官方文档](https://www.mdui.org/)

数据库的话，就用我最熟的几个：[MySql](https://www.mysql.com/) && [Radius](https://radiuspharm.com/)

#####  Bootstrap：

```html
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
```

##### Mdui：

```html
<!-- MDUI CSS -->
<link
  rel="stylesheet"
  href="https://cdn.jsdelivr.net/npm/mdui@1.0.1/dist/css/mdui.min.css"
  integrity="sha384-cLRrMq39HOZdvE0j6yBojO4+1PrHfB7a9l5qLcmRm/fiWXYY+CndJPmyu5FV/9Tw"
  crossorigin="anonymous"
/>

<!-- MDUI JavaScript -->
<script
  src="https://cdn.jsdelivr.net/npm/mdui@1.0.1/dist/js/mdui.min.js"
  integrity="sha384-gCMZcshYKOGRX9r6wbDrvF+TcCCswSHFucUzUPwka+Gr+uHgjlYvkABr95TCOz3A"
  crossorigin="anonymous"
></script>
```

### 2. 开始行动

#### 1.）我想要的功能

**用户功能**：注册，登录，忘记密码，QQ邮箱发信，图片上传，聊天室，签到，音乐，天气

**管理功能**：数据管理，信息管理，用户管理

#### 2.）数据库结构

**账户数据库**：QQ号，用户名，密码，性别，年龄，爱好，地区，注册时间

**聊天室**：聊天信息，信息发送时间，用户信息

**音乐**：id，歌手，歌名，歌词，封面链接，歌曲链接，当前音乐id，收藏歌曲id

**天气**：用户地区

#### 3.）网页样式





