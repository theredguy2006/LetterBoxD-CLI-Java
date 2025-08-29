-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 28, 2024 at 01:07 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `letterboxd`
--

-- --------------------------------------------------------

--
-- Table structure for table `movie`
--

CREATE TABLE `movie` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `d_name` varchar(50) DEFAULT NULL,
  `release_date` varchar(20) DEFAULT NULL,
  `ratings` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `movie`
--

INSERT INTO `movie` (`id`, `name`, `d_name`, `release_date`, `ratings`) VALUES
(1, 'The Godfather', 'Francis Ford Coppola', '1972-03-24', 9),
(2, 'Casablanca', 'Michael Curtiz', '1942-11-26', 9),
(3, 'Citizen Kane', 'Orson Welles', '1941-09-05', 9),
(4, 'Gone with the Wind', 'Victor Fleming', '1939-12-15', 9),
(5, 'Lawrence of Arabia', 'David Lean', '1962-12-10', 9),
(6, 'The Wizard of Oz', 'Victor Fleming', '1939-08-25', 9),
(7, 'Schindler\'s List', 'Steven Spielberg', '1993-12-15', 9),
(8, 'Pulp Fiction', 'Quentin Tarantino', '1994-10-14', 9),
(9, 'Singin\' in the Rain', 'Gene Kelly', '1952-04-10', 9),
(10, 'Raging Bull', 'Martin Scorsese', '1980-11-14', 9),
(11, '2001: A Space Odyssey', 'Stanley Kubrick', '1968-04-03', 9),
(12, 'North by Northwest', 'Alfred Hitchcock', '1959-07-01', 9),
(13, 'Psycho', 'Alfred Hitchcock', '1960-06-16', 9),
(14, 'The Shawshank Redemption', 'Frank Darabont', '1994-09-23', 9),
(15, 'The Empire Strikes Back', 'Irvin Kershner', '1980-05-21', 9),
(16, 'Chinatown', 'Roman Polanski', '1974-06-20', 9),
(17, 'One Flew Over the Cuckoo\'s Nest', 'Milos Forman', '1975-11-19', 9),
(18, 'Vertigo', 'Alfred Hitchcock', '1958-05-09', 9),
(19, 'The Good, the Bad and the Ugly', 'Sergio Leone', '1966-12-23', 9),
(20, 'Forrest Gump', 'Robert Zemeckis', '1994-07-06', 9),
(21, 'Sunset Boulevard', 'Billy Wilder', '1950-08-10', 9),
(22, 'Apocalypse Now', 'Francis Ford Coppola', '1979-08-15', 9),
(23, 'Rear Window', 'Alfred Hitchcock', '1954-09-01', 9),
(24, 'A Clockwork Orange', 'Stanley Kubrick', '1971-12-19', 9),
(25, 'The Sound of Music', 'Robert Wise', '1965-03-02', 9),
(26, 'The Lord of the Rings: The Fellowship of the Ring', 'Peter Jackson', '2001-12-19', 9),
(27, 'Goodfellas', 'Martin Scorsese', '1990-09-19', 9),
(28, 'The Matrix', 'Lana Wachowski, Lilly Wachowski', '1999-03-31', 9),
(29, 'Star Wars: A New Hope', 'George Lucas', '1977-05-25', 9),
(30, 'The Silence of the Lambs', 'Jonathan Demme', '1991-02-14', 9),
(31, 'Saving Private Ryan', 'Steven Spielberg', '1998-07-24', 9),
(32, 'Gladiator', 'Ridley Scott', '2000-05-05', 9),
(33, 'Braveheart', 'Mel Gibson', '1995-05-24', 9),
(34, 'Titanic', 'James Cameron', '1997-12-19', 9),
(35, 'The Departed', 'Martin Scorsese', '2006-10-06', 9),
(36, 'E.T. the Extra-Terrestrial', 'Steven Spielberg', '1982-06-11', 9),
(37, 'Fight Club', 'David Fincher', '1999-10-15', 9),
(38, 'Blade Runner', 'Ridley Scott', '1982-06-25', 9),
(39, 'The Dark Knight', 'Christopher Nolan', '2008-07-18', 9),
(40, 'The Lion King', 'Roger Allers, Rob Minkoff', '1994-06-15', 9),
(41, 'Jurassic Park', 'Steven Spielberg', '1993-06-11', 9),
(42, 'Back to the Future', 'Robert Zemeckis', '1985-07-03', 9),
(43, 'The Green Mile', 'Frank Darabont', '1999-12-10', 9),
(44, 'Rocky', 'John G. Avildsen', '1976-11-21', 9),
(45, 'Jaws', 'Steven Spielberg', '1975-06-20', 9),
(46, 'The Exorcist', 'William Friedkin', '1973-12-26', 9),
(47, 'Iron Man', 'Jon Favreau', '2008-05-02', 8),
(48, 'The Incredible Hulk', 'Louis Leterrier', '2008-06-13', 7),
(49, 'Iron Man 2', 'Jon Favreau', '2010-05-07', 7),
(50, 'Thor', 'Kenneth Branagh', '2011-05-06', 7),
(51, 'Captain America: The First Avenger', 'Joe Johnston', '2011-07-22', 7),
(52, 'The Avengers', 'Joss Whedon', '2012-05-04', 8),
(53, 'Iron Man 3', 'Shane Black', '2013-05-03', 7),
(54, 'Thor: The Dark World', 'Alan Taylor', '2013-11-08', 7),
(55, 'Captain America: The Winter Soldier', 'Anthony Russo, Joe Russo', '2014-04-04', 8),
(56, 'Guardians of the Galaxy', 'James Gunn', '2014-08-01', 8),
(57, 'Avengers: Age of Ultron', 'Joss Whedon', '2015-05-01', 7),
(58, 'Ant-Man', 'Peyton Reed', '2015-07-17', 7),
(59, 'Captain America: Civil War', 'Anthony Russo, Joe Russo', '2016-05-06', 8),
(60, 'Doctor Strange', 'Scott Derrickson', '2016-11-04', 7),
(61, 'Guardians of the Galaxy Vol. 2', 'James Gunn', '2017-05-05', 7),
(62, 'Spider-Man: Homecoming', 'Jon Watts', '2017-07-07', 8),
(63, 'Thor: Ragnarok', 'Taika Waititi', '2017-11-03', 8),
(64, 'Black Panther', 'Ryan Coogler', '2018-02-16', 8),
(65, 'Avengers: Infinity War', 'Anthony Russo, Joe Russo', '2018-04-27', 8),
(66, 'Ant-Man and the Wasp', 'Peyton Reed', '2018-07-06', 7),
(67, 'Captain Marvel', 'Anna Boden, Ryan Fleck', '2019-03-08', 7),
(68, 'Avengers: Endgame', 'Anthony Russo, Joe Russo', '2019-04-26', 9),
(69, 'Spider-Man: Far From Home', 'Jon Watts', '2019-07-02', 7),
(70, 'Shang-Chi and the Legend of the Ten Rings', 'Destin Daniel Cretton', '2021-09-03', 7),
(71, 'Eternals', 'Chloé Zhao', '2021-11-05', 6),
(72, 'Spider-Man: No Way Home', 'Jon Watts', '2021-12-17', 8),
(73, 'Doctor Strange in the Multiverse of Madness', 'Sam Raimi', '2022-05-06', 7),
(74, 'Thor: Love and Thunder', 'Taika Waititi', '2022-07-08', 6),
(75, 'Black Panther: Wakanda Forever', 'Ryan Coogler', '2022-11-11', 7),
(76, 'Man of Steel', 'Zack Snyder', '2013-06-14', 7),
(77, 'Batman v Superman: Dawn of Justice', 'Zack Snyder', '2016-03-25', 6),
(78, 'Suicide Squad', 'David Ayer', '2016-08-05', 6),
(79, 'Wonder Woman', 'Patty Jenkins', '2017-06-02', 8),
(80, 'Justice League', 'Zack Snyder', '2017-11-17', 6),
(81, 'Aquaman', 'James Wan', '2018-12-21', 7),
(82, 'Shazam!', 'David F. Sandberg', '2019-04-05', 7),
(83, 'Birds of Prey', 'Cathy Yan', '2020-02-07', 6),
(84, 'Wonder Woman 1984', 'Patty Jenkins', '2020-12-25', 6),
(85, 'Zack Snyder\'s Justice League', 'Zack Snyder', '2021-03-18', 8),
(86, 'The Suicide Squad', 'James Gunn', '2021-08-06', 7),
(87, 'The Batman', 'Matt Reeves', '2022-03-04', 8),
(88, 'Black Adam', 'Jaume Collet-Serra', '2022-10-21', 6),
(89, 'Shazam! Fury of the Gods', 'David F. Sandberg', '2023-03-17', 6),
(90, 'The Flash', 'Andy Muschietti', '2023-06-16', 6);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `u_id` int(11) NOT NULL,
  `u_name` varchar(50) DEFAULT NULL,
  `u_email` varchar(50) DEFAULT NULL,
  `u_pw` varchar(50) DEFAULT NULL,
  `u_watched` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`u_id`, `u_name`, `u_email`, `u_pw`, `u_watched`) VALUES
