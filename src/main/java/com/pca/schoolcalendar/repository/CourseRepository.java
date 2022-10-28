package com.pca.schoolcalendar.repository;

import com.pca.schoolcalendar.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {

    List<Course> findAllByAcademicSubjectsNotNull();
}
