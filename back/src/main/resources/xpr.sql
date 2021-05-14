-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 14, 2021 at 01:35 PM
-- Server version: 8.0.24
-- PHP Version: 7.3.24-(to be removed in future macOS)

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `xpr`
--

-- --------------------------------------------------------

--
-- Table structure for table `agences`
--

CREATE TABLE `agences` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `entite_id` bigint DEFAULT NULL,
  `ville_nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `agences`
--

INSERT INTO `agences` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `nom`, `entite_id`, `ville_nom`) VALUES
(1, NULL, NULL, NULL, NULL, 'Agence fes', 1, 'FES'),
(2, NULL, NULL, NULL, NULL, 'Agence Casa', NULL, 'Casa');

-- --------------------------------------------------------

--
-- Table structure for table `autorisations`
--

CREATE TABLE `autorisations` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `auth_name` varchar(255) DEFAULT NULL,
  `uri` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `autorisations`
--

INSERT INTO `autorisations` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `auth_name`, `uri`) VALUES
(1, NULL, NULL, NULL, NULL, 'ACCOUNT-REST$CREATE$ALL', '/account'),
(2, NULL, NULL, NULL, NULL, 'ACCOUNT-REST$CREATE$ENTITE', '/account'),
(3, NULL, NULL, NULL, NULL, 'ACCOUNT-REST$CREATE$CLIENT', '/account'),
(4, NULL, NULL, NULL, NULL, 'ACCOUNT-REST$UPDATE$ALL', '/account'),
(5, NULL, NULL, NULL, NULL, 'ACCOUNT-REST$UPDATE$ENTITE', '/account'),
(6, NULL, NULL, NULL, NULL, 'ACCOUNT-REST$UPDATE$CLIENT', '/account'),
(7, NULL, NULL, NULL, NULL, 'ACCOUNT-REST$DELETE$ALL', '/account'),
(8, NULL, NULL, NULL, NULL, 'ACCOUNT-REST$DELETE$ENTITE', '/account'),
(9, NULL, NULL, NULL, NULL, 'ACCOUNT-REST$DELETE$CLIENT', '/account'),
(10, NULL, NULL, NULL, NULL, 'ACCOUNT-REST$LIST$ALL', '/account'),
(11, NULL, NULL, NULL, NULL, 'ACCOUNT-REST$LIST$ENTITE', '/account'),
(12, NULL, NULL, NULL, NULL, 'ACCOUNT-REST$LIST$CLIENT', '/account'),
(13, NULL, NULL, NULL, NULL, 'ACCOUNT-REST$LISTSELECT$ALL', '/account'),
(14, NULL, NULL, NULL, NULL, 'ACCOUNT-REST$LISTSELECT$ENTITE', '/account'),
(15, NULL, NULL, NULL, NULL, 'ACCOUNT-REST$LISTSELECT$CLIENT', '/account'),
(16, NULL, NULL, NULL, NULL, 'BON-EXPEDITION-REST$CREATE$ALL', '/bonExpedition'),
(17, NULL, NULL, NULL, NULL, 'BON-EXPEDITION-REST$CREATE$ENTITE', '/bonExpedition'),
(18, NULL, NULL, NULL, NULL, 'BON-EXPEDITION-REST$CREATE$CLIENT', '/bonExpedition'),
(19, NULL, NULL, NULL, NULL, 'BON-EXPEDITION-REST$UPDATE$ALL', '/bonExpedition'),
(20, NULL, NULL, NULL, NULL, 'BON-EXPEDITION-REST$UPDATE$ENTITE', '/bonExpedition'),
(21, NULL, NULL, NULL, NULL, 'BON-EXPEDITION-REST$UPDATE$CLIENT', '/bonExpedition'),
(22, NULL, NULL, NULL, NULL, 'BON-EXPEDITION-REST$DELETE$ALL', '/bonExpedition'),
(23, NULL, NULL, NULL, NULL, 'BON-EXPEDITION-REST$DELETE$ENTITE', '/bonExpedition'),
(24, NULL, NULL, NULL, NULL, 'BON-EXPEDITION-REST$DELETE$CLIENT', '/bonExpedition'),
(25, NULL, NULL, NULL, NULL, 'BON-EXPEDITION-REST$LIST$ALL', '/bonExpedition'),
(26, NULL, NULL, NULL, NULL, 'BON-EXPEDITION-REST$LIST$ENTITE', '/bonExpedition'),
(27, NULL, NULL, NULL, NULL, 'BON-EXPEDITION-REST$LIST$CLIENT', '/bonExpedition'),
(28, NULL, NULL, NULL, NULL, 'BON-EXPEDITION-REST$LISTSELECT$ALL', '/bonExpedition'),
(29, NULL, NULL, NULL, NULL, 'BON-EXPEDITION-REST$LISTSELECT$ENTITE', '/bonExpedition'),
(30, NULL, NULL, NULL, NULL, 'BON-EXPEDITION-REST$LISTSELECT$CLIENT', '/bonExpedition'),
(31, NULL, NULL, NULL, NULL, 'BON-RAMASSAGE-REST$CREATE$ALL', '/bonRamassage'),
(32, NULL, NULL, NULL, NULL, 'BON-RAMASSAGE-REST$CREATE$ENTITE', '/bonRamassage'),
(33, NULL, NULL, NULL, NULL, 'BON-RAMASSAGE-REST$CREATE$CLIENT', '/bonRamassage'),
(34, NULL, NULL, NULL, NULL, 'BON-RAMASSAGE-REST$UPDATE$ALL', '/bonRamassage'),
(35, NULL, NULL, NULL, NULL, 'BON-RAMASSAGE-REST$UPDATE$ENTITE', '/bonRamassage'),
(36, NULL, NULL, NULL, NULL, 'BON-RAMASSAGE-REST$UPDATE$CLIENT', '/bonRamassage'),
(37, NULL, NULL, NULL, NULL, 'BON-RAMASSAGE-REST$DELETE$ALL', '/bonRamassage'),
(38, NULL, NULL, NULL, NULL, 'BON-RAMASSAGE-REST$DELETE$ENTITE', '/bonRamassage'),
(39, NULL, NULL, NULL, NULL, 'BON-RAMASSAGE-REST$DELETE$CLIENT', '/bonRamassage'),
(40, NULL, NULL, NULL, NULL, 'BON-RAMASSAGE-REST$LIST$ALL', '/bonRamassage'),
(41, NULL, NULL, NULL, NULL, 'BON-RAMASSAGE-REST$LIST$ENTITE', '/bonRamassage'),
(42, NULL, NULL, NULL, NULL, 'BON-RAMASSAGE-REST$LIST$CLIENT', '/bonRamassage'),
(43, NULL, NULL, NULL, NULL, 'BON-RAMASSAGE-REST$LISTSELECT$ALL', '/bonRamassage'),
(44, NULL, NULL, NULL, NULL, 'BON-RAMASSAGE-REST$LISTSELECT$ENTITE', '/bonRamassage'),
(45, NULL, NULL, NULL, NULL, 'BON-RAMASSAGE-REST$LISTSELECT$CLIENT', '/bonRamassage'),
(46, NULL, NULL, NULL, NULL, 'BON-RETOUR-REST$CREATE$ALL', '/bonRetour'),
(47, NULL, NULL, NULL, NULL, 'BON-RETOUR-REST$CREATE$ENTITE', '/bonRetour'),
(48, NULL, NULL, NULL, NULL, 'BON-RETOUR-REST$CREATE$CLIENT', '/bonRetour'),
(49, NULL, NULL, NULL, NULL, 'BON-RETOUR-REST$UPDATE$ALL', '/bonRetour'),
(50, NULL, NULL, NULL, NULL, 'BON-RETOUR-REST$UPDATE$ENTITE', '/bonRetour'),
(51, NULL, NULL, NULL, NULL, 'BON-RETOUR-REST$UPDATE$CLIENT', '/bonRetour'),
(52, NULL, NULL, NULL, NULL, 'BON-RETOUR-REST$DELETE$ALL', '/bonRetour'),
(53, NULL, NULL, NULL, NULL, 'BON-RETOUR-REST$DELETE$ENTITE', '/bonRetour'),
(54, NULL, NULL, NULL, NULL, 'BON-RETOUR-REST$DELETE$CLIENT', '/bonRetour'),
(55, NULL, NULL, NULL, NULL, 'BON-RETOUR-REST$LIST$ALL', '/bonRetour'),
(56, NULL, NULL, NULL, NULL, 'BON-RETOUR-REST$LIST$ENTITE', '/bonRetour'),
(57, NULL, NULL, NULL, NULL, 'BON-RETOUR-REST$LIST$CLIENT', '/bonRetour'),
(58, NULL, NULL, NULL, NULL, 'BON-RETOUR-REST$LISTSELECT$ALL', '/bonRetour'),
(59, NULL, NULL, NULL, NULL, 'BON-RETOUR-REST$LISTSELECT$ENTITE', '/bonRetour'),
(60, NULL, NULL, NULL, NULL, 'BON-RETOUR-REST$LISTSELECT$CLIENT', '/bonRetour'),
(61, NULL, NULL, NULL, NULL, 'CLIENT-REST$CREATE$ALL', '/client'),
(62, NULL, NULL, NULL, NULL, 'CLIENT-REST$CREATE$ENTITE', '/client'),
(63, NULL, NULL, NULL, NULL, 'CLIENT-REST$CREATE$CLIENT', '/client'),
(64, NULL, NULL, NULL, NULL, 'CLIENT-REST$UPDATE$ALL', '/client'),
(65, NULL, NULL, NULL, NULL, 'CLIENT-REST$UPDATE$ENTITE', '/client'),
(66, NULL, NULL, NULL, NULL, 'CLIENT-REST$UPDATE$CLIENT', '/client'),
(67, NULL, NULL, NULL, NULL, 'CLIENT-REST$DELETE$ALL', '/client'),
(68, NULL, NULL, NULL, NULL, 'CLIENT-REST$DELETE$ENTITE', '/client'),
(69, NULL, NULL, NULL, NULL, 'CLIENT-REST$DELETE$CLIENT', '/client'),
(70, NULL, NULL, NULL, NULL, 'CLIENT-REST$LIST$ALL', '/client'),
(71, NULL, NULL, NULL, NULL, 'CLIENT-REST$LIST$ENTITE', '/client'),
(72, NULL, NULL, NULL, NULL, 'CLIENT-REST$LIST$CLIENT', '/client'),
(73, NULL, NULL, NULL, NULL, 'CLIENT-REST$LISTSELECT$ALL', '/client'),
(74, NULL, NULL, NULL, NULL, 'CLIENT-REST$LISTSELECT$ENTITE', '/client'),
(75, NULL, NULL, NULL, NULL, 'CLIENT-REST$LISTSELECT$CLIENT', '/client'),
(76, NULL, NULL, NULL, NULL, 'COLIS-REST$CREATE$ALL', '/colis'),
(77, NULL, NULL, NULL, NULL, 'COLIS-REST$CREATE$ENTITE', '/colis'),
(78, NULL, NULL, NULL, NULL, 'COLIS-REST$CREATE$CLIENT', '/colis'),
(79, NULL, NULL, NULL, NULL, 'COLIS-REST$UPDATE$ALL', '/colis'),
(80, NULL, NULL, NULL, NULL, 'COLIS-REST$UPDATE$ENTITE', '/colis'),
(81, NULL, NULL, NULL, NULL, 'COLIS-REST$UPDATE$CLIENT', '/colis'),
(82, NULL, NULL, NULL, NULL, 'COLIS-REST$DELETE$ALL', '/colis'),
(83, NULL, NULL, NULL, NULL, 'COLIS-REST$DELETE$ENTITE', '/colis'),
(84, NULL, NULL, NULL, NULL, 'COLIS-REST$DELETE$CLIENT', '/colis'),
(85, NULL, NULL, NULL, NULL, 'COLIS-REST$LIST$ALL', '/colis'),
(86, NULL, NULL, NULL, NULL, 'COLIS-REST$LIST$ENTITE', '/colis'),
(87, NULL, NULL, NULL, NULL, 'COLIS-REST$LIST$CLIENT', '/colis'),
(88, NULL, NULL, NULL, NULL, 'COLIS-REST$LISTSELECT$ALL', '/colis'),
(89, NULL, NULL, NULL, NULL, 'COLIS-REST$LISTSELECT$ENTITE', '/colis'),
(90, NULL, NULL, NULL, NULL, 'COLIS-REST$LISTSELECT$CLIENT', '/colis'),
(91, NULL, NULL, NULL, NULL, 'DASHBOARD$CREATE$ALL', '/dashboard'),
(92, NULL, NULL, NULL, NULL, 'DASHBOARD$CREATE$ENTITE', '/dashboard'),
(93, NULL, NULL, NULL, NULL, 'DASHBOARD$CREATE$CLIENT', '/dashboard'),
(94, NULL, NULL, NULL, NULL, 'DASHBOARD$UPDATE$ALL', '/dashboard'),
(95, NULL, NULL, NULL, NULL, 'DASHBOARD$UPDATE$ENTITE', '/dashboard'),
(96, NULL, NULL, NULL, NULL, 'DASHBOARD$UPDATE$CLIENT', '/dashboard'),
(97, NULL, NULL, NULL, NULL, 'DASHBOARD$DELETE$ALL', '/dashboard'),
(98, NULL, NULL, NULL, NULL, 'DASHBOARD$DELETE$ENTITE', '/dashboard'),
(99, NULL, NULL, NULL, NULL, 'DASHBOARD$DELETE$CLIENT', '/dashboard'),
(100, NULL, NULL, NULL, NULL, 'DASHBOARD$LIST$ALL', '/dashboard'),
(101, NULL, NULL, NULL, NULL, 'DASHBOARD$LIST$ENTITE', '/dashboard'),
(102, NULL, NULL, NULL, NULL, 'DASHBOARD$LIST$CLIENT', '/dashboard'),
(103, NULL, NULL, NULL, NULL, 'DASHBOARD$LISTSELECT$ALL', '/dashboard'),
(104, NULL, NULL, NULL, NULL, 'DASHBOARD$LISTSELECT$ENTITE', '/dashboard'),
(105, NULL, NULL, NULL, NULL, 'DASHBOARD$LISTSELECT$CLIENT', '/dashboard'),
(106, NULL, NULL, NULL, NULL, 'DEMANDE-REST$CREATE$ALL', '/demande'),
(107, NULL, NULL, NULL, NULL, 'DEMANDE-REST$CREATE$ENTITE', '/demande'),
(108, NULL, NULL, NULL, NULL, 'DEMANDE-REST$CREATE$CLIENT', '/demande'),
(109, NULL, NULL, NULL, NULL, 'DEMANDE-REST$UPDATE$ALL', '/demande'),
(110, NULL, NULL, NULL, NULL, 'DEMANDE-REST$UPDATE$ENTITE', '/demande'),
(111, NULL, NULL, NULL, NULL, 'DEMANDE-REST$UPDATE$CLIENT', '/demande'),
(112, NULL, NULL, NULL, NULL, 'DEMANDE-REST$DELETE$ALL', '/demande'),
(113, NULL, NULL, NULL, NULL, 'DEMANDE-REST$DELETE$ENTITE', '/demande'),
(114, NULL, NULL, NULL, NULL, 'DEMANDE-REST$DELETE$CLIENT', '/demande'),
(115, NULL, NULL, NULL, NULL, 'DEMANDE-REST$LIST$ALL', '/demande'),
(116, NULL, NULL, NULL, NULL, 'DEMANDE-REST$LIST$ENTITE', '/demande'),
(117, NULL, NULL, NULL, NULL, 'DEMANDE-REST$LIST$CLIENT', '/demande'),
(118, NULL, NULL, NULL, NULL, 'DEMANDE-REST$LISTSELECT$ALL', '/demande'),
(119, NULL, NULL, NULL, NULL, 'DEMANDE-REST$LISTSELECT$ENTITE', '/demande'),
(120, NULL, NULL, NULL, NULL, 'DEMANDE-REST$LISTSELECT$CLIENT', '/demande'),
(121, NULL, NULL, NULL, NULL, 'FACTURE-REST$CREATE$ALL', '/facture'),
(122, NULL, NULL, NULL, NULL, 'FACTURE-REST$CREATE$ENTITE', '/facture'),
(123, NULL, NULL, NULL, NULL, 'FACTURE-REST$CREATE$CLIENT', '/facture'),
(124, NULL, NULL, NULL, NULL, 'FACTURE-REST$UPDATE$ALL', '/facture'),
(125, NULL, NULL, NULL, NULL, 'FACTURE-REST$UPDATE$ENTITE', '/facture'),
(126, NULL, NULL, NULL, NULL, 'FACTURE-REST$UPDATE$CLIENT', '/facture'),
(127, NULL, NULL, NULL, NULL, 'FACTURE-REST$DELETE$ALL', '/facture'),
(128, NULL, NULL, NULL, NULL, 'FACTURE-REST$DELETE$ENTITE', '/facture'),
(129, NULL, NULL, NULL, NULL, 'FACTURE-REST$DELETE$CLIENT', '/facture'),
(130, NULL, NULL, NULL, NULL, 'FACTURE-REST$LIST$ALL', '/facture'),
(131, NULL, NULL, NULL, NULL, 'FACTURE-REST$LIST$ENTITE', '/facture'),
(132, NULL, NULL, NULL, NULL, 'FACTURE-REST$LIST$CLIENT', '/facture'),
(133, NULL, NULL, NULL, NULL, 'FACTURE-REST$LISTSELECT$ALL', '/facture'),
(134, NULL, NULL, NULL, NULL, 'FACTURE-REST$LISTSELECT$ENTITE', '/facture'),
(135, NULL, NULL, NULL, NULL, 'FACTURE-REST$LISTSELECT$CLIENT', '/facture'),
(136, NULL, NULL, NULL, NULL, 'LIVREUR-REST$CREATE$ALL', '/livreur'),
(137, NULL, NULL, NULL, NULL, 'LIVREUR-REST$CREATE$ENTITE', '/livreur'),
(138, NULL, NULL, NULL, NULL, 'LIVREUR-REST$CREATE$CLIENT', '/livreur'),
(139, NULL, NULL, NULL, NULL, 'LIVREUR-REST$UPDATE$ALL', '/livreur'),
(140, NULL, NULL, NULL, NULL, 'LIVREUR-REST$UPDATE$ENTITE', '/livreur'),
(141, NULL, NULL, NULL, NULL, 'LIVREUR-REST$UPDATE$CLIENT', '/livreur'),
(142, NULL, NULL, NULL, NULL, 'LIVREUR-REST$DELETE$ALL', '/livreur'),
(143, NULL, NULL, NULL, NULL, 'LIVREUR-REST$DELETE$ENTITE', '/livreur'),
(144, NULL, NULL, NULL, NULL, 'LIVREUR-REST$DELETE$CLIENT', '/livreur'),
(145, NULL, NULL, NULL, NULL, 'LIVREUR-REST$LIST$ALL', '/livreur'),
(146, NULL, NULL, NULL, NULL, 'LIVREUR-REST$LIST$ENTITE', '/livreur'),
(147, NULL, NULL, NULL, NULL, 'LIVREUR-REST$LIST$CLIENT', '/livreur'),
(148, NULL, NULL, NULL, NULL, 'LIVREUR-REST$LISTSELECT$ALL', '/livreur'),
(149, NULL, NULL, NULL, NULL, 'LIVREUR-REST$LISTSELECT$ENTITE', '/livreur'),
(150, NULL, NULL, NULL, NULL, 'LIVREUR-REST$LISTSELECT$CLIENT', '/livreur'),
(151, NULL, NULL, NULL, NULL, 'RAMASSEUR-REST$CREATE$ALL', '/ramasseur'),
(152, NULL, NULL, NULL, NULL, 'RAMASSEUR-REST$CREATE$ENTITE', '/ramasseur'),
(153, NULL, NULL, NULL, NULL, 'RAMASSEUR-REST$CREATE$CLIENT', '/ramasseur'),
(154, NULL, NULL, NULL, NULL, 'RAMASSEUR-REST$UPDATE$ALL', '/ramasseur'),
(155, NULL, NULL, NULL, NULL, 'RAMASSEUR-REST$UPDATE$ENTITE', '/ramasseur'),
(156, NULL, NULL, NULL, NULL, 'RAMASSEUR-REST$UPDATE$CLIENT', '/ramasseur'),
(157, NULL, NULL, NULL, NULL, 'RAMASSEUR-REST$DELETE$ALL', '/ramasseur'),
(158, NULL, NULL, NULL, NULL, 'RAMASSEUR-REST$DELETE$ENTITE', '/ramasseur'),
(159, NULL, NULL, NULL, NULL, 'RAMASSEUR-REST$DELETE$CLIENT', '/ramasseur'),
(160, NULL, NULL, NULL, NULL, 'RAMASSEUR-REST$LIST$ALL', '/ramasseur'),
(161, NULL, NULL, NULL, NULL, 'RAMASSEUR-REST$LIST$ENTITE', '/ramasseur'),
(162, NULL, NULL, NULL, NULL, 'RAMASSEUR-REST$LIST$CLIENT', '/ramasseur'),
(163, NULL, NULL, NULL, NULL, 'RAMASSEUR-REST$LISTSELECT$ALL', '/ramasseur'),
(164, NULL, NULL, NULL, NULL, 'RAMASSEUR-REST$LISTSELECT$ENTITE', '/ramasseur'),
(165, NULL, NULL, NULL, NULL, 'RAMASSEUR-REST$LISTSELECT$CLIENT', '/ramasseur'),
(166, NULL, NULL, NULL, NULL, 'VILLE-REST$CREATE$ALL', '/ville'),
(167, NULL, NULL, NULL, NULL, 'VILLE-REST$CREATE$ENTITE', '/ville'),
(168, NULL, NULL, NULL, NULL, 'VILLE-REST$CREATE$CLIENT', '/ville'),
(169, NULL, NULL, NULL, NULL, 'VILLE-REST$UPDATE$ALL', '/ville'),
(170, NULL, NULL, NULL, NULL, 'VILLE-REST$UPDATE$ENTITE', '/ville'),
(171, NULL, NULL, NULL, NULL, 'VILLE-REST$UPDATE$CLIENT', '/ville'),
(172, NULL, NULL, NULL, NULL, 'VILLE-REST$DELETE$ALL', '/ville'),
(173, NULL, NULL, NULL, NULL, 'VILLE-REST$DELETE$ENTITE', '/ville'),
(174, NULL, NULL, NULL, NULL, 'VILLE-REST$DELETE$CLIENT', '/ville'),
(175, NULL, NULL, NULL, NULL, 'VILLE-REST$LIST$ALL', '/ville'),
(176, NULL, NULL, NULL, NULL, 'VILLE-REST$LIST$ENTITE', '/ville'),
(177, NULL, NULL, NULL, NULL, 'VILLE-REST$LIST$CLIENT', '/ville'),
(178, NULL, NULL, NULL, NULL, 'VILLE-REST$LISTSELECT$ALL', '/ville'),
(179, NULL, NULL, NULL, NULL, 'VILLE-REST$LISTSELECT$ENTITE', '/ville'),
(180, NULL, NULL, NULL, NULL, 'VILLE-REST$LISTSELECT$CLIENT', '/ville');

-- --------------------------------------------------------

--
-- Table structure for table `bon_expeditions`
--

CREATE TABLE `bon_expeditions` (
  `nom` varchar(255) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `disabled` bit(1) NOT NULL,
  `logistique` varchar(255) DEFAULT NULL,
  `prix` double NOT NULL,
  `ref_bon_logistique` varchar(255) DEFAULT NULL,
  `depart_id` bigint DEFAULT NULL,
  `destination_id` bigint DEFAULT NULL,
  `entite_id` bigint DEFAULT NULL,
  `statut_code` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `bon_ramassages`
--

CREATE TABLE `bon_ramassages` (
  `nom` varchar(255) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `disabled` bit(1) NOT NULL,
  `agence_id` bigint DEFAULT NULL,
  `agence_depart_id` bigint DEFAULT NULL,
  `agence_destination_id` bigint DEFAULT NULL,
  `client_ice` varchar(255) DEFAULT NULL,
  `entite_id` bigint DEFAULT NULL,
  `facture_name` varchar(255) DEFAULT NULL,
  `ramasseur_email` varchar(255) DEFAULT NULL,
  `statut_code` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `bon_ramassages`
--

INSERT INTO `bon_ramassages` (`nom`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `disabled`, `agence_id`, `agence_depart_id`, `agence_destination_id`, `client_ice`, `entite_id`, `facture_name`, `ramasseur_email`, `statut_code`) VALUES
('BR-14052021-10000', NULL, '2021-05-14 13:32:34.652000', NULL, NULL, b'0', 1, NULL, NULL, 'ice1', 4, NULL, 'ramasseur1@xpr.com', 'RAMASSÉ'),
('BR-14052021-10001', NULL, '2021-05-15 13:32:34.725000', NULL, NULL, b'0', 1, NULL, NULL, 'ice1', 1, NULL, 'ramasseur1@xpr.com', 'RAMASSÉ'),
('BR-14052021-10002', NULL, '2021-05-16 13:32:34.767000', NULL, NULL, b'0', 1, NULL, NULL, 'ice1', 4, NULL, 'ramasseur1@xpr.com', 'RAMASSÉ'),
('BR-14052021-10003', NULL, '2021-05-17 13:32:34.829000', NULL, NULL, b'0', 1, NULL, NULL, 'ice1', 1, NULL, 'ramasseur1@xpr.com', 'RAMASSÉ'),
('BR-14052021-10004', NULL, '2021-05-18 13:32:34.877000', NULL, NULL, b'0', 1, NULL, NULL, 'ice1', 4, NULL, 'ramasseur1@xpr.com', 'RAMASSÉ'),
('BR-14052021-10005', NULL, '2021-05-19 13:32:34.929000', NULL, NULL, b'0', 1, NULL, NULL, 'ice1', 1, NULL, 'ramasseur1@xpr.com', 'RAMASSÉ'),
('BR-14052021-10006', NULL, '2021-05-20 13:32:34.984000', NULL, NULL, b'0', 1, NULL, NULL, 'ice1', 4, NULL, 'ramasseur1@xpr.com', 'RAMASSÉ'),
('BR-14052021-10007', NULL, '2021-05-21 13:32:35.034000', NULL, NULL, b'0', 1, NULL, NULL, 'ice1', 1, NULL, 'ramasseur1@xpr.com', 'RAMASSÉ'),
('BR-14052021-10008', NULL, '2021-05-22 13:32:35.108000', NULL, NULL, b'0', 1, NULL, NULL, 'ice1', 4, NULL, 'ramasseur1@xpr.com', 'RAMASSÉ'),
('BR-14052021-10009', NULL, '2021-05-23 13:32:35.160000', NULL, NULL, b'0', 1, NULL, NULL, 'ice1', 1, NULL, 'ramasseur1@xpr.com', 'RAMASSÉ'),
('BR-14052021-10010', NULL, '2021-05-24 13:32:35.215000', NULL, NULL, b'0', 1, NULL, NULL, 'ice1', 4, NULL, 'ramasseur1@xpr.com', 'RAMASSÉ'),
('BR-14052021-10011', NULL, '2021-05-25 13:32:35.262000', NULL, NULL, b'0', 1, NULL, NULL, 'ice1', 1, NULL, 'ramasseur1@xpr.com', 'RAMASSÉ'),
('BR-14052021-10012', NULL, '2021-05-26 13:32:35.299000', NULL, NULL, b'0', 1, NULL, NULL, 'ice1', 4, NULL, 'ramasseur1@xpr.com', 'RAMASSÉ'),
('BR-14052021-10013', NULL, '2021-05-27 13:32:35.339000', NULL, NULL, b'0', 1, NULL, NULL, 'ice1', 1, NULL, 'ramasseur1@xpr.com', 'RAMASSÉ'),
('BR-14052021-10014', NULL, '2021-05-28 13:32:35.383000', NULL, NULL, b'0', 1, NULL, NULL, 'ice1', 4, NULL, 'ramasseur1@xpr.com', 'RAMASSÉ'),
('BR-14052021-10015', NULL, '2021-05-29 13:32:35.422000', NULL, NULL, b'0', 1, NULL, NULL, 'ice1', 1, NULL, 'ramasseur1@xpr.com', 'RAMASSÉ'),
('BR-14052021-10016', NULL, '2021-05-30 13:32:35.459000', NULL, NULL, b'0', 1, NULL, NULL, 'ice1', 4, NULL, 'ramasseur1@xpr.com', 'RAMASSÉ'),
('BR-14052021-10017', NULL, '2021-05-31 13:32:35.507000', NULL, NULL, b'0', 1, NULL, NULL, 'ice1', 1, NULL, 'ramasseur1@xpr.com', 'RAMASSÉ'),
('BR-14052021-10018', NULL, '2021-06-01 13:32:35.554000', NULL, NULL, b'0', 1, NULL, NULL, 'ice1', 4, NULL, 'ramasseur1@xpr.com', 'RAMASSÉ'),
('BR-14052021-10019', NULL, '2021-06-02 13:32:35.604000', NULL, NULL, b'0', 1, NULL, NULL, 'ice1', 1, NULL, 'ramasseur1@xpr.com', 'RAMASSÉ'),
('BR-14052021-10020', NULL, '2021-06-03 13:32:35.658000', NULL, NULL, b'0', 1, NULL, NULL, 'ice1', 4, NULL, 'ramasseur1@xpr.com', 'RAMASSÉ'),
('BR-14052021-10021', NULL, '2021-06-04 13:32:35.700000', NULL, NULL, b'0', 1, NULL, NULL, 'ice1', 1, NULL, 'ramasseur1@xpr.com', 'RAMASSÉ'),
('BR-14052021-10022', NULL, '2021-06-05 13:32:35.753000', NULL, NULL, b'0', 1, NULL, NULL, 'ice1', 4, NULL, 'ramasseur1@xpr.com', 'RAMASSÉ'),
('BR-14052021-10023', NULL, '2021-06-06 13:32:35.802000', NULL, NULL, b'0', 1, NULL, NULL, 'ice1', 1, NULL, 'ramasseur1@xpr.com', 'RAMASSÉ'),
('BR-14052021-10024', NULL, '2021-06-07 13:32:35.841000', NULL, NULL, b'0', 1, NULL, NULL, 'ice1', 4, NULL, 'ramasseur1@xpr.com', 'RAMASSÉ'),
('BR-14052021-10025', NULL, '2021-06-08 13:32:35.889000', NULL, NULL, b'0', 1, NULL, NULL, 'ice1', 1, NULL, 'ramasseur1@xpr.com', 'RAMASSÉ'),
('BR-14052021-10026', NULL, '2021-06-09 13:32:35.930000', NULL, NULL, b'0', 1, NULL, NULL, 'ice1', 4, NULL, 'ramasseur1@xpr.com', 'RAMASSÉ'),
('BR-14052021-10027', NULL, '2021-06-10 13:32:35.968000', NULL, NULL, b'0', 1, NULL, NULL, 'ice1', 1, NULL, 'ramasseur1@xpr.com', 'RAMASSÉ'),
('BR-14052021-10028', NULL, '2021-06-11 13:32:36.024000', NULL, NULL, b'0', 1, NULL, NULL, 'ice1', 4, NULL, 'ramasseur1@xpr.com', 'RAMASSÉ'),
('BR-14052021-10029', NULL, '2021-06-12 13:32:36.069000', NULL, NULL, b'0', 1, NULL, NULL, 'ice1', 1, NULL, 'ramasseur1@xpr.com', 'RAMASSÉ');

-- --------------------------------------------------------

--
-- Table structure for table `bon_retours`
--

CREATE TABLE `bon_retours` (
  `nom` varchar(255) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `disabled` bit(1) NOT NULL,
  `client_ice` varchar(255) DEFAULT NULL,
  `entite_id` bigint DEFAULT NULL,
  `livreur_email` varchar(255) DEFAULT NULL,
  `statut_code` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `business`
--

CREATE TABLE `business` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `client_ice` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `business`
--

INSERT INTO `business` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `nom`, `client_ice`) VALUES
(1, NULL, NULL, NULL, NULL, 'business1', 'ice1');

-- --------------------------------------------------------

--
-- Table structure for table `clients`
--

CREATE TABLE `clients` (
  `ice` varchar(255) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `disabled` bit(1) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prefix_commande` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `type_client` varchar(255) DEFAULT NULL,
  `contrat_id` bigint DEFAULT NULL,
  `entite_id` bigint DEFAULT NULL,
  `ville_nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `clients`
--

INSERT INTO `clients` (`ice`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `address`, `contact`, `disabled`, `nom`, `prefix_commande`, `telephone`, `type_client`, `contrat_id`, `entite_id`, `ville_nom`) VALUES
('ice1', NULL, NULL, NULL, NULL, NULL, 'client1Contact', b'0', 'Client1', 'PR', '052250605040', 'Entreprise', NULL, 1, 'FES'),
('iceClient1', NULL, NULL, NULL, NULL, NULL, NULL, b'0', 'client1', 'Client1Prefix', NULL, NULL, NULL, 1, 'FES'),
('iceXPR', NULL, NULL, NULL, NULL, NULL, 'XPR', b'0', 'XPR', 'XPR', NULL, 'Entreprise', NULL, 1, NULL),
('IdCE0', NULL, NULL, NULL, NULL, NULL, NULL, b'0', 'Client 0', NULL, NULL, NULL, NULL, 2, NULL),
('IdCE1', NULL, NULL, NULL, NULL, NULL, NULL, b'0', 'Client 1', NULL, NULL, NULL, NULL, 3, NULL),
('IdCE2', NULL, NULL, NULL, NULL, NULL, NULL, b'0', 'Client 2', NULL, NULL, NULL, NULL, 2, NULL),
('IdCE3', NULL, NULL, NULL, NULL, NULL, NULL, b'0', 'Client 3', NULL, NULL, NULL, NULL, 3, NULL),
('IdCE4', NULL, NULL, NULL, NULL, NULL, NULL, b'0', 'Client 4', NULL, NULL, NULL, NULL, 2, NULL),
('IdCE5', NULL, NULL, NULL, NULL, NULL, NULL, b'0', 'Client 5', NULL, NULL, NULL, NULL, 3, NULL),
('IdCE6', NULL, NULL, NULL, NULL, NULL, NULL, b'0', 'Client 6', NULL, NULL, NULL, NULL, 2, NULL),
('IdCE7', NULL, NULL, NULL, NULL, NULL, NULL, b'0', 'Client 7', NULL, NULL, NULL, NULL, 3, NULL),
('IdCE8', NULL, NULL, NULL, NULL, NULL, NULL, b'0', 'Client 8', NULL, NULL, NULL, NULL, 2, NULL),
('IdCE9', NULL, NULL, NULL, NULL, NULL, NULL, b'0', 'Client 9', NULL, NULL, NULL, NULL, 3, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `colis`
--

CREATE TABLE `colis` (
  `num_commande` varchar(255) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `adresse` text,
  `application_frais` bit(1) NOT NULL,
  `application_frais_assurance` bit(1) NOT NULL,
  `code_envoi` varchar(255) DEFAULT NULL,
  `date_livraison` datetime(6) DEFAULT NULL,
  `date_ramassage` datetime(6) DEFAULT NULL,
  `destinataire` varchar(255) DEFAULT NULL,
  `disabled` bit(1) NOT NULL,
  `facturer` bit(1) NOT NULL,
  `facturer_client` bit(1) NOT NULL,
  `id_intern` varchar(255) DEFAULT NULL,
  `nom_complet` varchar(255) DEFAULT NULL,
  `ouverture_colis` bit(1) NOT NULL,
  `remarque` text,
  `secteur` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `type_livraison` varchar(255) DEFAULT NULL,
  `bon_expedition_nom` varchar(255) DEFAULT NULL,
  `bon_ramassage_nom` varchar(255) DEFAULT NULL,
  `bon_retour_nom` varchar(255) DEFAULT NULL,
  `business_id` bigint DEFAULT NULL,
  `client_ice` varchar(255) DEFAULT NULL,
  `entite_id` bigint DEFAULT NULL,
  `facture_name` varchar(255) DEFAULT NULL,
  `livreur_email` varchar(255) DEFAULT NULL,
  `ramasseur_email` varchar(255) DEFAULT NULL,
  `status_id` varchar(255) DEFAULT NULL,
  `ville_destination_nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `colis`
