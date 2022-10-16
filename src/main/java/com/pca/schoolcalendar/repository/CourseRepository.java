package com.pca.schoolcalendar.repository;

import com.pca.schoolcalendar.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer> {
}
