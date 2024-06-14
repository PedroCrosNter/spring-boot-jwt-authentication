package app.project.content.student.application.mapper;

import app.project.content.student.domain.entity.Student;
import app.project.content.student.infrastructure.controller.dto.input.StudentCreateInputDto;
import app.project.content.student.infrastructure.controller.dto.input.StudentUpdateInputDto;
import app.project.content.student.infrastructure.repository.jpa.entity.StudentJpa;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentEntityMapper {
    
    StudentEntityMapper INSTANCE = Mappers.getMapper(StudentEntityMapper.class);


// ##########################################################################################
// ##################################### TO ENTITY ##########################################
// ##########################################################################################

//    @Mappings({
////            @Mapping(source = "idPerson", target = "idPerson"),
//            @Mapping(source = "numHoursWeek", target = "numHoursWeek"),
////            @Mapping(source = "idTeacher", target = "idTeacher"),
//            @Mapping(source = "branch", target = "branch", ignore = true)
//    })
    Student toEntity(StudentCreateInputDto studentCreateInputDto);

    Student toEntity(StudentUpdateInputDto studentUpdateInputDto);

    @Mappings({
            @Mapping(source = "teacherJpa", target = "teacher", ignore = true),
            @Mapping(source = "personJpa", target = "person", ignore = true),
    })
    Student toEntity(StudentJpa studentJpa);

    void toEntity(Student source, @MappingTarget StudentJpa target);

// ########################################## LIST #########################################
    @Named("toEntityListFromJpa")
    List<Student> toEntityListFromJpa(List<StudentJpa> studentsJpa);

    @Named("toEntityListFromInputDto")
    List<Student> toEntityListFromInputDto(List<StudentCreateInputDto> studentsInputDtoList);


// ##########################################################################################
// ##################################### TO ENTITY JPA ######################################
// ##########################################################################################
    @Mappings({
            @Mapping(source = "teacher", target = "teacherJpa"),
            @Mapping(source = "person", target = "personJpa"),
    })
    StudentJpa toEntityJpa(Student student);

    StudentJpa toEntityJpa(StudentJpa studentJpa);

    StudentJpa toEntityJpa(StudentCreateInputDto studentCreateInputDto);

// ########################################## LIST #########################################
    List<StudentJpa> toEntityJpaList(List<Student> students);

    Iterable<StudentJpa> toEntityJpaIterable(List<Student> students);
}
