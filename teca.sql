-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-06-2025 a las 18:05:19
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
-- Base de datos: `teca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genero`
--

CREATE TABLE `genero` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `genero`
--

INSERT INTO `genero` (`id`, `nombre`) VALUES
(5, 'Drama'),
(6, 'Thriller'),
(7, 'Acción'),
(8, 'Aventura'),
(9, 'Fantasía'),
(10, 'Magia'),
(11, 'Ciencia ficción'),
(12, 'Animación'),
(13, 'Musical'),
(14, 'Desarrollo personal'),
(15, 'Comunicación'),
(16, 'Psicología'),
(17, 'Ciencia'),
(18, 'Filosofía'),
(19, 'Biografía'),
(20, 'Nutrición'),
(21, 'Deporte'),
(22, 'I Guerra Mundial'),
(23, 'II Guerra Mundial'),
(24, 'Romance'),
(25, 'Paternidad'),
(26, 'Educación'),
(27, 'Viajes'),
(28, 'Historia'),
(29, 'Astronomía'),
(30, 'Mitología'),
(31, 'Biología'),
(32, 'Holocausto'),
(33, 'Amor'),
(34, 'Fútbol'),
(35, 'Clásico'),
(36, 'Terror'),
(37, 'Policíaco'),
(38, 'Thriller psicológico'),
(39, 'Documental'),
(40, 'Distopía'),
(41, 'Infantil'),
(42, 'Western'),
(43, 'Política'),
(44, 'Crimen'),
(45, 'Carcelario'),
(46, 'Relaciones sociales'),
(47, 'Matemáticas'),
(48, 'Enfermedad'),
(49, 'Bélico'),
(50, 'Comedia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `id` bigint(20) NOT NULL,
  `titulo` varchar(200) NOT NULL,
  `titulo_original` varchar(200) NOT NULL,
  `anio_lanzamiento` int(11) NOT NULL,
  `paginas_aprox` int(11) NOT NULL,
  `sinopsis` text NOT NULL,
  `imagen` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`id`, `titulo`, `titulo_original`, `anio_lanzamiento`, `paginas_aprox`, `sinopsis`, `imagen`) VALUES
(2, 'ejemplo', 'example', 2000, 100, 'nd', 'nd'),
(3, 'libro', 'book', 2000, 200, 'nd', 'nd');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro_genero`
--

CREATE TABLE `libro_genero` (
  `id_libro` bigint(20) NOT NULL,
  `id_genero` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `libro_genero`
--

INSERT INTO `libro_genero` (`id_libro`, `id_genero`) VALUES
(2, 20),
(2, 22),
(3, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro_participante`
--

