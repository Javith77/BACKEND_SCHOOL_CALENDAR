package com.pca.schoolcalendar.rest;

import com.pca.schoolcalendar.dto.AssignmentsDTO;
import com.pca.schoolcalendar.dto.StudentDTO;
import com.pca.schoolcalendar.response.MessageResponse;
import com.pca.schoolcalendar.service.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentRest {

    private final IStudentService service;

    @PostMapping
    public ResponseEntity<MessageResponse> create(@RequestBody @Valid StudentDTO studentDto){
        return new ResponseEntity<>(service.save(studentDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageResponse> update(@PathVariable("id") Integer id, @RequestBody @Valid StudentDTO studentDto){
        return new ResponseEntity<>(service.update(id, studentDto), HttpStatus.CREATED);
    }

    @PutMapping("/course/assignments/{idCourse}")
    public ResponseEntity<MessageResponse> updateCourseAssignments(@PathVariable("idCourse") Integer id, @RequestBody @Valid List<AssignmentsDTO> assignments){
        return new ResponseEntity<>(service.updateCourseAssignments(id, assignments), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> findById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/unassigned/course")
    public ResponseEntity<List<StudentDTO>> findByIdCourse(){
        return new ResponseEntity<>(service.findUnassignedCourse(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> delete(@PathVariable("id") Integer id){
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
