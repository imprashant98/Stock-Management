-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 22, 2020 at 08:07 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `storemanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `category` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`category`) VALUES
('Computer_Accessories'),
('Computer_Components'),
('Desktop'),
('Drives_and_Storage'),
('Laptop'),
('MacBook'),
('Networking'),
('Printer'),
('Projector');

-- --------------------------------------------------------

--
-- Table structure for table `computer_accessories`
--

CREATE TABLE `computer_accessories` (
  `Company` varchar(40) NOT NULL,
  `ProductName` varchar(100) NOT NULL,
  `Quantity` int(3) NOT NULL,
  `Pricepp` int(7) NOT NULL,
  `dealerid` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `computer_accessories`
--

INSERT INTO `computer_accessories` (`Company`, `ProductName`, `Quantity`, `Pricepp`, `dealerid`) VALUES
('Panasonic', 'Panaroma_42', 3, 100000, 'D101'),
('Sony', 'Bravia_32', 6, 45000, 'D100');

-- --------------------------------------------------------

--
-- Table structure for table `computer_components`
--

CREATE TABLE `computer_components` (
  `Company` varchar(40) NOT NULL,
  `ProductName` varchar(100) NOT NULL,
  `Quantity` int(3) NOT NULL,
  `Pricepp` int(7) NOT NULL,
  `dealerid` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `computer_components`
--

INSERT INTO `computer_components` (`Company`, `ProductName`, `Quantity`, `Pricepp`, `dealerid`) VALUES
('LG', 'Avado_24', 6, 25000, 'D103'),
('Samsung', 'Ultrahd_56', 2, 200000, 'D102');

-- --------------------------------------------------------

--
-- Table structure for table `dealer`
--

CREATE TABLE `dealer` (
  `Dealer_ID` varchar(20) NOT NULL DEFAULT '',
  `Name` varchar(20) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Contact_No` bigint(20) NOT NULL,
  `Tin_No` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dealer`
--

INSERT INTO `dealer` (`Dealer_ID`, `Name`, `Gender`, `Address`, `Contact_No`, `Tin_No`) VALUES
('D100', 'Suresh', 'Male', 'Allahabad', 9632587410, 12365478969),
('D101', 'Mukesh', 'Male', 'Allahabad', 8523697410, 98745632102),
('D102', 'Lokesh', 'Male', 'Allahabad', 7412589630, 25874136960),
('D103', 'Mandakini', 'Female', 'Varanasi', 7896541230, 10000000002);

-- --------------------------------------------------------

--
-- Table structure for table `desktop`
--

CREATE TABLE `desktop` (
  `Company` varchar(40) NOT NULL,
  `ProductName` varchar(100) NOT NULL,
  `Quantity` int(3) NOT NULL,
  `Pricepp` int(7) NOT NULL,
  `dealerid` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `desktop`
--

INSERT INTO `desktop` (`Company`, `ProductName`, `Quantity`, `Pricepp`, `dealerid`) VALUES
('rtyy', 'ds', 12, 2000, 'D100');

-- --------------------------------------------------------

--
-- Table structure for table `drives_and_storage`
--

CREATE TABLE `drives_and_storage` (
  `Company` varchar(40) NOT NULL,
  `ProductName` varchar(100) NOT NULL,
  `Quantity` int(3) NOT NULL,
  `Pricepp` int(7) NOT NULL,
  `dealerid` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `drives_and_storage`
--

INSERT INTO `drives_and_storage` (`Company`, `ProductName`, `Quantity`, `Pricepp`, `dealerid`) VALUES
('Elctrolux', 'Grill_20', 5, 9000, 'D102'),
('LG', 'Convection_22', 2, 16000, 'D100');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `Emp_ID` varchar(10) NOT NULL DEFAULT '',
  `Name` varchar(20) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Contact_No` bigint(20) NOT NULL,
  `Citizenship_No` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`Emp_ID`, `Name`, `Gender`, `Address`, `Contact_No`, `Citizenship_No`) VALUES
('E100', 'Manu', 'Male', 'Naini', 9873214560, 123654789632),
('E101', 'Arun', 'Male', 'Agra', 7896541258, 125478963258),
('E102', 'Vimla', 'Female', 'Lucknow', 7854123658, 147852369321);

-- --------------------------------------------------------

