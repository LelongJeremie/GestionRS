-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 18 jan. 2022 à 08:04
-- Version du serveur :  5.7.26
-- Version de PHP :  7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `siteschuman`
--

-- --------------------------------------------------------

--
-- Structure de la table `absence`
--

DROP TABLE IF EXISTS `absence`;
CREATE TABLE IF NOT EXISTS `absence` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `id_eleve` smallint(6) NOT NULL,
  `absence` smallint(6) NOT NULL,
  `date_heure` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_eleve` (`id_eleve`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `fourniture`
--

DROP TABLE IF EXISTS `fourniture`;
CREATE TABLE IF NOT EXISTS `fourniture` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `materiel` varchar(30) NOT NULL,
  `nombre` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `mots`
--

DROP TABLE IF EXISTS `mots`;
CREATE TABLE IF NOT EXISTS `mots` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `id_eleve` smallint(6) NOT NULL,
  `id_prof` smallint(6) NOT NULL,
  `mots` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_idelevemots` (`id_eleve`),
  KEY `fk_idprofmots` (`id_prof`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `rdv`
--

DROP TABLE IF EXISTS `rdv`;
CREATE TABLE IF NOT EXISTS `rdv` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `date_rdv` date NOT NULL,
  `id_participant` smallint(6) NOT NULL,
  `id_organisateur` smallint(6) NOT NULL,
  `validationrdv` int(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_participantrdv` (`id_participant`),
  KEY `fk_organisateurrdv` (`id_organisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `rdv`
--

INSERT INTO `rdv` (`id`, `date_rdv`, `id_participant`, `id_organisateur`, `validationrdv`) VALUES
(1, '2021-11-02', 4, 4, 0),
(13, '2021-12-07', 1, 4, 1),
(14, '2021-12-01', 1, 4, 1),
(15, '2021-12-01', 1, 4, 1);

-- --------------------------------------------------------

--
-- Structure de la table `sanction`
--

DROP TABLE IF EXISTS `sanction`;
CREATE TABLE IF NOT EXISTS `sanction` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `id_eleve` smallint(6) NOT NULL,
  `id_prof` smallint(6) NOT NULL,
  `temps` time NOT NULL,
  `description` text NOT NULL,
  `validation` varchar(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_prof` (`id_prof`),
  KEY `id_eleve` (`id_eleve`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `transfert`
--

DROP TABLE IF EXISTS `transfert`;
CREATE TABLE IF NOT EXISTS `transfert` (
  `id` smallint(6) NOT NULL,
  `id_materiel` smallint(6) NOT NULL,
  `id_utilisateur` smallint(6) NOT NULL,
  `nombre` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `validation` varchar(1) NOT NULL,
  `type_transfert` varchar(1) NOT NULL,
  KEY `id_materiel` (`id_materiel`),
  KEY `id_utilisateur` (`id_utilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `nom` varchar(15) NOT NULL,
  `prenom` varchar(15) NOT NULL,
  `date_naissance` varchar(15) NOT NULL,
  `role` varchar(1) NOT NULL,
  `classe` varchar(10) DEFAULT NULL,
  `id_famille` varchar(30) DEFAULT NULL,
  `mail` varchar(50) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  `validation` varchar(1) NOT NULL,
  `token` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `nom`, `prenom`, `date_naissance`, `role`, `classe`, `id_famille`, `mail`, `username`, `password`, `validation`, `token`) VALUES
(1, 'admin', 'admin', '2021-12-07', '1', NULL, NULL, 'admin@admin.Admin', 'admin', 'rloYdHi6P0DDs', '1', NULL),
(2, 'prof', 'prof', '2021-12-07', '2', NULL, NULL, 'prof@lprs.fr', 'prof', 'rl2AywpC6kXeg', '2', NULL),
(3, 'eleve', 'eleve', '2021-12-07', '4', NULL, NULL, 'eleve@lprs.com', 'eleve', 'rl82WIilKGnoo', '1', NULL),
(4, 'Vide', 'Vide', '', '4', NULL, NULL, 'vide@vide.com', 'vide', 'vide', '0', NULL),
(18, 'yacine', 'yacine', '2021-12-02', '1', NULL, NULL, 'y.tabti@lprs.fr', 'CRYPTO', 'rlHUEapGXz2k2', '1', 'rlM7nC/7P/zqI'),
(19, 'yacine', 'yacine', '2021-12-25', '3', NULL, NULL, 'jejesuisjeje@gmail.com', 'yacine', 'rlAwrzznCTytM', '2', NULL);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `absence`
--
ALTER TABLE `absence`
  ADD CONSTRAINT `absence_ibfk_1` FOREIGN KEY (`id_eleve`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `mots`
--
ALTER TABLE `mots`
  ADD CONSTRAINT `fk_idelevemots` FOREIGN KEY (`id_eleve`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `fk_idprofmots` FOREIGN KEY (`id_prof`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `rdv`
--
ALTER TABLE `rdv`
  ADD CONSTRAINT `fk_organisateurrdv` FOREIGN KEY (`id_organisateur`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `fk_participantrdv` FOREIGN KEY (`id_participant`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `sanction`
--
ALTER TABLE `sanction`
  ADD CONSTRAINT `sanction_ibfk_1` FOREIGN KEY (`id_prof`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `sanction_ibfk_2` FOREIGN KEY (`id_eleve`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `transfert`
--
ALTER TABLE `transfert`
  ADD CONSTRAINT `transfert_ibfk_1` FOREIGN KEY (`id_materiel`) REFERENCES `fourniture` (`id`),
  ADD CONSTRAINT `transfert_ibfk_2` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
