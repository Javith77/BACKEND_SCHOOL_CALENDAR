package com.pca.schoolcalendar.repository;

import com.pca.schoolcalendar.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

    List<Student> findStudentByCourseIsNull();

}
