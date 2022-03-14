-- SQL custom functions

-- function to calculate the number of days between two dates

delimiter $$
CREATE FUNCTION DaysApart(earlierDate DATE, laterDate DATE)
RETURNS INT DETERMINISTIC 
BEGIN
	RETURN laterDate - earlierDate;
END; $$
delimiter;

SELECT DaysApart('2022-12-01', '2022-12-31');

delimiter $$
CREATE FUNCTION WeightedAverage (n1 INT, n2 INT, n3 INT, n4 INT)
RETURNS DECIMAL(10, 2)
DETERMINISTIC
BEGIN
     DECLARE avg DECIMAL(10, 2);
     SET avg = (n1+n2+n3*2+n4*4)/8;
     RETURN avg;
END; $$
delimiter;

SELECT WeightedAverage(1, 2, 3, 4);

DELIMITER $$
CREATE FUNCTION CustmerMemberShipStatus(	credit DECIMAL(10,2) )
RETURNS VARCHAR(20)
DETERMINISTIC
BEGIN
   DECLARE customerLevel VARCHAR(20);
   IF credit > 50000 THEN
		SET customerLevel = 'PLATINUM';
   ELSEIF (credit >= 50000 AND credit <= 10000) THEN
      SET customerLevel = 'GOLD';
   ELSEIF credit < 10000 THEN
      SET customerLevel = 'SILVER';
   END IF;
 	-- return the customer level
	RETURN (customerLevel);
END$$
DELIMITER ;

SELECT customerName, CustmerMemberShipStatus(creditLimit)
FROM customers 
ORDER BY customerName;

-- SQL stored procedures

delimiter $$
CREATE PROCEDURE GetOfficeForUSA()
BEGIN
	SELECT * FROM offices o WHERE o.country = 'USA';
END$$
delimiter ;

SHOW PROCEDURE STATUS WHERE `Db`='classicmodels';
SHOW FUNCTION STATUS WHERE `Db`='classicmodels';

CALL GetOfficeForUSA;

-- stored procedure with IN parameter
delimiter $$
CREATE PROCEDURE GetOfficeByCountry(in countryName VARCHAR(10))
BEGIN
	SELECT * FROM offices o WHERE o.country = countryName;
END$$
delimiter ;

CALL GetOfficeByCountry('France');

-- stored procedure with OUT parameter
DELIMITER $$
CREATE PROCEDURE CountOrderByStatus(IN orderStatus VARCHAR(25),  OUT total INT)
BEGIN
	SELECT count(orderNumber) INTO total FROM orders
	WHERE status = orderStatus;
END$$
DELIMITER ;

CALL CountOrderByStatus('disputed', @total);
SELECT @total;

delimiter $$
CREATE PROCEDURE GetSalesRepCommission()
BEGIN
	SELECT CONCAT(e.lastName ,' ' , e.firstName) AS 'Sales Person',
			SUM(p.customerNumber) AS 'Total Customers',
			COUNT(p.customerNumber) AS 'Count of Payment',
			TRUNCATE(SUM(p.amount * 0.2), 0) AS 'Commission',
			if(c.salesRepEmployeeNumber IS NULL, 'Customer unknown', c.salesRepEmployeeNumber ) AS 'Sales Person ID'
	FROM employees e 	RIGHT JOIN customers c ON e.employeeNumber = c.salesRepEmployeeNumber
	LEFT JOIN payments p ON c.customerNumber = p.customerNumber
	GROUP BY c.salesRepEmployeeNumber
	ORDER BY 'Count of Payment';
END$$
delimiter ;

CALL GetSalesRepCommission();

-- subqueries

-- this wont work because aggregate functions cant be used with WHERE
SELECT checkNumber, amount
FROM payments
WHERE amount > AVG(amount);

-- so, use a subquery
-- with comparison operators, inner query must return only one value.
SELECT checkNumber, amount
FROM payments
WHERE amount > (SELECT AVG(p.amount) FROM payments p);

SELECT p.*
FROM products p
WHERE p.buyPrice > (SELECT AVG(p1.buyPrice) FROM products p1);

-- inner query returns an entire column (or a set of values)
SELECT e.firstName, e.lastName
FROM employees e
WHERE e.officeCode IN (SELECT o.officeCode FROM offices o WHERE o.country = 'USA');

