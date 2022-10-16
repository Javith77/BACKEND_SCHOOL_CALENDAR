package com.pca.schoolcalendar.dto;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;

public class TeacherDTO {

    private Integer id;

    @NotEmpty @Size(min = 5, max = 45)
    private String name;

    @NotEmpty @Size(min = 5, max = 45)
    private String lastName;

    private String address;

    @NotEmpty @Size(min = 5, max = 45)
    private String academicLevel;

    @NotNull
    private Calendar dateOfBirth;

}
