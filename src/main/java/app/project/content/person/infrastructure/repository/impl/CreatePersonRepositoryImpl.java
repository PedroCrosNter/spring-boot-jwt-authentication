package app.project.content.person.infrastructure.repository.impl;

import app.project.content.person.application.mapper.PersonEntityMapper;
import app.project.content.person.domain.entity.Person;
import app.project.content.person.domain.repository.CreatePersonRepository;
import app.project.content.person.infrastructure.repository.jpa.PersonRepositoryJpa;
import app.project.content.person.infrastructure.repository.jpa.entity.PersonJpa;
import app.project.shared.exceptions.UnprocessableEntityException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CreatePersonRepositoryImpl implements CreatePersonRepository {

    private final PersonRepositoryJpa personRepositoryJpa;


    @Override
    public Long save(Person person) throws UnprocessableEntityException {
        if (person.getUsername().length() <= 6 && person.getPassword().length() >= 10) {
            throw new UnprocessableEntityException("Username must be between 6 and 10 characters.");
        }
        PersonJpa personJpa = PersonEntityMapper.INSTANCE.toEntityJpa(person);
        return personRepositoryJpa.save(personJpa).getIdPerson();
    }
}
