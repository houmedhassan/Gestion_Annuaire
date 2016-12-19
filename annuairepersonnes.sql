-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 19, 2016 at 09:07 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `annuairepersonnes`
--

-- --------------------------------------------------------

--
-- Table structure for table `groups`
--

CREATE TABLE IF NOT EXISTS `groups` (
  `idgroup` int(11) NOT NULL,
  `nameGroup` varchar(50) NOT NULL,
  PRIMARY KEY (`idgroup`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `groups`
--

INSERT INTO `groups` (`idgroup`, `nameGroup`) VALUES
(1, 'ISL'),
(2, 'FSI');

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE IF NOT EXISTS `person` (
  `idPerson` int(10) NOT NULL AUTO_INCREMENT,
  `lastName` varchar(50) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `mail` varchar(100) NOT NULL,
  `webSite` text NOT NULL,
  `birthDay` varchar(10) NOT NULL,
  `password` varchar(50) NOT NULL,
  `idGroup` int(10) NOT NULL,
  PRIMARY KEY (`idPerson`),
  KEY `idGroup` (`idGroup`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1234567812 ;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`idPerson`, `lastName`, `firstName`, `mail`, `webSite`, `birthDay`, `password`, `idGroup`) VALUES
(1234567809, 'HAMOUD MANLID', 'Abdoulrahim', 'abdoulrahiim@gmail.com', 'page.person.abdoulrahim-hamoud-manlid.univ-amu', '1992-15-05', '79ee74ffddead5a3eae24091add4e8210bbb99f7', 1),
(1234567810, 'HASSAN MOHAMED', 'Houmed', 'houmedhassan20@gmail.com', 'page.person.houmed-HassanMohamed.com', '1991-31-10', 'a0ef1f937e927dfca918205332983dd7d5e5a39f', 1),
(1234567811, 'NASSEH', 'Mohamed-Amine', 'amineeh-n@gmail.com', 'page.person.amiineh-Nasseh.univ-amu', '2016-10-31', 'e6bdfbc59f4d6d51df96a60879010005176eb64d', 1);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `person`
--
ALTER TABLE `person`
  ADD CONSTRAINT `person_ibfk_1` FOREIGN KEY (`idGroup`) REFERENCES `groups` (`idgroup`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
