--1 - Criar um trigger que antes de inserir um ITENsVENDA, busque o valor do produto (tabela PRODUTOS) e atribua ao valor unitário de ITENSVENDA.

CREATE OR ALTER TRIGGER T_VALORUNITARIO_ITEMVENDA FOR ITEMVENDA
ACTIVE BEFORE INSERT OR UPDATE POSITION 6
AS
	DECLARE VARIABLE VALUNIT D_DECIMAL;		
BEGIN 
	SELECT FIRST 1 P.VALORUNITARIO
	FROM PRODUTO P
	WHERE P.CODIGO = NEW.CODPRODUTO
	INTO :VALUNIT;
	
	NEW.VALORUNITARIO =:VALUNIT;
END

SELECT * FROM ITEMVENDA;

SELECT * FROM PRODUTO;

INSERT INTO ITEMVENDA(CODPRODUTO,CODVENDA,TOTAL,QUANTIDADE)
VALUES
(14,7,30000,100);


--2 - Criar triggers para calcular o valor total do produto após inserir/atualizar um item da compra 
--(caso a compra não tenha sido finalizada). Calcular o subtotal e total da compra.


-- Calcula total de um insert ou alteração itemcompra
CREATE OR ALTER TRIGGER T_TOTALIT FOR ITEMCOMPRA
ACTIVE BEFORE INSERT OR UPDATE POSITION 5
AS		
BEGIN 
	NEW.TOTAL = NEW.VALORUNITARIO * NEW.QUANTIDADE;
END

--Calcular total da compra
CREATE OR ALTER TRIGGER T_TOTALCOMPRA FOR ITEMCOMPRA
ACTIVE AFTER INSERT OR UPDATE POSITION 5
AS
	DECLARE VARIABLE TOTALCOMPRA D_DECIMAL;		
BEGIN 
	SELECT SUM(IT.TOTAL)
	FROM ITEMCOMPRA IT
	INNER JOIN COMPRA C ON IT.CODCOMPRA = C.CODIGO
	INTO :TOTALCOMPRA;
	
	UPDATE COMPRA C
	SET C.TOTAL = :TOTALCOMPRA	
	WHERE C.CODIGO = NEW.CODCOMPRA;
	
	
	UPDATE COMPRA C
	SET C.SUBTOTAL = :TOTALCOMPRA - ( :TOTALCOMPRA * C.DESCONTO)
	WHERE C.CODIGO = NEW.CODCOMPRA;
END

DROP TRIGGER T_TOTALCOMPRA;

	SELECT SUM(IT.TOTAL)
	FROM ITEMCOMPRA IT
	INNER JOIN COMPRA C ON IT.CODCOMPRA = C.CODIGO
	
	
	
	
SELECT * FROM PRODUTO;

SELECT * FROM ITEMCOMPRA;

SELECT * FROM COMPRA;

--3 - Criar triggers para calcular o valor total do produto após inserir/atualizar um item da venda (caso a venda 
--não tenha sido finalizada). Calcular o subtotal e total da venda.
--Que impeça a inclusão, alteração ou exclusão de um item da compra caso a compra tenha sido finalizada.

CREATE EXCEPTION E_COMPRA_FINALIZADA 'Compra finalizada, não é possível alterar.';

CREATE OR ALTER TRIGGER T_TOTALCOMPRA FOR ITEMCOMPRA
ACTIVE AFTER INSERT OR UPDATE POSITION 5
AS
	DECLARE VARIABLE TOTALCOMPRA D_DECIMAL;
	DECLARE VARIABLE FINALIZADA D_FINALIZADA;
BEGIN 
	SELECT C.CODIGO  
	FROM COMPRA C 
	WHERE C.CODIGO = NEW.CODCOMPRA
	INTO :FINALIZADA;
	
	IF(( :FINALIZADA = 'N'))THEN
	BEGIN
		SELECT SUM(IT.TOTAL)
		FROM ITEMCOMPRA IT
		INNER JOIN COMPRA C ON IT.CODCOMPRA = C.CODIGO
		INTO :TOTALCOMPRA;
	
		UPDATE COMPRA C
		SET C.TOTAL = :TOTALCOMPRA	
		WHERE C.CODIGO = NEW.CODCOMPRA;	
		
		UPDATE COMPRA C
		SET C.SUBTOTAL = :TOTALCOMPRA - ( :TOTALCOMPRA * C.DESCONTO)
		WHERE C.CODIGO = NEW.CODCOMPRA;
	END	
	IF((:FINALIZADA = 'S'))THEN
		EXCEPTION E_COMPRA_FINALIZADA;
END

--4 - Criar uma Visão que mostre a data da venda, numero da NF, subtotal, desconto, total e o nome do cliente 
--para as vendas do ano de 2017

--5 - Fazer uma stored procedure que receba como parâmetro de entrada o código do cliente e calcule o número de vendas que o mesmo realizou, efetuando a atualização do número de vendas (tabela CLIENTE). 

--6 - Criar uma visão que mostre todos os produtos vendidos de uma marca específica nos 2 primeiros meses do 2º semestre do ano de 2017.

--7 - Elaborar uma Stored Procedure que receba como parâmetro TODOS os dados de um PRODUTO (exceto as IDs), juntamente com o nome da marca e o nome do tipo.
--Verificar se a MARCA e TIPO existem em suas respectivas tabelas e retornar suas IDs.
--Caso não existam, inserir na respectiva tabela e recuperar a ID.
--Inserir os dados completos do PRODUTO.