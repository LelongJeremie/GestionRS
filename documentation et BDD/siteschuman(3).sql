-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mar. 05 avr. 2022 à 20:51
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `siteschuman`
--

-- --------------------------------------------------------

--
-- Structure de la table `absence`
--

DROP TABLE IF EXISTS `absence`;
CREATE TABLE IF NOT EXISTS `absence` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `id_eleve` smallint(6) NOT NULL,
  `ars` smallint(6) NOT NULL COMMENT '1 pour retard/ 2 pour absence/3 pour sanction',
  `date_heure` datetime DEFAULT NULL,
  `duree` int(6) DEFAULT NULL COMMENT 'En minute',
  `commentaire` text,
  PRIMARY KEY (`id`),
  KEY `id_eleve` (`id_eleve`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `absence`
--

INSERT INTO `absence` (`id`, `id_eleve`, `ars`, `date_heure`, `duree`, `commentaire`) VALUES
(1, 3, 1, NULL, 10, NULL),
(4, 3, 3, NULL, NULL, 'zifhzedihzfopha'),
(5, 3, 3, NULL, NULL, 'eiopfjzepijfzpi'),
(6, 3, 1, '2022-04-05 06:34:00', 5, NULL),
(9, 3, 1, '2022-04-05 10:25:00', 1, NULL),
(10, 3, 2, '2022-04-05 10:25:00', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

DROP TABLE IF EXISTS `classe`;
CREATE TABLE IF NOT EXISTS `classe` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `classe`
--

INSERT INTO `classe` (`id`, `libelle`) VALUES
(3, 'test');

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
-- Structure de la table `joursemaine`
--

DROP TABLE IF EXISTS `joursemaine`;
CREATE TABLE IF NOT EXISTS `joursemaine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jour` varchar(22) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `joursemaine`
--

INSERT INTO `joursemaine` (`id`, `jour`) VALUES
(1, 'lundi'),
(2, 'mardi'),
(3, 'mercredi'),
(4, 'jeudi'),
(5, 'vendredi'),
(6, 'samedi');

-- --------------------------------------------------------

--
-- Structure de la table `maclasse`
--

DROP TABLE IF EXISTS `maclasse`;
CREATE TABLE IF NOT EXISTS `maclasse` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `iduser` smallint(6) NOT NULL,
  `idclasse` smallint(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_iduser` (`iduser`),
  KEY `fk_classe` (`idclasse`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `maclasse`
--

INSERT INTO `maclasse` (`id`, `iduser`, `idclasse`) VALUES
(1, 3, 3),
(3, 4, 3),
(9, 3, 3);

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
-- Structure de la table `planning`
--

DROP TABLE IF EXISTS `planning`;
CREATE TABLE IF NOT EXISTS `planning` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jour` int(11) NOT NULL,
  `HeureDebut` int(11) NOT NULL,
  `duree` int(11) NOT NULL,
  `idUtilisateur` smallint(6) DEFAULT NULL,
  `idClasse` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Utilisateur` (`idUtilisateur`),
  KEY `fk_classse` (`idClasse`),
  KEY `fk_jour` (`jour`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `planning`
--

INSERT INTO `planning` (`id`, `jour`, `HeureDebut`, `duree`, `idUtilisateur`, `idClasse`) VALUES
(9, 1, 13, 1, 18, 3);

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
  `role` varchar(30) NOT NULL,
  `classe` smallint(10) DEFAULT NULL,
  `id_famille` varchar(30) DEFAULT NULL,
  `mail` varchar(50) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  `validation` varchar(30) NOT NULL,
  `token` varchar(50) DEFAULT NULL,
  `Disponible` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_classeid` (`classe`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `nom`, `prenom`, `date_naissance`, `role`, `classe`, `id_famille`, `mail`, `username`, `password`, `validation`, `token`, `Disponible`) VALUES
(1, 'admin', 'admin', '2021-12-07', 'Admin', NULL, NULL, 'Admin', 'admin', 'admin', 'Desactive', NULL, NULL),
(2, 'prof', 'prof', '2021-12-07', 'Profprinc', 3, NULL, 'Profprinc', 'prof', 'Profprinc', 'null', NULL, NULL),
(3, 'eleve', 'eleve', '2021-12-07', 'Eleve', 3, NULL, 'eleve@lprs.com', 'eleve', 'rl82WIilKGnoo', 'null', NULL, NULL),
(4, 'vide', 'videe', '2021-12-04', 'Prof', NULL, NULL, 'Prof', 'vide', 'Prof', 'Desactive', '78551', NULL),
(18, 'yacine', 'yacine', '2021-12-02', 'Admin', NULL, NULL, 'y.tabti@lprs.fr', 'CRYPTO', 'rlHUEapGXz2k2', 'Active', '35459', NULL),
(19, 'yacine', 'yacine', '2021-12-25', 'Admin', NULL, NULL, 'jejesuisjeje@gmail.com', 'yacine', 'rlAwrzznCTytM', 'Desactive', NULL, NULL),
(20, 'test', 'test', 'test', '3', NULL, NULL, 'test', 'test', 'test', '0', NULL, NULL),
(27, 'testcm', 'testcm', 'testcm', 'Admin', NULL, NULL, 'testcm', 'testcm', 'testcm', 'Active', NULL, NULL),
(28, 'testi', 'testi', 'testi', 'Prof', NULL, NULL, 'testi', 'testi', 'testi', '0', NULL, NULL);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `absence`
--
ALTER TABLE `absence`
  ADD CONSTRAINT `absence_ibfk_1` FOREIGN KEY (`id_eleve`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `maclasse`
--
ALTER TABLE `maclasse`
  ADD CONSTRAINT `fk_classe` FOREIGN KEY (`idclasse`) REFERENCES `classe` (`id`),
  ADD CONSTRAINT `fk_iduser` FOREIGN KEY (`iduser`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `mots`
--
ALTER TABLE `mots`
  ADD CONSTRAINT `fk_idelevemots` FOREIGN KEY (`id_eleve`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `fk_idprofmots` FOREIGN KEY (`id_prof`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `planning`
--
ALTER TABLE `planning`
  ADD CONSTRAINT `planning_ibfk_1` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`id`),
  ADD CONSTRAINT `planning_ibfk_2` FOREIGN KEY (`jour`) REFERENCES `joursemaine` (`id`),
  ADD CONSTRAINT `planning_ibfk_3` FOREIGN KEY (`idClasse`) REFERENCES `classe` (`id`);

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

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `FK_classeid` FOREIGN KEY (`classe`) REFERENCES `classe` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