CREATE TABLE `libro_participante` (
  `id_libro` bigint(20) NOT NULL,
  `id_participante` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `libro_participante`
--

INSERT INTO `libro_participante` (`id_libro`, `id_participante`) VALUES
(2, 6),
(3, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro_valoracion`
--

CREATE TABLE `libro_valoracion` (
  `id_libro` bigint(20) NOT NULL,
  `valoracion` decimal(10,2) NOT NULL,
  `fav` tinyint(1) NOT NULL,
  `critica` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `libro_valoracion`
--

INSERT INTO `libro_valoracion` (`id_libro`, `valoracion`, `fav`, `critica`) VALUES
(2, 2.00, 0, 'nd'),
(3, 3.00, 1, 'nd');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pais`
--

CREATE TABLE `pais` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `bandera` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pais`
--

INSERT INTO `pais` (`id`, `nombre`, `bandera`) VALUES
(1, 'España', 'https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Bandera_de_España.svg/1200px-Bandera_de_España.svg.png'),
(4, 'Reino Unido', 'https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/Flag_of_the_United_Kingdom_%283-5%29.svg/1280px-Flag_of_the_United_Kingdom_%283-5%29.svg.png'),
(5, 'Estados Unidos', 'https://banderasysoportes.com/xen_media/bandera-eeuu.jpg'),
(6, 'Alemania', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/ba/Flag_of_Germany.svg/960px-Flag_of_Germany.svg.png'),
(7, 'Francia', 'https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/Flag_of_France.svg/2560px-Flag_of_France.svg.png'),
(8, 'Argentina', 'https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/Flag_of_Argentina.svg/1280px-Flag_of_Argentina.svg.png'),
(9, 'Brasil', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/Flag_of_Brazil.svg/1024px-Flag_of_Brazil.svg.png'),
(10, 'Italia', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/03/Flag_of_Italy.svg/2560px-Flag_of_Italy.svg.png'),
(11, 'Países Bajos', 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/20/Flag_of_the_Netherlands.svg/1200px-Flag_of_the_Netherlands.svg.png'),
(12, 'Portugal', 'https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Flag_of_Portugal.svg/2560px-Flag_of_Portugal.svg.png'),
(13, 'Cuba', 'https://img.freepik.com/fotos-premium/bandera-nacional-tela-cuba-simbolo-mundo-internacional-america-pais-caribe_113767-1645.jpg'),
(14, 'Canadá', 'https://st2.depositphotos.com/4744673/8052/v/950/depositphotos_80525134-stock-illustration-flag-of-canada.jpg'),
(15, 'Dinamarca', 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Flag_of_Denmark.svg/1200px-Flag_of_Denmark.svg.png'),
(16, 'Mexico', 'https://upload.wikimedia.org/wikipedia/commons/thumb/f/fc/Flag_of_Mexico.svg/2560px-Flag_of_Mexico.svg.png'),
(17, 'Colombia', 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Flag_of_Colombia.svg/330px-Flag_of_Colombia.svg.png'),
(18, 'Chile', 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/78/Flag_of_Chile.svg/330px-Flag_of_Chile.svg.png'),
(19, 'Ecuador', 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/e8/Flag_of_Ecuador.svg/2560px-Flag_of_Ecuador.svg.png'),
(20, 'Venezuela', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/06/Flag_of_Venezuela.svg/800px-Flag_of_Venezuela.svg.png'),
(21, 'Polonia', 'https://upload.wikimedia.org/wikipedia/commons/1/12/Flag_of_Poland.svg'),
(22, 'Tailandia', 'https://upload.wikimedia.org/wikipedia/commons/a/a9/Flag_of_Thailand.svg'),
(23, 'Japón', 'https://upload.wikimedia.org/wikipedia/commons/9/9e/Flag_of_Japan.svg'),
(24, 'China', 'https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Flag_of_the_People%27s_Republic_of_China.svg/1200px-Flag_of_the_People%27s_Republic_of_China.svg.png'),
(25, 'Corea del Sur', 'https://upload.wikimedia.org/wikipedia/commons/0/09/Flag_of_South_Korea.svg'),
(26, 'Grecia', 'https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Flag_of_Greece.svg/1200px-Flag_of_Greece.svg.png'),
(27, 'Suiza', 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/92/Civil_Ensign_of_Switzerland_%28Pantone%29.svg/250px-Civil_Ensign_of_Switzerland_%28Pantone%29.svg.png'),
(28, 'Irlanda', 'https://www.comprarbanderas.es/images/banderas/400/87-irlanda_400px.jpg'),
(29, 'Noruega', 'https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Flag_of_Norway.svg/640px-Flag_of_Norway.svg.png'),
(30, 'Suecia', 'https://upload.wikimedia.org/wikipedia/commons/4/4c/Flag_of_Sweden.svg'),
(31, 'Finlandia', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/bc/Flag_of_Finland.svg/960px-Flag_of_Finland.svg.png'),
(32, 'Estonia', 'https://upload.wikimedia.org/wikipedia/commons/thumb/8/8f/Flag_of_Estonia.svg/330px-Flag_of_Estonia.svg.png'),
(33, 'Letonia', 'https://www.comprarbanderas.es/images/banderas/400/103-letonia_400px.jpg'),
(34, 'Lituania', 'https://upload.wikimedia.org/wikipedia/commons/1/11/Flag_of_Lithuania.svg'),
(35, 'Rusia', 'https://upload.wikimedia.org/wikipedia/commons/f/f3/Flag_of_Russia.svg'),
(36, 'Ucrania', 'https://upload.wikimedia.org/wikipedia/commons/thumb/4/49/Flag_of_Ukraine.svg/250px-Flag_of_Ukraine.svg.png'),
(37, 'Bielorrusia', 'https://upload.wikimedia.org/wikipedia/commons/thumb/8/85/Flag_of_Belarus.svg/1200px-Flag_of_Belarus.svg.png'),
(38, 'Hungría', 'https://www.recon-company.com/media/image/ea/a8/c5/flagge-ungarn_91905_1_600x600.jpg'),
(39, 'Moldavia', 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/27/Flag_of_Moldova.svg/960px-Flag_of_Moldova.svg.png'),
(40, 'Andorra', 'https://upload.wikimedia.org/wikipedia/commons/1/19/Flag_of_Andorra.svg'),
(41, 'Croacia', 'https://www.comprarbanderas.es/images/banderas/400/51-croacia_400px.jpg'),
(42, 'Bosnia', 'https://media.car-flags.eu/media/catalog/product/cache/78ead0662930e105a85d1fa3f0325792/B/A/BA-1x1.5.png'),
(43, 'Rumanía', 'https://upload.wikimedia.org/wikipedia/commons/7/73/Flag_of_Romania.svg'),
(44, 'Eslovenia', 'https://img.freepik.com/fotos-premium/fondo-textil-bandera-nacional-tela-eslovenia-simbolo-mundo-europeo-pais_113767-1799.jpg'),
(45, 'Eslovaquia', 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/e6/Flag_of_Slovakia.svg/800px-Flag_of_Slovakia.svg.png'),
(46, 'Austria', 'https://upload.wikimedia.org/wikipedia/commons/thumb/4/41/Flag_of_Austria.svg/800px-Flag_of_Austria.svg.png'),
(47, 'Serbia', 'https://upload.wikimedia.org/wikipedia/commons/f/ff/Flag_of_Serbia.svg'),
(48, 'Kosovo', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTp6xD88MTrWUwYTz84lP6BZznUD7qOkJk0Gw&s'),
(49, 'Montenegro', 'https://upload.wikimedia.org/wikipedia/commons/thumb/6/64/Flag_of_Montenegro.svg/1200px-Flag_of_Montenegro.svg.png'),
(50, 'India', 'https://upload.wikimedia.org/wikipedia/commons/thumb/4/41/Flag_of_India.svg/1200px-Flag_of_India.svg.png'),
(51, 'Uruguay', 'https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Uruguay.svg/1200px-Flag_of_Uruguay.svg.png'),
(52, 'Nicaragua', 'https://upload.wikimedia.org/wikipedia/commons/1/19/Flag_of_Nicaragua.svg'),
(53, 'Costa Rica', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/bc/Flag_of_Costa_Rica_%28state%29.svg/1280px-Flag_of_Costa_Rica_%28state%29.svg.png'),
(54, 'Panamá', 'https://upload.wikimedia.org/wikipedia/commons/a/ab/Flag_of_Panama.svg'),
(55, 'República Dominicana', 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/9f/Flag_of_the_Dominican_Republic.svg/640px-Flag_of_the_Dominican_Republic.svg.png'),
(56, 'Perú', 'https://www.comprarbanderas.es/images/banderas/400/143-peru_400px.jpg'),
(57, 'Bolivia', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b3/Bandera_de_Bolivia_%28Estado%29.svg/330px-Bandera_de_Bolivia_%28Estado%29.svg.png'),
(58, 'Paraguay', 'https://tiendayofutbol.es/649/bandera-paraguay.jpg'),
(59, 'Guatemala', 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Flag_of_Guatemala.svg/1280px-Flag_of_Guatemala.svg.png'),
(60, 'Honduras', 'https://media.istockphoto.com/id/1175675339/es/foto/bandera-de-tela-nacional-de-honduras-fondo-textil-s%C3%ADmbolo-del-pa%C3%ADs-internacional-de-am%C3%A9rica.jpg?s=612x612&w=0&k=20&c=OcZT9kglTn_wvqytg3ehNF0uF05ExTfi9FhCEz39xq4='),
(61, 'El Salvador', 'https://upload.wikimedia.org/wikipedia/commons/thumb/3/34/Flag_of_El_Salvador.svg/2560px-Flag_of_El_Salvador.svg.png'),
(62, 'Jamaica', 'https://www.comprarbanderas.es/images/banderas/400/93-jamaica_400px.jpg'),
(63, 'Puerto Rico', 'https://upload.wikimedia.org/wikipedia/commons/thumb/d/dc/Flag_of_Puerto_Rico_%281952%E2%80%931995%29.svg/330px-Flag_of_Puerto_Rico_%281952%E2%80%931995%29.svg.png'),
(64, 'Marruecos', 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Flag_of_Morocco.svg/330px-Flag_of_Morocco.svg.png'),
(65, 'Bulgaria', 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/9a/Flag_of_Bulgaria.svg/960px-Flag_of_Bulgaria.svg.png'),
(66, 'Turquía', 'https://upload.wikimedia.org/wikipedia/commons/b/b4/Flag_of_Turkey.svg'),
(67, 'Georgia', 'https://upload.wikimedia.org/wikipedia/commons/0/0f/Flag_of_Georgia.svg'),
(68, 'Sudáfrica', 'https://upload.wikimedia.org/wikipedia/commons/thumb/a/af/Flag_of_South_Africa.svg/1200px-Flag_of_South_Africa.svg.png'),
(69, 'Indonesia', 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/9f/Flag_of_Indonesia.svg/800px-Flag_of_Indonesia.svg.png'),
(70, 'Malasia', 'https://media.istockphoto.com/id/1258709699/es/vector/antecedentes-de-la-bandera-nacional.jpg?s=612x612&w=0&k=20&c=aT0QZLLfAaj8kU-u7NJTiyEitdXBBLlaRCE-kxzSfyI='),
(71, 'Israel', 'https://upload.wikimedia.org/wikipedia/commons/d/d4/Flag_of_Israel.svg'),
(72, 'Australia', 'https://upload.wikimedia.org/wikipedia/commons/8/88/Flag_of_Australia_%28converted%29.svg'),
(73, 'Nueva Zelanda', 'https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/Flag_of_New_Zealand.svg/2560px-Flag_of_New_Zealand.svg.png'),
(74, 'Vietnam', 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Flag_of_Vietnam.svg/1200px-Flag_of_Vietnam.svg.png'),
(75, 'Laos', 'https://upload.wikimedia.org/wikipedia/commons/thumb/5/56/Flag_of_Laos.svg/1200px-Flag_of_Laos.svg.png'),
(76, 'Camboya', 'https://upload.wikimedia.org/wikipedia/commons/8/83/Flag_of_Cambodia.svg'),
(77, 'Filipinas', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS4nPl_0n5J58Mc7k5wLKIXpet_EuRSPRnkxw&s');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `participante`
--

CREATE TABLE `participante` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `fecha_fallecimiento` date DEFAULT NULL,
  `imagen` varchar(1000) DEFAULT NULL,
  `id_pais` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `participante`
--

INSERT INTO `participante` (`id`, `nombre`, `fecha_nacimiento`, `fecha_fallecimiento`, `imagen`, `id_pais`) VALUES
(3, 'Participante', '1980-01-01', '2010-01-01', 'nd', 1),
(4, 'participante', '1980-01-01', NULL, 'nd', 1),
(5, 'participante2', '1980-01-01', NULL, 'nd', 1),
(6, 'javi', '2003-04-25', NULL, 'nd', 1),
(10, 'antonioo', '2002-01-20', NULL, 'nd', 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelicula`
--

CREATE TABLE `pelicula` (
  `id` bigint(20) NOT NULL,
  `titulo` varchar(200) NOT NULL,
  `titulo_original` varchar(200) NOT NULL,
  `anio_estreno` int(11) NOT NULL,
  `duracion` int(11) NOT NULL,
  `sinopsis` text NOT NULL,
  `imagen` varchar(1000) DEFAULT NULL,
  `id_pais` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pelicula`
--

INSERT INTO `pelicula` (`id`, `titulo`, `titulo_original`, `anio_estreno`, `duracion`, `sinopsis`, `imagen`, `id_pais`) VALUES
(7, 'Harry Potter y la Piedra Filosofal', 'Harry Potter and the Philosopher\'s Stone', 2001, 152, 'nd', 'https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/media/image/2016/12/harry-potter-piedra-filosofal.jpg?tf=2048x', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelicula_genero`
--

CREATE TABLE `pelicula_genero` (
  `id_pelicula` bigint(20) NOT NULL,
  `id_genero` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pelicula_genero`
--

INSERT INTO `pelicula_genero` (`id_pelicula`, `id_genero`) VALUES
(7, 9),
(7, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelicula_participante`
--

CREATE TABLE `pelicula_participante` (
  `id_pelicula` bigint(20) NOT NULL,
  `id_participante` bigint(20) NOT NULL,
  `es_actor` tinyint(1) NOT NULL,
  `es_director` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pelicula_participante`
--

INSERT INTO `pelicula_participante` (`id_pelicula`, `id_participante`, `es_actor`, `es_director`) VALUES
(7, 6, 0, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelicula_valoracion`
--

CREATE TABLE `pelicula_valoracion` (
  `id_pelicula` bigint(20) NOT NULL,
  `valoracion` decimal(10,2) NOT NULL,
  `fav` tinyint(1) NOT NULL,
  `critica` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pelicula_valoracion`
--

INSERT INTO `pelicula_valoracion` (`id_pelicula`, `valoracion`, `fav`, `critica`) VALUES
(7, 5.00, 1, 'nd');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `serie`
--

CREATE TABLE `serie` (
  `id` bigint(20) NOT NULL,
  `titulo` varchar(200) NOT NULL,
  `titulo_original` varchar(200) NOT NULL,
  `terminada` tinyint(1) NOT NULL,
  `sinopsis` text NOT NULL,
  `imagen` varchar(1000) DEFAULT NULL,
  `id_pais` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `serie`
--

INSERT INTO `serie` (`id`, `titulo`, `titulo_original`, `terminada`, `sinopsis`, `imagen`, `id_pais`) VALUES
(2, 'Serie', 'serie', 1, 'nd', 'nd', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `serie_genero`
--

CREATE TABLE `serie_genero` (
  `id_serie` bigint(20) NOT NULL,
  `id_genero` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `serie_participante`
--

CREATE TABLE `serie_participante` (
  `id_serie` bigint(20) NOT NULL,
  `id_participante` bigint(20) NOT NULL,
  `es_actor` tinyint(1) NOT NULL,
  `es_director` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `serie_participante`
--

INSERT INTO `serie_participante` (`id_serie`, `id_participante`, `es_actor`, `es_director`) VALUES
(2, 3, 0, 1),
(2, 6, 0, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `serie_valoracion`
--

CREATE TABLE `serie_valoracion` (
  `id_serie` bigint(20) NOT NULL,
  `valoracion` decimal(10,2) NOT NULL,
  `fav` tinyint(1) NOT NULL,
  `critica` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `serie_valoracion`
--

INSERT INTO `serie_valoracion` (`id_serie`, `valoracion`, `fav`, `critica`) VALUES
(2, 2.00, 0, 'nd');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `temporada`
--

CREATE TABLE `temporada` (
  `id` bigint(20) NOT NULL,
  `numero` int(11) NOT NULL,
  `anio_estreno` int(11) NOT NULL,
  `num_capitulos` int(11) NOT NULL,
  `duracion_media` int(11) NOT NULL,
  `sinopsis` text NOT NULL,
  `id_serie` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `temporada`
--

INSERT INTO `temporada` (`id`, `numero`, `anio_estreno`, `num_capitulos`, `duracion_media`, `sinopsis`, `id_serie`) VALUES
(1, 1, 2000, 10, 40, 'nd', 2),
(4, 2, 2002, 10, 40, 'nd', 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `genero`
--
ALTER TABLE `genero`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `libro_genero`
--
ALTER TABLE `libro_genero`
  ADD PRIMARY KEY (`id_libro`,`id_genero`),
  ADD KEY `id_genero` (`id_genero`);

--
-- Indices de la tabla `libro_participante`
--
ALTER TABLE `libro_participante`
  ADD PRIMARY KEY (`id_libro`,`id_participante`),
  ADD KEY `id_participante` (`id_participante`);

--
-- Indices de la tabla `libro_valoracion`
--
ALTER TABLE `libro_valoracion`
  ADD PRIMARY KEY (`id_libro`);

--
-- Indices de la tabla `pais`
--
ALTER TABLE `pais`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `participante`
--
ALTER TABLE `participante`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_pais` (`id_pais`);

--
-- Indices de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_pais` (`id_pais`);

--
-- Indices de la tabla `pelicula_genero`
--
ALTER TABLE `pelicula_genero`
  ADD PRIMARY KEY (`id_pelicula`,`id_genero`),
  ADD KEY `id_genero` (`id_genero`);

--
-- Indices de la tabla `pelicula_participante`
--
ALTER TABLE `pelicula_participante`
  ADD PRIMARY KEY (`id_pelicula`,`id_participante`),
  ADD KEY `id_participante` (`id_participante`);

--
-- Indices de la tabla `pelicula_valoracion`
--
ALTER TABLE `pelicula_valoracion`
  ADD PRIMARY KEY (`id_pelicula`);

--
-- Indices de la tabla `serie`
--
ALTER TABLE `serie`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_pais` (`id_pais`);

--
-- Indices de la tabla `serie_genero`
--
ALTER TABLE `serie_genero`
  ADD PRIMARY KEY (`id_serie`,`id_genero`),
  ADD KEY `id_genero` (`id_genero`);

--
-- Indices de la tabla `serie_participante`
--
ALTER TABLE `serie_participante`
  ADD PRIMARY KEY (`id_serie`,`id_participante`),
  ADD KEY `id_participante` (`id_participante`);

--
-- Indices de la tabla `serie_valoracion`
--
ALTER TABLE `serie_valoracion`
  ADD PRIMARY KEY (`id_serie`);

--
-- Indices de la tabla `temporada`
--
ALTER TABLE `temporada`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_serie` (`id_serie`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `genero`
--
ALTER TABLE `genero`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT de la tabla `libro`
--
ALTER TABLE `libro`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `pais`
--
ALTER TABLE `pais`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=78;

--
-- AUTO_INCREMENT de la tabla `participante`
--
ALTER TABLE `participante`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `serie`
--
ALTER TABLE `serie`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `temporada`
--
ALTER TABLE `temporada`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `libro_genero`
--
ALTER TABLE `libro_genero`
  ADD CONSTRAINT `libro_genero_ibfk_1` FOREIGN KEY (`id_libro`) REFERENCES `libro` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `libro_genero_ibfk_2` FOREIGN KEY (`id_genero`) REFERENCES `genero` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `libro_participante`
--
ALTER TABLE `libro_participante`
  ADD CONSTRAINT `libro_participante_ibfk_1` FOREIGN KEY (`id_libro`) REFERENCES `libro` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `libro_participante_ibfk_2` FOREIGN KEY (`id_participante`) REFERENCES `participante` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `libro_valoracion`
--
ALTER TABLE `libro_valoracion`
  ADD CONSTRAINT `libro_valoracion_ibfk_1` FOREIGN KEY (`id_libro`) REFERENCES `libro` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `participante`
--
ALTER TABLE `participante`
  ADD CONSTRAINT `participante_ibfk_1` FOREIGN KEY (`id_pais`) REFERENCES `pais` (`id`);

--
-- Filtros para la tabla `pelicula`
--
ALTER TABLE `pelicula`
  ADD CONSTRAINT `pelicula_ibfk_1` FOREIGN KEY (`id_pais`) REFERENCES `pais` (`id`);

--
-- Filtros para la tabla `pelicula_genero`
--
ALTER TABLE `pelicula_genero`
  ADD CONSTRAINT `pelicula_genero_ibfk_1` FOREIGN KEY (`id_pelicula`) REFERENCES `pelicula` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `pelicula_genero_ibfk_2` FOREIGN KEY (`id_genero`) REFERENCES `genero` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `pelicula_participante`
--
ALTER TABLE `pelicula_participante`
  ADD CONSTRAINT `pelicula_participante_ibfk_1` FOREIGN KEY (`id_pelicula`) REFERENCES `pelicula` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `pelicula_participante_ibfk_2` FOREIGN KEY (`id_participante`) REFERENCES `participante` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `pelicula_valoracion`
--
ALTER TABLE `pelicula_valoracion`
  ADD CONSTRAINT `pelicula_valoracion_ibfk_1` FOREIGN KEY (`id_pelicula`) REFERENCES `pelicula` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `serie`
--
ALTER TABLE `serie`
  ADD CONSTRAINT `serie_ibfk_1` FOREIGN KEY (`id_pais`) REFERENCES `pais` (`id`);

--
-- Filtros para la tabla `serie_genero`
--
ALTER TABLE `serie_genero`
  ADD CONSTRAINT `serie_genero_ibfk_1` FOREIGN KEY (`id_serie`) REFERENCES `serie` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `serie_genero_ibfk_2` FOREIGN KEY (`id_genero`) REFERENCES `genero` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `serie_participante`
--
ALTER TABLE `serie_participante`
  ADD CONSTRAINT `serie_participante_ibfk_1` FOREIGN KEY (`id_serie`) REFERENCES `serie` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `serie_participante_ibfk_2` FOREIGN KEY (`id_participante`) REFERENCES `participante` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `serie_valoracion`
--
ALTER TABLE `serie_valoracion`
  ADD CONSTRAINT `serie_valoracion_ibfk_1` FOREIGN KEY (`id_serie`) REFERENCES `serie` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `temporada`
--
ALTER TABLE `temporada`
  ADD CONSTRAINT `temporada_ibfk_1` FOREIGN KEY (`id_serie`) REFERENCES `serie` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
