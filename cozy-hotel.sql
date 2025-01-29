-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 30, 2025 at 12:34 AM
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
-- Database: `cozy-hotel`
--

-- --------------------------------------------------------

--
-- Table structure for table `floors`
--

CREATE TABLE `floors` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `floors`
--

INSERT INTO `floors` (`id`, `name`) VALUES
(1, '1st Floor'),
(2, '2nd Floor'),
(3, '3rd Floor'),
(4, 'Penthouse');

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

CREATE TABLE `rooms` (
  `num` int(11) NOT NULL,
  `type` varchar(10) NOT NULL,
  `floor_id` int(11) NOT NULL,
  `state` varchar(10) NOT NULL,
  `price` varchar(100) NOT NULL,
  `description` varchar(400) NOT NULL,
  `image` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rooms`
--

INSERT INTO `rooms` (`num`, `type`, `floor_id`, `state`, `price`, `description`, `image`) VALUES
(100, 'Simple', 1, 'Free', '25 $ per day', '-Single bedroom\r\n\r\n-Single bathroom\r\n\r\n-Desk\r\n\r\n-Table with chairs\r\n\r\n-A private balcony overlooking the garden ', '/images/100.jpeg'),
(101, 'Double', 1, 'Free', '35 $ per day', '-Double bed\r\n\r\n-Single bathroom\r\n\r\n-Large desk\r\n\r\n-Table with chairs\r\n\r\n-A private balcony overlooking the garden ', '/images/101.jpeg'),
(102, 'Speciality', 1, 'Free', '30 $ per day', 'For Desabled:\r\n\r\n-equipements\r\n\r\n-Single bedroom\r\n\r\n-Single bathroom with equipement\r\n\r\n-Desk\r\n\r\n-Table \r\n\r\n-A private balcony overlooking the garden ', '/images/102.jpeg'),
(103, 'Simple', 1, 'Free', '25 $ per day', '-Single bedroom\r\n\r\n-Single bathroom\r\n\r\n-Desk\r\n\r\n-Table with chairs\r\n\r\n-A private balcony overlooking the garden ', '/images/103.jpeg'),
(104, 'Family', 1, 'Free', '60 $ per day', '3 joined rooms\r\n\r\n*principal:\r\n \r\n-Double bed\r\n\r\n-Single bathroom\r\n\r\n-Desk\r\n\r\n-Table with chairs\r\n\r\n-A private balcony overlooking the garden.\r\n\r\n*secondaries :\r\n\r\n-single beds (depends on the number and\r\n \r\nthat may influence the actual price).\r\n\r\n-2 separate desks.\r\n ', '/images/104.jpeg'),
(105, 'Double', 1, 'Free', '35 $ per day', '-Double bed\r\n\r\n-Single bathroom\r\n\r\n-Large desk\r\n\r\n-Table with chairs\r\n\r\n-A private balcony overlooking the garden. ', '/images/105.jpeg'),
(106, 'Speciality', 2, 'Free', '30 $ per day', 'Studio Room:\r\n\r\n-Single bed\r\n\r\n-Single bathroom\r\n\r\n-Equiped desk\r\n\r\n-Table with chairs\r\n\r\n-A private balcony overlooking the garden ', '/images/106.jpeg'),
(107, 'Suite', 2, 'Free', '65 $ per day', '2 joined rooms + Kitchen\r\n\r\n*principal: \r\n\r\n-Double bed\r\n\r\n-Single bathroom\r\n\r\n-Desk\r\n\r\n-Large balcony with table and chairs \r\n\r\noverlooking the garden\r\n\r\n*secondary :\r\n\r\n-single beds (depends on the number and \r\n\r\nthat may influence the actual price)\r\n\r\n-2 separate desks\r\n\r\n*Equipied kitchen\r\n ', '/images/107.jpeg'),
(108, 'Double', 2, 'Free', '35 $ per day', '-Double bed\r\n\r\n-Single bathroom\r\n\r\n-Large desk\r\n\r\n-Table with chairs\r\n\r\n-A private balcony overlooking the garden. ', '/images/108.jpeg'),
(109, 'Double', 2, 'Free', '35 $ per day', '-Double bed\r\n\r\n-Single bathroom\r\n\r\n-Large desk\r\n\r\n-Table with chairs\r\n\r\n-A private balcony overlooking the garden. ', '/images/109.jpeg'),
(110, 'Simple', 2, 'Free', '25 $ per day', '-Single bedroom\r\n\r\n-Single bathroom\r\n\r\n-Desk\r\n\r\n-Table with chairs\r\n\r\n-A private balcony overlooking the garden ', '/images/110.jpeg'),
(111, 'Simple', 2, 'Free', '25 $ per day', '-Single bedroom\r\n\r\n-Single bathroom\r\n\r\n-Desk\r\n\r\n-Table with chairs\r\n\r\n-A private balcony overlooking the garden ', '/images/111.jpeg'),
(112, 'Family', 3, 'Free', '60 $ per day', '3 joined rooms\r\n\r\n*principal:\r\n \r\n-Double bed\r\n\r\n-Single bathroom\r\n\r\n-Desk\r\n\r\n-Table with chairs\r\n\r\n-A private balcony overlooking the garden.\r\n\r\n*secondaries :\r\n\r\n-single beds (depends on the number and\r\n \r\nthat may influence the actual price).\r\n\r\n-2 separate desks.\r\n ', '/images/112.jpeg'),
(113, 'Family', 3, 'Free', '60 $ per day', '3 joined rooms\r\n\r\n*principal:\r\n \r\n-Double bed\r\n\r\n-Single bathroom\r\n\r\n-Desk\r\n\r\n-Table with chairs\r\n\r\n-A private balcony overlooking the garden.\r\n\r\n*secondaries :\r\n\r\n-single beds (depends on the number and\r\n \r\nthat may influence the actual price).\r\n\r\n-2 separate desks.\r\n ', '/images/113.jpeg'),
(114, 'Family', 3, 'Free', '60 $ per day', '3 joined rooms\r\n\r\n*principal:\r\n \r\n-Double bed\r\n\r\n-Single bathroom\r\n\r\n-Desk\r\n\r\n-Table with chairs\r\n\r\n-A private balcony overlooking the garden.\r\n\r\n*secondaries :\r\n\r\n-single beds (depends on the number and\r\n \r\nthat may influence the actual price).\r\n\r\n-2 separate desks.\r\n ', '/images/114.jpeg'),
(115, 'Suite', 3, 'Free', '65 $ per day', '2 joined rooms + Kitchen\r\n\r\n*principal: \r\n\r\n-Double bed\r\n\r\n-Single bathroom\r\n\r\n-Desk\r\n\r\n-Large balcony with table and chairs \r\n\r\noverlooking the garden\r\n\r\n*secondary :\r\n\r\n-single beds (depends on the number and \r\n\r\nthat may influence the actual price)\r\n\r\n-2 separate desks\r\n\r\n*Equipied kitchen\r\n ', '/images/115.jpeg'),
(116, 'Suite', 3, 'Free', '65 $ per day', '2 joined rooms + Kitchen\r\n\r\n*principal: \r\n\r\n-Double bed\r\n\r\n-Single bathroom\r\n\r\n-Desk\r\n\r\n-Large balcony with table and chairs \r\n\r\noverlooking the garden\r\n\r\n*secondary :\r\n\r\n-single beds (depends on the number and \r\n\r\nthat may influence the actual price)\r\n\r\n-2 separate desks\r\n\r\n*Equipied kitchen\r\n ', '/images/116.jpeg'),
(117, 'Double', 3, 'Free', '35 $ per day', '-Double bed\r\n\r\n-Single bathroom\r\n\r\n-Large desk\r\n\r\n-Table with chairs\r\n\r\n-A private balcony overlooking the garden. ', '/images/117.jpeg'),
(118, 'Suite', 4, 'Free', '80 $ per day', 'Duplex bed\r\n\r\nequiped desks\r\n\r\nequiped bathrooms\r\n\r\nLarge balcony with table and chairs\r\n\r\nequiped kitchen\r\n\r\n2 secondary rooms equiped\r\n\r\nfree services for the first 2 days', '/images/118.jpeg'),
(119, 'Suite', 4, 'Free', '65 $ per day', '2 joined rooms + Kitchen\r\n\r\n*principal: \r\n\r\n-Double bed\r\n\r\n-Single bathroom\r\n\r\n-Desk\r\n\r\n-Large balcony with table and chairs \r\n\r\noverlooking the garden\r\n\r\n*secondary :\r\n\r\n-single beds (depends on the number and \r\n\r\nthat may influence the actual price)\r\n\r\n-2 separate desks\r\n\r\n*Equipied kitchen\r\n ', '/images/119.jpeg'),
(120, 'Suite', 4, 'Free', '65 $ per day', '2 joined rooms + Kitchen\r\n\r\n*principal: \r\n\r\n-Double bed\r\n\r\n-Single bathroom\r\n\r\n-Desk\r\n\r\n-Large balcony with table and chairs \r\n\r\noverlooking the garden\r\n\r\n*secondary :\r\n\r\n-single beds (depends on the number and \r\n\r\nthat may influence the actual price)\r\n\r\n-2 separate desks\r\n\r\n*Equipied kitchen\r\n ', '/images/120.jpeg'),
(121, 'Suite', 4, 'Free', '65 $ per day', '2 joined rooms + Kitchen\r\n\r\n*principal: \r\n\r\n-Double bed\r\n\r\n-Single bathroom\r\n\r\n-Desk\r\n\r\n-Large balcony with table and chairs \r\n\r\noverlooking the garden\r\n\r\n*secondary :\r\n\r\n-single beds (depends on the number and \r\n\r\nthat may influence the actual price)\r\n\r\n-2 separate desks\r\n\r\n*Equipied kitchen\r\n ', '/images/121.jpeg'),
(122, 'Double', 4, 'Free', '35 $ per day', '-Double bed\r\n\r\n-Single bathroom\r\n\r\n-Large desk\r\n\r\n-Table with chairs\r\n\r\n-A private balcony overlooking the garden. ', '/images/122.jpeg'),
(123, 'Simple', 4, 'Free', '25 $ per day', '-Single bedroom\r\n\r\n-Single bathroom\r\n\r\n-Desk\r\n\r\n-Table with chairs\r\n\r\n-A private balcony overlooking the garden ', '/images/123.jpeg'),
(124, 'Double', 4, 'Free', '35 $ per day', '-Double bed\r\n\r\n-Single bathroom\r\n\r\n-Large desk\r\n\r\n-Table with chairs\r\n\r\n-A private balcony overlooking the garden. ', '/images/122.jpeg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `floors`
--
ALTER TABLE `floors`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`num`),
  ADD KEY `floor_id` (`floor_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `floors`
--
ALTER TABLE `floors`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `rooms`
--
ALTER TABLE `rooms`
  MODIFY `num` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=125;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `rooms`
--
ALTER TABLE `rooms`
  ADD CONSTRAINT `rooms_ibfk_1` FOREIGN KEY (`floor_id`) REFERENCES `floors` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
