USE classicmodels;

-- MOD
-- finds whether the quantity of products, which customers ordered, is odd or even

SELECT od.orderNumber, 
		SUM(od.quantityOrdered) TotalQtty, 
		if(MOD(SUM(od.quantityOrdered), 2), 'Odd', 'Even') OddorEven
FROM orderdetails od
GROUP BY od.orderNumber;

-- TRUNCATE
SELECT TRUNCATE(8.556, 1);
SELECT TRUNCATE(8.556, 0);
SELECT TRUNCATE(888.556, -2);

-- ROUND
-- finds the average order line item values by product codes
SELECT od.productCode, round(AVG(od.quantityOrdered * od.priceEach)) AS AvgValues
FROM orderdetails od
GROUP BY od.productCode;

-- REPLACE
UPDATE products p
SET p.productDescription = REPLACE(p.productDescription, 'Features', 'Bells and whistles');

UPDATE products p
SET p.productDescription = REPLACE(p.productDescription, 'Bells and whistles', 'Features');

-- DATEDIFF
-- 1 number of days for the year to end
SELECT DATEDIFF('2022-12-31', CURRENT_DATE());

-- 2 a calculate the number of days between the required date and shipped date of the orders,
SELECT o.orderNumber, DATEDIFF(o.requiredDate, o.shippedDate) AS daysLeft
FROM orders o
ORDER BY daysLeft DESC;

-- 2 b gets all orders whose statuses are in-process, and calculates the
-- number of days between ordered date and required date:
SELECT o.orderNumber, DATEDIFF(o.requiredDate, o.orderDate) AS daysLeft
FROM orders o
WHERE o.`status` = 'In Process'
ORDER BY daysLeft;

-- 2 c calculating an interval in week or month, you can divide the returned value of
-- the DATEDIFF function by 7 or 30
SELECT o.orderNumber, 
		DATEDIFF(o.requiredDate, o.orderDate) AS daysLeft,
		ROUND(DATEDIFF(o.requiredDate, o.orderDate)/7, 2) AS weeksLeft,
		ROUND(DATEDIFF(o.requiredDate, o.orderDate)/30, 2) AS monthsLeft
FROM orders o
WHERE o.`status` = 'In Process';

-- DATE_FORMAT
SELECT orderNumber,
		DATE_FORMAT(orderDate, '%W %D %M %Y') AS orderDate,
		DATE_FORMAT(requiredDate, '%M %e %Y') AS requiredDate,
		DATE_FORMAT(shippedDate, '%m/%d/%Y') AS shippedDate
FROM orders;

-- DATE_FORMAT returns string, so do not sort by a DATE_FORMAT result!
SELECT orderNumber,
		DATE_FORMAT(shippedDate, '%W %D %M %Y') AS DateShipped
FROM orders
WHERE shippedDate IS NOT NULL
ORDER BY shippedDate;

-- LPAD 
SELECT LPAD('Good Morning', 15, '*');

SELECT LPAD('Good Morning', 10, '*');

-- RPAD
SELECT RPAD('Good Morning', 15, '*');

SELECT firstName, LPAD(firstName, 10, '#'), LPAD(firstName, 5, '#'), LPAD(firstName, 4, '#')
FROM employees;

-- TRIM, LTRIM, RTRIM
-- remove leading/trailing spaces/other characters from a string
SELECT TRIM('SQL TRIM Function');

SELECT TRIM('-' FROM '---SQL TRIM Function---');

-- nothing updated
UPDATE products
SET productName = TRIM(productName);

