alter table usuario
add column tipousuario varchar(14)

alter table usuario
drop column usertype;

alter table usuario
add column password varchar(20);

alter table usuario
add column usertype varchar(14)


select * from usuario;

create table types(
id serial primary key,
name varchar(30)
)


create table brands(
id serial primary key,
name varchar(30)
)

select * from brands


create table clients(
id serial primary key,
name varchar(60),
numsales int,
email varchar(50),
telephone varchar(20),
govid varchar(20),
birthdate date
)

drop table client;


create table users(
id serial primary key,
username varchar(20),
password varchar(20),
usertype varchar(20)
)

select * from types;

delete from types
where id = 1;


insert into users(username,password,usertype)
values('admin','admin','admin')


insert into usuario(username,password,usertype)
values('admin','admin','admin')

insert into client(name,numsales,email,telephone,govid,birthdate)
values('vinicius',0,'vini@gmail.com','5532213615','12345678912','2010-02-20')

select * from client;

select exists(select from client where name ='vinicius' and email = 'vini@gmail.com' and govid ='12345678912')

select *
from client
where name ='vinicius' and email = 'vini@.com' and govid ='12345678912'
limit 1



