package com.pca.schoolcalendar.rest;

import com.pca.schoolcalendar.dto.AssignmentsDTO;
import com.pca.schoolcalendar.dto.CourseDTO;
import com.pca.schoolcalendar.response.MessageResponse;
import com.pca.schoolcalendar.service.ICourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/courses")
public class CourseRest {

    private final ICourseService service;

    @PostMapping
    public ResponseEntity<MessageResponse> create(@RequestBody @Valid CourseDTO courseDto){
        return new ResponseEntity<>(service.save(courseDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageResponse> update(@PathVariable("id") Integer id, @RequestBody @Valid CourseDTO courseDto){
        return new ResponseEntity<>(service.update(id, courseDto), HttpStatus.CREATED);
    }

    @PutMapping("/academic-subjects/assignments/{idCourse}")
    public ResponseEntity<MessageResponse> updateCourseAssignments(@PathVariable("idCourse") Integer id, @RequestBody @Valid List<AssignmentsDTO> assignments){
        return new ResponseEntity<>(service.updateCourseAssignments(id, assignments), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> findById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/assign/subject-academic")
    public ResponseEntity<List<CourseDTO>> findAllWithAcademicSubjectAssign(){
        return new ResponseEntity<>(service.findAllWithAcademicSubjectAssign(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> delete(@PathVariable("id") Integer id){
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }

}