-- find which customer payed the highest amount
SELECT p1.customerNumber, p1.checkNumber
FROM payments p1
WHERE p1.amount = (SELECT MAX(p2.amount) FROM payments p2);

-- find which customer payed the highest amount
-- to find customer's name, use INNER JOIN
SELECT p1.customerNumber, CONCAT(c.contactFirstName, ' ', c.contactLastName), p1.checkNumber
FROM payments p1 INNER JOIN customers c ON p1.customerNumber = c.customerNumber
WHERE p1.amount = (SELECT MAX(p2.amount) FROM payments p2);

-- find which customer payed less than highest amount
-- to find customer's name, use INNER JOIN
SELECT p1.customerNumber, CONCAT(c.contactFirstName, ' ', c.contactLastName), p1.checkNumber
FROM payments p1 INNER JOIN customers c ON p1.customerNumber = c.customerNumber
WHERE p1.amount < (SELECT MAX(p2.amount) FROM payments p2);

-- find customer country name where payment less than average
SELECT c.country, COUNT(p1.customerNumber) AS NumberOfCustomers
FROM payments p1 INNER JOIN customers c ON p1.customerNumber = c.customerNumber
WHERE p1.amount < (SELECT MAX(p2.amount) FROM payments p2)
GROUP BY c.country
HAVING COUNT(p1.customerNumber) < (SELECT AVG(p3.amount) FROM payments p3);

-- find the customers who has made payments more than the overall average payment amount (Classicmodel db)
SELECT distinct p1.customerNumber, 
		CONCAT(c.contactFirstName, ' ', c.contactLastName) AS CustomerName
FROM payments p1 INNER JOIN customers c ON p1.customerNumber = c.customerNumber
WHERE p1.amount > (SELECT avg(p2.amount) FROM payments p2);

-- find the customers who have not place any orders yet (classic model db)
SELECT c.customerNumber
FROM customers c LEFT JOIN orders o ON c.customerNumber = o.CustomerNumber
GROUP BY c.customerNumber
HAVING COUNT(o.orderNumber) = 0;

-- using subquery!
SELECT c.customerNumber
FROM customers c
WHERE c.customerNumber NOT IN (SELECT DISTINCT customerNumber FROM orders);

-- find the customers whose payments are greather than average payments
-- ??
SELECT distinct p1.customerNumber, 
		CONCAT(c.contactFirstName, ' ', c.contactLastName) AS CustomerName
FROM payments p1 INNER JOIN customers c ON p1.customerNumber = c.customerNumber
WHERE p1.amount > (SELECT avg(p2.amount) 
						FROM payments p2 
						GROUP BY p2.customerNumber 
						HAVING p1.customerNumber = p2.customerNumber);

-- subquery or derived table?						
SELECT tablealias.ordernumber, tablealias.productcode
FROM (SELECT od.orderNumber AS ordernumber, od.productcode AS productcode FROM orderdetails od) AS tablealias;

-- find the max item purchase, avg item purchase, min item purchase in orders table
SELECT MAX(a.items), MIN(a.items), AVG(a.items)
FROM
(
	SELECT COUNT(od.ordernumber) AS items,
	productcode
	FROM orderdetails od
	GROUP BY od.ordernumber
) AS a

-- find the avg amount of the grand total amount of each specific customer
SELECT AVG(a.gtotal)
FROM
(
	SELECT SUM(amount) AS gtotal
	FROM payments
	GROUP BY customernumber
) AS a

-- find the grand total amount of orders
SELECT sum(totalamt)
FROM
(
	SELECT SUM(priceeach * quantityordered) AS totalamt
	FROM orderdetails
	GROUP BY ordernumber
) AS a

-- grand total per customer
SELECT a.cfname AS CutomerFirstName,
		SUM(a.totalamt) AS GrandTotal
FROM
(
	SELECT SUM(od.priceeach * od.quantityordered) AS totalamt,
				c.contactfirstname AS cfname,
				customernumber
	FROM orderdetails od INNER JOIN orders o USING (ordernumber)
							INNER JOIN customers c USING (customernumber)
	GROUP BY od.ordernumber
) AS a
GROUP BY a.customernumber;

