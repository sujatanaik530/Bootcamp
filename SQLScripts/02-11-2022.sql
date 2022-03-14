INSERT INTO customers (customerNumber, customerName, contactLastName, contactFirstName, phone, city, state) VALUES (2, 'Julian', 'ABC', 'XYZ', '258963', 'NYC', 'NY');

INSERT INTO customers (customerNumber, customerName, contactLastName, contactFirstName, phone, city, state) VALUES (3, 'Julian', 'ABC', 'XYZ', '258963', 'NYC', 'NY'),
(4, 'Julian', 'ABC', 'XYZ', '258963', 'NYC', 'NY'),
(5, 'Julian', 'ABC', 'XYZ', '258963', 'NYC', 'NY'),
(6, 'Julian', 'ABC', 'XYZ', '258963', 'NYC', 'NY'),
(7, 'Julian', 'ABC', 'XYZ', '258963', 'NYC', 'NY'),
(8, 'Julian', 'ABC', 'XYZ', '258963', 'NYC', 'NY');

SELECT *
FROM customers
WHERE customerNumber >= 2 AND customerNumber <= 8;

SELECT *
FROM customers
WHERE customerNumber BETWEEN 2 AND 8;

INSERT INTO customers (customerNumber, customerName, contactLastName, contactFirstName, phone, city, state) VALUES (9, 'Julian', 'ABC', 'XYZ', '258963', 'NYC', 'NY'),
(10, 'Julian', 'ABC', 'XYZ', '258963', 'NYC', 'NY'),
(11, 'Julian', 'ABC', 'XYZ', '258963', 'NYC', 'NY');

SELECT *
FROM customers
WHERE customerNumber < 2 OR customerNumber > 11;

SELECT *
FROM customers
WHERE customerNumber NOT BETWEEN 2 AND 11;

DROP TABLE payments_high;

CREATE TABLE `payments_high` (
	`customerNumber` INT(11) NOT NULL,
	`checkNumber` VARCHAR(50) NOT NULL COLLATE 'latin1_swedish_ci',
	`paymentDate` DATE NOT NULL,
	`amount` DECIMAL(10,2) NOT NULL,
	`status` VARCHAR(10) NOT NULL DEFAULT 'pending' COLLATE 'latin1_swedish_ci',
	PRIMARY KEY (`customerNumber`, `checkNumber`) USING BTREE
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB;

INSERT INTO payments_high
SELECT * FROM payments WHERE amount > 2000;

SELECT * FROM payments_high;

UPDATE customers c SET c.phone = '000000' WHERE c.customerNumber = 131;

SELECT * FROM customers c WHERE  c.customerNumber = 131;

UPDATE customers c
SET
c.phone = '000000',
c.customerName = "Techno solution",
c.addressLine1 = "25 Street nyc"
    WHERE c.customerNumber = 131;
SELECT * FROM customers c WHERE c.customerNumber = 131;

SELECT country FROM customers
GROUP BY country
order BY customerNumber DESC;

SELECT DISTINCT(country) FROM customers
ORDER BY customerNumber DESC;

-- same as next query
SELECT DISTINCT(STATUS) FROM orders;

-- same as previous query
SELECT STATUS FROM orders
GROUP BY STATUS;

SELECT STATUS, COUNT(*) FROM orders
GROUP BY STATUS;

SELECT p.productLine, COUNT(p.productLine), MAX(p.buyPrice), MIN(p.buyPrice)
FROM products p
GROUP BY p.productLine;

SELECT o.orderNumber, SUM(o.quantityOrdered * o.priceEach) AS total_price_of_order
FROM orderdetails o
GROUP BY o.orderNumber;

-- Total number of orders by year
SELECT ltrim(year(orderDate)) AS yr, COUNT(orderNumber) AS total_number_of_orders
FROM orders
GROUP BY yr;

-- get order number, items sold per order, total sales for each order
SELECT orderNumber, sum(quantityOrdered) AS 'items sold per order', SUM(quantityOrdered * priceEach) AS 'total sales for order'
FROM orderdetails
GROUP BY orderNumber;

-- above results, where order has total sales greater than 20000
SELECT orderNumber, sum(quantityOrdered) AS 'items sold per order', SUM(quantityOrdered * priceEach) AS total_sales_for_order
FROM orderdetails
GROUP BY orderNumber
HAVING total_sales_for_order > 20000;

SELECT orderNumber, sum(quantityOrdered) AS 'items sold per order', SUM(quantityOrdered * priceEach) AS total_sales_for_order
FROM orderdetails
WHERE orderNumber BETWEEN 10104 AND 10114
GROUP BY orderNumber
HAVING total_sales_for_order > 20000;

-- customername starts with 'A'
SELECT *
FROM customers
WHERE customerName like 'A%';

-- customername end with 'a'
SELECT *
FROM customers
WHERE customerName LIKE '%a';

-- customername has with 'inc'
SELECT *
FROM customers
WHERE customerName LIKE '%inc%';

-- customername starts with 'a' and ends with 'o'
SELECT *
FROM customers
WHERE customerName LIKE 'a%o';

-- query to see columns in a table
SHOW COLUMNS FROM customers;

-- query to see columns in a table
DESCRIBE customers;

SELECT * FROM customers LIMIT 3, 5;