(1, 'temp', 'cosmic.cowboy@gmail.com', '123', 15),
(2, 'Quantum_Quokka', 'quantum.quokka@gmail.com', 'qk4ever!', 25),
(3, 'Nebula_Ninja', 'nebula.ninja@gmail.com', 'galaxy123', 30),
(4, 'Zen_Zebra', 'zen.zebra@gmail.com', 'stripey99', 40),
(5, 'Maverick_Mole', 'maverick.mole@gmail.com', 'burrow23', 55),
(6, 'Lunar_Lynx', 'lunar.lynx@gmail.com', 'moonlight77', 10),
(7, 'Robo_Rhino', 'robo.rhino@gmail.com', 'techno88', 5),
(8, 'Funky_Falcon', 'funky.falcon@gmail.com', 'flyhigh56', 12),
(9, 'Astro_Aardvark', 'astro.aardvark@gmail.com', 'spacey44', 20),
(10, 'Jazzy_Jaguar', 'jazzy.jaguar@gmail.com', 'rhythm55', 65);

-- --------------------------------------------------------

--
-- Table structure for table `watched`
--

CREATE TABLE `watched` (
  `watched_id` int(11) NOT NULL,
  `id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL CHECK (`rating` between 1 and 10)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `watched`
--

INSERT INTO `watched` (`watched_id`, `id`, `user_id`, `rating`) VALUES
(1, 1, 1, 8),
(2, 2, 1, 9),
(3, 3, 2, 7),
(4, 4, 3, 10),
(5, 5, 4, 8),
(6, 6, 5, 9),
(7, 7, 6, 6),
(8, 8, 7, 8),
(9, 9, 8, 9),
(10, 10, 9, 7),
(11, 13, 1, 10),
(12, 16, 1, 10),
(13, 87, 1, 7),
(14, 13, 1, 8),
(15, 13, 1, 8),
(16, 19, 1, 8),
(17, 23, 1, 8);

-- --------------------------------------------------------

--
-- Table structure for table `watchlist`
--

CREATE TABLE `watchlist` (
  `watchlist_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `watchlist_name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `watchlist`
--

INSERT INTO `watchlist` (`watchlist_id`, `user_id`, `watchlist_name`) VALUES
(2, 2, 'Drama Collection'),
(3, 3, 'Sci-Fi Favorites'),
(4, 4, 'Animation Picks'),
(5, 5, 'Crime Classics'),
(6, 6, 'Adventure Watchlist'),
(7, 7, 'Fantasy Legends'),
(8, 8, 'Top Rated'),
(9, 9, 'Marvel Movies'),
(10, 10, 'DC Movies'),
(11, 1, 'FunToWatch');

-- --------------------------------------------------------

--
-- Table structure for table `watchlist_movie`
--

CREATE TABLE `watchlist_movie` (
  `u_id` int(11) DEFAULT NULL,
  `id` int(11) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `watchlist_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `watchlist_movie`
--

INSERT INTO `watchlist_movie` (`u_id`, `id`, `rating`, `watchlist_id`) VALUES
(1, 2, 9, 2),
(2, 3, 7, 3),
(3, 4, 10, 4),
(4, 5, 8, 5),
(5, 6, 9, 6),
(6, 7, 6, 7),
(7, 8, 8, 8),
(8, 9, 9, 9),
(9, 10, 7, 10),
(NULL, 15, NULL, 11),
(NULL, 24, NULL, 11);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `movie`
--
ALTER TABLE `movie`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`u_id`);

