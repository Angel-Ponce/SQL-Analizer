# FIRST RUN THIS QUERY #
CREATE DATABASE analizer;

# SECOND RUN THOSE QUERYS #
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `edad` int(11) NOT NULL,
  `estado` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

INSERT INTO `usuario` (`id`, `nombre`, `edad`, `estado`) VALUES
(1, 'Angel Ponce', 20, 1),
(2, 'Carlos Dubón', 21, 1),
(3, 'Sergio Morán', 19, 0),
(4, 'Samantha Chub', 19, 1),
(5, 'Celeste Morales', 20, 0),
(6, 'Sergio Santos', 22, 1),
(7, 'Jonathan Riveiro', 20, 1),
(8, 'Oscar Sierra', 20, 0),
(9, 'Mario Armas', 22, 0),
(10, 'Kevin Briones', 21, 0);