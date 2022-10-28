package com.pca.schoolcalendar.rest;

import com.pca.schoolcalendar.dto.AcademicSubjectDTO;
import com.pca.schoolcalendar.response.MessageResponse;
import com.pca.schoolcalendar.service.IAcademicSubjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/academic-subjects")
public class AcademicSubjectRest {

    private final IAcademicSubjectService service;

    @PostMapping
    public ResponseEntity<MessageResponse> create(@RequestBody @Valid AcademicSubjectDTO academicSubjectDto){
        return new ResponseEntity<>(service.save(academicSubjectDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageResponse> update(@PathVariable("id") Integer id, @RequestBody @Valid AcademicSubjectDTO academicSubjectDto){
        return new ResponseEntity<>(service.update(id, academicSubjectDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcademicSubjectDTO> findById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AcademicSubjectDTO>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/course/{idCourse}")
    public ResponseEntity<List<AcademicSubjectDTO>> findAllByIdCourse(@PathVariable("idCourse") Integer idCourse){
        return new ResponseEntity<>(service.findAllByIdCourse(idCourse), HttpStatus.OK);
    }

    @GetMapping("/assigned/teacher")
    public ResponseEntity<List<AcademicSubjectDTO>> findAllWithTeacherAssigned(){
        return new ResponseEntity<>(service.findAllWithTeacherAssigned(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> delete(@PathVariable("id") Integer id){
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
