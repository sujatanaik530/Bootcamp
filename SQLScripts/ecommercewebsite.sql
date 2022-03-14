/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

DROP DATABASE IF EXISTS `ecommercewebsite`;
CREATE DATABASE IF NOT EXISTS `ecommercewebsite` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `ecommercewebsite`;

DROP TABLE IF EXISTS `customers`;
CREATE TABLE IF NOT EXISTS `customers` (
  `customerId` int(255) NOT NULL AUTO_INCREMENT,
  `customerName` varchar(25) DEFAULT NULL,
  `customerEmail` varchar(100) DEFAULT NULL,
  `customerAddress` varchar(255) DEFAULT NULL,
  `ManagerID` int(111) DEFAULT NULL,
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` (`customerId`, `customerName`, `customerEmail`, `customerAddress`, `ManagerID`) VALUES
	(1, 'Jenny', 'j@gmail.com', '25st', 0),
	(2, 'john', 'kk@g.com', '65 strrrt', 1),
	(3, 'Adam', 'ad@f.com', '85st', 1),
	(4, 'khalda', 'kh@fs.com', '86st', 1),
	(5, 'Jose', 'ki@ff.com', '41st', 2);
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;

DROP TABLE IF EXISTS `department`;
CREATE TABLE IF NOT EXISTS `department` (
  `depid` int(22) NOT NULL AUTO_INCREMENT,
  `dname` varchar(20) NOT NULL DEFAULT 'NAME is pending',
  `dzipcode` int(10) DEFAULT NULL,
  `dareacode` int(10) DEFAULT NULL,
  `daddress` varchar(50) DEFAULT NULL,
  `depcode` int(22) DEFAULT NULL,
  `depMini_wage` decimal(10,2) DEFAULT NULL CHECK (`depMini_wage` >= 15),
  `depStatus` enum('Active','deActive','onHold') DEFAULT NULL,
  PRIMARY KEY (`depid`),
  UNIQUE KEY `dname` (`dname`),
  UNIQUE KEY `daddress` (`daddress`),
  UNIQUE KEY `dzipcode` (`dzipcode`,`dareacode`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` (`depid`, `dname`, `dzipcode`, `dareacode`, `daddress`, `depcode`, `depMini_wage`, `depStatus`) VALUES
	(1, 'NAME is pending', 3535, 45, '44', 44, 16.00, 'deActive'),
	(3, 'HR', 3535, 345, '344', 434, 136.00, 'Active');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;

DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `Oid` int(111) NOT NULL AUTO_INCREMENT,
  `order_date` date DEFAULT NULL,
  `customerID` int(111) DEFAULT NULL,
  `quantity` int(225) DEFAULT NULL,
  `Last_UpdateDate` date DEFAULT NULL,
  `supplier_id` int(111) DEFAULT NULL,
  `product_id` int(111) DEFAULT NULL,
  PRIMARY KEY (`Oid`),
  KEY `customerID` (`customerID`),
  KEY `supplier_id` (`supplier_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`customerID`) REFERENCES `customers` (`customerId`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`sup_id`),
  CONSTRAINT `orders_ibfk_3` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` (`Oid`, `order_date`, `customerID`, `quantity`, `Last_UpdateDate`, `supplier_id`, `product_id`) VALUES
	(1, '2022-02-15', 1, 2, '2022-02-15', 4, 3),
	(2, '2022-02-15', 2, 33, '2022-02-15', 4, 3),
	(3, '2022-02-15', 3, 4545, '2022-02-15', 5, NULL),
	(4, '2022-02-15', NULL, 569, '2022-02-15', NULL, NULL),
	(5, '2022-02-15', 3, NULL, NULL, NULL, NULL),
	(6, '2022-02-15', NULL, NULL, NULL, NULL, NULL),
	(7, NULL, NULL, NULL, NULL, NULL, 2),
	(8, '2022-02-15', 1, NULL, NULL, NULL, 2),
	(9, NULL, NULL, NULL, NULL, NULL, 1),
	(10, NULL, NULL, NULL, NULL, 4, 3);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;

DROP TABLE IF EXISTS `payments`;
CREATE TABLE IF NOT EXISTS `payments` (
  `customerNumber` int(11) DEFAULT NULL,
  `checkNumber` varchar(255) DEFAULT NULL,
  `paymentDate` date DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `product_id` int(111) NOT NULL AUTO_INCREMENT,
  `supplier_id` int(111) DEFAULT NULL,
  `product_name` varchar(225) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `supplier_id` (`supplier_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`sup_id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`product_id`, `supplier_id`, `product_name`, `price`) VALUES
	(1, NULL, 'Laptop HP', 1000),
	(2, NULL, 'Blue Laptop', 12000),
	(3, 4, 'motorola G6', 100),
	(4, 4, 'motorolla G7', 120),
	(5, 5, 'Gaming machine One', 57412),
	(6, 5, 'Tando', 47852369),
	(7, 5, 'Atari', 5474);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

DROP TABLE IF EXISTS `supplier`;
CREATE TABLE IF NOT EXISTS `supplier` (
  `sup_id` int(11) NOT NULL AUTO_INCREMENT,
  `sup_name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`sup_id`),
  UNIQUE KEY `sup_name` (`sup_name`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` (`sup_id`, `sup_name`, `email`, `phone`) VALUES
	(4, 'Best Buy', 'by@f.com', 147852),
	(5, 'GameStop', 'GA@G.com', 587412),
	(6, 'Walmart', 'wa@gmailo.com', 7596);
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
