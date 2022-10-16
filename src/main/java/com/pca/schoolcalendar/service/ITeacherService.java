package com.pca.schoolcalendar.service;

import com.pca.schoolcalendar.dto.TeacherDTO;
import com.pca.schoolcalendar.entity.Teacher;
import com.pca.schoolcalendar.response.MessageResponse;

import java.util.List;

public interface ITeacherService {

    MessageResponse save(TeacherDTO teacherDTO);

    MessageResponse update(Integer id, TeacherDTO teacherDTO);

    MessageResponse delete(Integer id);

    TeacherDTO findById(Integer id);

    List<TeacherDTO> findAll();

}
