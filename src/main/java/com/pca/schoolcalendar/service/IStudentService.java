package com.pca.schoolcalendar.service;

import com.pca.schoolcalendar.dto.AssignmentsDTO;
import com.pca.schoolcalendar.dto.StudentDTO;
import com.pca.schoolcalendar.response.MessageResponse;

import java.util.List;

public interface IStudentService {

    MessageResponse save(StudentDTO StudentDTO);

    MessageResponse update(Integer id, StudentDTO StudentDTO);

    MessageResponse updateCourseAssignments(Integer idCourse, List<AssignmentsDTO> assignments);

    MessageResponse delete(Integer id);

    StudentDTO findById(Integer id);

    List<StudentDTO>  findAll();

    List<StudentDTO>  findUnassignedCourse();
}
