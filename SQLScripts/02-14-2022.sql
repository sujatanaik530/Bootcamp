-- replace all occurrences of Customer with Client
-- only displays, table not changed
SELECT REPLACE(o.comments, 'Customer', 'Client')
from orders o;

-- removes leading/trailing character from string
SELECT TRIM(LEADING '@' FROM '@@teksystems@@');
SELECT TRIM(trailing '@' FROM '@@teksystems@@');
SELECT TRIM(both '@' FROM '@@teksystems@@');
SELECT TRIM('@' FROM '@@teksystems@@');

-- only displays, table not changed
SELECT  TRIM(BOTH 'my' FROM o.addressLine1)
FROM offices o;

select count(*)
FROM employees e
WHERE e.reportsTo IS NULL;

SELECT COUNT(*)
FROM products p;

SELECT COUNT(p.productCode)
FROM products p;

SELECT COUNT(distinct p.productLine)
FROM products p;

select MAX(p.amount), MIN(p.amount), COUNT(*), SUM(p.amount), AVG(p.amount), status
from payments p
GROUP BY p.`status`;

-- average buying price for American Airlines
SELECT AVG(p.buyPrice), MAX(p.buyPrice), MIN(p.buyPrice)
FROM products p
WHERE p.productName LIKE 'American Airlines: MD-11S';

SELECT AVG(p.buyPrice), MAX(p.buyPrice), MIN(p.buyPrice)
FROM products p
WHERE p.productLine = 'Planes';

SELECT concat(MOD(12, 5), ' is the remainder of 12 by 5.') AS remainder;

SELECT od.quantityOrdered AS beforeMOD, MOD(od.quantityOrdered, 3) AS afterMOD
FROM orderdetails od;

SELECT ROUND(121.55, 2);
SELECT ROUND(121.55, 1);
SELECT ROUND(121.552569, 3) AS roundedvalue, truncate(121.552569, 3) AS truncatedvalue;
SELECT ROUND(121.55, -1);
SELECT ROUND(121.55, -2);

SELECT od.priceEach AS beforeROUND, round(od.priceEach, -1) AS afterROUND
FROM orderdetails od;

SELECT od.priceEach AS beforeROUND, round(od.priceEach) AS afterROUND
FROM orderdetails od;

SELECT 	ROUND(121.552569, 3) AS roundedvalue, 
			truncate(121.552569, 3) AS truncatedvalue,
			FLOOR(121.552569) AS flooredvalue,
			CEIL(121.552569) AS ceiledvalue;

SELECT 	od.priceEach AS beforeROUND, 
			round(od.priceEach, 1) AS afterROUND,
			truncate(od.priceEach, 1) AS afterTRUNCATE,
			FLOOR(od.priceEach) AS afterFLOOR,
			CEIL(od.priceEach) AS afterCEIL
FROM orderdetails od;

SELECT 	88 AS beforeROUND, 
			ROUND(88, 1) AS afterROUND,
			TRUNCATE(88, 1) AS afterTRUNCATE,
			FLOOR(88) AS afterFLOOR,
			CEIL(88) AS afterCEIL;
			
SELECT CURRENT_DATE(), CURDATE();

INSERT INTO offices(officeCode, addressLine1, phone, city, country, postalCode, territory, createdate)
VALUES(40004, 'myaddress', 000-000-0000, 'NYC', 'USA', 111111, 'NA', CURRENT_DATE());

UPDATE offices
SET createDate = CURRENT_DATE()
WHERE createDate IS NULL;

SELECT CURRENT_TIME(), CURRENT_TIMESTAMP();

UPDATE offices
SET createTime = CURRENT_TIME()
WHERE createTime IS NULL;

SELECT MONTH(CURRENT_DATE()), MONTH('2021-05-09');
SELECT trim(year(CURRENT_DATE())), trim(year('2021-05-09'));

-- formatting dates
SELECT DATE_FORMAT(CURRENT_DATE(), '%a %e %M %Y');

SELECT DATE_FORMAT(CURRENT_DATE(), '%u');
SELECT DATE_FORMAT('2022-01-08', '%u');

SELECT DATE_FORMAT(p.paymentDate, '%W %e %M %Y') AS Formatted_Payment_Dates, p.paymentDate AS RawDate
FROM payments p;

SELECT DATEDIFF('2022-5-30', CURRENT_DATE());

SELECT if (10 > 5, 'Yes', 'No'), if (100 < 50, 'Yes', 'No');

SELECT od.orderNumber, od.quantityOrdered, if (od.quantityOrdered < 40, 'Less', 'More')
FROM orderdetails od;

SELECT CAST('2014-02-28' AS DATE), CAST(125 AS char), CAST('125' AS DECIMAL(6,2));

SELECT CAST('2014-02-28' AS DATE), CAST(125 AS DECIMAL(2,2)), CAST('125' AS DECIMAL(6,2));

