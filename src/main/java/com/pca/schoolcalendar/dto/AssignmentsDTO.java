package com.pca.schoolcalendar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentsDTO {

    @NonNull
    private Integer id;

    @NonNull
    private boolean check;

}
