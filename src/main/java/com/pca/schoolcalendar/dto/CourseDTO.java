package com.pca.schoolcalendar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

    private Integer id;

    @NotEmpty @Size(min = 5, max = 45)
    private String description;

    @NotNull @Min(1) @Max(24)
    private Double hours;

}
