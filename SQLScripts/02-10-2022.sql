SELECT c.customerName, c.phone, c.city, c.state
FROM customers c;

SELECT *
FROM customers c;

SELECT COUNT(*)
FROM customers;

SELECT *
FROM customers c
WHERE c.country = 'Germany'
OR c.country = 'USA'
ORDER BY c.country ASC;

SELECT c.customerName, c.addressLine1 AS Address, c.city
FROM customers c
WHERE c.country = 'USA'
AND c.city = 'NYC'
OR c.city = 'Los Angeles'
OR c.city = 'San Francisco';

SELECT c.customerName, c.addressLine1 AS Address, c.city
FROM customers c
WHERE c.country = 'USA'
AND c.city IN ('NYC', 'Los Angeles', 'San Francisco');

SELECT DISTINCT c.postalCode
FROM customers c;