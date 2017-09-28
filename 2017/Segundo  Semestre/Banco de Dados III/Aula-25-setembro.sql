create table cliente(
id serial primary key,
nome varchar(150) not null,
email varchar(100) unique not null,
cpf char(11) not null,
telefone char(9),
data_nasc date,
logradouro varchar(100),
complemento varchar(100),
cep char(9),
cidade varchar(100),
estado varchar(100)
);

insert into cliente(nome, email, cpf, telefone,data_nasc,logradouro,complemento,cep,cidade,estado)
values('joao','joao@mail','2193813','232329','02-25-2000','jscisjcis','shudhsud','36278','santa maria','rs')

select * from cliente

create table compra(
id serial primary key,
id_cliente integer not null,
valor_total decimal(15,2) not null,
valor_desconto decimal(15,2) not null,
valor_liquido decimal (15,2),
foreign key (id_cliente) references cliente(id)
on update cascade on delete restrict
);

create table itemcompra(
id serial primary key,
id_cliente integer not null,
id_produto integer not null,
qtd integer,
valor_total decimal(15,2) not null,
valor_desconto decimal(15,2) not null,
valor_liquido decimal (15,2),
foreign key (id_cliente) references cliente(id)
on update cascade on delete restrict,
foreign key (id_produto) references produto(id)
on update cascade on delete restrict
);


create table produto (
id serial primary key,
descricao varchar(300),
fornecedor varchar(100),
estoque integer,
custo decimal(15,2),
preco decimal(15,2)
);

--Inicialmente, crie regras para não permitir o cadastro:
--
--Cliente sem nome, sem CPF, sem telefone (deve mostrar um select da tabela cliente)
--Compra sem valores (deve mostrar um select da tabela compra)
--Produtos sem descrição, estoque, custo e preço (deve mostrar um select da tabela produtos)


create rule nome_cpf_telefone_vaziosOuNulos as
on insert to cliente
	where new.nome = '' or new.nome is null or new.cpf = '' or new.cpf is null or new.telefone = '' or new.telefone is null
	do instead 
		select *  
		from cliente
		limit 10;

create rule compra_sem_valor as 
on insert to compra
	where new.valor_total = 0 or new.valor_total is null or new.valor_liquido = 0 or new.valor_liquido is null
	do instead 
	select * from compra limit 10;
	
create rule produto_sem_valores as 
on insert to produto
	where new.descricao = ''  or new.descricao is null or new.estoque = 0 
	or new.estoque is null or new.custo = 0 or new.custo is null or new.preco = 0 or new.preco is null
	do instead 
	select * from produto limit 10;

--	2) Criar quatro tabelas auxiliares chamadas hist_cliente, his_produto, hist_compras e hist_item_compra 
--que devem ser utilizadas para armazenar um histórico de atualização.
--Devem ser inseridos em cada tabela um campo onde deve conter o tipo de alteração qu
--e foi efetuada na tabela (como preferir armazenar esta informação), por exemplo:
--1 - Inserção
--2 - Update
--3 - Delete

	--COmpras

create rule insercao_compra as 
on insert to compra	
	do also insert into hist_compras(tipo_mudanca,data_mudanca)
	values('insert', current_timestamp);
	
create rule alteracao_compra as 
on update to compra	
	do also insert into hist_compras(tipo_mudanca,data_mudanca)
	values('update', current_timestamp);	

	
create rule delete_compra as 
on delete to compra	
	do also insert into hist_compras(tipo_mudanca,data_mudanca)
	values('delete', current_timestamp);	
*************************
--produto

create rule insercao_produto as 
on insert to produto	
	do also insert into hist_produto(tipo_mudanca,data_mudanca)
	values('insert', current_timestamp);
	
create rule alteracao_produto as 
on update to produto	
	do also insert into hist_produto(tipo_mudanca,data_mudanca)
	values('update', current_timestamp);	

	
create rule delete_produto as 
on delete to produto	
	do also insert into hist_produto(tipo_mudanca,data_mudanca)
	values('delete', current_timestamp);	
******************
--Cliente

create rule insercao_cliente as 
on insert to cliente	
	do also insert into hist_cliente(tipo_mudanca,data_mudanca)
	values('insert', current_timestamp);
	
create rule alteracao_cliente as 
on update to cliente	
	do also insert into hist_cliente(tipo_mudanca,data_mudanca)
	values('update', current_timestamp);	

	
create rule delete_cliente as 
on delete to cliente	
	do also insert into hist_cliente(tipo_mudanca,data_mudanca)
	values('delete', current_timestamp);	
***************

-- Item compra
create rule insercao_itemcompra as 
on insert to itemcompra	
	do also insert into hist_item_compra(tipo_mudanca,data_mudanca)
	values('insert', current_timestamp);
	
create rule alteracao_itemcompra as 
on update to itemcompra	
	do also insert into hist_item_compra(tipo_mudanca,data_mudanca)
	values('update', current_timestamp);	

	
create rule delete_itemcompra as 
on delete to itemcompra	
	do also insert into hist_item_compra(tipo_mudanca,data_mudanca)
	values('delete', current_timestamp);

	
	
	
create table hist_cliente(
tipo_mudanca char(8),
data_mudanca timestamp);

create table hist_produto(
tipo_mudanca char(8),
data_mudanca timestamp);



create table hist_compras(
tipo_mudanca char(8),
data_mudanca timestamp);

create table hist_item_compra	(
tipo_mudanca char(8),
data_mudanca timestamp);