--

INSERT INTO `colis` (`num_commande`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `adresse`, `application_frais`, `application_frais_assurance`, `code_envoi`, `date_livraison`, `date_ramassage`, `destinataire`, `disabled`, `facturer`, `facturer_client`, `id_intern`, `nom_complet`, `ouverture_colis`, `remarque`, `secteur`, `telephone`, `type_livraison`, `bon_expedition_nom`, `bon_ramassage_nom`, `bon_retour_nom`, `business_id`, `client_ice`, `entite_id`, `facture_name`, `livreur_email`, `ramasseur_email`, `status_id`, `ville_destination_nom`) VALUES
('XPR1032MA-10000', 'SuperAdmin', '2021-05-14 13:32:33.393000', NULL, NULL, 'addresse0', b'1', b'0', 'XPR1032MA0', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern0', 'Houssam Houssam 0', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10001', 'SuperAdmin', '2021-05-15 13:32:33.432000', NULL, NULL, 'addresse1', b'1', b'0', 'XPR1032MA1', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern1', 'Houssam Houssam 1', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10002', 'SuperAdmin', '2021-05-16 13:32:33.449000', NULL, NULL, 'addresse2', b'1', b'0', 'XPR1032MA2', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern2', 'Houssam Houssam 2', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10003', 'SuperAdmin', '2021-05-17 13:32:33.476000', NULL, NULL, 'addresse3', b'1', b'0', 'XPR1032MA3', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern3', 'Houssam Houssam 3', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10004', 'SuperAdmin', '2021-05-18 13:32:33.498000', NULL, NULL, 'addresse4', b'1', b'0', 'XPR1032MA4', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern4', 'Houssam Houssam 4', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10005', 'SuperAdmin', '2021-05-19 13:32:33.516000', NULL, NULL, 'addresse5', b'1', b'0', 'XPR1032MA5', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern5', 'Houssam Houssam 5', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10006', 'SuperAdmin', '2021-05-20 13:32:33.532000', NULL, NULL, 'addresse6', b'1', b'0', 'XPR1032MA6', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern6', 'Houssam Houssam 6', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10007', 'SuperAdmin', '2021-05-21 13:32:33.551000', NULL, NULL, 'addresse7', b'1', b'0', 'XPR1032MA7', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern7', 'Houssam Houssam 7', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10008', 'SuperAdmin', '2021-05-22 13:32:33.574000', NULL, NULL, 'addresse8', b'1', b'0', 'XPR1032MA8', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern8', 'Houssam Houssam 8', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10009', 'SuperAdmin', '2021-05-23 13:32:33.598000', NULL, NULL, 'addresse9', b'1', b'0', 'XPR1032MA9', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern9', 'Houssam Houssam 9', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10010', 'SuperAdmin', '2021-05-24 13:32:33.630000', NULL, NULL, 'addresse10', b'1', b'0', 'XPR1032MA10', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern10', 'Houssam Houssam 10', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10011', 'SuperAdmin', '2021-05-25 13:32:33.653000', NULL, NULL, 'addresse11', b'1', b'0', 'XPR1032MA11', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern11', 'Houssam Houssam 11', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10012', 'SuperAdmin', '2021-05-26 13:32:33.705000', NULL, NULL, 'addresse12', b'1', b'0', 'XPR1032MA12', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern12', 'Houssam Houssam 12', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10013', 'SuperAdmin', '2021-05-27 13:32:33.740000', NULL, NULL, 'addresse13', b'1', b'0', 'XPR1032MA13', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern13', 'Houssam Houssam 13', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10014', 'SuperAdmin', '2021-05-28 13:32:33.763000', NULL, NULL, 'addresse14', b'1', b'0', 'XPR1032MA14', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern14', 'Houssam Houssam 14', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10015', 'SuperAdmin', '2021-05-29 13:32:33.785000', NULL, NULL, 'addresse15', b'1', b'0', 'XPR1032MA15', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern15', 'Houssam Houssam 15', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10016', 'SuperAdmin', '2021-05-30 13:32:33.806000', NULL, NULL, 'addresse16', b'1', b'0', 'XPR1032MA16', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern16', 'Houssam Houssam 16', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10017', 'SuperAdmin', '2021-05-31 13:32:33.831000', NULL, NULL, 'addresse17', b'1', b'0', 'XPR1032MA17', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern17', 'Houssam Houssam 17', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10018', 'SuperAdmin', '2021-06-01 13:32:33.880000', NULL, NULL, 'addresse18', b'1', b'0', 'XPR1032MA18', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern18', 'Houssam Houssam 18', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10019', 'SuperAdmin', '2021-06-02 13:32:33.919000', NULL, NULL, 'addresse19', b'1', b'0', 'XPR1032MA19', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern19', 'Houssam Houssam 19', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10020', 'SuperAdmin', '2021-06-03 13:32:33.958000', NULL, NULL, 'addresse20', b'1', b'0', 'XPR1032MA20', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern20', 'Houssam Houssam 20', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10021', 'SuperAdmin', '2021-06-04 13:32:33.977000', NULL, NULL, 'addresse21', b'1', b'0', 'XPR1032MA21', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern21', 'Houssam Houssam 21', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10022', 'SuperAdmin', '2021-06-05 13:32:34.002000', NULL, NULL, 'addresse22', b'1', b'0', 'XPR1032MA22', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern22', 'Houssam Houssam 22', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10023', 'SuperAdmin', '2021-06-06 13:32:34.030000', NULL, NULL, 'addresse23', b'1', b'0', 'XPR1032MA23', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern23', 'Houssam Houssam 23', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10024', 'SuperAdmin', '2021-06-07 13:32:34.050000', NULL, NULL, 'addresse24', b'1', b'0', 'XPR1032MA24', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern24', 'Houssam Houssam 24', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10025', 'SuperAdmin', '2021-06-08 13:32:34.067000', NULL, NULL, 'addresse25', b'1', b'0', 'XPR1032MA25', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern25', 'Houssam Houssam 25', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10026', 'SuperAdmin', '2021-06-09 13:32:34.099000', NULL, NULL, 'addresse26', b'1', b'0', 'XPR1032MA26', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern26', 'Houssam Houssam 26', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10027', 'SuperAdmin', '2021-06-10 13:32:34.135000', NULL, NULL, 'addresse27', b'1', b'0', 'XPR1032MA27', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern27', 'Houssam Houssam 27', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10028', 'SuperAdmin', '2021-06-11 13:32:34.163000', NULL, NULL, 'addresse28', b'1', b'0', 'XPR1032MA28', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern28', 'Houssam Houssam 28', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10029', 'SuperAdmin', '2021-06-12 13:32:34.180000', NULL, NULL, 'addresse29', b'1', b'0', 'XPR1032MA29', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern29', 'Houssam Houssam 29', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10030', 'SuperAdmin', '2021-06-13 13:32:34.196000', NULL, NULL, 'addresse30', b'1', b'0', 'XPR1032MA30', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern30', 'Houssam Houssam 30', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10031', 'SuperAdmin', '2021-06-14 13:32:34.211000', NULL, NULL, 'addresse31', b'1', b'0', 'XPR1032MA31', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern31', 'Houssam Houssam 31', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10032', 'SuperAdmin', '2021-06-15 13:32:34.227000', NULL, NULL, 'addresse32', b'1', b'0', 'XPR1032MA32', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern32', 'Houssam Houssam 32', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10033', 'SuperAdmin', '2021-06-16 13:32:34.242000', NULL, NULL, 'addresse33', b'1', b'0', 'XPR1032MA33', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern33', 'Houssam Houssam 33', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10034', 'SuperAdmin', '2021-06-17 13:32:34.261000', NULL, NULL, 'addresse34', b'1', b'0', 'XPR1032MA34', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern34', 'Houssam Houssam 34', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10035', 'SuperAdmin', '2021-06-18 13:32:34.307000', NULL, NULL, 'addresse35', b'1', b'0', 'XPR1032MA35', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern35', 'Houssam Houssam 35', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10036', 'SuperAdmin', '2021-06-19 13:32:34.331000', NULL, NULL, 'addresse36', b'1', b'0', 'XPR1032MA36', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern36', 'Houssam Houssam 36', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10037', 'SuperAdmin', '2021-06-20 13:32:34.350000', NULL, NULL, 'addresse37', b'1', b'0', 'XPR1032MA37', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern37', 'Houssam Houssam 37', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10038', 'SuperAdmin', '2021-06-21 13:32:34.366000', NULL, NULL, 'addresse38', b'1', b'0', 'XPR1032MA38', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern38', 'Houssam Houssam 38', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10039', 'SuperAdmin', '2021-06-22 13:32:34.385000', NULL, NULL, 'addresse39', b'1', b'0', 'XPR1032MA39', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern39', 'Houssam Houssam 39', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10040', 'SuperAdmin', '2021-06-23 13:32:34.433000', NULL, NULL, 'addresse40', b'1', b'0', 'XPR1032MA40', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern40', 'Houssam Houssam 40', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10041', 'SuperAdmin', '2021-06-24 13:32:34.457000', NULL, NULL, 'addresse41', b'1', b'0', 'XPR1032MA41', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern41', 'Houssam Houssam 41', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10042', 'SuperAdmin', '2021-06-25 13:32:34.484000', NULL, NULL, 'addresse42', b'1', b'0', 'XPR1032MA42', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern42', 'Houssam Houssam 42', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10043', 'SuperAdmin', '2021-06-26 13:32:34.501000', NULL, NULL, 'addresse43', b'1', b'0', 'XPR1032MA43', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern43', 'Houssam Houssam 43', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10044', 'SuperAdmin', '2021-06-27 13:32:34.516000', NULL, NULL, 'addresse44', b'1', b'0', 'XPR1032MA44', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern44', 'Houssam Houssam 44', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10045', 'SuperAdmin', '2021-06-28 13:32:34.539000', NULL, NULL, 'addresse45', b'1', b'0', 'XPR1032MA45', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern45', 'Houssam Houssam 45', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10046', 'SuperAdmin', '2021-06-29 13:32:34.564000', NULL, NULL, 'addresse46', b'1', b'0', 'XPR1032MA46', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern46', 'Houssam Houssam 46', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10047', 'SuperAdmin', '2021-06-30 13:32:34.581000', NULL, NULL, 'addresse47', b'1', b'0', 'XPR1032MA47', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern47', 'Houssam Houssam 47', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10048', 'SuperAdmin', '2021-07-01 13:32:34.605000', NULL, NULL, 'addresse48', b'1', b'0', 'XPR1032MA48', NULL, NULL, 'destinataire1', b'0', b'0', b'0', 'idIntern48', 'Houssam Houssam 48', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, NULL, 'EN ATTENTE DE RAMASSAGE', 'Casa'),
('XPR1032MA-10049', 'SuperAdmin', '2021-07-02 13:32:34.623000', NULL, NULL, 'addresse49', b'1', b'0', 'XPR1032MA49', NULL, '2021-05-14 13:32:36.069000', 'destinataire1', b'0', b'0', b'0', 'idIntern49', 'Houssam Houssam 49', b'0', NULL, NULL, '06 20 67 47 78', 'A domicile', NULL, NULL, NULL, NULL, 'ice1', 1, NULL, NULL, 'ramasseur1@xpr.com', 'RÉCEPSSIONÉ SUR AGENCE', 'Casa');

