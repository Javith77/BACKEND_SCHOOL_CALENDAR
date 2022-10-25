DROP SCHEMA IF EXISTS `schoolcalendar`;
CREATE SCHEMA `schoolcalendar`;

CREATE TABLE `schoolcalendar`.`academic_subject` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE `schoolcalendar`.`course` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `schoolcalendar`.`teacher` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type_document` VARCHAR(45) NOT NULL,
  `document` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `genre` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NULL,
  `academic_level` VARCHAR(45) NOT NULL,
  `date_of_birth` DATE NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `schoolcalendar`.`student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type_document` VARCHAR(45) NOT NULL,
  `document` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `genre` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NULL,
  `fk_id_course` INT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`fk_id_student`) REFERENCES `schoolcalendar`.`student` (`id`));

CREATE TABLE `schoolcalendar`.`course_academic_subject` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fk_id_course` INT NOT NULL,
  `fk_id_academic_subject` INT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`fk_id_course`) REFERENCES `schoolcalendar`.`course` (`id`),
  FOREIGN KEY (`fk_id_academic_subject`) REFERENCES `schoolcalendar`.`academic_subject` (`id`));

  -- CREATE TABLE `schoolcalendar`.`course_student` (
  --   `id` INT NOT NULL AUTO_INCREMENT,
  --   `fk_id_course` INT NOT NULL,
  --   `fk_id_student` INT NOT NULL,
  -- PRIMARY KEY (`id`),FERENCES `schoolcalendar`.`course` (`id`),
  -- FOREIGN KEY (`fk_id_student`) REFERENCES `schoolcalendar`.`student` (`id`));

CREATE TABLE `schoolcalendar`.`academic_subject_teacher` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fk_id_academic_subject` INT NOT NULL,
  `fk_id_teacher` INT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`fk_id_academic_subject`) REFERENCES `schoolcalendar`.`course` (`id`),
  FOREIGN KEY (`fk_id_teacher`) REFERENCES `schoolcalendar`.`teacher` (`id`));

CREATE TABLE `schoolcalendar`.`schedule` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `start_date` DATETIME NOT NULL,
  `end_date` DATETIME NOT NULL,
  `fk_id_course` INT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`fk_id_course`) REFERENCES `schoolcalendar`.`course` (`id`));


-- CREATE TABLE `schoolcalendar`.`schedule_detail` (
--   `id` INT NOT NULL AUTO_INCREMENT,
--   `fk_id_schedule` INT NOT NULL,
--   `fk_id_student` INT NOT NULL,
--   PRIMARY KEY (`id`),
--   INDEX `fk_id_schedule_idx` (`fk_id_schedule` ASC) VISIBLE,
--   INDEX `fk_id_student_idx` (`fk_id_student` ASC) VISIBLE,
--   CONSTRAINT `fk_id_schedule`
--     FOREIGN KEY (`fk_id_schedule`)
--     REFERENCES `schoolcalendar`.`schedule` (`id`)
--     ON DELETE NO ACTION
--     ON UPDATE NO ACTION,
--   CONSTRAINT `fk_id_student`
--     FOREIGN KEY (`fk_id_student`)
--     REFERENCES `schoolcalendar`.`student` (`id`)
--     ON DELETE NO ACTION
--     ON UPDATE NO ACTION);
