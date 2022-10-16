package com.pca.schoolcalendar.repository;

import com.pca.schoolcalendar.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Integer, Student> {
}
