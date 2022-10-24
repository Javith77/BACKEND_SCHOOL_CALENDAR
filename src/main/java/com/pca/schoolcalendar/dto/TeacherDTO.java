package com.pca.schoolcalendar.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDTO {

    private Integer id;

    @NotEmpty @Size(max = 45)
    private String typeDocument;

    @NotEmpty @Size(max = 45)
    private String document;

    @NotEmpty @Size(min = 2, max = 45)
    private String name;

    @NotEmpty @Size(max = 45)
    private String lastName;

    @NotEmpty
    private String genre;

    @Size(max = 45)
    private String address;

    @NotEmpty @Size(max = 45)
    private String academicLevel;

    @NotNull
    private LocalDate dateOfBirth;

}