-- --------------------------------------------------------

--
-- Table structure for table `commentaires`
--

CREATE TABLE `commentaires` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `commentaire` varchar(255) DEFAULT NULL,
  `date_creation` datetime(6) DEFAULT NULL,
  `colis_num_commande` varchar(255) DEFAULT NULL,
  `utilisateur_email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `commentaires`
--

INSERT INTO `commentaires` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `commentaire`, `date_creation`, `colis_num_commande`, `utilisateur_email`) VALUES
(1, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:33.393000', 'XPR1032MA-10000', 'managerXPR@xpr.com'),
(2, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:33.432000', 'XPR1032MA-10001', 'managerXPR@xpr.com'),
(3, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:33.449000', 'XPR1032MA-10002', 'managerXPR@xpr.com'),
(4, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:33.476000', 'XPR1032MA-10003', 'managerXPR@xpr.com'),
(5, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:33.498000', 'XPR1032MA-10004', 'managerXPR@xpr.com'),
(6, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:33.516000', 'XPR1032MA-10005', 'managerXPR@xpr.com'),
(7, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:33.532000', 'XPR1032MA-10006', 'managerXPR@xpr.com'),
(8, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:33.551000', 'XPR1032MA-10007', 'managerXPR@xpr.com'),
(9, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:33.574000', 'XPR1032MA-10008', 'managerXPR@xpr.com'),
(10, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:33.598000', 'XPR1032MA-10009', 'managerXPR@xpr.com'),
(11, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:33.630000', 'XPR1032MA-10010', 'managerXPR@xpr.com'),
(12, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:33.653000', 'XPR1032MA-10011', 'managerXPR@xpr.com'),
(13, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:33.705000', 'XPR1032MA-10012', 'managerXPR@xpr.com'),
(14, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:33.737000', 'XPR1032MA-10013', 'managerXPR@xpr.com'),
(15, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:33.763000', 'XPR1032MA-10014', 'managerXPR@xpr.com'),
(16, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:33.785000', 'XPR1032MA-10015', 'managerXPR@xpr.com'),
(17, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:33.806000', 'XPR1032MA-10016', 'managerXPR@xpr.com'),
(18, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:33.831000', 'XPR1032MA-10017', 'managerXPR@xpr.com'),
(19, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:33.880000', 'XPR1032MA-10018', 'managerXPR@xpr.com'),
(20, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:33.919000', 'XPR1032MA-10019', 'managerXPR@xpr.com'),
(21, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:33.958000', 'XPR1032MA-10020', 'managerXPR@xpr.com'),
(22, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:33.977000', 'XPR1032MA-10021', 'managerXPR@xpr.com'),
(23, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:34.002000', 'XPR1032MA-10022', 'managerXPR@xpr.com'),
(24, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:34.030000', 'XPR1032MA-10023', 'managerXPR@xpr.com'),
(25, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:34.050000', 'XPR1032MA-10024', 'managerXPR@xpr.com'),
(26, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:34.067000', 'XPR1032MA-10025', 'managerXPR@xpr.com'),
(27, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:34.099000', 'XPR1032MA-10026', 'managerXPR@xpr.com'),
(28, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:34.135000', 'XPR1032MA-10027', 'managerXPR@xpr.com'),
(29, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:34.163000', 'XPR1032MA-10028', 'managerXPR@xpr.com'),
(30, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:34.180000', 'XPR1032MA-10029', 'managerXPR@xpr.com'),
(31, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:34.196000', 'XPR1032MA-10030', 'managerXPR@xpr.com'),
(32, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:34.211000', 'XPR1032MA-10031', 'managerXPR@xpr.com'),
(33, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:34.227000', 'XPR1032MA-10032', 'managerXPR@xpr.com'),
(34, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:34.242000', 'XPR1032MA-10033', 'managerXPR@xpr.com'),
(35, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:34.261000', 'XPR1032MA-10034', 'managerXPR@xpr.com'),
(36, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:34.307000', 'XPR1032MA-10035', 'managerXPR@xpr.com'),
(37, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:34.331000', 'XPR1032MA-10036', 'managerXPR@xpr.com'),
(38, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:34.350000', 'XPR1032MA-10037', 'managerXPR@xpr.com'),
(39, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:34.366000', 'XPR1032MA-10038', 'managerXPR@xpr.com'),
(40, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:34.385000', 'XPR1032MA-10039', 'managerXPR@xpr.com'),
(41, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:34.433000', 'XPR1032MA-10040', 'managerXPR@xpr.com'),
(42, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:34.457000', 'XPR1032MA-10041', 'managerXPR@xpr.com'),
(43, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:34.484000', 'XPR1032MA-10042', 'managerXPR@xpr.com'),
(44, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:34.501000', 'XPR1032MA-10043', 'managerXPR@xpr.com'),
(45, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:34.516000', 'XPR1032MA-10044', 'managerXPR@xpr.com'),
(46, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:34.539000', 'XPR1032MA-10045', 'managerXPR@xpr.com'),
(47, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:34.564000', 'XPR1032MA-10046', 'managerXPR@xpr.com'),
(48, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:34.580000', 'XPR1032MA-10047', 'managerXPR@xpr.com'),
(49, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:34.605000', 'XPR1032MA-10048', 'managerXPR@xpr.com'),
(50, NULL, NULL, NULL, NULL, 'merci de le livrer au plus vite', '2021-05-14 13:32:34.623000', 'XPR1032MA-10049', 'managerXPR@xpr.com');

-- --------------------------------------------------------

--
-- Table structure for table `contrats`
--

CREATE TABLE `contrats` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `date_debut` datetime(6) DEFAULT NULL,
  `date_fin` datetime(6) DEFAULT NULL,
  `prix_annulation` double NOT NULL,
  `prix_livraison` double NOT NULL,
  `client_ice` varchar(255) DEFAULT NULL,
  `entite_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `contrats`
