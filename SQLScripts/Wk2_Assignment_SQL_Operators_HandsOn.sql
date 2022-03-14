-- 1 OR
-- to get the customers who locate in the USA or France,
SELECT customername, country
FROM customers
WHERE country = 'USA' OR country = 'France';

-- 2 AND A
-- returns the customers who are located in the USA or France and have credit
-- limits greater than 10000.
SELECT customername, country, creditLimit
FROM customers
WHERE (country = 'USA' OR country = 'France')
AND creditLimit > 10000;

-- 2 AND B 
-- will return the customers who locate in the USA or the customers who locate in France
-- with the credit limit greater than 10000.
SELECT customername, country, creditLimit
FROM customers
WHERE country = 'USA'
OR (country = 'France' AND creditLimit > 10000);

-- 2 AND C
-- retrieves customers who are located in California (CA) and USA.
SELECT customername, state, country
FROM customers
WHERE state = 'CA'
and country = 'USA';

-- 2 AND D
-- returns the customers who are located in California, USA, and have credit limits greater than 100K.
SELECT customername, state, country
FROM customers
WHERE state = 'CA'
and country = 'USA'
AND creditLimit > 100000;

-- 3 BETWEEN A
-- to find products whose buy prices are within the ranges of 90 and 100
SELECT productCode, productName, buyPrice
FROM products
WHERE buyPrice BETWEEN 90 AND 100;

-- 3 BETWEEN B
-- to find products whose buy prices are within the ranges of 90 and 100
SELECT productCode, productName, buyPrice
FROM products
WHERE buyPrice >= 90 
AND buyPrice <= 100;

-- 3 BETWEEN C
-- find the product whose buy price is not between $20 and $100
SELECT productCode, productName, buyPrice
FROM products
WHERE buyPrice NOT BETWEEN 20 AND 100;

-- 3 BETWEEN C
-- find the product whose buy price is not between $20 and $100
SELECT productCode, productName, buyPrice
FROM products
WHERE buyPrice < 20 
OR buyPrice > 100;

-- IS NULL 1
-- find customers who do not have a sales representative
SELECT customerName, country, salesRepEmployeeNumber
FROM customers
WHERE salesRepEmployeeNumber IS NULL;

-- IS NOT NULL 2
-- get the customers who have a sales representative
SELECT customerName, country, salesRepEmployeeNumber
FROM customers
WHERE salesRepEmployeeNumber IS NOT NULL;