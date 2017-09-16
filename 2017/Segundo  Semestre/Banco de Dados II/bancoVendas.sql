

CREATE TABLE cliente (
Codigo D_PK PRIMARY KEY,
nome D_NOME,
numerovendas D_INTEIRO,
telefone D_TELEFONE,
email D_EMAIL,
CPF D_CPF,
datanasc D_DATA);

INSERT	INTO CLIENTE(NOME,NUMEROVENDAS,TELEFONE,EMAIL,CPF,DATANASC)
('Milton Friedman',5000,'5599201920','mfried@gmail.com','49203920392','07-10-1980')
		
INSERT	INTO CLIENTE(NOME,NUMEROVENDAS,TELEFONE,EMAIL,CPF,DATANASC)
VALUES
('Milton Friedman',5000,'5599201920','mfried@gmail.com','49203920392','07-10-1980'),
('Rodrigo Saraiva',1000,'5599302810','joao@gmail.com','20192039201','12-10-1970'),
('Joao da Silva',25,'5532219029','joao@gmail.com','92018293019','10-20-1955'),
('Roberto Jucá',45,'5530261019','juca@gmail.com','39481038292','6-20-1970'),
('Leandro Narlock',100,'5533209120','lnarlock@gmail.com','91029382910','5-20-1964');
SELECT * FROM CLIENTE;

-- generator Cliente

CREATE generator g_inc_cliente;

-- Trigger

SET term ^;
CREATE TRIGGER t_inc_cliente FOR cliente
active BEFORE INSERT POSITION 5
AS BEGIN
	NEW.codigo=gen_id(g_inc_cliente,1);
END 
SET term ;^
-----------------------------------------------
-- Venda

CREATE TABLE venda(
Codigo D_PK PRIMARY KEY,
datavenda D_DATA,
numeroNF D_INTEIRO,
subtotal D_DECIMAL,
desconto D_DECIMAL,
total D_DECIMAL,
codcliente D_INTEIRO,
FOREIGN KEY (codcliente) REFERENCES CLIENTE(codigo)
ON UPDATE CASCADE ON DELETE SET NULL
);

SELECT * FROM VENDA;

ALTER TABLE venda add numeronf char(14);


-- generator Venda

CREATE generator g_inc_venda;

-- Trigger Venda

SET term ^;
CREATE TRIGGER t_inc_venda FOR venda
active BEFORE INSERT POSITION 5
AS BEGIN
	NEW.codigo=gen_id(g_inc_venda,1);
END 
SET term ;^

-----------------------------------------------
-- Fornecedor

CREATE TABLE fornecedor(
codigo D_PK PRIMARY KEY,
razaosocial D_NOME,
email D_EMAIL,
cnpj D_CNPJ NOT NULL,
telefone D_TELEFONE,
nomefantasia D_NOME,
numerocompras D_INTEIRO);

INSERT INTO FORNECEDOR (razaosocial, EMAIL, CNPJ, TELEFONE, NOMEFANTASIA,NUMEROCOMPRAS)
VALUES
('Fornecedor 1', 'forn1@gmail.com', '29102938102920', '5533201920','Nome fantasia 1', 100)
('Fornecedor 2', 'forn2@gmail.com', '29102938102921', '5533201921','Nome fantasia 2', 200)
('Fornecedor 3', 'forn3@gmail.com', '29102938102922', '5533201922','Nome fantasia 3', 300)
('Fornecedor 4', 'forn4@gmail.com', '29102938102923', '5533201923','Nome fantasia 4', 400)
('Fornecedor 5', 'forn5@gmail.com', '29102938102924', '5533201924','Nome fantasia 5', 500)
('Fornecedor 6', 'forn6@gmail.com', '29102938102925', '5533201925','Nome fantasia 6', 600);


-- generator fornecedor

CREATE generator g_inc_fornecedor;

-- Trigger fornecedor

SET term ^;
CREATE TRIGGER t_inc_fornecedor FOR fornecedor
active BEFORE INSERT POSITION 5
AS BEGIN
	NEW.codigo=gen_id(g_inc_fornecedor,1);
END 
SET term ;^

-----------------------------------------------
-- Compra 
-- e ON DELETE CASCADE

CREATE TABLE Compra(
codigo D_PK PRIMARY KEY,
datacompra D_DATA,
numeroinf D_INTEIRO,
subtotal D_DECIMAL,
desconto D_DECIMAL,
total D_DECIMAL,
codigofornecedor D_INTEIRO,
FOREIGN KEY(codigofornecedor) REFERENCES fornecedor(codigo)
ON UPDATE CASCADE ON DELETE SET null);




INSERT INTO COMPRA (DATACOMPRA, NUMEROINF,SUBTOTAL,DESCONTO,TOTAL,CODIGOFORNECEDOR)
VALUES
('10-22-2005',2019201922, 8000, 0, 8000,1);

