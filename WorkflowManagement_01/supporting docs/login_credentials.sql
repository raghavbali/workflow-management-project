-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 13, 2013 at 03:52 AM
-- Server version: 5.5.28
-- PHP Version: 5.3.10-1ubuntu3.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `workflow_mgmt_sys`
--

-- --------------------------------------------------------

--
-- Table structure for table `login_credentials`
--

CREATE TABLE IF NOT EXISTS `login_credentials` (
  `user_id` int(5) NOT NULL AUTO_INCREMENT,
  `username` text COLLATE utf8_bin NOT NULL,
  `password` varchar(20) COLLATE utf8_bin NOT NULL,
  `p_id` int(5) NOT NULL,
  `w_id` int(11) NOT NULL,
  `role` set('admin','author','publisher','editor') COLLATE utf8_bin NOT NULL,
  `active_flag` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`user_id`),
  KEY `p_id` (`p_id`),
  KEY `w_id` (`w_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=8 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `login_credentials`
--
ALTER TABLE `login_credentials`
  ADD CONSTRAINT `login_credentials_ibfk_1` FOREIGN KEY (`p_id`) REFERENCES `personal_information` (`p_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `login_credentials_ibfk_2` FOREIGN KEY (`w_id`) REFERENCES `workflow_master` (`w_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
