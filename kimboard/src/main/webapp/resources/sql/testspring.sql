-- springuser table (관리자, 시스템관리자, 테스트용)
CREATE TABLE `scott`.`springuser` (
  `id` INT NOT NULL,
  `name` VARCHAR(15) NOT NULL,
  `password` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



-- board table
CREATE TABLE `board` (
  `bno` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `content` varchar(100) NOT NULL,
  `id` varchar(20) NOT NULL,
  `regdate` datetime NOT NULL,
  `readcnt` int NOT NULL,
  `etc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`bno`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8

CREATE TABLE `board_reply` (
  `reno` int NOT NULL AUTO_INCREMENT,
  `rewriter` varchar(45) NOT NULL,
  `rememo` varchar(45) NOT NULL,
  `redate` datetime NOT NULL,
  `bno` int NOT NULL,
  PRIMARY KEY (`reno`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


