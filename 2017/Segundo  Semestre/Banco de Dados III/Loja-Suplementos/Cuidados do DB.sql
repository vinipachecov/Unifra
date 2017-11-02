alter table usuario
add column tipousuario varchar(14)

alter table usuario
drop column usertype;

alter table usuario
add column password varchar(20);

alter table usuario
add column usertype varchar(14)


select * from usuario;


insert into usuario(username,password,usertype)
values('admin','admin','admin')



