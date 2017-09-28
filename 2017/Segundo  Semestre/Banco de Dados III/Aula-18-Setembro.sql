
create table funcionario(
id serial primary key,
nome varchar(150) not null,
salario decimal(15,2),
funcao varchar(100),
datanasc date
);

drop table funcionario;

insert into funcionario (nome, funcao, datanasc) 
values ('Teste', 'Jornaleiro', '2000-02-02');

create rule salario as
on insert to funcionario
	where new.salario >= 5000
	do instead nothing
	
create rule semnomevazio as
on insert to funcionario
	where new.nome = '' or new.nome = null
	do instead nothing

create rule semnomevazio_update as
on update to funcionario
	where new.nome = '' or new.nome = null
	do instead nothing

	
-- teste com vazio

	insert into funcionario (nome, salario, funcao) 
values ('TESTE', 4500,'Jornaleiro');


update funcionario
set nome = ''
where funcionario.id = 1



select * from funcionario;

delete from funcionario
where id = 5

-- EXERCICIOS

--Crie regra para não aceitar a atualização de um salário acima de 5000.
create rule salario as
on insert to funcionario
	where new.salario >= 5000
	do instead nothing

--• Crie uma regra para não aceitar a inserção e atualização de um cadastro
--sem nome

create rule semnomevazio as
on insert to funcionario
	where new.nome = '' or new.nome is null
	do instead nothing

create rule semnomevazio_update as
on update to funcionario
	where new.nome = '' or new.nome is null
	do instead nothing
--• Crie uma regra para quando a inserção e atualização de um cadastro
--sem nome retorne uma consulta de todos os funcionários

create rule semnomevazio_insert_select as
on insert to funcionario
	where new.nome = '' or new.nome is null
	do instead 
		select * from funcionario;


--• Crie uma regra para quando for cadastrado um funcionário com salário
--acima de 5000, retorne a consulta de todos os funcionários que tem
--salário maior que 3000

create rule salario_5000_select_3k as
on insert to funcionario
	where new.salario > 5000
	do instead 
		select * from funcionario
		where salario > 3000;		
		
		
--• Crie uma regra que não permita o cadastro do funcionario sem data de
--nascimento
create rule semdatanasc as
on insert to funcionario
	where new.datanasc is null
	do instead nothing

--• Crie uma regra que não permita o cadastro do funcionário sem salário

create rule semsalario as
on insert to funcionario
	where new.salario < 0 or new.salario is null
	do instead nothing


	
	
