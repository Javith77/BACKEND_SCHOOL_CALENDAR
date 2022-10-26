package com.pca.schoolcalendar.mapper;

import com.pca.schoolcalendar.dto.AcademicSubjectDTO;
import com.pca.schoolcalendar.entity.AcademicSubject;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AcademicSubjectMapper {

    private final ModelMapper modelmapper;

    /**
     * convert Entity to Dto
     * @param course entity
     * @return AcademicSubjectDTO dto
     */
    public AcademicSubjectDTO mapToDto(AcademicSubject course) {
        return modelmapper.map(course, AcademicSubjectDTO.class);
    }

    /**
     * convert Dto to Entity
     * @param academicSubjectDto dto
     * @return AcademicSubject entity
     */
    public AcademicSubject mapToEntity(AcademicSubjectDTO academicSubjectDto) {
        return modelmapper.map(academicSubjectDto, AcademicSubject.class);
    }
}
