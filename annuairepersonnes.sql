-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Lun 21 Novembre 2016 à 20:36
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `annuairepersonnes`
--

-- --------------------------------------------------------

--
-- Structure de la table `groups`
--

CREATE TABLE `groups` (
  `idGroup` varchar(10) NOT NULL,
  `nameGroup` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `groups`
--

INSERT INTO `groups` (`idGroup`, `nameGroup`) VALUES
('1', 'isl'),
('2', 'fsi');

-- --------------------------------------------------------

--
-- Structure de la table `person`
--

CREATE TABLE `person` (
  `idPerson` varchar(10) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `mail` varchar(100) NOT NULL,
  `webSite` text NOT NULL,
  `birthDay` date NOT NULL,
  `password` varchar(50) NOT NULL,
  `idGroup` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `person`
--

INSERT INTO `person` (`idPerson`, `lastName`, `firstName`, `mail`, `webSite`, `birthDay`, `password`, `idGroup`) VALUES
('1', 'reol', 'dombo', 'haha@hotmail.fr', 'tata.com', '1928-03-01', 'kakako', '1'),
('2', 'Rébecca', 'Armand', 'Saint-Didier-des-Bois', 'ara.com', '1929-02-03', 'lskss', '1'),
('3', 'Aimée', 'Hebert', 'Marigny-le-Châtel', 'bore.fr', '2016-12-02', 'msmsekdl', '1'),
('4', 'Marielle', 'Ribeiro', 'Maillères', 'ofr.fd', '2012-07-03', 'eod,sld', '2');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `groups`
--
ALTER TABLE `groups`
  ADD PRIMARY KEY (`idGroup`);

--
-- Index pour la table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`idPerson`),
  ADD KEY `idGroup` (`idGroup`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
