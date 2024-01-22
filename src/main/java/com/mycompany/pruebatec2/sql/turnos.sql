-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-01-2024 a las 11:06:59
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
-- Estructura de tabla para la tabla `turnos`
--

CREATE TABLE `turnos` (
  `id` int(11) NOT NULL,
  `descripcionTramite` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `hora` varchar(255) DEFAULT NULL,
  `numero` bigint(5) DEFAULT NULL,
  `ciudadano_dni` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `turnos`
--

INSERT INTO `turnos` (`id`, `descripcionTramite`, `estado`, `fecha`, `hora`, `numero`, `ciudadano_dni`) VALUES
(1, 'Metamorfosis CromÃ¡tica - Javier Medina', 'en espera', '2024-01-21', '13:15 - 14:00', 52, 1),
(2, 'Resonancias Urbanas - Valentina Ramos', 'en espera', '2024-01-20', '08:00 - 08:45', 96, 51),
(3, 'Sinfoni�a en Azul - MartÃ­n Vargas', 'ya atendido', '2024-01-20', '08:00 - 08:45', 22, 53),
(4, 'Resonancias Urbanas - Valentina Ramos', 'en espera', '2024-01-21', '08:00 - 08:45', 24, 41),
(5, 'Metamorfosis Cromatica - Javier Medina', 'ya atendido', '2024-01-20', '14:00 - 14:45', 53, 1),
(6, 'Entre Sombras y Luces - Camila Torres', 'en espera', '2024-01-21', '08:00 - 08:45', 92, 13),
(7, 'Jardines del MaÃ±ana - Clara Hernandez', 'en espera', '2024-01-21', '11:00 - 11:45', 2, 13),
(8, 'Entre Sombras y Luces - Camila Torres', 'ya atendido', '2024-01-21', '08:00 - 08:45', 31, 73),
(9, 'Resonancias Urbanas - Valentina Ramos', 'en espera', '2024-01-21', '11:00 - 11:45', 48, 1),
(10, 'Abstracciones en Movimiento - Andres Rodri�guez', 'ya atendido', '2024-01-20', '09:30 - 10:15', 46, 1),


--
-- �?ndices para tablas volcadas
--

--
-- Indices de la tabla `turnos`
--
ALTER TABLE `turnos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_turnos_ciudadano_dni` (`ciudadano_dni`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `turnos`
--
ALTER TABLE `turnos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `turnos`
--
ALTER TABLE `turnos`
  ADD CONSTRAINT `FK_turnos_ciudadano_dni` FOREIGN KEY (`ciudadano_dni`) REFERENCES `ciudadanos` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