SELECT buyPrice,
		case 	when buyPrice < 49 then 'low'
				when buyprice BETWEEN 49 AND 99 then 'average'
				else 'high'
		END AS PriceLevel
FROM products;

-- DDL Data Definition Language

-- create database
CREATE DATABASE LibraryDB;

-- delete database
DROP DATABASE librarydb;

-- create database
CREATE DATABASE LibraryDB;

-- create tables in this new database
USE librarydb;

CREATE TABLE customers (
	customerid INT(255) PRIMARY KEY,
	customername VARCHAR(25),
	customeremail VARCHAR(100),
	customeraddress VARCHAR(255)
	);

-- show table structure	
DESCRIBE customers;

-- create another table
CREATE TABLE payments (
	customernumber INT,
	checknumber VARCHAR(255),
	paymentdate DATE,
	amount DECIMAL(10, 2)
);

-- add a new column
ALTER TABLE customers
ADD dob DATE;

-- add more new columns
ALTER TABLE customers
ADD contactnumber VARCHAR(10),
ADD address VARCHAR(100);

-- change data type of existing column
ALTER TABLE customers
MODIFY contactnumber VARCHAR(15);

-- rename table
RENAME TABLE customers TO newcustomers;

-- rename back
RENAME TABLE newcustomers TO customers;

-- delete table
DROP TABLE customers;

-- DELETE removes data (all or chosen)
-- DROP removes data and structure
-- TRUNCATE removes all data and cannot be rolled back

-- field level primary key constraint
CREATE TABLE department (
	deptid INT(22) PRIMARY KEY,
	deptname VARCHAR(20),
	deptCode INT(22)
);

-- table level primary key constraint
CREATE TABLE department (
	deptid INT(22),
	deptname VARCHAR(20),
	deptCode INT(22),
	CONSTRAINT IDPK PRIMARY KEY(deptid, deptcode)
);

INSERT INTO department VALUES(2, 'HR', 2);

-- auto_increment
CREATE TABLE department (
	deptid INT(22) auto_increment,
	deptname VARCHAR(20),
	deptCode INT(22),
	CONSTRAINT IDPK PRIMARY KEY(deptid, deptcode)
);

INSERT INTO department (deptname, deptcode) VALUES("IT", 21);

-- unique 
CREATE TABLE department (
	deptid INT(22) auto_increment,
	deptname VARCHAR(20) unique,
	deptaddress VARCHAR(50) UNIQUE,
	deptCode INT(22),
	CONSTRAINT IDPK PRIMARY KEY(deptid, deptcode)
);

-- unique on two column combo
CREATE TABLE department (
	deptid INT(22) auto_increment,
	deptname VARCHAR(20) unique,
	deptaddress VARCHAR(50) UNIQUE,
	deptzipcode INT(10),
	deptareacode INT(10),
	deptCode INT(22),
	UNIque(deptzipcode, deptareacode),
	CONSTRAINT IDPK PRIMARY KEY(deptid, deptcode)
);

-- unique on two column combo
CREATE TABLE department (
	deptid INT(22) AUTO_INCREMENT NOT null,
	deptname VARCHAR(20) UNIQUE NOT NULL DEFAULT 'Pending',
	deptaddress VARCHAR(50) UNIQUE,
	deptzipcode INT(10),
	deptareacode INT(10),
	deptCode INT(22),
	UNIque(deptzipcode, deptareacode),
	CONSTRAINT IDPK PRIMARY KEY(deptid, deptcode)
);

INSERT INTO department (deptname, deptzipcode, deptareacode, deptaddress, deptCode)
VALUES ('IT', '11103', '3859', 'NJ', '698');

-- CHECK
CREATE TABLE department (
	deptid INT(22) AUTO_INCREMENT NOT null,
	deptname VARCHAR(20) UNIQUE NOT NULL DEFAULT 'Pending',
	deptzipcode INT(10),
	deptareacode INT(10),
	deptaddress VARCHAR(50) UNIQUE,
	deptCode INT(22),
	deptminwage DECIMAL(10, 2) CHECK(deptminwage >= 15),
	deptstatus ENUM('Active', 'Inactive', 'On Hold'),
	PRIMARY KEY(deptid, deptcode),
	UNIque(deptzipcode, deptareacode)
);


USE librarydb;
DROP TABLE department;

-- from instructor
CREATE TABLE department (
deptid INT(22) AUTO_INCREMENT NOT NULL,
deptname VARCHAR(20) UNIQUE NOT NULL DEFAULT "NAME is pending" ,
deptzipcode INT(10),
deptareacode INT(10),
deptaddress VARCHAR(50) UNIQUE,
deptcode INT(22),
deptminwage DECIMAL(10,2) CHECK (deptminwage >= 15),
deptStatus ENUM('Active', 'deActive', 'onHold'),
	PRIMARY KEY(deptid),
	UNIQUE(deptzipcode,deptareacode )
	);	

