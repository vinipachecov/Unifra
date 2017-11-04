-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 29-Abr-2017 às 21:00
-- Versão do servidor: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Aula03agenda`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `Funcionario`
--

CREATE TABLE `Funcionario` (
  `ID` int(11) NOT NULL,
  `NOME` varchar(150) NOT NULL,
  `EMAIL` varchar(150) NOT NULL,
  `CARGO` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `Funcionario`
--

INSERT INTO `Funcionario` (`ID`, `NOME`, `EMAIL`, `CARGO`) VALUES
(1, 'Vinicius', 'vinci@email.com', 'Faxineiro'),
(2, 'Ricardo', 'ricardo@email.com', 'Professor'),
(3, 'Mauricio', 'mauricio@email.com', 'Porteiro'),
(4, 'Matheus', 'matheus@email.com', 'Pesquisador'),
(7, 'Lorenzo', 'lorenzo@email.com', 'Professor'),
(8, 'Luiza', 'luiza@email.com', 'Professor'),
(9, 'Lizandra', 'lizandra@email.com', 'Chefe de Departamento'),
(10, 'Pedro', 'pedro@email.com', 'Chefe de Departamento'),
(11, 'Rodrigo', 'rodrigo@minotauro.br', 'Lutador'),
(12, 'Luiz', 'luiz@email.com', 'Faxineiro'),
(13, 'Lucas', 'lucas@email.com', 'Chefe de Departamento'),
(14, 'Rodrigo', 'rodrigo@minotauro.br', 'Lutador'),
(15, 'joao', 'j@emai.com', 'estudante');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Funcionario`
--
ALTER TABLE `Funcionario`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Funcionario`
--
ALTER TABLE `Funcionario`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
