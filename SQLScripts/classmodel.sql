-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.5.9-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for demodb
USE `classicmodels`;

-- Dumping structure for table demodb.customers
CREATE TABLE IF NOT EXISTS `customers` (
  `CustomerId` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) DEFAULT NULL,
  `dob` date DEFAULT '0000-00-00',
  `EmployeeId` int(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT 'abcs@xyz.com',
  `country` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `creditLimit` double DEFAULT NULL,
  PRIMARY KEY (`CustomerId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- Dumping data for table demodb.customers: ~11 rows (approximately)
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` (`CustomerId`, `Name`, `dob`, `EmployeeId`, `email`, `country`, `status`, `creditLimit`) VALUES
	(1, 'yasir', '2021-03-21', 1, 'haseeb@gmail.com', 'USA', 'Deactive', 2000),
	(2, 'yasir', '2021-03-22', 2, 'haseeb@gmail.com', 'UK', 'Deactive', 2000),
	(3, 'Kamel', '2021-03-23', 2, NULL, 'UK', NULL, NULL),
	(4, 'ALex', '2021-03-24', 2, 'alex@gmail.com', 'USA', 'Active', 2000),
	(5, NULL, '0000-00-00', NULL, 'j@gma.com', 'USA', 'Active', 5000),
	(6, 'ALex', '0000-00-00', NULL, 'ALex@gmail.com', 'USA', 'Active', 5000),
	(7, 'Jack', '0000-00-00', NULL, 'j@gma.com', 'USA', 'Active', 5000),
	(8, 'Haseeb', '0000-00-00', NULL, 'haseeb@gmail.com', NULL, 'Active', NULL),
	(9, 'binu Thankachan', '0000-00-00', NULL, 'binu@gmail.com', NULL, 'Active', 1000),
	(10, 'Drew Parsons', '0000-00-00', NULL, 'Drew@gmail.com', 'Germany', 'Active', NULL),
	(11, 'Drew Parsons', '0000-00-00', NULL, 'Drew@gmail.com', NULL, 'Active', 200),
	(12, 'Derrick', '0000-00-00', NULL, 'Derrick@gmail.com', NULL, 'Active', NULL),
	(13, 'Derrick', '0000-00-00', NULL, 'Derrick@gmail.com', 'Canada', 'Active', NULL);
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;

-- Dumping structure for table demodb.department
CREATE TABLE IF NOT EXISTS `department` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `Column 2` int(11) NOT NULL DEFAULT 0,
  `dname` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dumping data for table demodb.department: ~0 rows (approximately)
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
/*!40000 ALTER TABLE `department` ENABLE KEYS */;

-- Dumping structure for table demodb.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `EmployeeId` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `ManagerId` int(11) DEFAULT NULL,
  `Title` varchar(10) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `salary` int(11) DEFAULT 2000,
  `department` varchar(50) DEFAULT 'Account',
  PRIMARY KEY (`EmployeeId`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

-- Dumping data for table demodb.employee: ~7 rows (approximately)
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`EmployeeId`, `Name`, `ManagerId`, `Title`, `dob`, `salary`, `department`) VALUES
	(2, 'Muhammad haseeb', 1, 'VP', '2021-04-20', 3000, 'IT'),
	(20, 'Dreq Parsons', 2, 'Admin', '2021-01-01', 100000, 'IT'),
	(21, 'Dreq Parsons', 2, 'Admin', '2021-01-01', 100000, 'IT'),
	(22, 'jenny', 2, 'VP', '2000-01-01', 1000000, 'IT'),
	(23, 'haseeb', 2, 'manager', '1898-10-02', 1004, 'Account'),
	(24, 'TekEmployee', 6, 'Developer', '1989-01-01', 1000, 'HR'),
	(25, 'HAseeb', 6, 'Developer', '1989-01-01', 1000, 'HR'),
	(26, 'TekEmployee', 6, 'Developer', '1989-01-01', 1000, 'HR'),
	(27, 'TekEmployee', 6, 'Developer', '1989-01-01', 1000, 'HR'),
	(28, 'TekEmployee', 6, 'Developer', '1989-01-01', 1000, 'HR'),
	(29, 'TekEmployee', 6, 'Developer', '1989-01-01', 1000, 'HR');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;

-- Dumping structure for procedure demodb.filter_by_productCode
DELIMITER //
CREATE PROCEDURE `filter_by_productCode`(IN P_CODE VARCHAR(50))
BEGIN
 SELECT * FROM products WHERE productCode=P_CODE;
 
END//
DELIMITER ;

-- Dumping structure for procedure demodb.get_order_by_cust
DELIMITER //
CREATE PROCEDURE `get_order_by_cust`()
BEGIN
SELECT * FROM customers;
END//
DELIMITER ;

-- Dumping structure for table demodb.orders
CREATE TABLE IF NOT EXISTS `orders` (
  `OrderId` int(10) NOT NULL AUTO_INCREMENT,
  `CustomerId` int(10) DEFAULT NULL,
  `quantity` int(10) DEFAULT NULL,
  `OrderDate` datetime DEFAULT NULL,
  `supplier_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`OrderId`)
) ENGINE=InnoDB AUTO_INCREMENT=500128 DEFAULT CHARSET=latin1;

-- Dumping data for table demodb.orders: ~6 rows (approximately)
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` (`OrderId`, `CustomerId`, `quantity`, `OrderDate`, `supplier_id`) VALUES
	(100, 1, 5, '2021-03-23 00:00:00', 1),
	(200, 4, 10, '2021-03-23 00:00:00', NULL),
	(300, 3, 20, '2021-03-23 00:00:00', NULL),
	(400, 1, 10, '2021-03-23 00:00:00', 10000),
	(500, NULL, NULL, NULL, 10002),
	(600, NULL, 6, NULL, NULL);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;

-- Dumping structure for table demodb.suppliers
CREATE TABLE IF NOT EXISTS `suppliers` (
  `supplier_id` int(11) DEFAULT NULL,
  `supplier_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table demodb.suppliers: ~5 rows (approximately)
/*!40000 ALTER TABLE `suppliers` DISABLE KEYS */;
INSERT INTO `suppliers` (`supplier_id`, `supplier_name`) VALUES
	(10000, 'IBM'),
	(10002, 'Hewlett Packard'),
	(10001, 'Microsoft'),
	(10003, 'NVIDIA'),
	(1, 'Haseeb');
/*!40000 ALTER TABLE `suppliers` ENABLE KEYS */;

-- Dumping structure for table demodb.teacher
CREATE TABLE IF NOT EXISTS `teacher` (
  `eid` int(11) NOT NULL AUTO_INCREMENT,
  `salary` varchar(50) NOT NULL DEFAULT '0',
  `ename` varchar(50) DEFAULT NULL,
  `did` int(11) DEFAULT NULL,
  PRIMARY KEY (`eid`),
  KEY `FK_teacher_did` (`did`),
  CONSTRAINT `FK_teacher_did` FOREIGN KEY (`did`) REFERENCES `department` (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table demodb.teacher: ~0 rows (approximately)
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
