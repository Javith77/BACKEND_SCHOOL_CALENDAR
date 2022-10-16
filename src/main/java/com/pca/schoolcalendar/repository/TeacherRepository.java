package com.pca.schoolcalendar.repository;

import com.pca.schoolcalendar.entity.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
}
