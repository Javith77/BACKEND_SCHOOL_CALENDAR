package com.pca.schoolcalendar.dto;

import javax.validation.constraints.*;
import java.util.Calendar;

public class CourseDTO {

    private Integer id;

    @NotEmpty @Size(min = 5, max = 45)
    private String description;

    @NotNull @Min(1) @Max(24)
    private Double hours;

}
