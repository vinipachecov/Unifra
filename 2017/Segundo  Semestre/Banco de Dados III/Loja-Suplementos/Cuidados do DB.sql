alter table usuario
add column tipousuario varchar(14)

alter table usuario
drop column usertype;

alter table usuario
add column password varchar(20);

alter table usuario
add column usertype varchar(14)


select * from usuario;


create table brands(
id serial primary key,
name varchar(30)
)

select * from brands


create table users(
id serial primary key,
username varchar(20),
password varchar(20),
usertype varchar(20)
)



insert into users(username,password,usertype)
values('admin','admin','admin')


insert into usuario(username,password,usertype)
values('admin','admin','admin')



