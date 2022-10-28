
-- course data
INSERT INTO `schoolcalendar`.`course`(`description`) VALUES ('CURSO_001');
INSERT INTO `schoolcalendar`.`course`(`description`) VALUES ('CURSO_002');
INSERT INTO `schoolcalendar`.`course`(`description`) VALUES ('CURSO_003');
INSERT INTO `schoolcalendar`.`course`(`description`) VALUES ('CURSO_004');
INSERT INTO `schoolcalendar`.`course`(`description`) VALUES ('CURSO_005');
INSERT INTO `schoolcalendar`.`course`(`description`) VALUES ('CURSO_006');
INSERT INTO `schoolcalendar`.`course`(`description`) VALUES ('CURSO_007');
INSERT INTO `schoolcalendar`.`course`(`description`) VALUES ('CURSO_008');

-- student data
INSERT INTO `schoolcalendar`.`student`(`type_document`,`document`,`name`,`last_name`,`genre`, `address`,`fk_id_course`)
VALUES ('Cédula de ciudadanía', '212121888', 'Usuario 1', 'Usuario 1', 'F', 'Calle Test 1', 1);

INSERT INTO `schoolcalendar`.`student`(`type_document`,`document`,`name`,`last_name`,`genre`, `address`,`fk_id_course`)
VALUES ('Cédula de ciudadanía', '14545475', 'Usuario 2', 'Usuario 2', 'F', 'Calle Test 2', 1);

INSERT INTO `schoolcalendar`.`student`(`type_document`,`document`,`name`,`last_name`,`genre`, `address`,`fk_id_course`)
VALUES ('Cédula de ciudadanía', '18909809', 'Usuario 3', 'Usuario 3', 'M', 'Calle Test 3', 1);

INSERT INTO `schoolcalendar`.`student`(`type_document`,`document`,`name`,`last_name`,`genre`, `address`,`fk_id_course`)
VALUES ('Cédula de ciudadanía', '119090878', 'Usuario 4', 'Usuario 4', 'M', 'Calle Test 4', 1);

-- academic_subject data
INSERT INTO `schoolcalendar`.`academic_subject`(`description`) VALUES ('Matemáticas');
INSERT INTO `schoolcalendar`.`academic_subject`(`description`) VALUES ('Lengua Castellana');
INSERT INTO `schoolcalendar`.`academic_subject`(`description`) VALUES ('Humanidades Inglés');
INSERT INTO `schoolcalendar`.`academic_subject`(`description`) VALUES ('Ciencias Naturales');
INSERT INTO `schoolcalendar`.`academic_subject`(`description`) VALUES ('Ciencias Sociales');
INSERT INTO `schoolcalendar`.`academic_subject`(`description`) VALUES ('Tecnología e Informática');
INSERT INTO `schoolcalendar`.`academic_subject`(`description`) VALUES ('Educación Artística.');
INSERT INTO `schoolcalendar`.`academic_subject`(`description`) VALUES ('Ética y Religión');




















-- teacher data
INSERT INTO `schoolcalendar`.`teacher`(`name`, `last_name`, `address`, `academic_level`, `date_of_birth`)
VALUES('Profesor 1', 'Apellido 1', 'Test', 'Ingeniero', '1992-10-21');

INSERT INTO `schoolcalendar`.`teacher`(`name`, `last_name`, `address`, `academic_level`, `date_of_birth`)
VALUES('Profesor 2', 'Apellido 2', 'Test', 'Ingeniero', '1989-03-06');

INSERT INTO `schoolcalendar`.`teacher`(`name`, `last_name`, `address`, `academic_level`, `date_of_birth`)
VALUES('Profesor 3', 'Apellido 3', 'Test', 'Especializado', '1992-06-01');


-- course data
INSERT INTO `schoolcalendar`.`course` (`description`, `hours`) VALUES ('Matematica', 3);

INSERT INTO `schoolcalendar`.`course` (`description`, `hours`) VALUES ('Fisica', 4);

INSERT INTO `schoolcalendar`.`course` (`description`, `hours`) VALUES ('Economia', 2);

INSERT INTO `schoolcalendar`.`course` (`description`, `hours`) VALUES ('Ingles', 2);


--course_detail data
INSERT INTO `schoolcalendar`.`course_detail` (`fk_id_course`, `fk_id_teacher`) VALUES(1, 1);

INSERT INTO `schoolcalendar`.`course_detail` (`fk_id_course`, `fk_id_teacher`) VALUES(2, 1);

INSERT INTO `schoolcalendar`.`course_detail` (`fk_id_course`, `fk_id_teacher`) VALUES(4, 2);

INSERT INTO `schoolcalendar`.`course_detail` (`fk_id_course`, `fk_id_teacher`) VALUES(3, 3);