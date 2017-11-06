-- Procedures

--------------------------------------------------------------------
--						ADD A SALE PROCEDURES

-- GET CLIENTS
CREATE or replace FUNCTION get_clients()
RETURNS TABLE(name varchar(50)) AS $$
BEGIN
    RETURN QUERY select c.name
				  FROM clients as c;
END;            
$$ LANGUAGE plpgsql;

select * from get_clients();

select * from sales;





-- ADD A NEW SALE
CREATE OR REPLACE FUNCTION add_sale(	
	subtotal float,
	total float,
	clientname character varying,
	discout float,
	finalized char(1)
) 
    RETURNS void AS $$
    declare 
    	idclient integer;    	
    BEGIN
      	select c.id
      	from clients c
      	where c."name" = clientname
      	into idclient;      	
	    
	    INSERT INTO sales(
	   	saledate,		
		subtotal,
		total,
		clientid,
		discout,
		finalized) 
	    VALUES (
	    current_timestamp,	    
	    subtotal,
	    total,
	    idclient,
	    discout,
	    finalized
		);
    END;
    $$ LANGUAGE plpgsql;
    
    -- Execute store procedure    
DO $$ BEGIN
    PERFORM add_sale(100.0,50.0,'vinicius',0.5, 'F');
END $$;


--RESTART SEQUENCES
ALTER SEQUENCE sales_id_seq RESTART WITH 2

select * from sales;

CREATE or replace FUNCTION checkInvoiceIDAlreadyExists(iputFiscalNote character varying)
RETURNS TABLE(id integer) AS $$
BEGIN
    RETURN QUERY select s.id 
				  FROM sales as s
				  where s.invoice = iputFiscalNote;
END;            
$$ LANGUAGE plpgsql;

select * from checkInvoiceIDAlreadyExists('123456489');

--------------------------------------------------------------------
--						ADD A PRODUCT PROCEDURES
-- GET BRANDS
CREATE or replace FUNCTION get_brands()
RETURNS TABLE(name varchar(50)) AS $$
BEGIN
    RETURN QUERY select b.name
				  FROM brands as b;
END;            
$$ LANGUAGE plpgsql;

-- GET TYPES

CREATE or replace FUNCTION get_types()
RETURNS TABLE(name varchar(50)) AS $$
BEGIN
    RETURN QUERY select t.name
				  FROM types as t;
END;            
$$ LANGUAGE plpgsql;


CREATE or replace FUNCTION get_products()
RETURNS TABLE(
productname character varying,
brandname character varying,
typename  character varying ,
minimumquantity integer,
currentquantity integer,
unitvalue decimal(15,2),
unittype varchar(30)) AS $$
BEGIN    
	RETURN QUERY select p."name",b."name",t."name",p.minimumquantity,p.currentquantity,p.unitvalue,p.unittype
				  FROM products p
				  join types t on p.typeid = t.id
				  join brands b on p.brandid = b.id
				  limit 50;				  
END;            
$$ LANGUAGE plpgsql;


CREATE or replace FUNCTION get_a_product(pname varchar(50))
RETURNS TABLE(
productname character varying,
brandname character varying,
typename  character varying ,
minimumquantity integer,
currentquantity integer,
unitvalue decimal(15,2),
unittype varchar(30)) AS $$
BEGIN    
	RETURN QUERY select p."name",b."name",t."name",p.minimumquantity,p.currentquantity,p.unitvalue,p.unittype
				  FROM products p
				  join types t on p.typeid = t.id
				  join brands b on p.brandid = b.id
				  where p."name" = pname;
END;            
$$ LANGUAGE plpgsql;


drop function get_products

select * from get_products();

select * from products;

select * from products
where "name" = 

select p."name" productname,b."name" brandname, t."name" typename ,p.minimumquantity,p.currentquantity,p.unitvalue,p.unittype  
  FROM products p
  join types t on p.typeid = t.id
  join brands b on p.brandid = b.id;


CREATE or replace FUNCTION product_exists(pname character varying)
RETURNS TABLE(hasproduct boolean) AS $$
BEGIN
    RETURN QUERY 
    select exists(select from products as p
    				where p."name" = pname );
END;            
$$ LANGUAGE plpgsql;


CREATE or replace FUNCTION product_exists(pname character varying)
RETURNS TABLE(hasproduct boolean) AS $$
BEGIN
    RETURN QUERY 
    select exists(select from products as p
    				where p."name" = pname );
END;            
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION add_product(
	pname character varying,
	brandname character varying,
	typename character varying ,
	minimumquantity integer,
	currentquantity integer,
	unitvalue decimal(15,2),
	unittype character varying
) 
    RETURNS void AS $$
    declare 
    	idbrand integer;
    	idtype integer;
    BEGIN
      	select b.id
      	from brands b
      	where b."name" = brandname
      	into idbrand;
      	
      	select t.id
      	from types t
      	where t."name" = typename
      	into idtype;
	    
	    INSERT INTO products(
	    name,
		brandid,
		typeid,
		minimumquantity,
		currentquantity,
		unitvalue,
		unittype) 
	    VALUES (
	    pname,
	    idbrand,
	    idtype,
	    minimumquantity,
		currentquantity,
		unitvalue,
		unittype 
		);
    END;
    $$ LANGUAGE plpgsql;
    
-- Execute store procedure    
DO $$ BEGIN
    PERFORM add_product('Ultra Whey','ProStar','Protein Bar',20,200,150.00,'900g');
END $$;


    
select * from brands;

select * from products;
    
add_product('Ultra Whey','Prostar','Protein Bar',20,200,150.00,'900g');

select * from products;

select * from types;


select hasproduct from product_exists('Optimum Whey 900g - 100%');


select * from products;

select * from get_brands();

select name from get_types()

--CREATE OR REPLACE FUNCTION my_function(user_id integer) RETURNS TABLE(name character varying) AS $$
--DECLARE
--    ids INTEGER[];
--BEGIN
--     ids := ARRAY[1,2];
--     RETURN QUERY
--         SELECT users.id, users.firstname, users.lastname
--         FROM public.users
--         WHERE users.id = ANY(ids);
--END;
--$$ LANGUAGE plpgsql;