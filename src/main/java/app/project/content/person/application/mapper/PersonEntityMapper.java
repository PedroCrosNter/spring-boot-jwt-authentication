package app.project.content.person.application.mapper;

import app.project.content.person.domain.entity.Person;
import app.project.content.person.infrastructure.controller.dto.input.PersonCreateInputDto;
import app.project.content.person.infrastructure.controller.dto.input.PersonUpdateInputDto;
import app.project.content.person.infrastructure.repository.jpa.entity.PersonJpa;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonEntityMapper {

    PersonEntityMapper INSTANCE = Mappers.getMapper(PersonEntityMapper.class);


// ##########################################################################################
// ##################################### TO ENTITY ##########################################
// ##########################################################################################
    Person toEntity(PersonCreateInputDto personCreateInputDto);

    Person toEntity(PersonUpdateInputDto personUpdateInputDto);

    Person toEntity(PersonJpa personJpa);

    void toEntity(Person source, @MappingTarget PersonJpa target);

// ########################################## LIST #########################################
    @Named("toEntityListFromJpa")
    List<Person> toEntityListFromJpa(List<PersonJpa> peopleJpa);

    @Named("toEntityListFromInputDto")
    List<Person> toEntityListFromInputDto(List<PersonCreateInputDto> peopleInputDtoList);


// ##########################################################################################
// ##################################### TO ENTITY JPA ######################################
// ##########################################################################################
    PersonJpa toEntityJpa(Person person);

    PersonJpa toEntityJpa(PersonJpa personJpa);

    PersonJpa toEntityJpa(PersonCreateInputDto personCreateInputDto);

// ########################################## LIST #########################################
    List<PersonJpa> toEntityJpaList(List<Person> people);

    Iterable<PersonJpa> toEntityJpaIterable(List<Person> people);
}
