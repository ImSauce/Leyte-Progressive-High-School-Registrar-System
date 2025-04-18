-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 01, 2024 at 05:43 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lphs5`
--

-- --------------------------------------------------------

--
-- Table structure for table `archive`
--

CREATE TABLE `archive` (
  `fname` varchar(100) NOT NULL,
  `mname` varchar(100) NOT NULL,
  `lname` varchar(100) NOT NULL,
  `sex` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `birthday` varchar(50) NOT NULL,
  `bday` varchar(50) NOT NULL,
  `bmonth` varchar(50) NOT NULL,
  `byear` varchar(50) NOT NULL,
  `contact` varchar(50) NOT NULL,
  `lrn` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL,
  `grade` int(20) NOT NULL,
  `g6` varchar(2) NOT NULL,
  `g10` varchar(2) NOT NULL,
  `g12` varchar(2) NOT NULL,
  `schoolyear` varchar(50) NOT NULL,
  `syear1` varchar(4) NOT NULL,
  `syear2` varchar(50) NOT NULL,
  `tyear` varchar(50) NOT NULL,
  `transferin` varchar(2) NOT NULL,
  `transferout` varchar(2) NOT NULL,
  `archive` varchar(255) NOT NULL,
  `vmasterlist` tinyint(2) NOT NULL,
  `g6year` varchar(50) NOT NULL,
  `g10year` varchar(50) NOT NULL,
  `g12year` varchar(50) NOT NULL,
  `Bcertificate` varchar(2) NOT NULL,
  `sf9` varchar(2) NOT NULL,
  `sf10` varchar(2) NOT NULL,
  `description` varchar(255) NOT NULL,
  `imageName1` text NOT NULL,
  `imageName2` text NOT NULL,
  `imageName3` text NOT NULL,
  `imagePath1` text NOT NULL,
  `imagePath2` text NOT NULL,
  `imagePath3` text NOT NULL,
  `imageFile1` longblob NOT NULL,
  `imageFile2` longblob NOT NULL,
  `imageFile3` longblob NOT NULL,
  `Address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `username`, `password`) VALUES