--
-- Table structure for table `laptop`
--

CREATE TABLE `laptop` (
  `Company` varchar(40) DEFAULT NULL,
  `ProductName` varchar(100) DEFAULT NULL,
  `Quantity` int(3) DEFAULT NULL,
  `Pricepp` int(7) DEFAULT NULL,
  `dealerid` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `macbook`
--

CREATE TABLE `macbook` (
  `Company` varchar(40) NOT NULL,
  `ProductName` varchar(100) NOT NULL,
  `Quantity` int(3) NOT NULL,
  `Pricepp` int(7) NOT NULL,
  `dealerid` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `macbook`
--

INSERT INTO `macbook` (`Company`, `ProductName`, `Quantity`, `Pricepp`, `dealerid`) VALUES
('Apple', 'Iphone7', 1, 70000, 'D100'),
('Samsung', 'GalaxyS7', 3, 40000, 'D102');

-- --------------------------------------------------------

--
-- Table structure for table `networking`
--

CREATE TABLE `networking` (
  `Company` varchar(40) NOT NULL,
  `ProductName` varchar(100) NOT NULL,
  `Quantity` int(3) NOT NULL,
  `Pricepp` int(7) NOT NULL,
  `dealerid` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `networking`
--

INSERT INTO `networking` (`Company`, `ProductName`, `Quantity`, `Pricepp`, `dealerid`) VALUES
('Digicom', 'Router', 4, 15000, 'D102'),
('TP link', 'Modem', 3, 7000, 'D100');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `bill_id` varchar(5) NOT NULL DEFAULT '',
  `payment_mode` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`bill_id`, `payment_mode`) VALUES
('B100', 'Card'),
('B101', 'Cheque'),
('B102', 'cash');

-- --------------------------------------------------------

--
-- Table structure for table `printer`
--

CREATE TABLE `printer` (
  `Company` varchar(40) NOT NULL,
  `ProductName` varchar(100) NOT NULL,
  `Quantity` int(3) NOT NULL,
  `Pricepp` int(7) NOT NULL,
  `dealerid` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `printer`
--

INSERT INTO `printer` (`Company`, `ProductName`, `Quantity`, `Pricepp`, `dealerid`) VALUES
('LG', 'Halun_110', 3, 30000, 'D101'),
('Samsung', 'Doubledoor_500', 2, 250000, 'D100');

-- --------------------------------------------------------

--
-- Table structure for table `projector`
--

CREATE TABLE `projector` (
  `Company` varchar(40) NOT NULL,
  `ProductName` varchar(100) NOT NULL,
  `Quantity` int(3) NOT NULL,
  `Pricepp` int(7) NOT NULL,
  `dealerid` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `projector`
--

INSERT INTO `projector` (`Company`, `ProductName`, `Quantity`, `Pricepp`, `dealerid`) VALUES
('IFB', 'Manual_5', 6, 7000, 'D100'),
('Whirlpool', 'Automatic_7', 2, 15000, 'D103');

-- --------------------------------------------------------

--
-- Table structure for table `purchased_item`
--

CREATE TABLE `purchased_item` (
  `Bill_Id` varchar(10) NOT NULL DEFAULT '',
  `Company` varchar(20) NOT NULL,
  `Product` varchar(20) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Price` bigint(20) NOT NULL,
  `Dealer_ID` varchar(20) DEFAULT NULL,
  `date` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `purchased_item`
--

INSERT INTO `purchased_item` (`Bill_Id`, `Company`, `Product`, `Quantity`, `Price`, `Dealer_ID`, `date`) VALUES
('B1000', 'Voltas ', 'Split_2ton', 6, 40000, 'D100', '2017-03-26'),
('B1001', 'Lloyd', 'Window_3ton', 4, 25000, 'D101', '2017-03-27'),
('B1002', 'Sony', 'Bravia_32', 6, 45000, 'D100', '2017-02-28'),
('B1003', 'Panasonic', 'Panaroma_42', 3, 100000, 'D101', '2017-02-22'),
('B1004', 'LG', 'Avado_24', 6, 25000, 'D103', '2017-05-03'),
('B1005', 'Samsung', 'Ultrahd_56', 2, 200000, 'D102', '2017-05-15'),
('B1006', 'LG', 'Convection_22', 2, 16000, 'D100', '2017-03-14'),
('B1007', 'Elctrolux', 'Grill_20', 5, 9000, 'D102', '2017-03-14'),
('B1008', 'Samsung', 'Doubledoor_500', 2, 250000, 'D100', '2017-03-14'),
('B1009', 'LG', 'Halun_110', 3, 30000, 'D101', '2017-02-27'),
('B1010', 'Apple', 'Iphone7', 3, 70000, 'D100', '2017-03-10'),
('B1011', 'Samsung', 'GalaxyS7', 3, 40000, 'D102', '2017-03-10'),
('B1012', 'Whirlpool', 'Automatic_7', 2, 15000, 'D103', '2017-04-05'),
('B1013', 'IFB', 'Manual_5', 6, 7000, 'D100', '2017-04-09'),
('B1014', 'EurekaForbes', 'Aquaguard', 6, 15000, 'D102', '2017-04-03'),
('B1015', 'Kent', 'ManualRO_10', 3, 7000, 'D100', '2017-04-03'),
('B1016', 'rtyy', 'ds', 12, 2000, 'D100', '2017-03-27');

-- --------------------------------------------------------

--
-- Table structure for table `security`
--

CREATE TABLE `security` (
  `Question` varchar(100) DEFAULT NULL,
  `Answer` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `security`
--

INSERT INTO `security` (`Question`, `Answer`) VALUES
('What is the name of your First Dog?', 'Max'),
('Where your Mother was born?', 'Delhi'),
('Which was the first book you read?', 'The Kite Runner');

-- --------------------------------------------------------

--
-- Table structure for table `sold_item`
--

CREATE TABLE `sold_item` (
  `billid` varchar(100) NOT NULL DEFAULT '',
  `Prot` varchar(100) NOT NULL,
  `Pron` varchar(100) NOT NULL,
  `quantity` int(5) NOT NULL,
  `cname` varchar(100) NOT NULL,
  `addr` varchar(100) NOT NULL,
  `pno` varchar(12) NOT NULL,
  `date` varchar(10) NOT NULL,
  `total` int(8) NOT NULL,
  `Empid` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sold_item`
--

INSERT INTO `sold_item` (`billid`, `Prot`, `Pron`, `quantity`, `cname`, `addr`, `pno`, `date`, `total`, `Empid`) VALUES
('B100', 'Smartphones', 'Apple-Iphone7', 1, 'Pushpendra', 'Jaipur', '7418529632', '2017-03-27', 70000, 'E100'),
('B101', 'AirConditioner', 'Lloyd-Window_3ton', 1, 'Suyog', 'Bhilwara', '9630852741', '2017-03-28', 25000, 'E100'),
('B102', 'Smartphones', 'Apple-Iphone7', 1, 'pranjal', 'Allahabad', '4563217895', '2017-03-26', 70000, 'E100');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(40) DEFAULT NULL,
  `Password` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `Password`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `warranty`
--

CREATE TABLE `warranty` (
  `bill_id` varchar(5) NOT NULL DEFAULT '',
  `prdct_name` varchar(40) DEFAULT NULL,
  `owner_name` varchar(40) DEFAULT NULL,
  `date` varchar(10) DEFAULT NULL,
  `warranty` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `warranty`
--

INSERT INTO `warranty` (`bill_id`, `prdct_name`, `owner_name`, `date`, `warranty`) VALUES
('b100', 'Voltas -Split_2ton', 'Pranav', '2017-04-11', 'Return'),
('B102', 'Apple-Iphone7', 'pranjal', '2017-03-26', 'Return');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`category`);

--
-- Indexes for table `computer_accessories`
--
ALTER TABLE `computer_accessories`
  ADD PRIMARY KEY (`Company`,`ProductName`),
  ADD KEY `dealerid` (`dealerid`);

--
-- Indexes for table `computer_components`
--
ALTER TABLE `computer_components`
  ADD PRIMARY KEY (`Company`,`ProductName`),
  ADD KEY `dealerid` (`dealerid`);

--
-- Indexes for table `dealer`
--
ALTER TABLE `dealer`
  ADD PRIMARY KEY (`Dealer_ID`),
  ADD UNIQUE KEY `Tin_No` (`Tin_No`);

--
-- Indexes for table `desktop`
--
ALTER TABLE `desktop`
  ADD PRIMARY KEY (`Company`,`ProductName`),
  ADD KEY `dealerid` (`dealerid`);

--
-- Indexes for table `drives_and_storage`
--
ALTER TABLE `drives_and_storage`
  ADD PRIMARY KEY (`Company`,`ProductName`),
  ADD KEY `dealerid` (`dealerid`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`Emp_ID`),
  ADD UNIQUE KEY `Adhaar_No` (`Citizenship_No`);

--
-- Indexes for table `macbook`
--
ALTER TABLE `macbook`
  ADD PRIMARY KEY (`Company`,`ProductName`),
  ADD KEY `dealerid` (`dealerid`);

--
-- Indexes for table `networking`
--
ALTER TABLE `networking`
  ADD PRIMARY KEY (`Company`,`ProductName`),
  ADD KEY `dealerid` (`dealerid`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`bill_id`);

--
-- Indexes for table `printer`
--
ALTER TABLE `printer`
  ADD PRIMARY KEY (`Company`,`ProductName`),
  ADD KEY `dealerid` (`dealerid`);

--
-- Indexes for table `projector`
--
ALTER TABLE `projector`
  ADD PRIMARY KEY (`Company`,`ProductName`),
  ADD KEY `dealerid` (`dealerid`);

--
-- Indexes for table `purchased_item`
--
ALTER TABLE `purchased_item`
  ADD PRIMARY KEY (`Bill_Id`),
  ADD KEY `Dealer_ID` (`Dealer_ID`);

--
-- Indexes for table `sold_item`
--
ALTER TABLE `sold_item`
  ADD PRIMARY KEY (`billid`),
  ADD KEY `Empid` (`Empid`);

--
-- Indexes for table `warranty`
--
ALTER TABLE `warranty`
  ADD PRIMARY KEY (`bill_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `computer_accessories`
--
ALTER TABLE `computer_accessories`
  ADD CONSTRAINT `computer_accessories_ibfk_1` FOREIGN KEY (`dealerid`) REFERENCES `dealer` (`Dealer_ID`);

--
-- Constraints for table `computer_components`
--
ALTER TABLE `computer_components`
  ADD CONSTRAINT `computer_components_ibfk_1` FOREIGN KEY (`dealerid`) REFERENCES `dealer` (`Dealer_ID`);

--
-- Constraints for table `desktop`
--
ALTER TABLE `desktop`
  ADD CONSTRAINT `desktop_ibfk_1` FOREIGN KEY (`dealerid`) REFERENCES `dealer` (`Dealer_ID`);

--
-- Constraints for table `drives_and_storage`
--
ALTER TABLE `drives_and_storage`
  ADD CONSTRAINT `drives_and_storage_ibfk_1` FOREIGN KEY (`dealerid`) REFERENCES `dealer` (`Dealer_ID`);

--
-- Constraints for table `macbook`
--
ALTER TABLE `macbook`
  ADD CONSTRAINT `macbook_ibfk_1` FOREIGN KEY (`dealerid`) REFERENCES `dealer` (`Dealer_ID`);

--
-- Constraints for table `networking`
--
ALTER TABLE `networking`
  ADD CONSTRAINT `networking_ibfk_1` FOREIGN KEY (`dealerid`) REFERENCES `dealer` (`Dealer_ID`);

--
-- Constraints for table `printer`
--
ALTER TABLE `printer`
  ADD CONSTRAINT `printer_ibfk_1` FOREIGN KEY (`dealerid`) REFERENCES `dealer` (`Dealer_ID`);

--
-- Constraints for table `projector`
--
ALTER TABLE `projector`
  ADD CONSTRAINT `projector_ibfk_1` FOREIGN KEY (`dealerid`) REFERENCES `dealer` (`Dealer_ID`);

--
-- Constraints for table `purchased_item`
--
ALTER TABLE `purchased_item`
  ADD CONSTRAINT `purchased_item_ibfk_1` FOREIGN KEY (`Dealer_ID`) REFERENCES `dealer` (`Dealer_ID`) ON DELETE SET NULL;

--
-- Constraints for table `sold_item`
--
ALTER TABLE `sold_item`
  ADD CONSTRAINT `sold_item_ibfk_1` FOREIGN KEY (`Empid`) REFERENCES `employee` (`Emp_ID`) ON DELETE SET NULL;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
