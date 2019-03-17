-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 17, 2019 at 07:14 PM
-- Server version: 5.7.21
-- PHP Version: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `banqueservlet`
--

-- --------------------------------------------------------

--
-- Table structure for table `money`
--

DROP TABLE IF EXISTS `money`;
CREATE TABLE IF NOT EXISTS `money` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `amount` double NOT NULL DEFAULT '0',
  `at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `mon_fk_userid` (`userid`)
) ENGINE=MyISAM AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `money`
--

INSERT INTO `money` (`id`, `userid`, `amount`, `at`) VALUES
(1, 1, 15, '2019-03-17 15:31:47'),
(2, 1, -6, '2019-03-17 15:31:57'),
(3, 1, 155, '2019-03-17 15:32:04'),
(4, 0, 75, '2019-03-17 17:13:16'),
(5, 0, 52, '2019-03-17 17:13:18'),
(6, 0, 21, '2019-03-17 17:14:00'),
(7, 1, 46, '2019-03-17 17:14:51'),
(8, 1, 85, '2019-03-17 17:14:53'),
(9, 1, 64, '2019-03-17 17:14:55'),
(10, 1, 82, '2019-03-17 17:20:34'),
(11, 1, 67, '2019-03-17 17:20:36'),
(12, 1, 75, '2019-03-17 17:20:38'),
(13, 1, -37, '2019-03-17 17:21:21'),
(14, 1, -6, '2019-03-17 17:21:23'),
(15, 1, 31, '2019-03-17 17:21:45'),
(16, 1, -36, '2019-03-17 17:21:47'),
(17, 1, -8, '2019-03-17 17:21:48'),
(18, 1, -30, '2019-03-17 17:21:49'),
(19, 1, 63, '2019-03-17 17:21:54'),
(20, 1, -70, '2019-03-17 17:35:01'),
(21, 1, -86, '2019-03-17 17:35:01'),
(22, 1, -97, '2019-03-17 17:35:02'),
(23, 1, 80, '2019-03-17 17:35:03'),
(24, 1, 41, '2019-03-17 17:35:04'),
(25, 1, -76, '2019-03-17 17:46:48'),
(26, 1, -32, '2019-03-17 18:07:48'),
(27, 1, 96, '2019-03-17 18:07:50'),
(28, 1, -19, '2019-03-17 18:25:14'),
(29, 1, -66, '2019-03-17 18:25:17'),
(30, 1, 14, '2019-03-17 18:25:18'),
(31, 1, -39, '2019-03-17 18:29:56'),
(32, 1, 93, '2019-03-17 18:56:08');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(32) DEFAULT NULL,
  `prenom` varchar(32) DEFAULT NULL,
  `email` varchar(42) NOT NULL,
  `password` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `nom`, `prenom`, `email`, `password`) VALUES
(1, 'Aguerram', 'Mostafa', 'agurram@live.fr', '123');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
