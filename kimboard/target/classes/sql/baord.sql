CREATE TABLE `scott`.`board` (
  `bno` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `content` VARCHAR(45) NOT NULL,
  `id` VARCHAR(45) NOT NULL,
  `reddate` DATETIME NULL,
  `readcnt` INT NULL,
  `etc` VARCHAR(45) NULL,
  PRIMARY KEY (`bno`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;