--
-- Indexes for table `watched`
--
ALTER TABLE `watched`
  ADD PRIMARY KEY (`watched_id`),
  ADD KEY `id` (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `watchlist`
--
ALTER TABLE `watchlist`
  ADD PRIMARY KEY (`watchlist_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `watchlist_movie`
--
ALTER TABLE `watchlist_movie`
  ADD KEY `u_id` (`u_id`),
  ADD KEY `movie_id` (`id`),
  ADD KEY `fk_watchlist` (`watchlist_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `movie`
--
ALTER TABLE `movie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=91;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `watched`
--
ALTER TABLE `watched`
  MODIFY `watched_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `watchlist`
--
ALTER TABLE `watchlist`
  MODIFY `watchlist_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `watched`
--
ALTER TABLE `watched`
  ADD CONSTRAINT `watched_ibfk_1` FOREIGN KEY (`id`) REFERENCES `movie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `watched_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `watchlist`
--
ALTER TABLE `watchlist`
  ADD CONSTRAINT `watchlist_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE;

--
-- Constraints for table `watchlist_movie`
--
ALTER TABLE `watchlist_movie`
  ADD CONSTRAINT `fk_watchlist` FOREIGN KEY (`watchlist_id`) REFERENCES `watchlist` (`watchlist_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `watchlist_movie_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `watchlist_movie_ibfk_2` FOREIGN KEY (`id`) REFERENCES `movie` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
