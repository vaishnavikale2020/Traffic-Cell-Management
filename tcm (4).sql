-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 18, 2019 at 10:43 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 5.6.39

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tcm`
--

-- --------------------------------------------------------

--
-- Table structure for table `allocation`
--

CREATE TABLE `allocation` (
  `id` int(20) NOT NULL,
  `Auth_officer_no` varchar(20) DEFAULT NULL,
  `onduty_officer_no` varchar(20) DEFAULT NULL,
  `tp_no` int(11) NOT NULL,
  `remarks` varchar(50) DEFAULT NULL,
  `from_time` varchar(10) DEFAULT NULL,
  `to_time` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `allocation`
--

INSERT INTO `allocation` (`id`, `Auth_officer_no`, `onduty_officer_no`, `tp_no`, `remarks`, `from_time`, `to_time`) VALUES
(1, NULL, NULL, 0, NULL, NULL, NULL),
(2, '5', '5', 3, '', '', ''),
(3, '5', '5', 3, 'ty', 'f', 'f');

-- --------------------------------------------------------

--
-- Table structure for table `chalan`
--

CREATE TABLE `chalan` (
  `c_id` int(20) NOT NULL,
  `fine` varchar(20) NOT NULL,
  `ipc_no` varchar(20) DEFAULT NULL,
  `description` varchar(20) DEFAULT NULL,
  `offence_no` varchar(20) DEFAULT NULL,
  `offence_description` varchar(20) DEFAULT NULL,
  `long_description` varchar(20) DEFAULT NULL,
  `terms` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `chalan`
--

INSERT INTO `chalan` (`c_id`, `fine`, `ipc_no`, `description`, `offence_no`, `offence_description`, `long_description`, `terms`) VALUES
(22, '2000', '', 'jhbbes', '', '', '', ''),
(23, '', '', '', '', '', '', ''),
(24, '11', '', '11', '', '', '', ''),
(25, '', '', '', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `driver`
--

CREATE TABLE `driver` (
  `id` int(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `age` int(5) NOT NULL,
  `dob` varchar(20) DEFAULT NULL,
  `height` varchar(5) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `address1` varchar(50) DEFAULT NULL,
  `address2` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `driver`
--

INSERT INTO `driver` (`id`, `name`, `age`, `dob`, `height`, `email`, `address1`, `address2`) VALUES
(14, 'test', 70, '20/5/1949', '5.3', 'test@gmail.com', 'shivaji nagar', ''),
(16, 'kid', 10, '', '', '', '', ''),
(17, 'dilip', 12, '', '', '', '', ''),
(18, 'dilip', 12, '', '', '', '', ''),
(19, 'q', 84, '', '', '', '', ''),
(20, 'q', 52, '', '', '', '', ''),
(21, 'hf', 21, '', '', '', '', ''),
(22, 'yash', 12, '', '', '', '', ''),
(23, 'yash', 12, '', '', '', '', ''),
(24, 'gf', 11, '', '', '', '', ''),
(25, 'q', 12, '', '', '', '', ''),
(26, 'mhgs', 654, '', '', '', '', ''),
(27, 'yash', 11, '', '', '', '', ''),
(28, 'qq', 11, '', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `point`
--

CREATE TABLE `point` (
  `id` int(15) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `location` varchar(20) DEFAULT NULL,
  `milestone` varchar(20) DEFAULT NULL,
  `sensitivity` varchar(20) DEFAULT NULL,
  `description` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `point`
--

INSERT INTO `point` (`id`, `name`, `location`, `milestone`, `sensitivity`, `description`) VALUES
(3, 'qass', 'www', 'wqqw', 'ww', 'wqwe'),
(6, 'qq', 'qq', 'qq', 'qq', 'qq');

-- --------------------------------------------------------

--
-- Table structure for table `raising`
--

CREATE TABLE `raising` (
  `id` int(20) NOT NULL,
  `date` varchar(20) DEFAULT NULL,
  `norm_id` varchar(20) DEFAULT NULL,
  `driver_id` varchar(20) DEFAULT NULL,
  `vehical_id` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `raising`
--

INSERT INTO `raising` (`id`, `date`, `norm_id`, `driver_id`, `vehical_id`) VALUES
(1, '2019-03-18', '22', '14', '17');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `id` int(20) NOT NULL,
  `branch_id` int(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `branch_name` varchar(20) NOT NULL,
  `designation` varchar(20) DEFAULT NULL,
  `dob` varchar(20) DEFAULT NULL,
  `age` varchar(20) DEFAULT NULL,
  `joining_date` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `exp` varchar(50) DEFAULT NULL,
  `speciality` varchar(50) NOT NULL,
  `basic` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`id`, `branch_id`, `name`, `branch_name`, `designation`, `dob`, `age`, `joining_date`, `address`, `exp`, `speciality`, `basic`) VALUES
(7, 54, 'abc', 'abc', 'xyzz', '1214', '20', '1212', '4554', 'yes', 'aqs', '5564'),
(5, 6, 'q', 'q', 'qq', 'q', 'q', 'qq', 'q', 'q', 'cyz', 'q');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `uname` varchar(20) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `address` varchar(50) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `uname`, `pass`, `address`, `phone`) VALUES
(1, 'root', 'root', 'pass', 'xyz plaza', '1234567890'),
(7, 'deepeshas', 'dee22@tcm.com', '222asadeep', 'asasasa*2@', '2222222222'),
(5, 'q', 'q', 'q', 'q', '1234567890'),
(6, 'admin', 'adm23@tcm.com', '576amradmi', 'amravati', '9423576230'),
(8, 'qqqq', 'qqq89@tcm.com', '567abcqqqq', 'abcd', '1234567890'),
(9, 'abcd', 'abc89@tcm.com', '567amrabcd', 'amravat', '1234567890'),
(10, 'abcd', 'abc89@tcm.com', '567amrabcd', 'amravat', '1234567890'),
(11, 'qqqqq', 'qqq11@tcm.com', '111qqqqqqq', 'qqqqq', '1111111111'),
(12, 'qq;qq', 'qq;qq@tcm.com', 'qqqqqqqq;q', 'qqqq', 'qqqqqqqqqq'),
(13, 'kapil', 'kap78@tcm.com', '456amrkapi', 'amravati', '1230456789');

-- --------------------------------------------------------

--
-- Table structure for table `vehical`
--

CREATE TABLE `vehical` (
  `id` int(20) NOT NULL,
  `reg_no` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `fuel_type` varchar(20) DEFAULT NULL,
  `engine_type` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vehical`
