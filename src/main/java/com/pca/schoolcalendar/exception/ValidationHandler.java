package com.pca.schoolcalendar.exception;

import com.pca.schoolcalendar.dto.ErrorDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ErrorDTO> fieldErrors = ex.getBindingResult().getAllErrors()
                .stream().map(error -> new ErrorDTO(((FieldError) error).getField(),
                        error.getDefaultMessage(), ((FieldError) error).getRejectedValue()))
                .collect(Collectors.toList());

        Map<String, Object> body = new HashMap<>();
        body.put("statusCode",  HttpStatus.BAD_REQUEST.value());
        body.put("timestamp", new Date());
        body.put("message",  HttpStatus.BAD_REQUEST.getReasonPhrase() );
        body.put("fieldErrors",  fieldErrors);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