('1', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `test`
--

CREATE TABLE `test` (
  `fname` varchar(100) NOT NULL,
  `mname` varchar(100) NOT NULL,
  `lname` varchar(100) NOT NULL,
  `sex` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `birthday` varchar(50) NOT NULL,
  `bday` varchar(50) NOT NULL,
  `bmonth` varchar(50) NOT NULL,
  `byear` varchar(50) NOT NULL,
  `contact` varchar(50) NOT NULL,
  `lrn` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL,
  `grade` int(20) NOT NULL,
  `g6` varchar(2) NOT NULL,
  `g10` varchar(2) NOT NULL,
  `g12` varchar(2) NOT NULL,
  `schoolyear` varchar(50) NOT NULL,
  `syear1` varchar(4) NOT NULL,
  `syear2` varchar(50) NOT NULL,
  `tyear` varchar(50) NOT NULL,
  `transferin` varchar(2) NOT NULL,
  `transferout` varchar(2) NOT NULL,
  `archive` varchar(255) NOT NULL,
  `vmasterlist` tinyint(2) NOT NULL,
  `g6year` varchar(50) NOT NULL,
  `g10year` varchar(50) NOT NULL,
  `g12year` varchar(50) NOT NULL,
  `Bcertificate` varchar(2) NOT NULL,
  `sf9` varchar(2) NOT NULL,
  `sf10` varchar(2) NOT NULL,
  `description` varchar(255) NOT NULL,
  `imageName1` text NOT NULL,
  `imageName2` text NOT NULL,
  `imageName3` text NOT NULL,
  `imagePath1` text NOT NULL,
  `imagePath2` text NOT NULL,
  `imagePath3` text NOT NULL,
  `imageFile1` longblob NOT NULL,
  `imageFile2` longblob NOT NULL,
  `imageFile3` longblob NOT NULL,
  `Address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `transferin`
--

CREATE TABLE `transferin` (
  `fname` varchar(100) NOT NULL,
  `mname` varchar(100) NOT NULL,
  `lname` varchar(100) NOT NULL,
  `sex` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `birthday` varchar(50) NOT NULL,
  `bday` varchar(50) NOT NULL,
  `bmonth` varchar(50) NOT NULL,
  `byear` varchar(50) NOT NULL,
  `contact` varchar(50) NOT NULL,
  `lrn` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL,
  `grade` int(20) NOT NULL,
  `g6` varchar(2) NOT NULL,
  `g10` varchar(2) NOT NULL,
  `g12` varchar(2) NOT NULL,
  `schoolyear` varchar(50) NOT NULL,
  `syear1` varchar(4) NOT NULL,
  `syear2` varchar(50) NOT NULL,
  `tyear` varchar(50) NOT NULL,
  `transferin` varchar(2) NOT NULL,
  `transferout` varchar(2) NOT NULL,
  `archive` varchar(255) NOT NULL,
  `vmasterlist` tinyint(2) NOT NULL,
  `g6year` varchar(50) NOT NULL,
  `g10year` varchar(50) NOT NULL,
  `g12year` varchar(50) NOT NULL,
  `Bcertificate` varchar(2) NOT NULL,
  `sf9` varchar(2) NOT NULL,
  `sf10` varchar(2) NOT NULL,
  `description` varchar(255) NOT NULL,
  `imageName1` text NOT NULL,
  `imageName2` text NOT NULL,
  `imageName3` text NOT NULL,
  `imagePath1` text NOT NULL,
  `imagePath2` text NOT NULL,
  `imagePath3` text NOT NULL,
  `imageFile1` longblob NOT NULL,
  `imageFile2` longblob NOT NULL,
  `imageFile3` longblob NOT NULL,
  `Address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `transferout`
--

CREATE TABLE `transferout` (
  `fname` varchar(100) NOT NULL,
  `mname` varchar(100) NOT NULL,
  `lname` varchar(100) NOT NULL,
  `sex` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `birthday` varchar(50) NOT NULL,
  `bday` varchar(50) NOT NULL,
  `bmonth` varchar(50) NOT NULL,
  `byear` varchar(50) NOT NULL,
  `contact` varchar(50) NOT NULL,
  `lrn` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL,
  `grade` int(20) NOT NULL,
  `g6` varchar(2) NOT NULL,
  `g10` varchar(2) NOT NULL,
  `g12` varchar(2) NOT NULL,
  `schoolyear` varchar(50) NOT NULL,
  `syear1` varchar(4) NOT NULL,
  `syear2` varchar(50) NOT NULL,
  `tyear` varchar(50) NOT NULL,
  `transferin` varchar(2) NOT NULL,
  `transferout` varchar(2) NOT NULL,
  `archive` varchar(255) NOT NULL,
  `vmasterlist` tinyint(2) NOT NULL,
  `g6year` varchar(50) NOT NULL,
  `g10year` varchar(50) NOT NULL,
  `g12year` varchar(50) NOT NULL,
  `Bcertificate` varchar(2) NOT NULL,
  `sf9` varchar(2) NOT NULL,
  `sf10` varchar(2) NOT NULL,
  `description` varchar(255) NOT NULL,
  `imageName1` text NOT NULL,
  `imageName2` text NOT NULL,
  `imageName3` text NOT NULL,
  `imagePath1` text NOT NULL,
  `imagePath2` text NOT NULL,
  `imagePath3` text NOT NULL,
  `imageFile1` longblob NOT NULL,
  `imageFile2` longblob NOT NULL,
  `imageFile3` longblob NOT NULL,
  `Address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `archive`
--
ALTER TABLE `archive`
  ADD PRIMARY KEY (`lrn`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `test`
--
ALTER TABLE `test`
  ADD PRIMARY KEY (`lrn`);

--
-- Indexes for table `transferin`
--
ALTER TABLE `transferin`
  ADD PRIMARY KEY (`lrn`);

--
-- Indexes for table `transferout`
--
ALTER TABLE `transferout`
  ADD PRIMARY KEY (`lrn`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
