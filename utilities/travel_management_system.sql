-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 12:55 PM
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
  `answare` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `bookhotel`
--

CREATE TABLE `bookhotel` (
  `username` varchar(30) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `persons` varchar(20) DEFAULT NULL,
  `days` varchar(20) DEFAULT NULL,
  `air_conditioned` varchar(10) DEFAULT NULL,
  `food` varchar(10) DEFAULT NULL,
  `id` varchar(30) DEFAULT NULL,
  `number` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `cost` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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

-- --------------------------------------------------------

--
-- Table structure for table `hotels`
--

CREATE TABLE `hotels` (
  `name` varchar(30) DEFAULT NULL,
  `cost_per_day` varchar(20) DEFAULT NULL,
  `food_charges` varchar(20) DEFAULT NULL,
  `air_conditioned_charges` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hotels`
--

INSERT INTO `hotels` (`name`, `cost_per_day`, `food_charges`, `air_conditioned_charges`) VALUES
('Hotel1', '298', '29', '6'),
('Hotel2', '142', '15', '14'),
('Hotel3', '385', '25', '8'),
('Hotel4', '326', '12', '13'),
('Hotel5', '397', '16', '17'),
('Hotel6', '221', '16', '8'),
('Hotel7', '286', '24', '17'),
('Hotel8', '154', '20', '19'),
('Hotel9', '355', '27', '5'),
('Hotel10', '192', '14', '6'),
('Hotel11', '262', '29', '8'),
('Hotel12', '339', '14', '19'),
('Hotel13', '199', '28', '14'),
('Hotel14', '220', '26', '16'),
('Hotel15', '144', '15', '15'),
('Hotel16', '425', '29', '6'),
('Hotel17', '230', '19', '20'),
('Hotel18', '163', '25', '7'),
('Hotel19', '124', '13', '8'),
('Hotel20', '74', '21', '18'),
('Hotel21', '113', '25', '12'),
('Hotel22', '273', '22', '12'),
('Hotel23', '356', '21', '11'),
('Hotel24', '146', '18', '10'),
('Hotel25', '437', '11', '12'),
('Hotel26', '206', '21', '16'),
('Hotel27', '274', '24', '19'),
('Hotel28', '225', '27', '20'),
('Hotel29', '306', '12', '16'),
('Hotel30', '162', '28', '15'),
('Hotel31', '357', '12', '7'),
('Hotel32', '251', '27', '18'),
('Hotel33', '73', '23', '10'),
('Hotel34', '215', '22', '17'),
('Hotel35', '246', '12', '20'),
('Hotel36', '226', '12', '10'),
('Hotel37', '114', '14', '14'),
('Hotel38', '416', '13', '5'),
('Hotel39', '449', '26', '19'),
('Hotel40', '328', '20', '12'),
('Hotel41', '230', '13', '11'),
('Hotel42', '192', '18', '5'),
('Hotel43', '374', '29', '9'),
('Hotel44', '245', '28', '6'),
('Hotel45', '403', '24', '18'),
('Hotel46', '317', '15', '10'),
('Hotel47', '111', '14', '17'),
('Hotel48', '341', '22', '18'),
('Hotel49', '192', '22', '7'),
('Hotel50', '182', '25', '19');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
