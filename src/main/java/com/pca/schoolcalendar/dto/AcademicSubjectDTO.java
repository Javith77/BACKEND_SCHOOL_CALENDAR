package com.pca.schoolcalendar.dto;

import com.pca.schoolcalendar.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcademicSubjectDTO {

    private Integer id;

    @NotEmpty
    @Size(min = 2, max = 45)
    private String description;

    private List<Course> courses;

}
