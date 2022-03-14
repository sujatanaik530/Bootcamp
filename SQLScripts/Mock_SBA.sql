CREATE database IF NOT EXISTS mock_sba;
USE mock_sba;
SET foreign_key_checks = 0;
CREATE TABLE USERS (
USER_ID INT(5) PRIMARY KEY,
FIRST_NAME VARCHAR(30),
LAST_NAME VARCHAR(30),
CITY VARCHAR(60)
);
CREATE TABLE STORES (
STORE_ID INT(5) PRIMARY KEY,
NAME VARCHAR(100),
CITY VARCHAR(60),
SALES_TAX_RATE DECIMAL(6,5)
);
CREATE TABLE ITEMS (
ITEM_ID INTEGER PRIMARY KEY,
NAME VARCHAR(30),
PRICE DECIMAL(5,2)
);
CREATE TABLE ORDERS (
ORDER_ID INT(5) PRIMARY KEY,
USER_ID INT(5),
STORE_ID INT(5),
CONSTRAINT FK_UserID FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID),
CONSTRAINT FK_StoreID FOREIGN KEY (STORE_ID) REFERENCES STORES(STORE_ID)
);
CREATE TABLE ORDER_ITEMS (
ORDER_ID INT(5),
ITEM_ID INT(5),
QUANTITY INT(5),
CONSTRAINT PK_Order_Items PRIMARY KEY (ORDER_ID, ITEM_ID),
CONSTRAINT FK_OrderID FOREIGN KEY (ORDER_ID) REFERENCES ORDERS(ORDER_ID),
CONSTRAINT FK_ItemID FOREIGN KEY (ITEM_ID) REFERENCES ITEMS(ITEM_ID)
);
INSERT INTO USERS VALUES (1, 'Lucien', 'Arnolfi', 'New York');
INSERT INTO USERS VALUES (2, 'Susila', 'Foster', 'Stamford');
INSERT INTO USERS VALUES (3, 'Marion', 'Cole', 'New York');
INSERT INTO USERS VALUES (4, 'Edna', 'Kay', 'New York');
INSERT INTO USERS VALUES (5, 'Meridith', 'Stefanov', 'Stamford');
INSERT INTO USERS VALUES (6, 'Mike', 'G', 'New York');
INSERT INTO STORES VALUES (1, 'Bronx Location', 'New York', 0.08875);
INSERT INTO STORES VALUES (2, 'Financial District', 'New York', 0.08875);
INSERT INTO STORES VALUES (3, 'Harlem Location', 'New York', 0.08875);
INSERT INTO STORES VALUES (4, 'North Stamford Location', 'Stamford', 0.0635);
INSERT INTO STORES VALUES (5, 'South Stamford Location', 'Stamford', 0.0635);
INSERT INTO ITEMS VALUES (1,'Hotdog',1.35);
INSERT INTO ITEMS VALUES (2,'Hamburger', 2.00);
INSERT INTO ITEMS VALUES (3,'Cheeseburger',2.50);
INSERT INTO ITEMS VALUES (4,'Fries',1.00);
INSERT INTO ITEMS VALUES (5,'Soda',1.00);
INSERT INTO ORDERS VALUES(1,1,1);
INSERT INTO ORDERS VALUES(2,3,1);
INSERT INTO ORDERS VALUES(3,3,3);
INSERT INTO ORDERS VALUES(4,2,5);
INSERT INTO ORDERS VALUES(5,4,1);
INSERT INTO ORDERS VALUES(6,5,5);
INSERT INTO ORDERS VALUES(7,1,2);
INSERT INTO ORDERS VALUES(8,5,4);
INSERT INTO ORDER_ITEMS VALUES(1,1,2);
INSERT INTO ORDER_ITEMS VALUES(1,4,1);
INSERT INTO ORDER_ITEMS VALUES(1,5,1);
INSERT INTO ORDER_ITEMS VALUES(2,3,1);
INSERT INTO ORDER_ITEMS VALUES(2,5,1);
INSERT INTO ORDER_ITEMS VALUES(3,4,8);
INSERT INTO ORDER_ITEMS VALUES(4,3,1);
INSERT INTO ORDER_ITEMS VALUES(4,4,1);
INSERT INTO ORDER_ITEMS VALUES(5,5,1);
INSERT INTO ORDER_ITEMS VALUES(6,1,2);
INSERT INTO ORDER_ITEMS VALUES(7,1,2);
INSERT INTO ORDER_ITEMS VALUES(8,1,2);
SET foreign_key_checks = 1;

