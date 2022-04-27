

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";



--
-- Database:
-- Table structure 
--

CREATE TABLE IF NOT EXISTS `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `user_ame` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mobile` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table 
--

INSERT INTO `student` (`id`, `first_name`, `last_name`, `user_name`, `password`, `email`, `mobile`) VALUES
(1, 'firstName1', 'lastname1', 'username1', 'password1', 'test@gmail.com', 243253434),
(2, 'firstName2', 'lastname2', 'username2', 'password2', 'testt@gmail.com', 556544543),
(3, 'firstName3', 'lastname3', 'username3', 'password3', 'testtt@gmail.com', 34666466);
