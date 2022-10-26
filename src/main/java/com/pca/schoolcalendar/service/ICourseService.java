package com.pca.schoolcalendar.service;

import com.pca.schoolcalendar.dto.CourseDTO;
import com.pca.schoolcalendar.entity.Course;
import com.pca.schoolcalendar.response.MessageResponse;

import java.util.List;

public interface ICourseService {

    MessageResponse save(CourseDTO courseDto);

    MessageResponse update(Integer id, CourseDTO courseDto);

    MessageResponse delete(Integer id);

    CourseDTO findById(Integer id);

    List<CourseDTO> findAll();

}
