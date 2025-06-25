-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 25 nov. 2023 à 22:20
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `hospital`
--

-- --------------------------------------------------------

--
-- Structure de la table `docteur`
--

CREATE TABLE `docteur` (
  `id` int(111) NOT NULL,
  `nom` varchar(111) NOT NULL,
  `prenom` varchar(111) NOT NULL,
  `adresse` varchar(111) NOT NULL,
  `email` varchar(111) NOT NULL,
  `mdp` varchar(100) NOT NULL,
  `cmdp` varchar(100) NOT NULL,
  `specialite` varchar(111) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `docteur`
--

INSERT INTO `docteur` (`id`, `nom`, `prenom`, `adresse`, `email`, `mdp`, `cmdp`, `specialite`) VALUES
(18, 'walid', 'walid', 'tunis', 'walid', 'walid', 'walid', 'dentiste'),
(19, 'aa', 'aa', 'aa', 'aa', 'aa', 'aa', 'dentiste');

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

CREATE TABLE `patient` (
  `id` int(50) NOT NULL,
  `nom` varchar(111) NOT NULL,
  `prenom` varchar(111) NOT NULL,
  `adresse` varchar(111) NOT NULL,
  `email` varchar(111) NOT NULL,
  `docspec` varchar(111) NOT NULL,
  `mondoc` varchar(100) NOT NULL,
  `mdp` varchar(111) NOT NULL,
  `cmdp` varchar(111) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `patient`
--

INSERT INTO `patient` (`id`, `nom`, `prenom`, `adresse`, `email`, `docspec`, `mondoc`, `mdp`, `cmdp`) VALUES
(4, 'wajih', 'wajih', 'wajih', 'wajih', 'dentiste', 'walid walid', 'wajih', 'wajih'),
(5, 'aaa', 'aaa', 'aaa', 'aaa', 'dentiste', 'aa aa', 'aaa', 'aaa');

-- --------------------------------------------------------

--
-- Structure de la table `rendez_vous`
--

CREATE TABLE `rendez_vous` (
  `id` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `nompatient` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `rendez_vous`
--

INSERT INTO `rendez_vous` (`id`, `date`, `nompatient`) VALUES
(5, '2021-06-10 00:00:00', 'wajih wajih'),
(6, '2023-06-15 00:00:00', 'aaa aaa'),
(7, '2023-06-15 00:00:00', 'aaa aaa'),
(8, '2023-06-16 00:00:00', 'aaa aaa');

-- --------------------------------------------------------

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `docteur`
--
ALTER TABLE `docteur`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `rendez_vous`
--
ALTER TABLE `rendez_vous`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `docteur`
--
ALTER TABLE `docteur`
  MODIFY `id` int(111) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT pour la table `patient`
--
ALTER TABLE `patient`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `rendez_vous`
--
ALTER TABLE `rendez_vous`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
