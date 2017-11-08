-- DB PROCEDURES FOR FIREBIRD

-------------------------------------------------------------
--				ADD A PRODUCT


-- GET BRANDS
CREATE OR ALTER VIEW getbrands(
      NAME)
  AS
  SELECT name
  FROM BRANDS
  
  SELECT * FROM BRANDS;
  
  SELECT name FROM getbrands
  
  SELECT first 1 id
  FROM BRANDS b
  WHERE b.NAME = 'Optimum'

  
-- GET TYPES 
  CREATE OR ALTER VIEW gettypes(
      NAME)
  AS
  SELECT name
  FROM TYPES
  
  SELECT name FROM gettypes
  
  SELECT * FROM CLIENTS;
  
  SELECT * FROM BRANDS;
  
  SELECT * FROM TYPES;
  
  SELECT * FROM PRODUCTS;
  
  EXECUTE PROCEDURE SP_ADDPRODUCT('Whey 500%','Optimum','Whey Protein',0,0,150,'900g')
  
  
  --ADD A PRODUCT
  CREATE OR ALTER PROCEDURE SP_ADDPRODUCT(  
	PNAME D_NAME,
	brandname D_NAME,
	typename D_NAME,
	minimumquantity D_INT ,
	currentquantity D_INT ,
	unitvalue D_DECIMAL ,
	unittype D_UNIT) 
  AS  	
  DECLARE VARIABLE IDBRAND D_INT;
  DECLARE VARIABLE IDTYPE D_INT;
  	BEGIN	  	
	  	SELECT first 1 id 
	  	FROM BRANDS B
	  	WHERE B.NAME = :BRANDNAME
	  	INTO :IDBRAND;
	  	
	  	SELECT first 1 id
	  	FROM TYPES t
	  	WHERE t.NAME = :typename
	  	INTO :IDTYPE;	  	
  	
  		INSERT INTO PRODUCTS(NAME,BRANDID,TYPEID,MINIMUMQUANTITY,CURRENTQUANTITY,UNITVALUE,UNITTYPE)
  		VALUES(:PNAME, :IDBRAND, :IDTYPE, :minimumquantity, :currentquantity, :unitvalue, :unittype );  		
  	 END
  	 

	EXECUTE SP_ADDPRODUCT('Whey 200%','Optimum','Whey Protein',0,0,150.0,'900g');
 
	
SELECT * FROM PRODUCTS

SELECT FIRST 1 ID
FROM PRODUCTS
WHERE NAME = :PNAME

CREATE OR ALTER PROCEDURE hasproduct(PNAME D_NAME)
RETURNS (hasproduct D_INT)
AS
BEGIN 
	SELECT FIRST 1 ID
	FROM PRODUCTS P
	WHERE P.NAME = :PNAME
	INTO :HASPRODUCT;
END 


CREATE OR ALTER PROCEDURE hasproduct(PNAME D_NAME, BRANDNAME D_NAME)  
  AS  	
  DECLARE VARIABLE BRANDID D_INT;
  BEGIN
	  
	  SELECT FIRST 1 ID 
	  FROM BRANDS B
	  WHERE B.NAME = :BRANDNAME
	  INTO :BRANDID;	  
 
	  IF ( EXISTS (SELECT FIRST 1 P.NAME
	  			   FROM PRODUCTS P	  			   	  			   
	  			   WHERE P.NAME = :PNAME AND P.BRANDID = :BRANDID ))	  			   
	  			   THEN	  			   
			   	EXCEPTION E_PRODUTO_IGUAL;
  END 

  SELECT * FROM PRODUCTS;
  
EXECUTE PROCEDURE hasproduct('Whey 100%','ProStar')   	 
  	

---------------------------------------------------------------------
--				SEARCH PRODUCTS


CREATE OR ALTER PROCEDURE get_a_product(prodname D_NAME)
RETURNS (
pname D_NAME,
brandname D_NAME,
typename D_NAME,
minimumquantity D_INT,
currentquantity D_INT,
unitvalue D_DECIMAL,
unittype D_UNIT
)
  AS  
  BEGIN
	  SELECT  p.NAME, b.NAME, t.NAME, p.MINIMUMQUANTITY, p.CURRENTQUANTITY, p.UNITVALUE, p.UNITTYPE
	  FROM PRODUCTS p
	  INNER JOIN BRANDS B ON p.BRANDID = b.ID
	  INNER JOIN TYPES T ON p.TYPEID = t.ID
	  WHERE p.NAME = :prodname
	  INTO :pname, :brandname, :typename, :minimumquantity, :currentquantity, :unitvalue, :unittype;
  END
   	
  EXECUTE PROCEDURE get_a_product('Whey 100%')

CREATE OR ALTER VIEW get_products(pname,brandname,typename,minimumquantity,currentquantity,unitvalue,unittype)
AS
SELECT  p.NAME, b.NAME, t.NAME, p.MINIMUMQUANTITY, p.CURRENTQUANTITY, p.UNITVALUE, p.UNITTYPE
FROM PRODUCTS p
INNER JOIN BRANDS B ON p.BRANDID = b.ID
INNER JOIN TYPES T ON p.TYPEID = t.ID

SELECT * FROM get_products;
 
CREATE OR ALTER VIEW getbrands(
      NAME)
  AS
  SELECT name
  FROM BRANDS
  	 
  