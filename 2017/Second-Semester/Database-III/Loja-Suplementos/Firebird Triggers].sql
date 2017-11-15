

-----------------------------------------------------------------
--					TRIGGERS



CREATE TRIGGER H_SALES FOR SALEITEMS
ACTIVE AFTER INSERT OR UPDATE POSITION 5
AS
BEGIN
	INSERT INTO ACTIONHISTORY(prodid ,purchaseid , saleid , unitvalue , total , quantity, actiondate)
	VALUES(NEW.prodid,NULL,NEW.saleid,NEW.unitvalue,NEW.total,NEW.quantity, CURRENT_TIMESTAMP);
END

DROP TRIGGER H_SALES;

SELECT * FROM PRODUCTS;

SELECT * FROM sales;

SELECT * FROM actionhistory;


CREATE TRIGGER H_PURCHASES FOR PURCHASEITEMS
ACTIVE AFTER INSERT OR UPDATE POSITION 5
AS
BEGIN
	INSERT INTO ACTIONHISTORY(prodid ,purchaseid , saleid , unitvalue , total , quantity, actiondate)
	VALUES(NEW.prodid,NEW.purchaseid,NULL,NEW.unitvalue,NEW.total,NEW.quantity, CURRENT_TIMESTAMP);
END

