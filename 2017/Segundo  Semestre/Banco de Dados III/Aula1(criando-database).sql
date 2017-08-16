-- Aula 1 Banco III

drop table Pessoa;

create table Pessoa(
id serial primary key,
nome varchar(150) not null,
email varchar(100) unique not null
);

insert into pessoa (nome, email)
values 
('Vinicius', 'vinipachecov@gmail.com'),
('Lizandra','lizandra@gmail.com'),
('Roger', 'roger@gmail.com'),
('Ricardo','ricardo@gmail.com'),
('Pedro','pedro@gmail.com');


insert into pessoa (nome, email)
values
('Rosa', 'mrosapv@terra.com.br');

select * from pessoa;

create table suplementos(
id serial primary key,
nome varchar(100) unique not null);

drop table suplementos;

insert into suplementos (nome)
values
('Whey'),
('BCAA'),
('Pasta de Amendoim'),
('Colágeno'),
('Albumina');

select * from suplementos;


create table compra(
id serial primary key,
id_produto integer not null,
id_pessoa integer not null,
datetime timestamp without time zone,
foreign key (id_produto) references suplementos(id)
on update cascade,
foreign key (id_pessoa) references pessoa(id)
on update cascade on delete restrict
);

drop table compra;

insert into compra(id_pessoa,id_produto,datetime)
values
(1,1,'2009-02-02'),
(1,1,'2005-02-02'),
(1,1,'2005-02-22'),
(1,1,'2005-02-25'),
(1,1,'2005-03-30'),
(1,1,'2010-02-12'),
(1,1,'2011-02-13'),
(1,1,'2014-02-15')


select * from compra;


select compra.datetime, compra.id, pessoa.nome
from compra
join pessoa 
on pessoa.id = compra.id_pessoa;
