CREATE SCHEMA `schoolcalendar` ;

CREATE TABLE `schoolcalendar`.`course` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NOT NULL,
  `hours` DECIMAL NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `schoolcalendar`.`teacher` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NULL,
  `academic_level` VARCHAR(45) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `schoolcalendar`.`student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NULL,
  `date_of_birth` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `schoolcalendar`.`course_detail` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fk_id_course` INT NOT NULL,
  `fk_id_teacher` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_id_course_idx` (`fk_id_course` ASC) VISIBLE,
  INDEX `fk_id_teacher_idx` (`fk_id_teacher` ASC) VISIBLE,
  CONSTRAINT `fk_id_course`
    FOREIGN KEY (`fk_id_course`)
    REFERENCES `schoolcalendar`.`course` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_teacher`
    FOREIGN KEY (`fk_id_teacher`)
    REFERENCES `schoolcalendar`.`teacher` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `schoolcalendar`.`schedule` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `start_date` DATETIME NOT NULL,
  `end_date` DATETIME NOT NULL,
  `fk_id_course_detail` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_id_course_detail_idx` (`fk_id_course_detail` ASC) VISIBLE,
  CONSTRAINT `fk_id_course_detail`
    FOREIGN KEY (`fk_id_course_detail`)
    REFERENCES `schoolcalendar`.`course_detail` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `schoolcalendar`.`schedule_detail` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fk_id_schedule` INT NOT NULL,
  `fk_id_student` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_id_schedule_idx` (`fk_id_schedule` ASC) VISIBLE,
  INDEX `fk_id_student_idx` (`fk_id_student` ASC) VISIBLE,
  CONSTRAINT `fk_id_schedule`
    FOREIGN KEY (`fk_id_schedule`)
    REFERENCES `schoolcalendar`.`schedule` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_student`
    FOREIGN KEY (`fk_id_student`)
    REFERENCES `schoolcalendar`.`student` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