--

INSERT INTO `vehical` (`id`, `reg_no`, `name`, `fuel_type`, `engine_type`) VALUES
(12, '12', '1212', '', ''),
(13, 'mh 02 9076', 'victor rx', 'petrol', '2 stroke'),
(14, '2020', '', '', ''),
(15, 'mh 27 1210', '', '', ''),
(16, 'mh 27 7825', 'x110r bmw', 'power petrol', '4 stroke+1 / type 5'),
(17, 'mh 27 7825', 'x110r bmw', 'power petrol', '4 stroke+1 / type 5'),
(18, '5', '', '', ''),
(19, '53.', '', '', ''),
(20, '12', 'zmr', '', ''),
(21, '121', '', '', ''),
(22, '121', '', '', ''),
(23, '24', '', '', ''),
(24, '34', '', '', ''),
(25, '4', '', '', ''),
(26, 'mh27 1590', '', '', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `allocation`
--
ALTER TABLE `allocation`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `chalan`
--
ALTER TABLE `chalan`
  ADD PRIMARY KEY (`c_id`);

--
-- Indexes for table `driver`
--
ALTER TABLE `driver`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `point`
--
ALTER TABLE `point`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `raising`
--
ALTER TABLE `raising`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `vehical`
--
ALTER TABLE `vehical`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `allocation`
--
ALTER TABLE `allocation`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `chalan`
--
ALTER TABLE `chalan`
  MODIFY `c_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `driver`
--
ALTER TABLE `driver`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `point`
--
ALTER TABLE `point`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `raising`
--
ALTER TABLE `raising`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `vehical`
--
ALTER TABLE `vehical`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
