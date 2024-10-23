create database usermanagement;
use usermanagement;
create table users ( user_id int auto_increment primary key, username varchar(50), balance decimal(10, 2));
insert into users (username, balance) values ("hukam", 10000), ("himanshu", 20000), ("shreyash", 30000), ("shubham", 40000);

insert into users (username, balance) values ("aditya", 15000);

update user set balance = 20000 where username = "hukam";

delete from users where username = "himanshu";

select * from users;

select * from users where username = "shreyash";