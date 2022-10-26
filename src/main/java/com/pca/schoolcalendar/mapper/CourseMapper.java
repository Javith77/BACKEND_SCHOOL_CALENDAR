package com.pca.schoolcalendar.mapper;

import com.pca.schoolcalendar.dto.CourseDTO;
import com.pca.schoolcalendar.entity.Course;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CourseMapper {

    private final ModelMapper modelmapper;

    /**
     * convert Entity to Dto
     * @param course entity
     * @return CourseDTO dto
     */
    public CourseDTO mapToDto(Course course) {
        return modelmapper.map(course, CourseDTO.class);
    }

    /**
     * convert Dto to Entity
     * @param courseDto dto
     * @return Course entity
     */
    public Course mapToEntity(CourseDTO courseDto) {
        return modelmapper.map(courseDto, Course.class);
    }
}
