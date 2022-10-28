package com.pca.schoolcalendar.rest;

import com.pca.schoolcalendar.dto.ScheduleDTO;
import com.pca.schoolcalendar.dto.TeacherDTO;
import com.pca.schoolcalendar.response.MessageResponse;
import com.pca.schoolcalendar.service.IScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/schedule")
public class ScheduleRest {

    private final IScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<MessageResponse> create(@RequestBody @Valid ScheduleDTO scheduleDto){
        return new ResponseEntity<>(scheduleService.save(scheduleDto), HttpStatus.CREATED);
    }

    @GetMapping("/course/{idCourse}")
    public ResponseEntity<List<ScheduleDTO>> findAll(@PathVariable("idCourse") Integer idCourse){
        return new ResponseEntity<>(scheduleService.findAllByIdCourse(idCourse), HttpStatus.OK);
    }

}