--

INSERT INTO `contrats` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `date_debut`, `date_fin`, `prix_annulation`, `prix_livraison`, `client_ice`, `entite_id`) VALUES
(1, NULL, NULL, NULL, NULL, '2021-05-14 13:32:32.826000', NULL, 0, 10, 'iceClient1', 1);

-- --------------------------------------------------------

--
-- Table structure for table `demandes`
--

CREATE TABLE `demandes` (
  `nom` varchar(255) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `date_creation` date DEFAULT NULL,
  `date_modification` date DEFAULT NULL,
  `departement` varchar(255) DEFAULT NULL,
  `disabled` bit(1) NOT NULL,
  `evaluation` int NOT NULL,
  `objet` varchar(255) DEFAULT NULL,
  `priorite` varchar(255) DEFAULT NULL,
  `resolu` bit(1) NOT NULL,
  `statut` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `business_id` bigint DEFAULT NULL,
  `client_ice` varchar(255) DEFAULT NULL,
  `creer_par_email` varchar(255) DEFAULT NULL,
  `modifier_par_email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `entite`
--

CREATE TABLE `entite` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `entite_parent_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `entite`
--

INSERT INTO `entite` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `nom`, `entite_parent_id`) VALUES
(1, NULL, NULL, NULL, NULL, 'XPR', NULL),
(2, NULL, NULL, NULL, NULL, 'MEL', NULL),
(3, NULL, NULL, NULL, NULL, 'CTM', NULL),
(4, NULL, NULL, NULL, NULL, 'SEM', 1);

-- --------------------------------------------------------

--
-- Table structure for table `factures`
--

