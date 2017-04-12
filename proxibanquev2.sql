-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Mar 11 Avril 2017 à 19:17
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `proxibanquev2`
--

-- --------------------------------------------------------

--
-- Structure de la table `agence`
--

CREATE TABLE `agence` (
  `idAgence` int(11) NOT NULL,
  `dateCreationAgence` date DEFAULT NULL,
  `idGerant` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------
INSERT INTO `agence` (`idAgence`, `dateCreationAgence`, `idGerant`) VALUES
(1, '2010-01-12', 1);
--
-- Structure de la table `cartebancaire`
--

CREATE TABLE `cartebancaire` (
  `numeroCarte` int(11) NOT NULL,
  `dateExpiration` date DEFAULT NULL,
  `codeSecurite` int(11) DEFAULT NULL,
  `nomCarte` varchar(25) DEFAULT NULL,
  `prenomCarte` varchar(25) DEFAULT NULL,
  `idClient` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `cartebancaire`
--

INSERT INTO `cartebancaire` (`numeroCarte`, `dateExpiration`, `codeSecurite`, `nomCarte`, `prenomCarte`, `idClient`) VALUES
(11, '2020-04-11', 123, 'nomCarte11', 'prenomCarte11', 1),
(12, '2020-10-01', 753, 'nomCarte12', 'prenomcarte12', 2),
(13, '2021-12-22', 852, 'nomCarte13', 'prenomCarte13', 3),
(14, '2030-03-21', 951, 'nomCarte14', 'prenomCarte14', 4),
(15, '2020-05-06', 357, 'nomCarte15', 'prenomCarte15', 5),
(16, '2025-06-05', 456, 'nomCarte16', 'prenomCarte16', 7),
(17, '2020-09-30', 159, 'nomCarte17', 'prenomCarte17', 8);

-- --------------------------------------------------------

--
-- Structure de la table `clients`
--

CREATE TABLE `clients` (
  `idClient` int(11) NOT NULL,
  `civilite` varchar(25) DEFAULT NULL,
  `nom` varchar(25) DEFAULT NULL,
  `prenom` varchar(25) DEFAULT NULL,
  `rue` varchar(25) DEFAULT NULL,
  `telephone` varchar(25) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  `nomEntreprise` varchar(25) DEFAULT NULL,
  `codePostal` varchar(25) DEFAULT NULL,
  `ville` varchar(25) DEFAULT NULL,
  `idConseiller` int(11) DEFAULT NULL,
  `idCompteCourant` int(11) DEFAULT NULL,
  `numeroCarte` int(11) DEFAULT NULL,
  `idCompteEpargne` int(11) DEFAULT NULL,
  `idAgence` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `clients`
--

INSERT INTO `clients` (`idClient`, `civilite`, `nom`, `prenom`, `rue`, `telephone`, `email`, `nomEntreprise`, `codePostal`, `ville`, `idConseiller`, `idCompteCourant`, `numeroCarte`, `idCompteEpargne`,`idAgence`) VALUES
(1, 'M', 'DUPONT', 'Marc', '5,rue du chat', '0121326525', 'marc.dupont@yahoo.fr', NULL, '67852', 'Lefonaine', 1, 1234, 11, NULL,1),
(2, 'Mme', 'BERNARD', 'Josepha', '6,rue du chien', '1234455678', 'joseph.bernard@laposte.fr', NULL, '69053', 'Villeurbanne', 2, 4567, 12, NULL,1),
(3, 'Mlle', 'HENAF', 'Emmanuelle', '7,rue du poisson', '9876543210', 'manu.henaf@lenet.fr', NULL, '02541', 'Pasloingue', 3, 8910, 13, NULL,1),
(4, 'M', 'LE BAIL', 'Joseph', '8,rue du requin', '7253159852', 'josephlebail@orange.fr', NULL, '95841', 'Theville', 4, 1112, 14, 3,1),
(5, 'Mme', 'LE PUIL', 'Paula', '9,rue du oiseaux', '1587423621', 'paulalepuil@free.fr', NULL, '65214', 'Lebourguade', 1, 1314, 15, NULL,1),
(6, 'M', 'BELLEC', 'Julien', '10,rue de gégé', '9632587410', 'juju69@yahoo.fr', NULL, '87412', 'Letrou', 2, 1516, NULL, 2,1),
(7, 'M', 'KERBAIL', 'Nicolas', '11,rue des ours', '1232145654', 'nicodu65@hotmail.fr', NULL, '56100', 'Quiberon', 3, 1718, 16, NULL,1),
(8, 'Mlle', 'LE GOFF', 'Yvette', '12,rue des epinards', '7586945162', 'yvettelegoff@caramail.fr', NULL, '29000', 'Brest', 3, 1920, 17, NULL,1),
(9, 'M', 'LE BIHAN', 'Roger', '13,rue des pikatchus', '1236549878', 'lentreprise01@laposte.fr', 'Lentrerprise01', '35000', 'Rennes', 4, NULL, NULL, 1,1);

-- --------------------------------------------------------

--
-- Structure de la table `comptecourant`
--

CREATE TABLE `comptecourant` (
  `idCompteCourant` int(11) NOT NULL,
  `solde` float DEFAULT NULL,
  `dateOuvertureCompte` date DEFAULT NULL,
  `decouvert` int(11) DEFAULT NULL,
  `idClient` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `comptecourant`
--

INSERT INTO `comptecourant` (`idCompteCourant`, `solde`, `dateOuvertureCompte`, `decouvert`, `idClient`) VALUES
(1112, 500, '2014-04-30', 1000, 4),
(1234, 10000, '2012-01-01', 1000, 1),
(1314, 4000, '2015-05-05', 1000, 5),
(1516, 8000, '2016-06-01', 1000, 6),
(1718, 900, '2017-01-20', 1000, 7),
(1920, 100000, '2012-07-12', 1000, 8),
(4567, 1000, '2013-02-02', 1000, 2),
(8910, 2000, '2014-06-03', 1000, 3);

-- --------------------------------------------------------

--
-- Structure de la table `compteepargne`
--

CREATE TABLE `compteepargne` (
  `idCompteEpargne` int(11) NOT NULL,
  `solde` float DEFAULT NULL,
  `dateOuvertureCompte` date DEFAULT NULL,
  `tauxRemuneration` varchar(25) DEFAULT NULL,
  `idClient` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `compteepargne`
--

INSERT INTO `compteepargne` (`idCompteEpargne`, `solde`, `dateOuvertureCompte`, `tauxRemuneration`, `idClient`) VALUES
(1, 100, '2012-02-01', '0.03', 9),
(2, 500, '2013-10-05', '0.03', 6),
(3, 4200, '2014-12-04', '0.03', 4);

-- --------------------------------------------------------

--
-- Structure de la table `conseillers`
--

CREATE TABLE `conseillers` (
  `idConseiller` int(11) NOT NULL,
  `nom` varchar(25) DEFAULT NULL,
  `prenom` varchar(25) DEFAULT NULL,
  `rue` varchar(25) DEFAULT NULL,
  `telephone` varchar(25) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  `civilite` varchar(25) DEFAULT NULL,
  `codePostal` varchar(25) DEFAULT NULL,
  `ville` varchar(25) DEFAULT NULL,
  `idGerant` int(11) DEFAULT NULL,
  `password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `conseillers`
--

INSERT INTO `conseillers` (`idConseiller`, `nom`, `prenom`, `rue`, `telephone`, `email`, `civilite`, `codePostal`, `ville`, `idGerant`, `password`) VALUES
(1, 'JAFFRE', 'Guy', '1652,rue chauvesouris', '0678974518', 'guy.jaffre@free.net', 'M', '56852', 'Smallville', 1, 'guyjaffre'),
(2, 'DUPONT', 'Alexandre', '1,avenue du cheval', '9875456412', 'alexdupont@yahoo.net', 'M', '69520', 'Lyon', 1, 'alexdupont'),
(3, 'HADDOCK', 'Archibald', '2,rue des poneys', '0305154897', 'archihadd@caramail.net', 'M', '52000', 'Rouen', 1, 'archihadd'),
(4, 'TOURNESOL', 'Triphon', '65,rue lane', '9845122346', 'Tournesol@laposte.net', 'M', '56300', 'Camors', 1, 'Tournesol');

-- --------------------------------------------------------

--
-- Structure de la table `gerants`
--

CREATE TABLE `gerants` (
  `idGerant` int(11) NOT NULL,
  `nom` varchar(25) DEFAULT NULL,
  `prenom` varchar(25) DEFAULT NULL,
  `rue` varchar(25) DEFAULT NULL,
  `telephone` varchar(25) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  `civilite` varchar(25) DEFAULT NULL,
  `codePostal` varchar(25) DEFAULT NULL,
  `ville` varchar(25) DEFAULT NULL,
  `idAgence` int(11) DEFAULT NULL,
  `password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `gerants`
--

INSERT INTO `gerants` (`idGerant`, `nom`, `prenom`, `rue`, `telephone`, `email`, `civilite`, `codePostal`, `ville`, `idAgence`, `password`) VALUES
(1, 'PERRIN', 'Damien', '2,rue du chaquitousse', '879745463212', 'damiendu22@free.net', 'M', '22000', 'SaintBrieuc', NULL, 'damienperrin');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `agence`
--
ALTER TABLE `agence`
  ADD PRIMARY KEY (`idAgence`),
  ADD KEY `FK_agence_idGerant` (`idGerant`);

--
-- Index pour la table `cartebancaire`
--
ALTER TABLE `cartebancaire`
  ADD PRIMARY KEY (`numeroCarte`),
  ADD KEY `FK_carteBancaire_idClient` (`idClient`);

--
-- Index pour la table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`idClient`),
  ADD KEY `FK_clients_idConseiller` (`idConseiller`),
  ADD KEY `FK_clients_idCompteCourant` (`idCompteCourant`),
  ADD KEY `FK_clients_numeroCarte` (`numeroCarte`),
  ADD KEY `FK_clients_idCompteEpargne` (`idCompteEpargne`),
  ADD KEY `FK_clients_idAgence` (`idAgence`);

--
-- Index pour la table `comptecourant`
--
ALTER TABLE `comptecourant`
  ADD PRIMARY KEY (`idCompteCourant`),
  ADD KEY `FK_compteCourant_idClient` (`idClient`);

--
-- Index pour la table `compteepargne`
--
ALTER TABLE `compteepargne`
  ADD PRIMARY KEY (`idCompteEpargne`),
  ADD KEY `FK_compteEpargne_idClient` (`idClient`);

--
-- Index pour la table `conseillers`
--
ALTER TABLE `conseillers`
  ADD PRIMARY KEY (`idConseiller`),
  ADD KEY `FK_conseillers_idGerant` (`idGerant`),
  ADD KEY `FK_conseillers_login` (`password`);

--
-- Index pour la table `gerants`
--
ALTER TABLE `gerants`
  ADD PRIMARY KEY (`idGerant`),
  ADD KEY `FK_gerants_idAgence` (`idAgence`),
  ADD KEY `FK_gerants_login` (`password`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `agence`
--
ALTER TABLE `agence`
  MODIFY `idAgence` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `clients`
--
ALTER TABLE `clients`
  MODIFY `idClient` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `conseillers`
--
ALTER TABLE `conseillers`
  MODIFY `idConseiller` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `gerants`
--
ALTER TABLE `gerants`
  MODIFY `idGerant` int(11) NOT NULL AUTO_INCREMENT;


-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `agence`
--
ALTER TABLE `agence`
  ADD CONSTRAINT `FK_agence_idGerant` FOREIGN KEY (`idGerant`) REFERENCES `gerants` (`idGerant`) ON DELETE SET NULL;

--
-- Contraintes pour la table `cartebancaire`
--
ALTER TABLE `cartebancaire`
  ADD CONSTRAINT `FK_carteBancaire_idClient` FOREIGN KEY (`idClient`) REFERENCES `clients` (`idClient`)ON DELETE SET NULL;

--
-- Contraintes pour la table `clients`
--
ALTER TABLE `clients`
  ADD CONSTRAINT `FK_clients_idCompteCourant` FOREIGN KEY (`idCompteCourant`) REFERENCES `comptecourant` (`idCompteCourant`)ON DELETE CASCADE,
  ADD CONSTRAINT `FK_clients_idCompteEpargne` FOREIGN KEY (`idCompteEpargne`) REFERENCES `compteepargne` (`idCompteEpargne`)ON DELETE CASCADE,
  ADD CONSTRAINT `FK_clients_idConseiller` FOREIGN KEY (`idConseiller`) REFERENCES `conseillers` (`idConseiller`)ON DELETE SET NULL,
  ADD CONSTRAINT `FK_clients_numeroCarte` FOREIGN KEY (`numeroCarte`) REFERENCES `cartebancaire` (`numeroCarte`)ON DELETE CASCADE,
  ADD CONSTRAINT `FK_clients_idAgence` FOREIGN KEY (`idAgence`) REFERENCES `agence` (`idAgence`) ON DELETE SET NULL;

--
-- Contraintes pour la table `comptecourant`
--
ALTER TABLE `comptecourant`
  ADD CONSTRAINT `FK_compteCourant_idClient` FOREIGN KEY (`idClient`) REFERENCES `clients` (`idClient`)ON DELETE SET NULL;

--
-- Contraintes pour la table `compteepargne`
--
ALTER TABLE `compteepargne`
  ADD CONSTRAINT `FK_compteEpargne_idClient` FOREIGN KEY (`idClient`) REFERENCES `clients` (`idClient`)ON DELETE SET NULL;

--
-- Contraintes pour la table `conseillers`
--
ALTER TABLE `conseillers`
  ADD CONSTRAINT `FK_conseillers_idGerant` FOREIGN KEY (`idGerant`) REFERENCES `gerants` (`idGerant`)ON DELETE SET NULL;
  /*
  ADD CONSTRAINT `FK_conseillers_login` FOREIGN KEY (`login`) REFERENCES `authentification` (`login`);*/

--
-- Contraintes pour la table `gerants`
--
ALTER TABLE `gerants`
  ADD CONSTRAINT `FK_gerants_idAgence` FOREIGN KEY (`idAgence`) REFERENCES `agence` (`idAgence`)ON DELETE SET NULL;/*
  ADD CONSTRAINT `FK_gerants_login` FOREIGN KEY (`login`) REFERENCES `authentification` (`login`);*/
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
