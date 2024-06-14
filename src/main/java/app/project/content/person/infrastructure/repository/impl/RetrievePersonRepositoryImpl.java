package app.project.content.person.infrastructure.repository.impl;

import app.project.content.person.application.mapper.PersonEntityMapper;
import app.project.content.person.domain.entity.Person;
import app.project.content.person.domain.repository.RetrievePersonRepository;
import app.project.content.person.infrastructure.repository.jpa.PersonRepositoryJpa;
import app.project.content.person.infrastructure.repository.jpa.entity.PersonJpa;
import app.project.shared.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RetrievePersonRepositoryImpl implements RetrievePersonRepository {

    private final PersonRepositoryJpa personRepositoryJpa;


    @Override
    public Person find(Long idPerson) {
//        return Optional.ofNullable(idPerson)
//                .map(id -> personRepositoryJpa.findById(id)
//                        .map(PersonEntityMapper.INSTANCE::toEntity)
//                        .orElseThrow(() -> new PersonNotFoundException(id)))
//                .orElseThrow(IdGivenIsNullException::new);
        return PersonEntityMapper.INSTANCE.toEntity(
                personRepositoryJpa.findById(idPerson)
                        .orElseThrow(() -> new EntityNotFoundException(Person.class, idPerson)));
    }

    @Override
    public List<Person> findAll() {
        List<PersonJpa> personJpaList = personRepositoryJpa.findAll();
        return personJpaList.stream()
                .map(PersonEntityMapper.INSTANCE::toEntity)
                .collect(Collectors.toList());
    }
}