CREATE TABLE `factures` (
  `name` varchar(255) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `date_creation` datetime(6) DEFAULT NULL,
  `disabled` bit(1) NOT NULL,
  `nbr_colis` int NOT NULL,
  `statut` varchar(255) DEFAULT NULL,
  `statut_avec_agence` varchar(255) DEFAULT NULL,
  `total_crbt` double NOT NULL,
  `total_frais` double NOT NULL,
  `total_net` double NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `type_reglement` varchar(255) DEFAULT NULL,
  `creer_par_email` varchar(255) DEFAULT NULL,
  `entite_id` bigint DEFAULT NULL,
  `livreur_email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `factures_client`
--

CREATE TABLE `factures_client` (
  `name` varchar(255) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `date_creation` datetime(6) DEFAULT NULL,
  `disabled` bit(1) NOT NULL,
  `nbr_colis` int NOT NULL,
  `statut` varchar(255) DEFAULT NULL,
  `statut_avec_client` varchar(255) DEFAULT NULL,
  `total_crbt` double NOT NULL,
  `total_frais` double NOT NULL,
  `total_net` double NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `type_reglement` varchar(255) DEFAULT NULL,
  `client_ice` varchar(255) DEFAULT NULL,
  `creer_par_email` varchar(255) DEFAULT NULL,
  `livreur_email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `factures_clients`
--

CREATE TABLE `factures_clients` (
  `facture_name` varchar(255) NOT NULL,
  `clients_ice` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `historiques`
--

CREATE TABLE `historiques` (
  `dtype` varchar(31) NOT NULL,
  `id` bigint NOT NULL,
  `action` varchar(255) DEFAULT NULL,
  `date_creation` datetime(6) DEFAULT NULL,
  `disabled` bit(1) NOT NULL,
  `statut` varchar(255) DEFAULT NULL,
  `utilisateur_email` varchar(255) DEFAULT NULL,
  `bon_expedition_nom` varchar(255) DEFAULT NULL,
  `bon_ramassage_nom` varchar(255) DEFAULT NULL,
  `bon_retour_nom` varchar(255) DEFAULT NULL,
  `colis_num_commande` varchar(255) DEFAULT NULL,
  `demande_nom` varchar(255) DEFAULT NULL,
  `stock_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `historiques`
--

INSERT INTO `historiques` (`dtype`, `id`, `action`, `date_creation`, `disabled`, `statut`, `utilisateur_email`, `bon_expedition_nom`, `bon_ramassage_nom`, `bon_retour_nom`, `colis_num_commande`, `demande_nom`, `stock_id`) VALUES
('HistoriqueColis', 1, 'Affectation du ramasseur', '2021-05-14 13:32:33.409000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10000', NULL, NULL),
('HistoriqueColis', 2, 'Affectation du ramasseur', '2021-05-14 13:32:33.439000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10001', NULL, NULL),
('HistoriqueColis', 3, 'Affectation du ramasseur', '2021-05-14 13:32:33.459000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10002', NULL, NULL),
('HistoriqueColis', 4, 'Affectation du ramasseur', '2021-05-14 13:32:33.483000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10003', NULL, NULL),
('HistoriqueColis', 5, 'Affectation du ramasseur', '2021-05-14 13:32:33.506000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10004', NULL, NULL),
('HistoriqueColis', 6, 'Affectation du ramasseur', '2021-05-14 13:32:33.522000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10005', NULL, NULL),
('HistoriqueColis', 7, 'Affectation du ramasseur', '2021-05-14 13:32:33.538000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10006', NULL, NULL),
('HistoriqueColis', 8, 'Affectation du ramasseur', '2021-05-14 13:32:33.560000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10007', NULL, NULL),
('HistoriqueColis', 9, 'Affectation du ramasseur', '2021-05-14 13:32:33.582000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10008', NULL, NULL),
('HistoriqueColis', 10, 'Affectation du ramasseur', '2021-05-14 13:32:33.610000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10009', NULL, NULL),
('HistoriqueColis', 11, 'Affectation du ramasseur', '2021-05-14 13:32:33.639000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10010', NULL, NULL),
('HistoriqueColis', 12, 'Affectation du ramasseur', '2021-05-14 13:32:33.670000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10011', NULL, NULL),
('HistoriqueColis', 13, 'Affectation du ramasseur', '2021-05-14 13:32:33.715000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10012', NULL, NULL),
('HistoriqueColis', 14, 'Affectation du ramasseur', '2021-05-14 13:32:33.749000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10013', NULL, NULL),
('HistoriqueColis', 15, 'Affectation du ramasseur', '2021-05-14 13:32:33.772000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10014', NULL, NULL),
('HistoriqueColis', 16, 'Affectation du ramasseur', '2021-05-14 13:32:33.794000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10015', NULL, NULL),
('HistoriqueColis', 17, 'Affectation du ramasseur', '2021-05-14 13:32:33.812000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10016', NULL, NULL),
('HistoriqueColis', 18, 'Affectation du ramasseur', '2021-05-14 13:32:33.845000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10017', NULL, NULL),
('HistoriqueColis', 19, 'Affectation du ramasseur', '2021-05-14 13:32:33.890000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10018', NULL, NULL),
('HistoriqueColis', 20, 'Affectation du ramasseur', '2021-05-14 13:32:33.926000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10019', NULL, NULL),
('HistoriqueColis', 21, 'Affectation du ramasseur', '2021-05-14 13:32:33.966000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10020', NULL, NULL),
('HistoriqueColis', 22, 'Affectation du ramasseur', '2021-05-14 13:32:33.983000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10021', NULL, NULL),
('HistoriqueColis', 23, 'Affectation du ramasseur', '2021-05-14 13:32:34.013000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10022', NULL, NULL),
('HistoriqueColis', 24, 'Affectation du ramasseur', '2021-05-14 13:32:34.037000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10023', NULL, NULL),
('HistoriqueColis', 25, 'Affectation du ramasseur', '2021-05-14 13:32:34.057000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10024', NULL, NULL),
('HistoriqueColis', 26, 'Affectation du ramasseur', '2021-05-14 13:32:34.076000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10025', NULL, NULL),
('HistoriqueColis', 27, 'Affectation du ramasseur', '2021-05-14 13:32:34.114000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10026', NULL, NULL),
('HistoriqueColis', 28, 'Affectation du ramasseur', '2021-05-14 13:32:34.148000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10027', NULL, NULL),
('HistoriqueColis', 29, 'Affectation du ramasseur', '2021-05-14 13:32:34.170000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10028', NULL, NULL),
('HistoriqueColis', 30, 'Affectation du ramasseur', '2021-05-14 13:32:34.187000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10029', NULL, NULL),
('HistoriqueColis', 31, 'Affectation du ramasseur', '2021-05-14 13:32:34.202000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10030', NULL, NULL),
('HistoriqueColis', 32, 'Affectation du ramasseur', '2021-05-14 13:32:34.217000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10031', NULL, NULL),
('HistoriqueColis', 33, 'Affectation du ramasseur', '2021-05-14 13:32:34.232000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10032', NULL, NULL),
('HistoriqueColis', 34, 'Affectation du ramasseur', '2021-05-14 13:32:34.247000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10033', NULL, NULL),
('HistoriqueColis', 35, 'Affectation du ramasseur', '2021-05-14 13:32:34.276000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10034', NULL, NULL),
('HistoriqueColis', 36, 'Affectation du ramasseur', '2021-05-14 13:32:34.316000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10035', NULL, NULL),
('HistoriqueColis', 37, 'Affectation du ramasseur', '2021-05-14 13:32:34.339000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10036', NULL, NULL),
('HistoriqueColis', 38, 'Affectation du ramasseur', '2021-05-14 13:32:34.356000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10037', NULL, NULL),
('HistoriqueColis', 39, 'Affectation du ramasseur', '2021-05-14 13:32:34.372000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10038', NULL, NULL),
('HistoriqueColis', 40, 'Affectation du ramasseur', '2021-05-14 13:32:34.406000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10039', NULL, NULL),
('HistoriqueColis', 41, 'Affectation du ramasseur', '2021-05-14 13:32:34.442000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10040', NULL, NULL),
('HistoriqueColis', 42, 'Affectation du ramasseur', '2021-05-14 13:32:34.469000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10041', NULL, NULL),
('HistoriqueColis', 43, 'Affectation du ramasseur', '2021-05-14 13:32:34.491000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10042', NULL, NULL),
('HistoriqueColis', 44, 'Affectation du ramasseur', '2021-05-14 13:32:34.506000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10043', NULL, NULL),
('HistoriqueColis', 45, 'Affectation du ramasseur', '2021-05-14 13:32:34.525000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10044', NULL, NULL),
('HistoriqueColis', 46, 'Affectation du ramasseur', '2021-05-14 13:32:34.551000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10045', NULL, NULL),
('HistoriqueColis', 47, 'Affectation du ramasseur', '2021-05-14 13:32:34.570000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10046', NULL, NULL),
('HistoriqueColis', 48, 'Affectation du ramasseur', '2021-05-14 13:32:34.590000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10047', NULL, NULL),
('HistoriqueColis', 49, 'Affectation du ramasseur', '2021-05-14 13:32:34.611000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10048', NULL, NULL),
('HistoriqueColis', 50, 'Affectation du ramasseur', '2021-05-14 13:32:34.628000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10049', NULL, NULL),
('HistoriqueColis', 51, 'creer nouveau colis', '2021-05-14 13:32:34.642000', b'0', 'En Attente de ramassage', 'managerXPR@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10049', NULL, NULL),
('HistoriqueColis', 52, 'réception colis sur agenceFes', '2021-05-14 13:32:36.119000', b'0', 'expeide', 'managerSEM@xpr.com', NULL, NULL, NULL, 'XPR1032MA-10049', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `ligne_bon_expeditions`
--

CREATE TABLE `ligne_bon_expeditions` (
  `id` bigint NOT NULL,
  `bon_expedition_nom` varchar(255) DEFAULT NULL,
  `colis_num_commande` varchar(255) DEFAULT NULL,
  `ligne_colis_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ligne_bon_retours`
--

CREATE TABLE `ligne_bon_retours` (
  `id` bigint NOT NULL,
  `qte_retourne` int NOT NULL,
  `bon_retour_nom` varchar(255) DEFAULT NULL,
  `colis_num_commande` varchar(255) DEFAULT NULL,
  `ligne_colis_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ligne_colis`
--

CREATE TABLE `ligne_colis` (
  `id` bigint NOT NULL,
  `prix` double DEFAULT NULL,
  `qte` int NOT NULL,
  `qte_livre` int NOT NULL,
  `qte_retourne` int NOT NULL,
  `bon_retour_nom` varchar(255) DEFAULT NULL,
  `business_id` bigint DEFAULT NULL,
  `colis_num_commande` varchar(255) DEFAULT NULL,
  `produit_id` bigint DEFAULT NULL,
  `stock_id` bigint DEFAULT NULL,
  `variante_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `ligne_colis`
--

INSERT INTO `ligne_colis` (`id`, `prix`, `qte`, `qte_livre`, `qte_retourne`, `bon_retour_nom`, `business_id`, `colis_num_commande`, `produit_id`, `stock_id`, `variante_id`) VALUES
(1, 1200, 2, 0, 0, NULL, NULL, 'XPR1032MA-10000', 1, NULL, NULL),
(2, 1200, 3, 0, 0, NULL, NULL, 'XPR1032MA-10001', 2, NULL, NULL),
(3, 1200, 4, 0, 0, NULL, NULL, 'XPR1032MA-10002', 3, NULL, NULL),
(4, 1200, 5, 0, 0, NULL, NULL, 'XPR1032MA-10003', 4, NULL, NULL),
(5, 1200, 6, 0, 0, NULL, NULL, 'XPR1032MA-10004', 5, NULL, NULL),
(6, 1200, 7, 0, 0, NULL, NULL, 'XPR1032MA-10005', 6, NULL, NULL),
(7, 1200, 8, 0, 0, NULL, NULL, 'XPR1032MA-10006', 7, NULL, NULL),
(8, 1200, 9, 0, 0, NULL, NULL, 'XPR1032MA-10007', 8, NULL, NULL),
(9, 1200, 10, 0, 0, NULL, NULL, 'XPR1032MA-10008', 9, NULL, NULL),
(10, 1200, 11, 0, 0, NULL, NULL, 'XPR1032MA-10009', 10, NULL, NULL),
(11, 1200, 12, 0, 0, NULL, NULL, 'XPR1032MA-10010', 11, NULL, NULL),
(12, 1200, 13, 0, 0, NULL, NULL, 'XPR1032MA-10011', 12, NULL, NULL),
(13, 1200, 14, 0, 0, NULL, NULL, 'XPR1032MA-10012', 13, NULL, NULL),
(14, 1200, 15, 0, 0, NULL, NULL, 'XPR1032MA-10013', 14, NULL, NULL),
(15, 1200, 16, 0, 0, NULL, NULL, 'XPR1032MA-10014', 15, NULL, NULL),
(16, 1200, 17, 0, 0, NULL, NULL, 'XPR1032MA-10015', 16, NULL, NULL),
(17, 1200, 18, 0, 0, NULL, NULL, 'XPR1032MA-10016', 17, NULL, NULL),
(18, 1200, 19, 0, 0, NULL, NULL, 'XPR1032MA-10017', 18, NULL, NULL),
(19, 1200, 20, 0, 0, NULL, NULL, 'XPR1032MA-10018', 19, NULL, NULL),
(20, 1200, 21, 0, 0, NULL, NULL, 'XPR1032MA-10019', 20, NULL, NULL),
(21, 1200, 22, 0, 0, NULL, NULL, 'XPR1032MA-10020', 21, NULL, NULL),
(22, 1200, 23, 0, 0, NULL, NULL, 'XPR1032MA-10021', 22, NULL, NULL),
(23, 1200, 24, 0, 0, NULL, NULL, 'XPR1032MA-10022', 23, NULL, NULL),
(24, 1200, 25, 0, 0, NULL, NULL, 'XPR1032MA-10023', 24, NULL, NULL),
(25, 1200, 26, 0, 0, NULL, NULL, 'XPR1032MA-10024', 25, NULL, NULL),
(26, 1200, 27, 0, 0, NULL, NULL, 'XPR1032MA-10025', 26, NULL, NULL),
(27, 1200, 28, 0, 0, NULL, NULL, 'XPR1032MA-10026', 27, NULL, NULL),
(28, 1200, 29, 0, 0, NULL, NULL, 'XPR1032MA-10027', 28, NULL, NULL),
(29, 1200, 30, 0, 0, NULL, NULL, 'XPR1032MA-10028', 29, NULL, NULL),
(30, 1200, 31, 0, 0, NULL, NULL, 'XPR1032MA-10029', 30, NULL, NULL),
(31, 1200, 32, 0, 0, NULL, NULL, 'XPR1032MA-10030', 31, NULL, NULL),
(32, 1200, 33, 0, 0, NULL, NULL, 'XPR1032MA-10031', 32, NULL, NULL),
(33, 1200, 34, 0, 0, NULL, NULL, 'XPR1032MA-10032', 33, NULL, NULL),
(34, 1200, 35, 0, 0, NULL, NULL, 'XPR1032MA-10033', 34, NULL, NULL),
(35, 1200, 36, 0, 0, NULL, NULL, 'XPR1032MA-10034', 35, NULL, NULL),
(36, 1200, 37, 0, 0, NULL, NULL, 'XPR1032MA-10035', 36, NULL, NULL),
(37, 1200, 38, 0, 0, NULL, NULL, 'XPR1032MA-10036', 37, NULL, NULL),
(38, 1200, 39, 0, 0, NULL, NULL, 'XPR1032MA-10037', 38, NULL, NULL),
(39, 1200, 40, 0, 0, NULL, NULL, 'XPR1032MA-10038', 39, NULL, NULL),
(40, 1200, 41, 0, 0, NULL, NULL, 'XPR1032MA-10039', 40, NULL, NULL),
(41, 1200, 42, 0, 0, NULL, NULL, 'XPR1032MA-10040', 41, NULL, NULL),
(42, 1200, 43, 0, 0, NULL, NULL, 'XPR1032MA-10041', 42, NULL, NULL),
(43, 1200, 44, 0, 0, NULL, NULL, 'XPR1032MA-10042', 43, NULL, NULL),
(44, 1200, 45, 0, 0, NULL, NULL, 'XPR1032MA-10043', 44, NULL, NULL),
(45, 1200, 46, 0, 0, NULL, NULL, 'XPR1032MA-10044', 45, NULL, NULL),
(46, 1200, 47, 0, 0, NULL, NULL, 'XPR1032MA-10045', 46, NULL, NULL),
(47, 1200, 48, 0, 0, NULL, NULL, 'XPR1032MA-10046', 47, NULL, NULL),
(48, 1200, 49, 0, 0, NULL, NULL, 'XPR1032MA-10047', 48, NULL, NULL),
(49, 1200, 50, 0, 0, NULL, NULL, 'XPR1032MA-10048', 49, NULL, NULL),
(50, 1200, 51, 0, 0, NULL, NULL, 'XPR1032MA-10049', 50, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `ligne_facture`
--

CREATE TABLE `ligne_facture` (
  `id` bigint NOT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `prix_facture` double NOT NULL,
  `qte` int NOT NULL,
  `facture_name` varchar(255) DEFAULT NULL,
  `ligne_colis_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ligne_facture_client`
--

CREATE TABLE `ligne_facture_client` (
  `id` bigint NOT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `prix_facture` double NOT NULL,
  `qte` int NOT NULL,
  `facture_client_name` varchar(255) DEFAULT NULL,
  `ligne_colis_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `log`
--

CREATE TABLE `log` (
  `id` int NOT NULL,
  `action` varchar(255) DEFAULT NULL,
  `archived` bit(1) NOT NULL,
  `incident_date` datetime(6) DEFAULT NULL,
  `new_value` text,
  `old_value` text,
  `subject` varchar(255) DEFAULT NULL,
  `subject_id` varchar(255) DEFAULT NULL,
  `triggered_by` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `news`
--

CREATE TABLE `news` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `grand_titre` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `notification`
--

CREATE TABLE `notification` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `is_read` bit(1) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `receiver_email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `produits`
--

CREATE TABLE `produits` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `dimension` varchar(255) DEFAULT NULL,
  `emballer` bit(1) NOT NULL,
  `id_intern` varchar(255) DEFAULT NULL,
  `marque` varchar(255) DEFAULT NULL,
  `nature` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `prix_originale` double DEFAULT NULL,
  `prix_vente` double DEFAULT NULL,
  `qte` int NOT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `client_ice` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `produits`
--

INSERT INTO `produits` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `dimension`, `emballer`, `id_intern`, `marque`, `nature`, `nom`, `photo`, `prix_originale`, `prix_vente`, `qte`, `reference`, `client_ice`) VALUES
(1, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit10', NULL, 1000, 1200, 2, NULL, NULL),
(2, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit11', NULL, 1000, 1200, 3, NULL, NULL),
(3, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit12', NULL, 1000, 1200, 4, NULL, NULL),
(4, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit13', NULL, 1000, 1200, 5, NULL, NULL),
(5, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit14', NULL, 1000, 1200, 6, NULL, NULL),
(6, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit15', NULL, 1000, 1200, 7, NULL, NULL),
(7, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit16', NULL, 1000, 1200, 8, NULL, NULL),
(8, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit17', NULL, 1000, 1200, 9, NULL, NULL),
(9, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit18', NULL, 1000, 1200, 10, NULL, NULL),
(10, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit19', NULL, 1000, 1200, 11, NULL, NULL),
(11, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit110', NULL, 1000, 1200, 12, NULL, NULL),
(12, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit111', NULL, 1000, 1200, 13, NULL, NULL),
(13, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit112', NULL, 1000, 1200, 14, NULL, NULL),
(14, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit113', NULL, 1000, 1200, 15, NULL, NULL),
(15, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit114', NULL, 1000, 1200, 16, NULL, NULL),
(16, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit115', NULL, 1000, 1200, 17, NULL, NULL),
(17, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit116', NULL, 1000, 1200, 18, NULL, NULL),
(18, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit117', NULL, 1000, 1200, 19, NULL, NULL),
(19, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit118', NULL, 1000, 1200, 20, NULL, NULL),
(20, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit119', NULL, 1000, 1200, 21, NULL, NULL),
(21, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit120', NULL, 1000, 1200, 22, NULL, NULL),
(22, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit121', NULL, 1000, 1200, 23, NULL, NULL),
(23, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit122', NULL, 1000, 1200, 24, NULL, NULL),
(24, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit123', NULL, 1000, 1200, 25, NULL, NULL),
(25, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit124', NULL, 1000, 1200, 26, NULL, NULL),
(26, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit125', NULL, 1000, 1200, 27, NULL, NULL),
(27, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit126', NULL, 1000, 1200, 28, NULL, NULL),
(28, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit127', NULL, 1000, 1200, 29, NULL, NULL),
(29, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit128', NULL, 1000, 1200, 30, NULL, NULL),
(30, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit129', NULL, 1000, 1200, 31, NULL, NULL),
(31, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit130', NULL, 1000, 1200, 32, NULL, NULL),
(32, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit131', NULL, 1000, 1200, 33, NULL, NULL),
(33, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit132', NULL, 1000, 1200, 34, NULL, NULL),
(34, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit133', NULL, 1000, 1200, 35, NULL, NULL),
(35, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit134', NULL, 1000, 1200, 36, NULL, NULL),
(36, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit135', NULL, 1000, 1200, 37, NULL, NULL),
(37, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit136', NULL, 1000, 1200, 38, NULL, NULL),
(38, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit137', NULL, 1000, 1200, 39, NULL, NULL),
(39, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit138', NULL, 1000, 1200, 40, NULL, NULL),
(40, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit139', NULL, 1000, 1200, 41, NULL, NULL),
(41, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit140', NULL, 1000, 1200, 42, NULL, NULL),
(42, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit141', NULL, 1000, 1200, 43, NULL, NULL),
(43, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit142', NULL, 1000, 1200, 44, NULL, NULL),
(44, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit143', NULL, 1000, 1200, 45, NULL, NULL),
(45, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit144', NULL, 1000, 1200, 46, NULL, NULL),
(46, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit145', NULL, 1000, 1200, 47, NULL, NULL),
(47, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit146', NULL, 1000, 1200, 48, NULL, NULL),
(48, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit147', NULL, 1000, 1200, 49, NULL, NULL),
(49, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit148', NULL, 1000, 1200, 50, NULL, NULL),
(50, NULL, NULL, NULL, NULL, NULL, b'0', NULL, NULL, NULL, 'produit149', NULL, 1000, 1200, 51, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `produit_stock_client`
--

CREATE TABLE `produit_stock_client` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `qte` int NOT NULL,
  `qte_en_cours_livraison` int NOT NULL,
  `qte_livre` int NOT NULL,
  `qte_non_livre` int NOT NULL,
  `agence_id` bigint DEFAULT NULL,
  `client_ice` varchar(255) DEFAULT NULL,
  `entite_id` bigint DEFAULT NULL,
  `produit_id` bigint DEFAULT NULL,
  `variante_id` bigint DEFAULT NULL,
  `ville_nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `profiles`
--

CREATE TABLE `profiles` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `prfl_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `profiles`
--

INSERT INTO `profiles` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `prfl_name`) VALUES
(1, NULL, NULL, NULL, NULL, 'Super Super Admin'),
(2, NULL, NULL, NULL, NULL, 'Super Admin'),
(3, NULL, NULL, NULL, NULL, 'Admin'),
(4, NULL, NULL, NULL, NULL, 'Client'),
(5, NULL, NULL, NULL, NULL, 'Manager'),
(6, NULL, NULL, NULL, NULL, 'Livreur'),
(7, NULL, NULL, NULL, NULL, 'Ramasseur');

-- --------------------------------------------------------

--
-- Table structure for table `profiles_autorisations`
--

CREATE TABLE `profiles_autorisations` (
  `profile_id` bigint NOT NULL,
  `autorisation_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `profiles_autorisations`
--

INSERT INTO `profiles_autorisations` (`profile_id`, `autorisation_id`) VALUES
(1, 1),
(1, 4),
(1, 7),
(1, 10),
(1, 13),
(1, 16),
(1, 19),
(1, 22),
(1, 25),
(1, 28),
(1, 31),
(1, 34),
(1, 37),
(1, 40),
(1, 43),
(1, 46),
(1, 49),
(1, 52),
(1, 55),
(1, 58),
(1, 61),
(1, 64),
(1, 67),
(1, 70),
(1, 73),
(1, 76),
(1, 79),
(1, 82),
(1, 85),
(1, 88),
(1, 91),
(1, 94),
(1, 97),
(1, 100),
(1, 103),
(1, 106),
(1, 109),
(1, 112),
(1, 115),
(1, 118),
(1, 121),
(1, 124),
(1, 127),
(1, 130),
(1, 133),
(1, 136),
(1, 139),
(1, 142),
(1, 145),
(1, 148),
(1, 151),
(1, 154),
(1, 157),
(1, 160),
(1, 163),
(1, 166),
(1, 169),
(1, 172),
(1, 175),
(1, 178);

-- --------------------------------------------------------

--
-- Table structure for table `statut_bon_expedition`
--

CREATE TABLE `statut_bon_expedition` (
  `code` varchar(255) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `statut_bon_ramassage`
--

CREATE TABLE `statut_bon_ramassage` (
  `code` varchar(255) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `statut_bon_ramassage`
--

INSERT INTO `statut_bon_ramassage` (`code`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `libelle`) VALUES
('EN ATTENTE DE RAMASSAGE', NULL, NULL, NULL, NULL, 'En Attente de ramassage'),
('RAMASSÉ', NULL, NULL, NULL, NULL, 'Ramassé');

-- --------------------------------------------------------

--
-- Table structure for table `statut_bon_retour`
--

CREATE TABLE `statut_bon_retour` (
  `code` varchar(255) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `statut_colis`
--

CREATE TABLE `statut_colis` (
  `code` varchar(255) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `statut_colis`
--

INSERT INTO `statut_colis` (`code`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `libelle`) VALUES
('EN ATTENTE DE LIVRAISON', NULL, NULL, NULL, NULL, 'En Attente de livraison'),
('EN ATTENTE DE RAMASSAGE', NULL, NULL, NULL, NULL, 'En Attente de ramassage'),
('LIVRÉ', NULL, NULL, NULL, NULL, 'Livré'),
('LIVRÉ PARTIELLEMENT', NULL, NULL, NULL, NULL, 'Livré partiellement'),
('NOUVEAU COLIS', NULL, NULL, NULL, NULL, 'Nouveau colis'),
('RÉCEPSSIONÉ SUR AGENCE', NULL, NULL, NULL, NULL, 'Récepssioné sur agence'),
('RETOURNÉ', NULL, NULL, NULL, NULL, 'Retourné');

-- --------------------------------------------------------

--
-- Table structure for table `statut_facture`
--

CREATE TABLE `statut_facture` (
  `code` varchar(255) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `statut_facture_client`
--

CREATE TABLE `statut_facture_client` (
  `code` varchar(255) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `dtype` varchar(31) NOT NULL,
  `email` varchar(255) NOT NULL,
  `cni` varchar(255) DEFAULT NULL,
  `disabled` bit(1) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `type_utilisateur` varchar(255) DEFAULT NULL,
  `client_ice` varchar(255) DEFAULT NULL,
  `entite_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`dtype`, `email`, `cni`, `disabled`, `nom`, `password`, `prenom`, `telephone`, `type_utilisateur`, `client_ice`, `entite_id`) VALUES
('Utilisateur', 'Admin', 'Admin', b'0', 'Admin', '$2a$10$ZYNDYL9yiNMM061p0BY/TODNr4foXpLEw3V7EzSYqimgdcyrocwCC', NULL, NULL, 'Utilisateur', 'iceXPR', 1),
('Utilisateur', 'client1@xpr.com', 'cniClient1', b'0', 'Client1 ', '$2a$10$ZaJOK1O0OMm5AJ.P0szB5eTr7nzgf2VzZnUgEHfrJ.hWs4ZA8ViKW', 'Client 1', NULL, 'Utilisateur', 'ice1', 1),
('Utilisateur', 'clientXPR@gmail.com', 'cniClient11', b'0', 'Client', '$2a$10$GPAilHN76cbN/J45QpLSNeb7Be7VstRbhkCf6BygimS1oKFSm7YF6', 'Client', NULL, 'Utilisateur', 'iceClient1', 1),
('Livreur', 'livreur1@xpr.com', 'CNILivreur1', b'0', 'nomlivreur1', '$2a$10$TzarLFJzjKAPoVP9JQk7Hut0Hf7iYGaEAFMcrGm0yqrum6grRacD2', 'prenomlivreur1', NULL, 'Livreur', NULL, 1),
('Livreur', 'livreur2@xpr.com', 'CNILivreur2', b'0', 'nomlivreur2', '$2a$10$2CmfHxX3w057LZCdzd.2u.mXtIMYyDJPOFUOVRfL2ygODtlPbSj6.', 'prenomlivreur2', NULL, 'Livreur', NULL, 1),
('Utilisateur', 'managerSEM@xpr.com', 'cniUserXpr2', b'0', 'userXpr2', '$2a$10$0TW78ZJ6TD9ugqnmxfS.S.YKXEYw8SZWxzN/nEiCfZrz6pDJSxSRu', NULL, NULL, 'Utilisateur', 'iceXPR', 4),
('Utilisateur', 'managerXPR@xpr.com', 'managerXPR@xpr.com', b'0', 'userXpr1', '$2a$10$SwdXkG1IyKG4j50cYhXgx.5USkUw07qmjk6VbH8/XFg5cR.XVis.6', NULL, NULL, 'Utilisateur', 'iceXPR', 1),
('Ramasseur', 'ramasseur1@xpr.com', 'CNIramasseur1', b'0', 'nomRamasseur1', '$2a$10$KfmuVoRlA6Tp9pCdNsnaUeMYMr6CVhEy3iC2AmXEuP9IgtknYqEqq', 'prenomRamasseur1', NULL, 'Ramasseur', NULL, NULL),
('Utilisateur', 'SuperAdmin', 'SuperAdmin', b'0', 'SuperAdmin', '$2a$10$spkRWSV6EiTQgadzz.q2FOeSQwEQbAYMVj5JeQNP2UHuUOwGtWBgy', NULL, NULL, 'Utilisateur', 'iceXPR', 1),
('Utilisateur', 'SuperSuperAdmin', 'SuperSuperAdmin', b'0', 'SuperSuperAdmin', '$2a$10$aR1akfwLM/.webm2g8toiePB6EydmPmOoFInLS2XmXKmrY.5fN722', NULL, NULL, 'Utilisateur', 'iceXPR', 1);

-- --------------------------------------------------------

--
-- Table structure for table `utilisateurs_profiles`
--

CREATE TABLE `utilisateurs_profiles` (
  `utilisateurs_email` varchar(255) NOT NULL,
  `profile_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `utilisateurs_profiles`
--

INSERT INTO `utilisateurs_profiles` (`utilisateurs_email`, `profile_id`) VALUES
('SuperSuperAdmin', 1),
('SuperAdmin', 2),
('Admin', 3),
('managerXPR@xpr.com', 5);

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur_villes`
--

CREATE TABLE `utilisateur_villes` (
  `ramasseur_email` varchar(255) NOT NULL,
  `villes_nom` varchar(255) NOT NULL,
  `livreur_email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `variante`
--

CREATE TABLE `variante` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  `dimension` varchar(255) DEFAULT NULL,
  `emballer` bit(1) NOT NULL,
  `id_intern` varchar(255) DEFAULT NULL,
  `marque` varchar(255) DEFAULT NULL,
  `nature` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `prix_originale` double DEFAULT NULL,
  `prix_vente` double DEFAULT NULL,
  `qte` int DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `sku` varchar(255) DEFAULT NULL,
  `produit_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ville`
--

CREATE TABLE `ville` (
  `nom` varchar(255) NOT NULL,
  `id` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `ville`
--

INSERT INTO `ville` (`nom`, `id`, `region`) VALUES
('Afourar', '0', '5'),
('Agadir', '1', '9'),
('Agdz', '2', '8'),
('Aghbala', '3', '5'),
('Agni Izimmer', '4', '9'),
('Agourai', '5', '3'),
('Ahfir', '6', '2'),
('Aïn Bni Mathar', '34', '2'),
('Aïn Cheggag', '35', '3'),
('Aïn Dorij', '36', '1'),
('Ain El Aouda', '7', '4'),
('Aïn Erreggada', '37', '2'),
('Aïn Harrouda', '38', '6'),
('Aïn Jemaa', '39', '3'),
('Aïn Karma', '40', '3'),
('Aïn Leuh', '41', '3'),
('Ain Taoujdate', '8', '3'),
('Aït Attab', '42', '5'),
('Aït Baha', '43', '9'),
('Aït Boubidmane', '44', '3'),
('Ait Daoud', '9', '7'),
('Aït Hichem‎', '45', '1'),
('Aït Iaâza', '46', '9'),
('Aït Ishaq', '47', '5'),
('Aït Majden', '48', '5'),
('Aït Melloul', '49', '9'),
('Aït Ourir', '50', '7'),
('Aït Yalla', '51', '8'),
('Ajdir‎', '10', '1'),
('Akchour', '11', '1'),
('Akka', '12', '9'),
('Aklim', '13', '2'),
('Aknoul‎', '14', '3'),
('Al Aroui', '15', '2'),
('Al Hoceïma‎', '16', '1'),
('Alnif', '17', '8'),
('Amalou Ighriben', '18', '5'),
('Amizmiz', '19', '7'),
('Anzi', '20', '9'),
('Aoufous', '21', '8'),
('Aoulouz', '22', '9'),
('Aourir', '23', '9'),
('Arazane', '24', '9'),
('Arbaoua', '25', '4'),
('Arfoud', '26', '8'),
('Assa', '27', '10'),
('Assahrij', '28', '7'),
('Assilah', '29', '1'),
('Awsard', '30', '12'),
('Azemmour', '31', '6'),
('Azilal', '32', '5'),
('Azrou', '33', '3'),
('Bab Berred', '52', '1'),
('Bab Taza', '53', '1'),
('Bejaâd', '54', '5'),
('Ben Ahmed', '55', '6'),
('Ben Guerir', '56', '7'),
('Ben Sergao', '57', '9'),
('Ben Taïeb', '58', '2'),
('Ben Yakhlef', '59', '6'),
('Beni Ayat', '60', '5'),
('Béni Mellal', '92', '5'),
('Benslimane', '61', '6'),
('Berkane', '62', '2'),
('Berrechid', '63', '6'),
('Bhalil', '64', '3'),
('Bin elouidane', '65', '5'),
('Biougra', '66', '9'),
('Bir Jdid', '67', '6'),
('Bni Ansar', '68', '2'),
('Bni Bouayach‎', '69', '1'),
('Bni Chiker', '70', '2'),
('Bni Drar', '71', '2'),
('Bni Hadifa‎', '72', '1'),
('Bni Tadjite', '73', '2'),
('Bouanane', '74', '2'),
('Bouarfa', '75', '2'),
('Boudnib', '76', '8'),
('Boufakrane', '77', '3'),
('Bouguedra', '78', '7'),
('Bouhdila', '79', '2'),
('Bouizakarne', '80', '10'),
('Boujdour‎', '81', '11'),
('Boujniba', '82', '5'),
('Boulanouare', '83', '5'),
('Boulemane', '84', '3'),
('Boumalne-Dadès', '85', '8'),
('Boumia', '86', '8'),
('Bouskoura', '87', '6'),
('Bouznika', '88', '6'),
('Bradia', '89', '5'),
('Brikcha', '90', '1'),
('Bzou', '91', '5'),
('Casa', NULL, NULL),
('Casablanca', '93', '6'),
('Chefchaouen', '94', '1'),
('Chichaoua', '95', '7'),
('Dar Bni Karrich', '96', '1'),
('Dar Chaoui', '97', '1'),
('Dar El Kebdani', '98', '2'),
('Dar Gueddari', '99', '4'),
('Dar Oulad Zidouh', '100', '5'),
('Dcheira El Jihadia', '101', '9'),
('Debdou', '102', '2'),
('Demnate', '103', '5'),
('Deroua', '104', '6'),
('Douar Kannine', '105', '2'),
('Dra\'a', '106', '8'),
('Drargua', '107', '9'),
('Driouch', '108', '2'),
('Echemmaia', '109', '7'),
('El Aïoun Sidi Mellouk', '110', '2'),
('El Borouj', '111', '6'),
('El Gara', '112', '6'),
('El Guerdane', '113', '9'),
('El Hajeb', '114', '3'),
('El Hanchane', '115', '7'),
('El Jadida', '116', '6'),
('El Kelaâ des Sraghna', '117', '7'),
('El Ksiba', '118', '5'),
('El Marsa‎', '119', '11'),
('El Menzel', '120', '3'),
('El Ouatia', '121', '10'),
('Elkbab', '122', '5'),
('Er-Rich', '123', '5'),
('Errachidia', '124', '8'),
('Es-Semara', '125', '11'),
('Essaouira', '126', '7'),
('Fam El Hisn', '127', '9'),
('Farkhana', '128', '2'),
('Fès', NULL, NULL),
('Figuig', '129', '2'),
('Fnideq', '130', '1'),
('Foum Jamaa', '131', '5'),
('Foum Zguid', '132', '9'),
('Fquih Ben Salah', '133', '5'),
('Fraïta', '134', '7'),
('Gardmit', '136', '8'),
('Ghafsai‎', '137', '3'),
('Ghmate', '138', '7'),
('Goulmima', '139', '8'),
('Gourrama', '140', '8'),
('Guelmim', '141', '10'),
('Guercif‎', '142', '2'),
('Gueznaia', '143', '1'),
('Guigou', '144', '3'),
('Guisser', '145', '6'),
('Had Bouhssoussen', '146', '5'),
('Had Kourt', '147', '4'),
('Haj Kaddour', '148', '3'),
('Harhoura', '149', '4'),
('Harte Lyamine', '150', '8'),
('Hattane', '151', '5'),
('Hrara', '152', '7'),
('Ida Ougnidif', '153', '9'),
('Ifrane', '154', '3'),
('Ifri', '155', '8'),
('Igdamen', '156', '9'),
('Ighil n\'Oumgoun', '157', '8'),
('Ighoud', '158', '7'),
('Ighounane', '159', '8'),
('Ihddaden', '160', '2'),
('Imassine', '161', '8'),
('Imintanoute', '162', '7'),
('Imouzzer Kandar', '163', '3'),
('Imouzzer Marmoucha', '164', '3'),
('Imzouren‎', '165', '1'),
('Inahnahen‎', '166', '1'),
('Inezgane', '167', '9'),
('Irherm', '168', '9'),
('Issaguen (Ketama)‎', '169', '1'),
('Itzer', '170', '8'),
('Jaâdar', '172', '2'),
('Jamâat Shaim', '171', '7'),
('Jebha', '173', '1'),
('Jerada', '174', '2'),
('Jorf', '175', '8'),
('Jorf El Melha', '176', '4'),
('Jorf Lasfar', '177', '6'),
('Karia', '178', '3'),
('Karia (El Jadida)‎', '179', '6'),
('Karia Ba Mohamed‎', '180', '3'),
('Kariat Arekmane', '181', '2'),
('Kasba Tadla', '182', '5'),
('Kassita', '183', '2'),
('Kattara', '184', '7'),
('Kehf Nsour', '185', '5'),
('Kelaat-M\'Gouna', '186', '8'),
('Kénitra', '196', '4'),
('Kerouna', '187', '2'),
('Kerrouchen', '188', '5'),
('Khémis Sahel', '192', '1'),
('Khemis Zemamra', '189', '6'),
('Khémisset', '193', '4'),
('Khenichet', '190', '4'),
('Khénifra', '194', '5'),
('Khouribga', '191', '5'),
('Ksar El Kébir', '195', '1'),
('Laaounate', '197', '6'),
('Laâtamna', '204', '2'),
('Lâattaouia', '208', '7'),
('Laayoune‎', '198', '11'),
('Lakhsas', '199', '9'),
('Lakhsass', '200', '9'),
('Lalla Mimouna', '201', '4'),
('Lalla Takerkoust', '202', '7'),
('Larache', '203', '1'),
('Loudaya', '205', '7'),
('Loulad', '206', '6'),
('Lqliâa', '207', '9'),
('M\'diq', '209', '1'),
('M\'haya', '210', '3'),
('M\'rirt', '211', '5'),
('M\'semrir', '212', '8'),
('Madagh', '213', '2'),
('Marrakech', '214', '7'),
('Martil', '215', '1'),
('Massa (Maroc)', '216', '9'),
('Mechra Bel Ksiri', '217', '4'),
('Médiouna', '236', '6'),
('Megousse', '218', '9'),
('Mehdia', '219', '4'),
('Meknès‎', '220', '3'),
('Midar', '221', '2'),
('Midelt', '222', '8'),
('Missour', '223', '3'),
('Mohammadia', '224', '6'),
('Moqrisset', '225', '1'),
('Moulay Abdallah', '226', '6'),
('Moulay Ali Cherif', '227', '8'),
('Moulay Bouazza', '228', '5'),
('Moulay Bousselham', '229', '4'),
('Moulay Brahim', '230', '7'),
('Moulay Idriss Zerhoun', '231', '3'),
('Moulay Yaâcoub', '232', '3'),
('Moussaoua', '233', '3'),
('MyAliCherif', '234', '8'),
('Mzouda', '235', '7'),
('N\'Zalat Bni Amar', '237', '3'),
('Nador', '238', '2'),
('Naima', '239', '2'),
('Oualidia', '240', '6'),
('Ouaouizeght', '241', '5'),
('Ouaoumana', '242', '5'),
('Ouarzazate', '243', '8'),
('Ouazzane', '244', '1'),
('Oued Amlil‎', '245', '3'),
('Oued Heimer', '246', '2'),
('Oued Ifrane', '247', '3'),
('Oued Laou', '248', '1'),
('Oued Rmel', '249', '1'),
('Oued Zem', '250', '5'),
('Oued-Eddahab', '251', '12'),
('Oujda', '252', '2'),
('Oulad Abbou', '253', '6'),
('Oulad Amrane', '254', '6'),
('Oulad Ayad', '255', '5'),
('Oulad Berhil', '256', '9'),
('Oulad Frej', '257', '6'),
('Oulad Ghadbane', '258', '6'),
('Oulad H\'Riz Sahel', '259', '6'),
('Oulad M\'Barek', '260', '5'),
('Oulad M\'rah', '261', '6'),
('Oulad Saïd', '262', '6'),
('Oulad Sidi Ben Daoud', '263', '6'),
('Oulad Teïma', '264', '9'),
('Oulad Yaich', '265', '5'),
('Oulad Zbair‎', '266', '3'),
('Ouled Tayeb', '267', '3'),
('Oulmès', '268', '4'),
('Ounagha', '269', '7'),
('Outat El Haj', '270', '3'),
('Point Cires', '271', '1'),
('Rabat', '272', '4'),
('Ras El Aïn', '273', '6'),
('Ras El Ma', '274', '2'),
('Ribate El Kheir', '275', '3'),
('Rissani', '276', '8'),
('Rommani', '277', '4'),
('Sabaa Aiyoun', '278', '3'),
('Safi', '279', '7'),
('Saïdia', '282', '2'),
('Salé', '280', '4'),
('Sarghine', '281', '8'),
('Sebt El Maârif', '283', '6'),
('Sebt Gzoula', '284', '7'),
('Sebt Jahjouh', '285', '3'),
('Séfrou', '322', '3'),
('Selouane', '286', '2'),
('Settat', '287', '6'),
('Sid L\'Mokhtar', '288', '7'),
('Sid Zouin', '289', '7'),
('Sidi Abdallah Ghiat', '290', '7'),
('Sidi Addi', '291', '3'),
('Sidi Ahmed', '292', '7'),
('Sidi Ali Ban Hamdouche', '293', '6'),
('Sidi Allal El Bahraoui', '294', '4'),
('Sidi Allal Tazi', '295', '4'),
('Sidi Bennour', '296', '6'),
('Sidi Bou Othmane', '297', '7'),
('Sidi Boubker', '298', '2'),
('Sidi Bouknadel', '299', '4'),
('Sidi Bouzid', '300', '6'),
('Sidi Ifni', '301', '10'),
('Sidi Jaber', '302', '5'),
('Sidi Kacem', '303', '4'),
('Sidi Lyamani', '304', '1'),
('Sidi Mohamed ben Abdallah el-Raisuni', '305', '1'),
('Sidi Rahhal', '306', '7'),
('Sidi Rahhal Chataï', '307', '6'),
('Sidi Slimane', '308', '4'),
('Sidi Slimane Echcharaa', '309', '2'),
('Sidi Smaïl', '310', '6'),
('Sidi Taibi', '311', '4'),
('Sidi Yahya El Gharb', '312', '4'),
('Skhinate', '313', '3'),
('Skhirate', '314', '4'),
('Skhour Rehamna', '315', '7'),
('Skoura', '316', '8'),
('Smimou', '317', '7'),
('Soualem', '318', '6'),
('Souk El Arbaa', '319', '4'),
('Souk Sebt Oulad Nemma', '320', '5'),
('Stehat', '321', '1'),
('Tabounte', '323', '8'),
('Tafajight', '324', '3'),
('Tafetachte', '325', '7'),
('Tafraout', '326', '9'),
('Taghjijt', '327', '10'),
('Taghzout', '328', '1'),
('Tagzen', '329', '9'),
('Tahannaout', '330', '7'),
('Tahla‎', '331', '3'),
('Taïnaste‎', '356', '3'),
('Tala Tazegwaght‎', '332', '1'),
('Taliouine', '333', '9'),
('Talmest', '334', '7'),
('Talsint', '335', '2'),
('Tamallalt', '336', '7'),
('Tamanar', '337', '7'),
('Tamansourt', '338', '7'),
('Tamassint‎', '339', '1'),
('Tamegroute', '340', '8'),
('Tameslouht', '341', '7'),
('Tamesna', '342', '4'),
('Tamraght', '343', '9'),
('Tan-Tan', '344', '10'),
('Tanalt', '345', '9'),
('Tanger‎', '346', '1'),
('Tanoumrite Nkob Zagora', '347', '8'),
('Taounate‎', '348', '3'),
('Taourirt', '349', '2'),
('Taourirt ait zaghar', '350', '8'),
('Tarfaya‎', '351', '11'),
('Targuist‎', '352', '1'),
('Taroudannt', '353', '9'),
('Tata', '354', '9'),
('Taza‎', '355', '3'),
('Témara', '381', '4'),
('Temsia', '357', '9'),
('Tendrara', '358', '2'),
('Tétouan‎', '382', '1'),
('Thar Es-Souk‎', '359', '3'),
('Tichoute', '360', '8'),
('Tiddas', '361', '4'),
('Tiflet', '362', '4'),
('Tifnit', '363', '9'),
('Tighassaline', '364', '5'),
('Tighza', '365', '5'),
('Timahdite', '366', '3'),
('Tinejdad', '367', '8'),
('Tisgdal', '368', '9'),
('Tissa‎', '369', '3'),
('Tit Mellil', '370', '6'),
('Tizguite', '371', '3'),
('Tizi Ouasli‎', '372', '3'),
('Tiznit', '373', '9'),
('Tiztoutine', '374', '2'),
('Touarga', '375', '4'),
('Touima', '376', '2'),
('Touissit', '377', '2'),
('Toulal', '378', '3'),
('Toundoute', '379', '8'),
('Tounfite', '380', '8'),
('Youssoufia', '383', '7'),
('Zag', '384', '10'),
('Zagora', '385', '8'),
('Zaïda', '388', '8'),
('Zaïo', '389', '2'),
('Zaouia d\'Ifrane', '386', '3'),
('Zaouïat Cheikh', '387', '5'),
('Zeghanghane', '390', '2'),
('Zeubelemok', '391', '7'),
('Zinat', '392', '1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `agences`
--
ALTER TABLE `agences`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK13xmyqp406ldbjtwn597h6ofs` (`entite_id`),
  ADD KEY `FK1pvivyga3i1jufrxv1qdli7qq` (`ville_nom`);

--
-- Indexes for table `autorisations`
--
ALTER TABLE `autorisations`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_hmu9uifhy301ok9s8893xvij3` (`auth_name`);

--
-- Indexes for table `bon_expeditions`
--
ALTER TABLE `bon_expeditions`
  ADD PRIMARY KEY (`nom`),
  ADD KEY `FK48773hduoad5qpr89dpni1um0` (`depart_id`),
  ADD KEY `FKt3j8ige9aeoqmi34ashqefqgq` (`destination_id`),
  ADD KEY `FKrqsvii880swwi5rame8vqa8nv` (`entite_id`),
  ADD KEY `FKawa3q24fcfwh0ekjhf09s3cmi` (`statut_code`);

--
-- Indexes for table `bon_ramassages`
--
ALTER TABLE `bon_ramassages`
  ADD PRIMARY KEY (`nom`),
  ADD KEY `FK4fh5hxkonebw03m54hoo0jfy5` (`agence_id`),
  ADD KEY `FK3ccj6kn93e2avex7dv2cd40fd` (`agence_depart_id`),
  ADD KEY `FKssri7lhee43ofqhdjmp2c0rrp` (`agence_destination_id`),
  ADD KEY `FKjmkquk5qhygpspngep3huj3ie` (`client_ice`),
  ADD KEY `FKh6ygld93lnf9jnhib8fy7stj2` (`entite_id`),
  ADD KEY `FK2sjj0k20ykowy1pffi8aw81xy` (`facture_name`),
  ADD KEY `FK4tcmmw747ksa3ql520nm4uxr8` (`ramasseur_email`),
  ADD KEY `FK7ifawbu6skpaj0hh15b7c4h3m` (`statut_code`);

--
-- Indexes for table `bon_retours`
--
ALTER TABLE `bon_retours`
  ADD PRIMARY KEY (`nom`),
  ADD KEY `FKchxn86jbjy73njtueuvgg86eg` (`client_ice`),
  ADD KEY `FKg55lxge1gl7qq5dgx6cy6w9hu` (`entite_id`),
  ADD KEY `FKreyv5ybadb4exda85mqx0jykd` (`livreur_email`),
  ADD KEY `FK6ib8mu2xo099hi5m4ckubasho` (`statut_code`);

--
-- Indexes for table `business`
--
ALTER TABLE `business`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKj5fky231tq01vb8f1fch6e5af` (`client_ice`);

--
-- Indexes for table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`ice`),
  ADD KEY `FKji61ypppud60udti6gam7b8lb` (`contrat_id`),
  ADD KEY `FKlub4glm594udkjgx4ol5umxgh` (`entite_id`),
  ADD KEY `FKc0pttitxpvevimdxdnt6y3rys` (`ville_nom`);

--
-- Indexes for table `colis`
--
ALTER TABLE `colis`
  ADD PRIMARY KEY (`num_commande`),
  ADD KEY `FK22kv9go0g3pf9u64oebkiepu0` (`bon_expedition_nom`),
  ADD KEY `FK159k6xwyydnw34gcvd4o9dpv4` (`bon_ramassage_nom`),
  ADD KEY `FKjnwv7rhboegktjy0c6ximw2jc` (`bon_retour_nom`),
  ADD KEY `FKio6gvh7fyvm800pffmprwlumj` (`business_id`),
  ADD KEY `FK4vvw0kj5tki8vxhwqivuj7882` (`client_ice`),
  ADD KEY `FKhx7pa1jqpt9jkb2e43fmsosl9` (`entite_id`),
  ADD KEY `FK4d7g90nqiqxedy7b5cus2l6md` (`facture_name`),
  ADD KEY `FK7ljx864f0gvxj6gcqs5o16new` (`livreur_email`),
  ADD KEY `FK33souwa6crv5kb7km7xk7gj9d` (`ramasseur_email`),
  ADD KEY `FKsn5qo4dirumnwlcq79pf2eah9` (`status_id`),
  ADD KEY `FKatvkqfv5vpc7giyaphnkbuv79` (`ville_destination_nom`);

--
-- Indexes for table `commentaires`
--
ALTER TABLE `commentaires`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4ji8eksfyugx1k6ddyqefkt13` (`colis_num_commande`),
  ADD KEY `FK4w81x5icamcls2scxuwter2pk` (`utilisateur_email`);

--
-- Indexes for table `contrats`
--
ALTER TABLE `contrats`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjsxxjm13s0ufkr4plc6do0thx` (`client_ice`),
  ADD KEY `FK76onu28f9qtddefkdq5elnskb` (`entite_id`);

--
-- Indexes for table `demandes`
--
ALTER TABLE `demandes`
  ADD PRIMARY KEY (`nom`),
  ADD KEY `FKqapfxth6cbhqvpruwll2qefko` (`business_id`),
  ADD KEY `FK5a0chvejma8m9irkgmpv6tbpo` (`client_ice`),
  ADD KEY `FKs73ma12j4wux2lxbuerit20sv` (`creer_par_email`),
  ADD KEY `FKstaxmvgbwve02cb8yl602yhg0` (`modifier_par_email`);

--
-- Indexes for table `entite`
--
ALTER TABLE `entite`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbhsl3ckdp7aolxdfxe6w9xv2d` (`entite_parent_id`);

--
-- Indexes for table `factures`
--
ALTER TABLE `factures`
  ADD PRIMARY KEY (`name`),
  ADD KEY `FKpf6g28is5ek4lm2fd1pyuhk1o` (`creer_par_email`),
  ADD KEY `FK300ks8k5pggt59kpykfrjo7j1` (`entite_id`),
  ADD KEY `FKnhx2sip66ci11bpen548tj5pc` (`livreur_email`);

--
-- Indexes for table `factures_client`
--
ALTER TABLE `factures_client`
  ADD PRIMARY KEY (`name`),
  ADD KEY `FKk5w557rw8m18pja7ow61wnlf2` (`client_ice`),
  ADD KEY `FK89j8n2eg321ybf9hv1sw3cy6q` (`creer_par_email`),
  ADD KEY `FKrx0oh12uni3e6gpnr1lfy7860` (`livreur_email`);

--
-- Indexes for table `factures_clients`
--
ALTER TABLE `factures_clients`
  ADD KEY `FKlavmq31byegjfuuwyvgcrxvh2` (`clients_ice`),
  ADD KEY `FKd4rx3e496hbp0j2dqs80shk98` (`facture_name`);

--
-- Indexes for table `historiques`
--
ALTER TABLE `historiques`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKlrktvuhmfjlxhbfrfj7ag8plh` (`utilisateur_email`),
  ADD KEY `FK7qsajj0mokur0dx57lxx9o9fu` (`bon_expedition_nom`),
  ADD KEY `FK4gw8wbvnvasx0nw7m6xstonbj` (`bon_ramassage_nom`),
  ADD KEY `FKkwxr5ug8o8h0qe63w8bdk9b83` (`bon_retour_nom`),
  ADD KEY `FK3k7w8r89xh4wl5vcpm2qa2ng6` (`colis_num_commande`),
  ADD KEY `FKgdhy0h1uf1gb21epg5tqka7h7` (`demande_nom`),
  ADD KEY `FKd2usumh1csra58egkrikngv61` (`stock_id`);

--
-- Indexes for table `ligne_bon_expeditions`
--
ALTER TABLE `ligne_bon_expeditions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5gn2dk94pxx1w0049onc3luc5` (`bon_expedition_nom`),
  ADD KEY `FKbb1d06473klc0pen3fymn7lpg` (`colis_num_commande`),
  ADD KEY `FK23xmy3edqclhvq9thg39eo8o3` (`ligne_colis_id`);

--
-- Indexes for table `ligne_bon_retours`
--
ALTER TABLE `ligne_bon_retours`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKkm1ill204r9xj3gj9raytv4nd` (`bon_retour_nom`),
  ADD KEY `FKu9w810r0ponodps6qxts6ppd` (`colis_num_commande`),
  ADD KEY `FKsbp1isn9nuw9ti3dcimy34hdc` (`ligne_colis_id`);

--
-- Indexes for table `ligne_colis`
--
ALTER TABLE `ligne_colis`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK801jkiey5nt10yyovi1me4a7u` (`bon_retour_nom`),
  ADD KEY `FK1kp20h3i9yhoi4fh53o5q8lcv` (`business_id`),
  ADD KEY `FKl18luxsqbc8p6tdaiy114kf3c` (`colis_num_commande`),
  ADD KEY `FK29x73d7j7maxpgkutneykwec4` (`produit_id`),
  ADD KEY `FK580pn9hm4e1cbt5mc2ykjfpve` (`stock_id`),
  ADD KEY `FKllwwnpbuoe92uc0eiontkwthv` (`variante_id`);

--
-- Indexes for table `ligne_facture`
--
ALTER TABLE `ligne_facture`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2jqffptu9978185i8rkfdq43j` (`facture_name`),
  ADD KEY `FKiiluucs0n6q8hb77f0f0gv8o8` (`ligne_colis_id`);

--
-- Indexes for table `ligne_facture_client`
--
ALTER TABLE `ligne_facture_client`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2boradiex1bs1k9f1ylshgtnp` (`facture_client_name`),
  ADD KEY `FKsw6yo93qh3ee53gpsc58ewun8` (`ligne_colis_id`);

--
-- Indexes for table `log`
--
ALTER TABLE `log`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `news`
--
ALTER TABLE `news`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `notification`
--
ALTER TABLE `notification`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKb9syc0k33aens1lyqeksxgbrl` (`receiver_email`);

--
-- Indexes for table `produits`
--
ALTER TABLE `produits`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKrxlg59ygc7mxvgnuk1e5qke2a` (`client_ice`);

--
-- Indexes for table `produit_stock_client`
--
ALTER TABLE `produit_stock_client`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhxd29q7a41tlhnnsin4m47kf0` (`agence_id`),
  ADD KEY `FKcbkyu8v14jfa3pv1n80ai97nk` (`client_ice`),
  ADD KEY `FK1y4gn9b3emjf3ufai1kvgqgef` (`entite_id`),
  ADD KEY `FKml61ml2vsyiy0utcgxrfo0oks` (`produit_id`),
  ADD KEY `FKkhp8r7vmgpwio2sa3ym5ohxe2` (`variante_id`),
  ADD KEY `FK50dkeiw8lk6v02mxds2gcg44o` (`ville_nom`);

--
-- Indexes for table `profiles`
--
ALTER TABLE `profiles`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `profiles_autorisations`
--
ALTER TABLE `profiles_autorisations`
  ADD PRIMARY KEY (`profile_id`,`autorisation_id`),
  ADD KEY `FK1u4tgbh5yvrpob921h4wclvff` (`autorisation_id`);

--
-- Indexes for table `statut_bon_expedition`
--
ALTER TABLE `statut_bon_expedition`
  ADD PRIMARY KEY (`code`);

--
-- Indexes for table `statut_bon_ramassage`
--
ALTER TABLE `statut_bon_ramassage`
  ADD PRIMARY KEY (`code`);

--
-- Indexes for table `statut_bon_retour`
--
ALTER TABLE `statut_bon_retour`
  ADD PRIMARY KEY (`code`);

--
-- Indexes for table `statut_colis`
--
ALTER TABLE `statut_colis`
  ADD PRIMARY KEY (`code`);

--
-- Indexes for table `statut_facture`
--
ALTER TABLE `statut_facture`
  ADD PRIMARY KEY (`code`);

--
-- Indexes for table `statut_facture_client`
--
ALTER TABLE `statut_facture_client`
  ADD PRIMARY KEY (`code`);

--
-- Indexes for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`email`),
  ADD KEY `FKiadxprncg1bxhh42mh5mqppf3` (`client_ice`),
  ADD KEY `FKjrf04hy5xyxd3x4j9462uk12a` (`entite_id`);

--
-- Indexes for table `utilisateurs_profiles`
--
ALTER TABLE `utilisateurs_profiles`
  ADD PRIMARY KEY (`utilisateurs_email`,`profile_id`),
  ADD KEY `FK5dde7yqmy6x46ma6od2n3wapa` (`profile_id`);

--
-- Indexes for table `utilisateur_villes`
--
ALTER TABLE `utilisateur_villes`
  ADD PRIMARY KEY (`livreur_email`,`villes_nom`),
  ADD KEY `FKa54qs6nys21lk8a4fs6cb215j` (`villes_nom`),
  ADD KEY `FK3m5xo38l38051mcqh9e16m7ce` (`ramasseur_email`);

--
-- Indexes for table `variante`
--
ALTER TABLE `variante`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8e1eaubum5671rkukhp07xdak` (`produit_id`);

--
-- Indexes for table `ville`
--
ALTER TABLE `ville`
  ADD PRIMARY KEY (`nom`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `agences`
--
ALTER TABLE `agences`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `autorisations`
--
ALTER TABLE `autorisations`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=181;

--
-- AUTO_INCREMENT for table `business`
--
ALTER TABLE `business`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `commentaires`
--
ALTER TABLE `commentaires`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT for table `contrats`
--
ALTER TABLE `contrats`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `entite`
--
ALTER TABLE `entite`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `historiques`
--
ALTER TABLE `historiques`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT for table `ligne_bon_expeditions`
--
ALTER TABLE `ligne_bon_expeditions`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ligne_bon_retours`
--
ALTER TABLE `ligne_bon_retours`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ligne_colis`
--
ALTER TABLE `ligne_colis`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT for table `ligne_facture`
--
ALTER TABLE `ligne_facture`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ligne_facture_client`
--
ALTER TABLE `ligne_facture_client`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `log`
--
ALTER TABLE `log`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `news`
--
ALTER TABLE `news`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `notification`
--
ALTER TABLE `notification`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `produits`
--
ALTER TABLE `produits`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT for table `produit_stock_client`
--
ALTER TABLE `produit_stock_client`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `profiles`
--
ALTER TABLE `profiles`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `variante`
--
ALTER TABLE `variante`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `agences`
--
ALTER TABLE `agences`
  ADD CONSTRAINT `FK13xmyqp406ldbjtwn597h6ofs` FOREIGN KEY (`entite_id`) REFERENCES `entite` (`id`),
  ADD CONSTRAINT `FK1pvivyga3i1jufrxv1qdli7qq` FOREIGN KEY (`ville_nom`) REFERENCES `ville` (`nom`);

--
-- Constraints for table `bon_expeditions`
--
ALTER TABLE `bon_expeditions`
  ADD CONSTRAINT `FK48773hduoad5qpr89dpni1um0` FOREIGN KEY (`depart_id`) REFERENCES `agences` (`id`),
  ADD CONSTRAINT `FKawa3q24fcfwh0ekjhf09s3cmi` FOREIGN KEY (`statut_code`) REFERENCES `statut_bon_expedition` (`code`),
  ADD CONSTRAINT `FKrqsvii880swwi5rame8vqa8nv` FOREIGN KEY (`entite_id`) REFERENCES `entite` (`id`),
  ADD CONSTRAINT `FKt3j8ige9aeoqmi34ashqefqgq` FOREIGN KEY (`destination_id`) REFERENCES `agences` (`id`);

--
-- Constraints for table `bon_ramassages`
--
ALTER TABLE `bon_ramassages`
  ADD CONSTRAINT `FK2sjj0k20ykowy1pffi8aw81xy` FOREIGN KEY (`facture_name`) REFERENCES `factures` (`name`),
  ADD CONSTRAINT `FK3ccj6kn93e2avex7dv2cd40fd` FOREIGN KEY (`agence_depart_id`) REFERENCES `agences` (`id`),
  ADD CONSTRAINT `FK4fh5hxkonebw03m54hoo0jfy5` FOREIGN KEY (`agence_id`) REFERENCES `agences` (`id`),
  ADD CONSTRAINT `FK4tcmmw747ksa3ql520nm4uxr8` FOREIGN KEY (`ramasseur_email`) REFERENCES `utilisateur` (`email`),
  ADD CONSTRAINT `FK7ifawbu6skpaj0hh15b7c4h3m` FOREIGN KEY (`statut_code`) REFERENCES `statut_bon_ramassage` (`code`),
  ADD CONSTRAINT `FKh6ygld93lnf9jnhib8fy7stj2` FOREIGN KEY (`entite_id`) REFERENCES `entite` (`id`),
  ADD CONSTRAINT `FKjmkquk5qhygpspngep3huj3ie` FOREIGN KEY (`client_ice`) REFERENCES `clients` (`ice`),
  ADD CONSTRAINT `FKssri7lhee43ofqhdjmp2c0rrp` FOREIGN KEY (`agence_destination_id`) REFERENCES `agences` (`id`);

--
-- Constraints for table `bon_retours`
--
ALTER TABLE `bon_retours`
  ADD CONSTRAINT `FK6ib8mu2xo099hi5m4ckubasho` FOREIGN KEY (`statut_code`) REFERENCES `statut_bon_retour` (`code`),
  ADD CONSTRAINT `FKchxn86jbjy73njtueuvgg86eg` FOREIGN KEY (`client_ice`) REFERENCES `clients` (`ice`),
  ADD CONSTRAINT `FKg55lxge1gl7qq5dgx6cy6w9hu` FOREIGN KEY (`entite_id`) REFERENCES `entite` (`id`),
  ADD CONSTRAINT `FKreyv5ybadb4exda85mqx0jykd` FOREIGN KEY (`livreur_email`) REFERENCES `utilisateur` (`email`);

--
-- Constraints for table `business`
--
ALTER TABLE `business`
  ADD CONSTRAINT `FKj5fky231tq01vb8f1fch6e5af` FOREIGN KEY (`client_ice`) REFERENCES `clients` (`ice`);

--
-- Constraints for table `clients`
--
ALTER TABLE `clients`
  ADD CONSTRAINT `FKc0pttitxpvevimdxdnt6y3rys` FOREIGN KEY (`ville_nom`) REFERENCES `ville` (`nom`),
  ADD CONSTRAINT `FKji61ypppud60udti6gam7b8lb` FOREIGN KEY (`contrat_id`) REFERENCES `contrats` (`id`),
  ADD CONSTRAINT `FKlub4glm594udkjgx4ol5umxgh` FOREIGN KEY (`entite_id`) REFERENCES `entite` (`id`);

--
-- Constraints for table `colis`
--
ALTER TABLE `colis`
  ADD CONSTRAINT `FK159k6xwyydnw34gcvd4o9dpv4` FOREIGN KEY (`bon_ramassage_nom`) REFERENCES `bon_ramassages` (`nom`),
  ADD CONSTRAINT `FK22kv9go0g3pf9u64oebkiepu0` FOREIGN KEY (`bon_expedition_nom`) REFERENCES `bon_expeditions` (`nom`),
  ADD CONSTRAINT `FK33souwa6crv5kb7km7xk7gj9d` FOREIGN KEY (`ramasseur_email`) REFERENCES `utilisateur` (`email`),
  ADD CONSTRAINT `FK4d7g90nqiqxedy7b5cus2l6md` FOREIGN KEY (`facture_name`) REFERENCES `factures` (`name`),
  ADD CONSTRAINT `FK4vvw0kj5tki8vxhwqivuj7882` FOREIGN KEY (`client_ice`) REFERENCES `clients` (`ice`),
  ADD CONSTRAINT `FK7ljx864f0gvxj6gcqs5o16new` FOREIGN KEY (`livreur_email`) REFERENCES `utilisateur` (`email`),
  ADD CONSTRAINT `FKatvkqfv5vpc7giyaphnkbuv79` FOREIGN KEY (`ville_destination_nom`) REFERENCES `ville` (`nom`),
  ADD CONSTRAINT `FKhx7pa1jqpt9jkb2e43fmsosl9` FOREIGN KEY (`entite_id`) REFERENCES `entite` (`id`),
  ADD CONSTRAINT `FKio6gvh7fyvm800pffmprwlumj` FOREIGN KEY (`business_id`) REFERENCES `business` (`id`),
  ADD CONSTRAINT `FKjnwv7rhboegktjy0c6ximw2jc` FOREIGN KEY (`bon_retour_nom`) REFERENCES `bon_retours` (`nom`),
  ADD CONSTRAINT `FKsn5qo4dirumnwlcq79pf2eah9` FOREIGN KEY (`status_id`) REFERENCES `statut_colis` (`code`);

--
-- Constraints for table `commentaires`
--
ALTER TABLE `commentaires`
  ADD CONSTRAINT `FK4ji8eksfyugx1k6ddyqefkt13` FOREIGN KEY (`colis_num_commande`) REFERENCES `colis` (`num_commande`),
  ADD CONSTRAINT `FK4w81x5icamcls2scxuwter2pk` FOREIGN KEY (`utilisateur_email`) REFERENCES `utilisateur` (`email`);

--
-- Constraints for table `contrats`
--
ALTER TABLE `contrats`
  ADD CONSTRAINT `FK76onu28f9qtddefkdq5elnskb` FOREIGN KEY (`entite_id`) REFERENCES `entite` (`id`),
  ADD CONSTRAINT `FKjsxxjm13s0ufkr4plc6do0thx` FOREIGN KEY (`client_ice`) REFERENCES `clients` (`ice`);

--
-- Constraints for table `demandes`
--
ALTER TABLE `demandes`
  ADD CONSTRAINT `FK5a0chvejma8m9irkgmpv6tbpo` FOREIGN KEY (`client_ice`) REFERENCES `clients` (`ice`),
  ADD CONSTRAINT `FKqapfxth6cbhqvpruwll2qefko` FOREIGN KEY (`business_id`) REFERENCES `business` (`id`),
  ADD CONSTRAINT `FKs73ma12j4wux2lxbuerit20sv` FOREIGN KEY (`creer_par_email`) REFERENCES `utilisateur` (`email`),
  ADD CONSTRAINT `FKstaxmvgbwve02cb8yl602yhg0` FOREIGN KEY (`modifier_par_email`) REFERENCES `utilisateur` (`email`);

--
-- Constraints for table `entite`
--
ALTER TABLE `entite`
  ADD CONSTRAINT `FKbhsl3ckdp7aolxdfxe6w9xv2d` FOREIGN KEY (`entite_parent_id`) REFERENCES `entite` (`id`);

--
-- Constraints for table `factures`
--
ALTER TABLE `factures`
  ADD CONSTRAINT `FK300ks8k5pggt59kpykfrjo7j1` FOREIGN KEY (`entite_id`) REFERENCES `entite` (`id`),
  ADD CONSTRAINT `FKnhx2sip66ci11bpen548tj5pc` FOREIGN KEY (`livreur_email`) REFERENCES `utilisateur` (`email`),
  ADD CONSTRAINT `FKpf6g28is5ek4lm2fd1pyuhk1o` FOREIGN KEY (`creer_par_email`) REFERENCES `utilisateur` (`email`);

--
-- Constraints for table `factures_client`
--
ALTER TABLE `factures_client`
  ADD CONSTRAINT `FK89j8n2eg321ybf9hv1sw3cy6q` FOREIGN KEY (`creer_par_email`) REFERENCES `utilisateur` (`email`),
  ADD CONSTRAINT `FKk5w557rw8m18pja7ow61wnlf2` FOREIGN KEY (`client_ice`) REFERENCES `clients` (`ice`),
  ADD CONSTRAINT `FKrx0oh12uni3e6gpnr1lfy7860` FOREIGN KEY (`livreur_email`) REFERENCES `utilisateur` (`email`);

--
-- Constraints for table `factures_clients`
--
ALTER TABLE `factures_clients`
  ADD CONSTRAINT `FKd4rx3e496hbp0j2dqs80shk98` FOREIGN KEY (`facture_name`) REFERENCES `factures` (`name`),
  ADD CONSTRAINT `FKlavmq31byegjfuuwyvgcrxvh2` FOREIGN KEY (`clients_ice`) REFERENCES `clients` (`ice`);

--
-- Constraints for table `historiques`
--
ALTER TABLE `historiques`
  ADD CONSTRAINT `FK3k7w8r89xh4wl5vcpm2qa2ng6` FOREIGN KEY (`colis_num_commande`) REFERENCES `colis` (`num_commande`),
  ADD CONSTRAINT `FK4gw8wbvnvasx0nw7m6xstonbj` FOREIGN KEY (`bon_ramassage_nom`) REFERENCES `bon_ramassages` (`nom`),
  ADD CONSTRAINT `FK7qsajj0mokur0dx57lxx9o9fu` FOREIGN KEY (`bon_expedition_nom`) REFERENCES `bon_expeditions` (`nom`),
  ADD CONSTRAINT `FKd2usumh1csra58egkrikngv61` FOREIGN KEY (`stock_id`) REFERENCES `produit_stock_client` (`id`),
  ADD CONSTRAINT `FKgdhy0h1uf1gb21epg5tqka7h7` FOREIGN KEY (`demande_nom`) REFERENCES `demandes` (`nom`),
  ADD CONSTRAINT `FKkwxr5ug8o8h0qe63w8bdk9b83` FOREIGN KEY (`bon_retour_nom`) REFERENCES `bon_retours` (`nom`),
  ADD CONSTRAINT `FKlrktvuhmfjlxhbfrfj7ag8plh` FOREIGN KEY (`utilisateur_email`) REFERENCES `utilisateur` (`email`);

--
-- Constraints for table `ligne_bon_expeditions`
--
ALTER TABLE `ligne_bon_expeditions`
  ADD CONSTRAINT `FK23xmy3edqclhvq9thg39eo8o3` FOREIGN KEY (`ligne_colis_id`) REFERENCES `ligne_colis` (`id`),
  ADD CONSTRAINT `FK5gn2dk94pxx1w0049onc3luc5` FOREIGN KEY (`bon_expedition_nom`) REFERENCES `bon_expeditions` (`nom`),
  ADD CONSTRAINT `FKbb1d06473klc0pen3fymn7lpg` FOREIGN KEY (`colis_num_commande`) REFERENCES `colis` (`num_commande`);

--
-- Constraints for table `ligne_bon_retours`
--
ALTER TABLE `ligne_bon_retours`
  ADD CONSTRAINT `FKkm1ill204r9xj3gj9raytv4nd` FOREIGN KEY (`bon_retour_nom`) REFERENCES `bon_retours` (`nom`),
  ADD CONSTRAINT `FKsbp1isn9nuw9ti3dcimy34hdc` FOREIGN KEY (`ligne_colis_id`) REFERENCES `ligne_colis` (`id`),
  ADD CONSTRAINT `FKu9w810r0ponodps6qxts6ppd` FOREIGN KEY (`colis_num_commande`) REFERENCES `colis` (`num_commande`);

--
-- Constraints for table `ligne_colis`
--
ALTER TABLE `ligne_colis`
  ADD CONSTRAINT `FK1kp20h3i9yhoi4fh53o5q8lcv` FOREIGN KEY (`business_id`) REFERENCES `business` (`id`),
  ADD CONSTRAINT `FK29x73d7j7maxpgkutneykwec4` FOREIGN KEY (`produit_id`) REFERENCES `produits` (`id`),
  ADD CONSTRAINT `FK580pn9hm4e1cbt5mc2ykjfpve` FOREIGN KEY (`stock_id`) REFERENCES `produit_stock_client` (`id`),
  ADD CONSTRAINT `FK801jkiey5nt10yyovi1me4a7u` FOREIGN KEY (`bon_retour_nom`) REFERENCES `bon_retours` (`nom`),
  ADD CONSTRAINT `FKl18luxsqbc8p6tdaiy114kf3c` FOREIGN KEY (`colis_num_commande`) REFERENCES `colis` (`num_commande`),
  ADD CONSTRAINT `FKllwwnpbuoe92uc0eiontkwthv` FOREIGN KEY (`variante_id`) REFERENCES `variante` (`id`);

--
-- Constraints for table `ligne_facture`
--
ALTER TABLE `ligne_facture`
  ADD CONSTRAINT `FK2jqffptu9978185i8rkfdq43j` FOREIGN KEY (`facture_name`) REFERENCES `factures` (`name`),
  ADD CONSTRAINT `FKiiluucs0n6q8hb77f0f0gv8o8` FOREIGN KEY (`ligne_colis_id`) REFERENCES `ligne_colis` (`id`);

--
-- Constraints for table `ligne_facture_client`
--
ALTER TABLE `ligne_facture_client`
  ADD CONSTRAINT `FK2boradiex1bs1k9f1ylshgtnp` FOREIGN KEY (`facture_client_name`) REFERENCES `factures_client` (`name`),
  ADD CONSTRAINT `FKsw6yo93qh3ee53gpsc58ewun8` FOREIGN KEY (`ligne_colis_id`) REFERENCES `ligne_colis` (`id`);

--
-- Constraints for table `notification`
--
ALTER TABLE `notification`
  ADD CONSTRAINT `FKb9syc0k33aens1lyqeksxgbrl` FOREIGN KEY (`receiver_email`) REFERENCES `utilisateur` (`email`);

--
-- Constraints for table `produits`
--
ALTER TABLE `produits`
  ADD CONSTRAINT `FKrxlg59ygc7mxvgnuk1e5qke2a` FOREIGN KEY (`client_ice`) REFERENCES `clients` (`ice`);

--
-- Constraints for table `produit_stock_client`
--
ALTER TABLE `produit_stock_client`
  ADD CONSTRAINT `FK1y4gn9b3emjf3ufai1kvgqgef` FOREIGN KEY (`entite_id`) REFERENCES `entite` (`id`),
  ADD CONSTRAINT `FK50dkeiw8lk6v02mxds2gcg44o` FOREIGN KEY (`ville_nom`) REFERENCES `ville` (`nom`),
  ADD CONSTRAINT `FKcbkyu8v14jfa3pv1n80ai97nk` FOREIGN KEY (`client_ice`) REFERENCES `clients` (`ice`),
  ADD CONSTRAINT `FKhxd29q7a41tlhnnsin4m47kf0` FOREIGN KEY (`agence_id`) REFERENCES `agences` (`id`),
  ADD CONSTRAINT `FKkhp8r7vmgpwio2sa3ym5ohxe2` FOREIGN KEY (`variante_id`) REFERENCES `variante` (`id`),
  ADD CONSTRAINT `FKml61ml2vsyiy0utcgxrfo0oks` FOREIGN KEY (`produit_id`) REFERENCES `produits` (`id`);

--
-- Constraints for table `profiles_autorisations`
--
ALTER TABLE `profiles_autorisations`
  ADD CONSTRAINT `FK1u4tgbh5yvrpob921h4wclvff` FOREIGN KEY (`autorisation_id`) REFERENCES `autorisations` (`id`),
  ADD CONSTRAINT `FK8jdhxuln078oictd7yu68x4i3` FOREIGN KEY (`profile_id`) REFERENCES `profiles` (`id`);

--
-- Constraints for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `FKiadxprncg1bxhh42mh5mqppf3` FOREIGN KEY (`client_ice`) REFERENCES `clients` (`ice`),
  ADD CONSTRAINT `FKjrf04hy5xyxd3x4j9462uk12a` FOREIGN KEY (`entite_id`) REFERENCES `entite` (`id`);

--
-- Constraints for table `utilisateurs_profiles`
--
ALTER TABLE `utilisateurs_profiles`
  ADD CONSTRAINT `FK5dde7yqmy6x46ma6od2n3wapa` FOREIGN KEY (`profile_id`) REFERENCES `profiles` (`id`),
  ADD CONSTRAINT `FKfa04vtdkrkhf27iwsblq1q8sk` FOREIGN KEY (`utilisateurs_email`) REFERENCES `utilisateur` (`email`);

--
-- Constraints for table `utilisateur_villes`
--
ALTER TABLE `utilisateur_villes`
  ADD CONSTRAINT `FK3m5xo38l38051mcqh9e16m7ce` FOREIGN KEY (`ramasseur_email`) REFERENCES `utilisateur` (`email`),
  ADD CONSTRAINT `FKa54qs6nys21lk8a4fs6cb215j` FOREIGN KEY (`villes_nom`) REFERENCES `ville` (`nom`),
  ADD CONSTRAINT `FKtea6gyx0nqfjdgk0lp7veilh7` FOREIGN KEY (`livreur_email`) REFERENCES `utilisateur` (`email`);

--
-- Constraints for table `variante`
--
ALTER TABLE `variante`
  ADD CONSTRAINT `FK8e1eaubum5671rkukhp07xdak` FOREIGN KEY (`produit_id`) REFERENCES `produits` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
