DROP DATABASE libdb;

CREATE DATABASE libdb;

USE libdb;

CREATE TABLE authors (
	authorid INT(5) PRIMARY KEY AUTO_INCREMENT,
	authorname VARCHAR(100) NOT NULL
);

INSERT INTO authors (authorname)
VALUES 
('AFN1 ALN1'),
('AFN2 ALN2'),
('AFN3 ALN3'),
('AFN4 ALN4'),
('AFN5 ALN5');

CREATE TABLE categories (
	categoryid INT(5) PRIMARY KEY AUTO_INCREMENT,
	categoryname VARCHAR(100) NOT NULL
);

INSERT INTO categories (categoryname)
VALUES 
('Mystery'),
('Science Fiction'),
('Politics'),
('Economics'),
('Cookery');

CREATE TABLE books (
	bookid INT(5) PRIMARY KEY AUTO_INCREMENT,
	bookname VARCHAR(255) NOT NULL,
	bookprice DECIMAL(10, 2) CHECK(bookprice>0),
	authorid INT(5) NOT NULL,
	categoryid INT(5) NOT NULL,
	FOREIGN KEY (authorid) REFERENCES authors(authorid),
	FOREIGN KEY (categoryid) REFERENCES categories(categoryid)
);

INSERT INTO books (bookname, bookprice, authorid, categoryid)
VALUES
('Book Title 1', 24.99, 1, 1),
('Book Title 2', 9.99, 2, 2),
('Book Title 3', 7.99, 3, 3),
('Book Title 4', 55.99, 4, 4),
('Book Title 5', 5.99, 5, 5),
('Book Title 6', 69.99, 1, 1),
('Book Title 7', 10.99, 2, 2),
('Book Title 8', 4.99, 3, 3),
('Book Title 9', 3.99, 4, 4),
('Book Title 10', 49.99, 5, 5),
('Book Title 11', 35.99, 1, 1),
('Book Title 12', 25.99, 2, 2);

CREATE TABLE libusers (
	userid INT(5) PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(100) NOT NULL,
	useremail VARCHAR(100) NOT NULL UNIQUE,
	userphone VARCHAR(15) NOT NULL,
	pwd VARCHAR(100) NOT NULL CHECK(length(pwd) >= 8)
);

INSERT INTO libusers (username, useremail, userphone, pwd)
VALUES 
('LUFN1 LULN1', 'lufnluln1@gmail.com', '111-111-1111', 'aaaaaaaaa'),
('LUFN2 LULN2', 'lufnluln2@gmail.com', '222-222-2222', 'bbbbbbbbb'),
('LUFN3 LULN3', 'lufnluln3@gmail.com', '333-333-3333', 'ccccccccc'),
('LUFN4 LULN4', 'lufnluln4@gmail.com', '444-444-4444', 'ddddddddd'),
('LUFN5 LULN5', 'lufnluln5@gmail.com', '555-555-5555', 'eeeeeeeee');

CREATE TABLE borrowedbooks (
	id INT(10) PRIMARY KEY AUTO_INCREMENT,
	bookid INT(5),
	userid INT(5),
	duedate DATE,
	FOREIGN KEY (bookid) REFERENCES books(bookid) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (userid) REFERENCES libusers(userid) ON DELETE SET NULL ON UPDATE SET NULL
);

INSERT INTO borrowedbooks (bookid, userid, duedate)
VALUES
(1, 1, CURRENT_DATE()),
(2, 2, CURRENT_DATE()),
(3, 3, CURRENT_DATE()),
(4, 4, CURRENT_DATE()),
(5, 5, CURRENT_DATE()),
(6, 1, CURRENT_DATE()),
(7, 2, CURRENT_DATE()),
(8, 3, CURRENT_DATE()),
(9, 4, CURRENT_DATE()),
(10, 5, CURRENT_DATE()),
(11, 1, CURRENT_DATE()),
(12, 2, CURRENT_DATE());

