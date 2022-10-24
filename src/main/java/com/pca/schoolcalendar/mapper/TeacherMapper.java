package com.pca.schoolcalendar.mapper;

import com.pca.schoolcalendar.dto.TeacherDTO;
import com.pca.schoolcalendar.entity.Teacher;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class TeacherMapper {

    private final ModelMapper modelmapper;


    /**
     * convert Entity to Dto
     * @param teacher entity
     * @return TeacherDTO dto
     */
    public TeacherDTO mapToDto(Teacher teacher) {
        return modelmapper.map(teacher, TeacherDTO.class);
    }

    /**
     * convert Dto to Entity
     * @param teacherDto dto
     * @return Teacher entity
     */
    public Teacher mapToEntity(TeacherDTO teacherDto) {
        return modelmapper.map(teacherDto, Teacher.class);
    }

}
