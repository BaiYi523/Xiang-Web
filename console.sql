create database xiang;
use xiang;

create table user(
    id int auto_increment primary key ,#id 主键
    qq bigint not null ,#QQ号
    user_name varchar(50) not null ,#昵称
    user_sex int , #0保密 1男 2女
    user_age int ,#年龄
    user_Pwd varchar(50) not null ,#密码
    user_hobby varchar(100),#爱好
    user_region varchar(50),#地区
    registration_date date not null,#注册时间
    Administrator int #管理员 0不是 1是
);
insert into user values
    (null,2089642063,'Xiang',null,null,'123456',null,null,'2022-4-9 12:00:00',null);

insert into user values
(null,2089642063,'Xiang',1,17,'123456','暂无','中国-湖南-湘潭','2022-4-9 12:00:00',1);

select * from user where user_name='Xian'

update user set user_Pwd = 123456 where qq=3;