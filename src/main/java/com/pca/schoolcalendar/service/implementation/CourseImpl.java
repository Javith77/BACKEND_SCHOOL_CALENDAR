package com.pca.schoolcalendar.service.implementation;

import com.pca.schoolcalendar.dto.CourseDTO;
import com.pca.schoolcalendar.entity.Course;
import com.pca.schoolcalendar.exception.ResourceNotFoundException;
import com.pca.schoolcalendar.mapper.CourseMapper;
import com.pca.schoolcalendar.repository.CourseRepository;
import com.pca.schoolcalendar.response.MessageResponse;
import com.pca.schoolcalendar.service.ICourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CourseImpl implements ICourseService {

    private CourseRepository courseRepository;
    private CourseMapper courseMapper;
    private static final String RESOURCE_NAME = "Course";

    @Override
    public MessageResponse save(CourseDTO courseDto) {
        Course course = courseMapper.mapToEntity(courseDto);
        Course newCourse = courseRepository.save(course);
        return new MessageResponse(HttpStatus.CREATED.value(), new Date(),
                "Registro guardado con éxito", courseMapper.mapToDto(newCourse));
    }

    @Override
    public MessageResponse update(Integer id, CourseDTO courseDto) {
        Optional<Course> course = courseRepository.findById(id);
        if(course.isEmpty()){
            throw new ResourceNotFoundException(RESOURCE_NAME, "id", id);
        }
        //update data
        course.get().setDescription(courseDto.getDescription());
        courseRepository.save(course.get());
        return new MessageResponse(HttpStatus.CREATED.value(), new Date(), "Registro actualizado con éxito", courseMapper.mapToDto(course.get()));
    }

    @Override
    public MessageResponse delete(Integer id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(RESOURCE_NAME, "id", id));
        courseRepository.delete(course);
        return new MessageResponse(HttpStatus.OK.value(), new Date(), "Registro eliminado con éxito", courseMapper.mapToDto(course));
    }

    @Override
    public CourseDTO findById(Integer id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(RESOURCE_NAME, "id", id));
        //convert entity to dto and return
        return courseMapper.mapToDto(course);
    }

    @Override
    public List<CourseDTO> findAll() {
        List<Course> courses = (List<Course>) courseRepository.findAll();
        //convert list entity to dto
        return courses.stream()
                .map(courseMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
