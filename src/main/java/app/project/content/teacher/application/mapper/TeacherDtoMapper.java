package app.project.content.teacher.application.mapper;

import app.project.content.teacher.domain.entity.Teacher;
import app.project.content.teacher.infrastructure.controller.dto.input.TeacherCreateInputDto;
import app.project.content.teacher.infrastructure.controller.dto.output.TeacherDetailsOutputDto;
import app.project.content.teacher.infrastructure.controller.dto.output.TeacherOutputDto;
import app.project.content.teacher.infrastructure.repository.jpa.entity.TeacherJpa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherDtoMapper {

    TeacherDtoMapper INSTANCE = Mappers.getMapper(TeacherDtoMapper.class);


// ##########################################################################################
// ##################################### TO InputDto ########################################
// ##########################################################################################
    TeacherCreateInputDto toInputDto(Teacher teacher);

    TeacherCreateInputDto toInputDto(TeacherJpa teacherJpa);


// ##########################################################################################
// ##################################### TO OutputDto #######################################
// ##########################################################################################
//    @Mapping(source = "teacher.person", target = "personOutputDto")
//    @Mapping(source = "students", target = "students")
    TeacherOutputDto toOutputDto(Teacher teacher);

    @Mapping(source = "students", target = "students", ignore = true)
    TeacherDetailsOutputDto toOutputDtoDetails(Teacher teacher);

    TeacherOutputDto toOutputDto(TeacherJpa teacherJpa);


    @Mappings({
            @Mapping(source = "idStudent", target = "idStudent"),
            @Mapping(source = "person", target = "person"),
            @Mapping(source = "numHoursWeek", target = "numHoursWeek"),
            @Mapping(source = "teacher", target = "teacher"),
            @Mapping(source = "branch", target = "branch")
    })
    List<TeacherOutputDto> toOutputDtoList(List<Teacher> teacher);
}