SELECT * FROM COMPRA;

ALTER TABLE COMPRA
DROP numeroinf

-- generator compra

CREATE generator g_inc_compra;

-- Trigger fornecedor

SET term ^;
CREATE TRIGGER t_inc_compra FOR compra
active BEFORE INSERT POSITION 5
AS BEGIN
	NEW.codigo=gen_id(g_inc_compra,1);
END 
SET term ;^

-----------------------------------------------
--  Marca

CREATE TABLE marca(
codigo D_PK PRIMARY KEY,
nome D_NOME);

INSERT INTO MARCA (NOME)
VALUES
('marca 5');


-- generator marca

CREATE generator g_inc_marca;

-- Trigger marca

SET term ^;
CREATE TRIGGER t_inc_marca FOR marca
active BEFORE INSERT POSITION 5
AS BEGIN
	NEW.codigo=gen_id(g_inc_marca,1);
END 
SET term ;^

-----------------------------------------------
-- 	Tipo
CREATE TABLE tipo(
codigo D_PK PRIMARY KEY,
nome D_NOME);

INSERT INTO TIPO (nome)
VALUES
('tipo 5');

SELECT * FROM TIPO;


-- generator tipo

CREATE generator g_inc_tipo;

-- Trigger tipo

SET term ^;
CREATE TRIGGER t_inc_tipo FOR tipo
active BEFORE INSERT POSITION 5
AS BEGIN
	NEW.codigo=gen_id(g_inc_tipo,1);
END 
SET term ;^

-----------------------------------------------

-- Produto
CREATE TABLE Produto(
codigo D_INTEIRO PRIMARY KEY,
codtipo D_INTEIRO,
codmarca D_PK,
nome D_NOME NOT NULL,
quantidademinima D_INTEIRO NOT NULL,
quantidadeatual D_INTEIRO NOT NULL,
valorunitario D_DECIMAL NOT NULL,
unidade D_UNIDADE,
FOREIGN KEY(codtipo) REFERENCES TIPO(codigo)
ON UPDATE CASCADE ON DELETE SET NULL,
FOREIGN KEY(codmarca) REFERENCES MARCA(codigo)
ON UPDATE CASCADE ON DELETE SET NULL);	

-- generator produto

CREATE generator g_inc_produto;

-- Trigger produto

SET term ^;
CREATE TRIGGER t_inc_produto FOR produto
active BEFORE INSERT POSITION 5
AS BEGIN
	NEW.codigo=gen_id(g_inc_produto,1);
END 
SET term ;^

-----------------------------------------------
--mudar On delete para -- ON DELETE CASCADE

-- Item Venda
CREATE TABLE itemvenda(
codproduto D_INTEIRO,
codvenda D_INTEIRO,
valorunitario D_DECIMAL,
quantidade D_INTEIRO NOT NULL,
total D_DECIMAL,
FOREIGN KEY(codproduto) REFERENCES PRODUTO(codigo)
ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY(codvenda) REFERENCES VENDA(codigo)
ON UPDATE CASCADE ON DELETE CASCADE,
PRIMARY KEY(codproduto,codvenda)
);


-----------------------------------------------
--mudar On delete para -- ON DELETE CASCADE
-- Item Compra

CREATE TABLE itemcompra(
codproduto D_PK NOT NULL,
codcompra D_PK NOT NULL,
total D_DECIMAL,
valorunitario D_DECIMAL,
quantidade D_INTEIRO NOT NULL,
FOREIGN KEY(codproduto) REFERENCES PRODUTO(codigo)
ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY(codcompra) REFERENCES COMPRA(codigo)
ON UPDATE CASCADE ON DELETE CASCADE,
PRIMARY KEY(codproduto,codcompra)
);

-----------------------------------------------
-- Historico Estoque


DROP TABLE HISTORICOESTOQUE;

CREATE TABLE historicoestoque(
codigo D_PK PRIMARY KEY,
codproduto D_INTEIRO,
codvenda D_INTEIRO,
codcompra D_INTEIRO,
valorunitario D_DECIMAL,
total D_DECIMAL NOT NULL,
quantidade D_DECIMAL NOT NULL,
FOREIGN key(codproduto) REFERENCES PRODUTO(codigo)
ON UPDATE CASCADE ON DELETE SET NULL,
FOREIGN KEY(codvenda) REFERENCES VENDA(codigo)
ON UPDATE CASCADE ON DELETE SET NULL,
FOREIGN KEY(codcompra) REFERENCES COMPRA(codigo)
ON UPDATE CASCADE ON DELETE SET NULL);

CREATE generator g_inc_historico;

SET term ^;
CREATE TRIGGER g_inc_historico FOR HISTORICOESTOQUE
active BEFORE INSERT POSITION 5
AS BEGIN
	NEW.codigo=gen_id(g_inc_historico,1);
END 
SET term ;^
