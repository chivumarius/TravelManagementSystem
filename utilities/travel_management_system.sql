-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 21, 2024 at 12:03 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `travel_management_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `username` varchar(30) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `question` varchar(100) DEFAULT NULL,
  `answer` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`username`, `name`, `password`, `question`, `answer`) VALUES
('user1', 'Name1', '123456', 'Your NickName?', 'user1'),
('user2', 'User2', '123456', 'Your Lucky Number?', '17');

-- --------------------------------------------------------

--
-- Table structure for table `bookhotel`
--

CREATE TABLE `bookhotel` (
  `username` varchar(30) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `persons` varchar(20) DEFAULT NULL,
  `days` varchar(20) DEFAULT NULL,
  `air_conditioned` varchar(20) DEFAULT NULL,
  `food` varchar(10) DEFAULT NULL,
  `id` varchar(30) DEFAULT NULL,
  `number` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `cost` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `bookhotel`
--

INSERT INTO `bookhotel` (`username`, `name`, `persons`, `days`, `air_conditioned`, `food`, `id`, `number`, `phone`, `cost`) VALUES
('user1', 'Hotel1', '1', '2', 'Air Conditioned', 'Yes', 'Identity Card', '0600415363524', '+4073300222', '432 Euro');

-- --------------------------------------------------------

--
-- Table structure for table `bookpackage`
--

CREATE TABLE `bookpackage` (
  `username` varchar(30) DEFAULT NULL,
  `package` varchar(40) DEFAULT NULL,
  `persons` varchar(20) DEFAULT NULL,
  `id` varchar(30) DEFAULT NULL,
  `number` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `price` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `bookpackage`
--

INSERT INTO `bookpackage` (`username`, `package`, `persons`, `id`, `number`, `phone`, `price`) VALUES
('user1', 'Gold Package', '1', 'Identity Card', '0600415363524', '+4073300222', '135 Euro');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `username` varchar(30) DEFAULT NULL,
  `id_type` varchar(20) DEFAULT NULL,
  `number` varchar(20) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `gender` varchar(15) DEFAULT NULL,
  `country` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`username`, `id_type`, `number`, `name`, `gender`, `country`, `address`, `phone`, `email`) VALUES
('customer1', 'Identity Card', '1950509546524', 'Name1', 'Male', 'Roamania', 'Address1', '+40722123456', 'customer1@gmail.com'),
('customer2', 'Passport', '123456789123456', 'Name1', 'Male', 'Romania', 'Address2', '+40755123123', 'customer2@gmail.com'),
('customer3', 'Passport', '1234567891345 ', 'Customer3', 'Female', 'Romania', 'Address3', '40711111111', 'customer3@gmail.com  '),
('Customer4', 'Voter Id', '12345678912345', 'Name5', 'Male', 'Romania', 'Address4', '+407012123123', 'customer4@gmail.com  '),
('Customer5', 'Identity Card', '1781020463515', 'Name5', 'Male', 'Romania', 'Address5', '0040799123456', 'customer5@yahoo.com'),
('user1', 'Identity Card', '0600415363524', 'Name1', 'Male', 'Romania', 'Address7', '+4073300222', 'user1@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `hotels`
--

CREATE TABLE `hotels` (
  `name` varchar(30) DEFAULT NULL,
  `cost_per_day` varchar(20) DEFAULT NULL,
  `food_charges` varchar(20) DEFAULT NULL,
  `air_conditioned` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hotels`
--

INSERT INTO `hotels` (`name`, `cost_per_day`, `food_charges`, `air_conditioned`) VALUES
('Hotel1', '170', '29', '17'),
('Hotel2', '165', '17', '17'),
('Hotel3', '266', '20', '13'),
('Hotel4', '78', '13', '13'),
('Hotel5', '299', '17', '10'),
('Hotel6', '208', '22', '12'),
('Hotel7', '180', '12', '12'),
('Hotel8', '97', '13', '11'),
('Hotel9', '295', '12', '9'),
('Hotel10', '324', '23', '16'),
('Hotel11', '256', '16', '15'),
('Hotel12', '182', '30', '17'),
('Hotel13', '312', '25', '9'),
('Hotel14', '130', '21', '8'),
('Hotel15', '73', '22', '19'),
('Hotel16', '71', '20', '13'),
('Hotel17', '170', '12', '12'),
('Hotel18', '284', '22', '18'),
('Hotel19', '267', '29', '15'),
('Hotel20', '335', '14', '9'),
('Hotel21', '241', '25', '20'),
('Hotel22', '347', '30', '7'),
('Hotel23', '186', '30', '16'),
('Hotel24', '85', '27', '6'),
('Hotel25', '95', '22', '18'),
('Hotel26', '141', '23', '14'),
('Hotel27', '322', '21', '8'),
('Hotel28', '77', '22', '19'),
('Hotel29', '344', '18', '6'),
('Hotel30', '229', '12', '17'),
('Hotel31', '212', '19', '17'),
('Hotel32', '287', '29', '11'),
('Hotel33', '274', '21', '14'),
('Hotel34', '235', '20', '17'),
('Hotel35', '242', '27', '12'),
('Hotel36', '274', '18', '17'),
('Hotel37', '190', '20', '9'),
('Hotel38', '320', '22', '11'),
('Hotel39', '136', '22', '9'),
('Hotel40', '315', '19', '15'),
('Hotel41', '162', '16', '13'),
('Hotel42', '321', '27', '14'),
('Hotel43', '290', '16', '9'),
('Hotel44', '144', '11', '12'),
('Hotel45', '200', '18', '14'),
('Hotel46', '245', '21', '18'),
('Hotel47', '79', '16', '9'),
('Hotel48', '304', '22', '15'),
('Hotel49', '323', '29', '7'),
('Hotel50', '300', '14', '14');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
