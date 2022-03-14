USE librarydb;


CREATE TABLE supplier (
	supplierid INT(111) PRIMARY KEY AUTO_INCREMENT,
	suppliername VARCHAR(50) UNIQUE,
	supplieremail VARCHAR(50) UNIQUE,
	supplierphone BIGINT
);

CREATE TABLE products (
	productid INT(111) PRIMARY KEY AUTO_INCREMENT,
	productname VARCHAR(225),
	productprice DECIMAL,
	supplierid INT(111),
	FOREIGN KEY (supplierid) REFERENCES supplier(supplierid) ON DELETE SET NULL ON UPDATE SET NULL
);

CREATE TABLE orders (
	orderid INT(111) PRIMARY KEY,
	orderdate DATE,
	customerid INT(111),
	quantity INT (225),
	lastupdatedate DATE,
	supplierid INT(111),
	productid INT(111),
	FOREIGN KEY (customerid) REFERENCES customers(customerid),
	FOREIGN KEY (supplierid) REFERENCES supplier(supplierid),
	FOREIGN KEY (productid) REFERENCES products(productid)
);

USE ecommercewebsite;

-- joins
SELECT * 
FROM customers c INNER JOIN orders o ON  c.customerId = o.customerID 
WHERE c.customerId = 1;
	
-- natural join --> We  specify "using" keyword instead ON,
	
SELECT * FROM customers c INNER JOIN orders o USING (customerId);
	
-- join 3three tables together
	
SELECT * FROM customers c 	INNER JOIN orders o ON c.customerId = o.customerID
									INNER JOIN supplier sp ON  sp.sup_id = o.supplier_id;
	
SELECT  	c.customerName AS 'Customer Name', 
			sp.sup_name AS 'Supplier Name', 
			o.Oid  
FROM customers c 	INNER JOIN orders o ON c.customerId = o.customerID
						INNER JOIN supplier sp ON  sp.sup_id = o.supplier_id;
	
	
SELECT 	c.customerName AS 'Customer Name',
			sp.sup_name AS 'Supplier Name',
			o.Oid	
FROM customers c	INNER JOIN orders o ON c.customerId = o.customerID
						INNER JOIN supplier sp ON  sp.sup_id = o.supplier_id;

SELECT 	c.customerName AS 'Customer Name',
			sp.sup_name AS 'Supplier Name',
			o.Oid,
			p.product_name
FROM customers c  INNER JOIN orders o ON c.customerId = o.customerID
						INNER JOIN supplier sp ON  sp.sup_id = o.supplier_id
						INNER JOIN product p ON p.product_id = o.product_id;

-- left join
SELECT *
FROM orders o LEFT JOIN customers c ON o.customerID = c.customerId;

-- right join
SELECT *
FROM orders o RIGHT JOIN customers c ON o.customerID = c.customerId;

-- inner join has higher priority
SELECT *
FROM orders o LEFT JOIN customers c ON o.customerID = c.customerId
					INNER JOIN supplier s ON s.sup_id = o.supplier_id;

-- self join
USE classicmodels;
SELECT CONCAT(e.firstName, ' ', e.lastName) AS Employee, CONCAT(m.firstName, ' ', m.lastName) AS Manager
FROM employees e JOIN employees m ON e.reportsTo = m.employeeNumber;

-- cross join
USE classicmodels;

-- 27 rows
SELECT * FROM employees;

-- 276 rows
SELECT * FROM payments;

-- 276 times 27 = 7452 rows
SELECT *
FROM employees e CROSS JOIN payments p;

-- union
SELECT * FROM customers c LEFT JOIN orders o USING (customerNumber)
UNION ALL
SELECT * FROM customers c RIGHT JOIN orders o USING (customerNumber);

-- write a query for customer name, product, how many orders (s)he placed, total amount, count of total amount
SELECT c.customerName AS 'Customer Name', 
		pd.productName AS 'Product',
		COUNT(o.orderNumber) AS 'Total Orders', 
		SUM(pt.amount) AS 'Total Amount'
FROM customers c left JOIN orders o ON c.customerNumber = o.customerNumber
						JOIN orderdetails od ON o.orderNumber = od.orderNumber
						JOIN products pd ON od.productCode = pd.productCode
						JOIN payments pt ON pt.customerNumber = c.customerNumber
GROUP BY c.customerNumber, pd.productName;

-- another form of above from instructor
SELECT c.customerName AS 'Customer Name',
		CONCAT(c.contactFirstName, ' ', c.contactLastName) AS 'Customer Contact Full Name',
		SUM(p.amount) AS 'Total Price',
		COUNT(o.orderNumber) AS 'Total Number of Orders'
FROM customers c INNER JOIN payments p ON c.customerNumber = p.customerNumber
						INNER JOIN orders o ON c.customerNumber = o.customerNumber
GROUP BY p.customerNumber;

-- write a query for customer full name, sales representative
SELECT c.customerName AS 'Customer Name',
		 CONCAT(c.contactFirstName, ' ', c.contactLastName) AS 'Customer Contact Name', 
		 CONCAT(e.firstName, ' ', e.lastName) AS 'Sales Representative'
FROM customers c JOIN employees e ON c.salesRepEmployeeNumber = e.employeeNumber;

--
SELECT CONCAT(e.lastName ,' ' , e.firstName) AS 'Sales Person',
		SUM(p.customerNumber) AS 'Total Customers',
		COUNT(p.customerNumber) AS 'Count of Payment',
		TRUNCATE(SUM(p.amount * 0.2), 0) AS 'Commission',
		if(c.salesRepEmployeeNumber IS NULL, 'Customer unknown', c.salesRepEmployeeNumber ) AS 'Sales PErson ID'
FROM employees e 	RIGHT JOIN customers c ON e.employeeNumber = c.salesRepEmployeeNumber
						LEFT JOIN payments p ON c.customerNumber = p.customerNumber
GROUP BY c.salesRepEmployeeNumber
ORDER BY 'Count of Payment';