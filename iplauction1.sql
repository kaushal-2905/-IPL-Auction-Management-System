-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 01, 2024 at 09:51 AM
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
-- Database: `iplauction1`
--

-- --------------------------------------------------------

--
-- Table structure for table `login_details`
--

CREATE TABLE `login_details` (
  `id_number` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `login_details`
--

INSERT INTO `login_details` (`id_number`, `name`, `password`) VALUES
(111, 'Admin', 'admin123');

-- --------------------------------------------------------

--
-- Table structure for table `player_details`
--

CREATE TABLE `player_details` (
  `player_id` int(10) NOT NULL,
  `player_name` varchar(25) NOT NULL,
  `player_type` varchar(25) NOT NULL,
  `team_name` varchar(25) NOT NULL,
  `base_price` double NOT NULL,
  `is_available` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `player_details`
--

INSERT INTO `player_details` (`player_id`, `player_name`, `player_type`, `team_name`, `base_price`, `is_available`) VALUES
(1111, 'Sam Curran', 'All rounder', 'PBKS', 2, 0),
(1112, 'Cemron Green', 'All rounder', '', 2, 1),
(1113, 'Harry Brook', 'Batsmen', '', 1.5, 1),
(1114, 'Ben Stokes', 'All rounder', '', 2, 1),
(1115, 'Adil Rashid', 'All rounder', '', 2, 1),
(1116, 'Nicholas Pooran', 'Batsmen', '', 2, 1),
(1117, 'Jason Holder', 'Bowler', 'LSG', 1.5, 0),
(1118, 'Mayank Agarwal', 'Bowler', '', 1, 1),
(1119, 'Srikar Bharat', 'Batsmen', '', 1.5, 1),
(1120, 'Shivam Mavi', 'Bowler', 'MI', 1, 0),
(1121, 'Virat Kohli', 'Batsmen', 'rcb', 8, 0),
(1122, 'Faf du Plesis', 'Batsmen', 'rcb', 4, 0),
(1123, 'Finn Allen', 'All rounder', 'rcb', 2, 0),
(1124, 'Rajat Patidar', 'Batsmen', 'rcb', 1, 0),
(1125, 'David Willey', 'Bowler', 'rcb', 1.5, 0),
(1126, 'Dinesh Kartik', 'Wicket keeper', 'rcb', 3, 0),
(1127, 'Glenn Maxwell', 'All rounder', 'rcb', 3, 0),
(1128, 'Harshal Patel', 'Bowler', 'rcb', 2, 0),
(1129, 'Josh Hazelwood', 'Bowler', 'rcb', 1.5, 0),
(1130, 'Mohammed Siraj', 'Bowler', 'rcb', 2.5, 0),
(1131, 'Suresh Raina', 'Batsmen', 'csk', 5, 0),
(1132, 'Ambati Rayudu', 'Batsmen', 'csk', 3, 0),
(1133, 'Deepak Chahar', 'Bowler', 'csk', 2, 0),
(1134, 'Devon Conway', 'All rounder', 'csk', 1.5, 0),
(1135, 'MS Dhoni', 'Wicket keeper', 'csk', 7, 0),
(1136, 'Maheesh Theekshana', 'Bowler', 'csk', 1.5, 0),
(1137, 'Shivam Dube', 'Batsmen', 'csk', 3, 0),
(1138, 'Moeen Ali', 'All rounder', 'csk', 2.5, 0),
(1139, 'Ravindra Jadeja', 'All rounder', 'csk', 5, 0),
(1140, 'Ruturaj Gaikwad', 'Batsmen', 'csk', 4, 0),
(1141, 'Andre Russell', 'All rounder', 'kkr', 4, 0),
(1142, 'Lockie Ferguson', 'Bowler', 'kkr', 2.5, 0),
(1143, 'Nitish Rana', 'Batsmen', 'kkr', 2.5, 0),
(1144, 'Rinku Singh', 'Batsmen', 'kkr', 3, 0),
(1145, 'Shardul Thakur', 'Bowler', 'kkr', 1.5, 0),
(1146, 'Shreyas Iyer', 'Batsmen', 'kkr', 3.5, 0),
(1147, 'Sunil Narine', 'All rounder', 'kkr', 3.5, 0),
(1148, 'Tim Southee', 'Bowler', 'kkr', 1, 0),
(1149, 'Varun Chakravarthy', 'Bowler', 'kkr', 2, 0),
(1150, 'Venkatesh Iyer', 'Batsmen', 'kkr', 2, 0),
(1151, 'Abdul Shamad', 'Batsmen', 'srh', 1.5, 0),
(1152, 'Abhisek Sharma', 'Batsmen', 'srh', 3, 0),
(1153, 'Aiden Markram', 'Batsmen', 'srh', 3.5, 0),
(1154, 'Bhuvneshwar Kumar', 'Bowler', 'srh', 4, 0),
(1155, 'Glenn Philips', 'Batsmen', 'srh', 2, 0),
(1156, 'Kartik Tyagi', 'Batsmen', 'srh', 1.5, 0),
(1157, 'Rahul Tripathi', 'Batsmen', 'srh', 2, 0),
(1158, 'T Natarajan', 'Bowler', 'srh', 3, 0),
(1159, 'Urman Mailk', 'Bowler', 'srh', 2.5, 0),
(1160, 'Henrich Klassen', 'Wicket keeper', 'srh', 4.5, 0),
(1161, 'Anrich Nortje', 'Bowler', 'dc', 1.5, 0),
(1162, 'Axar Patel', 'All rounder', 'dc', 3, 0),
(1163, 'David Warner', 'Batsmen', 'dc', 4, 0),
(1164, 'Kuldeep Yadav', 'Bowler', 'dc', 2.5, 0),
(1165, 'Mitchell Marsh', 'All rounder', 'dc', 4, 0),
(1166, 'Prithvi Shaw', 'Batsmen', 'dc', 3, 0),
(1167, 'Rishabh Pant', 'Wicket keeper', 'dc', 4, 0),
(1168, 'Rovman Powell', 'Al rounder', 'dc', 1.5, 0),
(1169, 'Sarfaraz Khan', 'Batsmen', 'dc', 1, 0),
(1170, 'Lungisani Ngidi', 'Bowler', 'dc', 1, 0),
(1171, 'Alzari Joseph', 'Bowler', 'gt', 2.5, 0),
(1172, 'David Miller', 'All rounder', 'gt', 3, 0),
(1173, 'Hardik Pandya', 'All rounder', 'gt', 3.5, 0),
(1174, 'Jayant Yadav', 'Bowler', 'gt', 2, 0),
(1175, 'Wriddhiman Saha', 'Wicket keeper', 'gt', 2, 0),
(1176, 'Mohmmad Shami', 'Bowler', 'gt', 3, 0),
(1177, 'Rahul Tewatia', 'Batsmen', 'gt', 2, 0),
(1178, 'Rashid Khan', 'All rounder', 'gt', 3, 0),
(1179, 'Shubman Gill', 'Batsmen', 'gt', 5, 0),
(1180, 'Vijay Shankar', 'Batsmen', 'gt', 2.5, 0),
(1181, 'Avesh Khan', 'Bowler', 'lsg', 1.5, 0),
(1182, 'Ayush Badoni', 'Batsmen', 'lsg', 1.5, 0),
(1183, 'Deepak Hooda', 'All rounder', 'lsg', 1.5, 0),
(1184, 'KL Rahul', 'Wicket keeper', 'lsg', 4, 0),
(1185, 'Krunal Pandya', 'All rounder', 'lsg', 2, 0),
(1186, 'Marcus Stoinis', 'All rounder', 'lsg', 3, 0),
(1187, 'Mayank yadav', 'Batsmen', 'lsg', 2, 0),
(1188, 'Mohsin Khan', 'Bowler', 'lsg', 1.5, 0),
(1189, 'Quinton De Kock', 'Batsmen', 'lsg', 3.5, 0),
(1190, 'Ravi Bishnoi', 'Bowler', 'lsg', 2, 0),
(1191, 'Ishan Kishan', 'Wicket keeper', 'mi', 3.5, 0),
(1192, 'Jason Behendroff', 'Bowler', 'mi', 2.5, 0),
(1193, 'Jasprit Bumrah', 'Bowler', 'mi', 4, 0),
(1194, 'Jofra Archer', 'Bowler', 'mi', 3, 0),
(1195, 'Tilak Varma', 'Batsmen', 'mi', 3, 0),
(1196, 'Dewald Brewis', 'All rounder', 'mi', 2, 0),
(1197, 'Arjun Tendulkar', 'Bowler', 'mi', 2, 0),
(1198, 'Rohit Sharma', 'Batsmen', 'mi', 6, 0),
(1199, 'Suryakumar Yadav', 'Batsmen', 'mi', 4, 0),
(1200, 'Tim David', 'All rounder', 'mi', 2, 0),
(1201, 'Devdutt Padikkal', 'Batsmen', 'rr', 2, 0),
(1202, 'Jos Buttler', 'Batsmen', 'rr', 3, 0),
(1203, 'Navdeep Saini', 'Bowler', 'rr', 1, 0),
(1204, 'R Ashwin', 'Bowler', 'rr', 3, 0),
(1205, 'Riyan Parag', 'All rounder', 'rr', 2, 0),
(1206, 'Sanjun Samson', 'Wicket keeper', 'rr', 3.5, 0),
(1207, 'Shimron Hetmyer', 'All rounder', 'rr', 2, 0),
(1208, 'Trent Boult', 'Bowler', 'rr', 3.5, 0),
(1209, 'Yashasvi Jaiswal', 'Batsmen', 'rr', 3.5, 0),
(1210, 'Yuzvendra Chahal', 'Bowler', 'rr', 3, 0),
(1211, 'Shikhar Dhawan', 'Batsmen', 'pk', 3.5, 0),
(1212, 'Sharukh Khan', 'Batsmen', 'pk', 2, 0),
(1213, 'Rahul Chahar', 'Bowler', 'pk', 2, 0),
(1214, 'Arshdeep Singh', 'Bowler', 'pk', 2, 0),
(1215, 'Harpreet Brar', 'All rounder', 'pk', 1.5, 0),
(1216, 'Jitesh Sharma', 'Bowler', 'pk', 1.5, 0),
(1217, 'Liam Livingstone', 'Batsmen', 'pk', 2.5, 0),
(1218, 'Kagiso Rabada', 'Bowler', 'pk', 2.5, 0),
(1219, 'Johnny Bairstow', 'Wicket keeper', 'pk', 3, 0),
(1220, 'Rishi Dhawan', 'Batsmen', 'pk', 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `team_details`
--

CREATE TABLE `team_details` (
  `team_id` int(11) NOT NULL,
  `team_name` varchar(50) NOT NULL,
  `team` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `team_details`
--

INSERT INTO `team_details` (`team_id`, `team_name`, `team`) VALUES
(11, 'Chennai Super Kings', 'CSK'),
(12, 'Royal Challengers Bengaluru', 'RCB'),
(13, 'Gujarat Titans', 'GT'),
(14, 'Kolkata Knight Riders', 'KKR'),
(15, 'Delhi Capitals', 'DC'),
(16, 'Lucknow Super Giants', 'LSG'),
(17, 'Mumbai Indians', 'MI'),
(18, 'Punjab Kings', 'PBKS'),
(19, 'Rajasthan Royals', 'RR'),
(20, 'Sunrisers Hyderabad', 'SRH');

-- --------------------------------------------------------

--
-- Table structure for table `win_details`
--

CREATE TABLE `win_details` (
  `team_name` varchar(30) NOT NULL,
  `year` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `win_details`
--

INSERT INTO `win_details` (`team_name`, `year`) VALUES
('Rajasthan Royals', 2008),
('Delhi Capitals', 2009),
('Chennai Super Kings', 2010),
('Chennai Super Kings', 2011),
('Kolkata Knight Riders', 2012),
('Mumbai Indians', 2013),
('Kolkata Knight Riders', 2014),
('Mumbai Indians', 2015),
('Sunrisers Hyderabad', 2016),
('Mumbai Indians', 2017),
('Chennai Super Kings', 2018),
('Mumbai Indians', 2019),
('Mumbai Indians', 2020),
('Chennai Super Kings', 2021),
('Gujarat Titans', 2022),
('Chennai Super Kings', 2023),
('Kolkata Knight Riders', 2024);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login_details`
--
ALTER TABLE `login_details`
  ADD PRIMARY KEY (`id_number`);

--
-- Indexes for table `player_details`
--
ALTER TABLE `player_details`
  ADD PRIMARY KEY (`player_id`);

--
-- Indexes for table `team_details`
--
ALTER TABLE `team_details`
  ADD PRIMARY KEY (`team_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `player_details`
--
ALTER TABLE `player_details`
  MODIFY `player_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1222;

--
-- AUTO_INCREMENT for table `team_details`
--
ALTER TABLE `team_details`
  MODIFY `team_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
