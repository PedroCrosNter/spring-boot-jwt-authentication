package app.project.content.subject.application.mapper;

import app.project.content.subject.domain.entity.Subject;
import app.project.content.subject.infrastructure.controller.dto.input.SubjectCreateInputDto;
import app.project.content.subject.infrastructure.controller.dto.output.SubjectDetailsOutputDto;
import app.project.content.subject.infrastructure.controller.dto.output.SubjectOutputDto;
import app.project.content.subject.infrastructure.repository.jpa.entity.SubjectJpa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubjectDtoMapper {
    
    SubjectDtoMapper INSTANCE = Mappers.getMapper(SubjectDtoMapper.class);


    // ##########################################################################################
// ##################################### TO InputDto ########################################
// ##########################################################################################
    SubjectCreateInputDto toInputDto(Subject person);

    SubjectCreateInputDto toInputDto(SubjectJpa subjectJpa);


    // ##########################################################################################
// ##################################### TO OutputDto #######################################
// ##########################################################################################
    SubjectOutputDto toOutputDto(Subject person);

    SubjectDetailsOutputDto toOutputDtoDetails(Subject person);

    @Mappings({
            @Mapping(source = "idPerson", target = "idPerson"),
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "surname", target = "surname"),
            @Mapping(source = "companyEmail", target = "companyEmail"),
            @Mapping(source = "personalEmail", target = "personalEmail"),
            @Mapping(source = "city", target = "city"),
            @Mapping(source = "active", target = "active"),
            @Mapping(source = "createdDate", target = "createdDate"),
            @Mapping(source = "imageUrl", target = "imageUrl"),
            @Mapping(source = "terminationDate", target = "terminationDate")
    })
    List<SubjectOutputDto> toOutputDtoList(List<Subject> subjects);
}
