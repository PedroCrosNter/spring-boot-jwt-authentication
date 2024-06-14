package app.project.content.teacher.application.mapper;

import app.project.content.teacher.domain.entity.Teacher;
import app.project.content.teacher.infrastructure.controller.dto.input.TeacherCreateInputDto;
import app.project.content.teacher.infrastructure.controller.dto.input.TeacherUpdateInputDto;
import app.project.content.teacher.infrastructure.repository.jpa.entity.TeacherJpa;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")//, uses = {PersonEntityMapper.class})
public interface TeacherEntityMapper {

    TeacherEntityMapper INSTANCE = Mappers.getMapper(TeacherEntityMapper.class);


// ##########################################################################################
// ##################################### TO ENTITY ##########################################
// ##########################################################################################

//    @Mappings({
////            @Mapping(source = "idStudent", target = "idStudent"),
//            @Mapping(source = "idPerson", target = "idPerson"),
//            @Mapping(source = "comments", target = "comments"),
//            @Mapping(source = "branch", target = "branch", ignore = true)
//    })
    Teacher toEntity(TeacherCreateInputDto teacherCreateInputDto);

    Teacher toEntity(TeacherUpdateInputDto teacherUpdateInputDto);

    @Mappings({
            @Mapping(source = "personJpa", target = "person", ignore = true),
            @Mapping(source = "students", target = "students", ignore = true),
//            @Mapping(source = "students.person", target = "person"),
//            @Mapping(source = "students.teacher", target = "teacher"),
    })
    Teacher toEntity(TeacherJpa teacherJpa);

    void toEntity(Teacher source, @MappingTarget TeacherJpa target);

    // ########################################## LIST #########################################
    @Named("toEntityListFromJpa")
    List<Teacher> toEntityListFromJpa(List<TeacherJpa> teachers);

    @Named("toEntityListFromInputDto")
    List<Teacher> toEntityListFromInputDto(List<TeacherCreateInputDto> teacherInputDtoList);


// ##########################################################################################
// ##################################### TO ENTITY JPA ######################################
// ##########################################################################################
//    @Mappings({
//        @Mapping(source = "idPerson", target = "idPerson"),
//        @Mapping(source = "comments", target = "comments"),
//        @Mapping(source = "branch", target = "branch", ignore = true)
//    })
    TeacherJpa toEntityJpa(Teacher teacher);

    TeacherJpa toEntityJpa(TeacherJpa teacherJpa);

    TeacherJpa toEntityJpa(TeacherCreateInputDto teacherCreateInputDto);

    // ########################################## LIST #########################################
    List<TeacherJpa> toEntityJpaList(List<Teacher> teachers);

    Iterable<TeacherJpa> toEntityJpaIterable(List<Teacher> teachers);
}
