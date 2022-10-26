package com.pca.schoolcalendar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcademicSubjectDTO {

    private Integer id;

    @NotEmpty
    @Size(min = 2, max = 45)
    private String description;

}
