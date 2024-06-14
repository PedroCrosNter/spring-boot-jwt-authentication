package app.project.content.subject.application.mapper;

import app.project.content.subject.domain.entity.Subject;
import app.project.content.subject.infrastructure.controller.dto.input.SubjectCreateInputDto;
import app.project.content.subject.infrastructure.repository.jpa.entity.SubjectJpa;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubjectEntityMapper {
    
    SubjectEntityMapper INSTANCE = Mappers.getMapper(SubjectEntityMapper.class);


    // ##########################################################################################
// ##################################### TO ENTITY ##########################################
// ##########################################################################################
    Subject toEntity(SubjectCreateInputDto subjectCreateInputDto);

//    Subject toEntity(SubjectUpdateInputDto subjectUpdateInputDto);

    Subject toEntity(SubjectJpa subjectJpa);

    void toEntity(Subject source, @MappingTarget SubjectJpa target);

    // ########################################## LIST #########################################
    @Named("toEntityListFromJpa")
    List<Subject> toEntityListFromJpa(List<SubjectJpa> subjectsJpa);

    @Named("toEntityListFromInputDto")
    List<Subject> toEntityListFromInputDto(List<SubjectCreateInputDto> subjectsInputDtoList);


    // ##########################################################################################
// ##################################### TO ENTITY JPA ######################################
// ##########################################################################################
    SubjectJpa toEntityJpa(Subject subject);

    SubjectJpa toEntityJpa(SubjectJpa subjectJpa);

    SubjectJpa toEntityJpa(SubjectCreateInputDto subjectCreateInputDto);

    // ########################################## LIST #########################################
    List<SubjectJpa> toEntityJpaList(List<Subject> subjects);

    Iterable<SubjectJpa> toEntityJpaIterable(List<Subject> subjects);
}
