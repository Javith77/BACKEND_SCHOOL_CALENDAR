package com.pca.schoolcalendar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private Integer id;

    @NotEmpty @Size(max = 45)
    private String typeDocument;

    @NotEmpty @Size(max = 45)
    private String document;

    @NotEmpty @Size(max = 45)
    private String name;

    @NotEmpty @Size(max = 45)
    private String lastName;

    @NotEmpty
    private String genre;

    private String address;

}
