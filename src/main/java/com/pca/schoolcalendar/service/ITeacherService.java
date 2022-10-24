package com.pca.schoolcalendar.service;

import com.pca.schoolcalendar.dto.TeacherDTO;
import com.pca.schoolcalendar.response.MessageResponse;

import java.util.List;

public interface ITeacherService {

    MessageResponse save(TeacherDTO teacherDto);

    MessageResponse update(Integer id, TeacherDTO teacherDto);

    MessageResponse delete(Integer id);

    TeacherDTO findById(Integer id);

    List<TeacherDTO> findAll();

}
