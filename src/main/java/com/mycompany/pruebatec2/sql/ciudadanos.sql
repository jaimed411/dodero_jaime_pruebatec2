-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-01-2024 a las 11:06:53
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `galeriaarte`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudadanos`
--

CREATE TABLE `ciudadanos` (
  `ID` bigint(20) NOT NULL,
  `APELLIDOS` varchar(255) DEFAULT NULL,
  `DNI` varchar(255) DEFAULT NULL,
  `EDAD` int(11) DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `TELEFONO` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ciudadanos`
--

INSERT INTO `ciudadanos` (`ID`, `APELLIDOS`, `DNI`, `EDAD`, `NOMBRE`, `TELEFONO`) VALUES
(1, 'Dodero', '05307686E', 34, 'jaime', '650845105'),
(2, 'Perez Garci�a', '05689512A', 63, 'Juan', '612345678'),
(3, 'Gonzalez MartÃ­nez', '06957742U', 32, 'Elena', '605112233'),
(4, 'Lopez SÃ¡nchez', '01548632H', 45, 'Javier', '611223344'),
(5, 'Rodriz PÃ©rez', '06975326J', 35, 'Maronia', '622334455'),
(6, 'Montes Diuaz', '05789633P', 31, 'Alicia', '666778899'),
(7, 'Sacristan Perez', '01458696V', 33, 'Miryam', '697423258'),
(8, 'Fiole Scum', '01578953L', 52, 'Silvia', '678425320'),
(9, 'Rubio Castilla', '06985566D', 34, 'Elena', '687412033'),
(10, 'Quesada Foi', '08456999G', 23, 'Jorge', '687452100'),


--
-- �?ndices para tablas volcadas
--

--
-- Indices de la tabla `ciudadanos`
--
ALTER TABLE `ciudadanos`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ciudadanos`
--
ALTER TABLE `ciudadanos`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=94;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
