-- --------------------------------
-- CREATE SCHEMA web_school_tracker
-- --------------------------------
DROP SCHEMA IF EXISTS `school_rest_test` ;
CREATE SCHEMA `school_rest_test` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
use `school_rest_test`;
SET FOREIGN_KEY_CHECKS = 1;
-- --------------------------------
-- CREATE TABLE INSTUCTOR 
-- --------------------------------
DROP TABLE IF EXISTS `instructor`;
CREATE TABLE `instructor`(
	`id` INT NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(45) DEFAULT NULL,
	`Last_name` VARCHAR(45) DEFAULT NULL,
    `email` VARCHAR(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
)ENGINE = InnoDB, AUTO_INCREMENT=1 DEFAULT CHARSET = latin1;

-- --------------------------------
-- CREATE TABLE STUDENT 
-- --------------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- --------------------------------
-- CREATE TABLE COURSE 
-- --------------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `course_code`varchar(128) DEFAULT NULL,
  `course_title` varchar(128) DEFAULT NULL,
  `instructor_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `TITLE_UNIQUE` (`course_code`),
  KEY `FK_INSTRUCTOR_idx` (`instructor_id`),
  CONSTRAINT `FK_INSTRUCTOR` 
  FOREIGN KEY (`instructor_id`) 
  REFERENCES `instructor` (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- --------------------------------
-- CREATE TABLE Day 
-- --------------------------------
DROP TABLE IF EXISTS `day`;
CREATE TABLE `day` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `day_of_week` DATE DEFAULT NULL,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- --------------------------------
-- CREATE TABLE DayTime 
-- ------daytime--------------------------
DROP TABLE IF EXISTS `daytime`;
CREATE TABLE `daytime` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `time_of_day` TIME DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- --------------------------------
-- CREATE TABLE Day_DayTime 
-- ------daytime--------------------------
DROP TABLE IF EXISTS `day_daytime`;
CREATE TABLE `day_daytime` (
  `day_time_id` int(11) NOT NULL,
  `day_id` int(11) NOT NULL,
  PRIMARY KEY (`day_time_id`,`day_id`),
  KEY `FK_DAY_idx` (`day_id`),
  CONSTRAINT `FK_DAYTIME` FOREIGN KEY (`day_time_id`) 
  REFERENCES `daytime` (`id`) ,
  CONSTRAINT `FK_DAY` FOREIGN KEY (`day_id`) 
  REFERENCES `day` (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------
-- CREATE TABLE Course_Day 
-- ------daytime--------------------------
DROP TABLE IF EXISTS `course_day`;
CREATE TABLE `course_day` (
  `day_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  PRIMARY KEY (`day_id`,`course_id`),
  KEY `FK_COURSE_idx` (`course_id`),
  CONSTRAINT `FK_DAY_02` FOREIGN KEY (`day_id`) 
  REFERENCES `day` (`id`) ,
  CONSTRAINT `FK_COURSE` FOREIGN KEY (`course_id`) 
  REFERENCES `course` (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------
-- CREATE TABLE COURSE_STUDENT
-- --------------------------------
DROP TABLE IF EXISTS `course_student`;
CREATE TABLE `course_student` (
  `course_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  PRIMARY KEY (`course_id`,`student_id`),
  KEY `FK_STUDENT_idx` (`student_id`),
  CONSTRAINT `FK_COURSE_05` FOREIGN KEY (`course_id`) 
  REFERENCES `course` (`id`) ,
  CONSTRAINT `FK_STUDENT` FOREIGN KEY (`student_id`) 
  REFERENCES `student` (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
