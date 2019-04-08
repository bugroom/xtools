
drop database if exists simpleweb;
create database simpleweb;
use simpleweb;

drop table if EXISTS user;
create table user
(
id int PRIMARY key auto_increment,
username varchar(100),
password varchar(100),
name varchar(100),
sex char(1),
email varchar(200),
tel varchar(100)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into user values (null, 'user1', 'password1', '用户1', '1', '00101@qq.com', '18011111111');
insert into user values (null, 'user2', 'password2', '用户2', '2', '00202@qq.com', '18022222222');