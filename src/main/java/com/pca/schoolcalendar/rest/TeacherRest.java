package com.pca.schoolcalendar.rest;

import com.pca.schoolcalendar.dto.TeacherDTO;
import com.pca.schoolcalendar.response.MessageResponse;
import com.pca.schoolcalendar.service.ITeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/teachers")
public class TeacherRest {

    private final ITeacherService service;

    @PostMapping
    public ResponseEntity<MessageResponse> create(@RequestBody @Valid TeacherDTO teacherDto){
        return new ResponseEntity<>(service.save(teacherDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageResponse> update(@PathVariable("id") Integer id, @RequestBody @Valid TeacherDTO teacherDto){
        return new ResponseEntity<>(service.update(id, teacherDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDTO> findById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TeacherDTO>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> delete(@PathVariable("id") Integer id){
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
