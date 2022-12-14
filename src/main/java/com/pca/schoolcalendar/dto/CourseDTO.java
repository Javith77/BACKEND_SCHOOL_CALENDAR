package com.pca.schoolcalendar.dto;

import com.pca.schoolcalendar.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

    private Integer id;

    @NotEmpty @Size(max = 45)
    private String description;

    private List<StudentDTO> students;

    private List<AcademicSubjectDTO> academicSubjects;

}
