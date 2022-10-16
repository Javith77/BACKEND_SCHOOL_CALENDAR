package com.pca.schoolcalendar.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageResponse {

    private int statusCode;
    private Date timestamp;
    private String message;
    private Object data;

}
