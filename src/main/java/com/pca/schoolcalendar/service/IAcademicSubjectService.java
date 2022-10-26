package com.pca.schoolcalendar.service;

import com.pca.schoolcalendar.dto.AssignmentsDTO;
import com.pca.schoolcalendar.dto.AcademicSubjectDTO;
import com.pca.schoolcalendar.response.MessageResponse;

import java.util.List;

public interface IAcademicSubjectService {

    MessageResponse save(AcademicSubjectDTO academicSubjectDto);

    MessageResponse update(Integer id, AcademicSubjectDTO academicSubjectDto);

    MessageResponse delete(Integer id);

    AcademicSubjectDTO findById(Integer id);

    List<AcademicSubjectDTO>  findAll();
}