-- the queries

-- 1 Create a query to return all orders made by users with the first name of “Marion” 

SELECT o.ORDER_ID, o.USER_ID, o.STORE_ID
FROM users u INNER JOIN orders o ON (u.USER_ID=o.USER_ID)
WHERE u.FIRST_NAME = 'Marion';

-- 2 Create a query to select all users that have not made an order 

SELECT u.USER_ID, u.FIRST_NAME, u.LAST_NAME, u.CITY
FROM users u 
WHERE u.USER_ID NOT IN (
									SELECT DISTINCT o.user_id
									FROM orders o
								);

-- 3 Create a Query to select the names and prices of all items that have been part of 2 or 
-- more separate orders.

SELECT i.NAME, i.PRICE
FROM items i INNER JOIN order_items oi ON (i.ITEM_ID = oi.ITEM_ID)
GROUP BY i.NAME, i.PRICE
HAVING COUNT(oi.ORDER_ID) >= 2;

-- 4 Create a query to return the Order Id, Item name, Item Price, and Quantity from orders 
-- made at stores in the city “New York”. Order by Order Id in ascending order. 

SELECT o.ORDER_ID, i.NAME, i.PRICE, oi.QUANTITY
FROM items i INNER JOIN order_items oi ON (i.item_id = oi.ITEM_ID)
					INNER JOIN orders o ON oi.ORDER_ID = o.ORDER_ID
					INNER JOIN stores s ON s.STORE_ID = o.STORE_ID
WHERE s.CITY = 'New York'
ORDER BY o.ORDER_ID ASC;

-- 5 Your boss would like you to create a query that calculates the total revenue generated 
-- by each item. Revenue for an item can be found as (Item Price * Total Quantity 
-- Ordered). Please return the first column as ‘ITEM_NAME’ and the second column as 
-- ‘REVENUE’. 

SELECT i.NAME AS ITEM_NAME, sum(oi.QUANTITY * i.PRICE) AS REVENUE
FROM items i INNER JOIN order_items oi ON (i.ITEM_ID = oi.ITEM_ID)
GROUP BY i.NAME;

-- 6 Create a query with the following output: 
-- a. Column 1 - Store Name 
--    i. The name of each store 
-- b. COLUMN 2 - Order Quantity 
--    i. The number of times an order has been made in this store 
-- c. Column 3 - Sales Figure 
--    i. If the store has been involved in more than 3 orders, mark as ‘High’ 
--    ii. If the store has been involved in less than 3 orders but more than 1 order, mark as ‘Medium’ 
--    iii. If the store has been involved with 1 or less orders, mark as ‘Low’ 
-- d. Should be ordered by the Order Quantity in Descending Order 
 
SELECT s.NAME AS Store_Name, 
		count(o.ORDER_ID) AS Order_Quantity, 
		case
			when count(o.ORDER_ID) > 3 then 'High'
			when (count(o.ORDER_ID) > 1) AND (count(o.ORDER_ID) <= 3) then 'Medium'
			when count(o.ORDER_ID) <= 1 then 'Low'
		END AS Sales_Figure
FROM stores s LEFT JOIN orders o ON s.STORE_ID = o.STORE_ID
GROUP BY s.name
ORDER BY Order_Quantity desc;
