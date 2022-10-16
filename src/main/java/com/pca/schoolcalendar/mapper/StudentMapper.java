package com.pca.schoolcalendar.mapper;

import com.pca.schoolcalendar.dto.StudentDTO;
import com.pca.schoolcalendar.entity.Student;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
public class StudentMapper {

    private final ModelMapper modelmapper;


    /**
     * convert Entity to Dto
     * @param student entity
     * @return StudentDTO dto
     */
    public StudentDTO mapToDto(Student student) {
        return modelmapper.map(student, StudentDTO.class);
    }

    /**
     * convert Dto to Entity
     * @param studentDto dto
     * @return Student entity
     */
    public Student mapToEntity(StudentDTO studentDto) {
        return modelmapper.map(studentDto, Student.class);
    }
}
