package app.project.content.person.application.mapper;

import app.project.content.person.domain.entity.Person;
import app.project.content.person.infrastructure.controller.dto.input.PersonCreateInputDto;
import app.project.content.person.infrastructure.controller.dto.output.PersonOutputDto;
import app.project.content.person.infrastructure.repository.jpa.entity.PersonJpa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonDtoMapper {

    PersonDtoMapper INSTANCE = Mappers.getMapper(PersonDtoMapper.class);


// ##########################################################################################
// ##################################### TO InputDto ########################################
// ##########################################################################################
    PersonCreateInputDto toInputDto(Person person);

    PersonCreateInputDto toInputDto(PersonJpa personJpa);


// ##########################################################################################
// ##################################### TO OutputDto #######################################
// ##########################################################################################
    PersonOutputDto toOutputDto(Person person);

    PersonOutputDto toOutputDto(PersonJpa personJpa);

    // Sin esto no funciona
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
    List<PersonOutputDto> toOutputDtoList(List<Person> people);
}
