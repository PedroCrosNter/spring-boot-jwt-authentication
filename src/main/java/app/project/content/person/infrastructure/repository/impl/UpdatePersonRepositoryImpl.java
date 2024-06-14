package app.project.content.person.infrastructure.repository.impl;

import app.project.content.person.application.mapper.PersonEntityMapper;
import app.project.content.person.domain.entity.Person;
import app.project.content.person.domain.repository.UpdatePersonRepository;
import app.project.content.person.infrastructure.repository.jpa.PersonRepositoryJpa;
import app.project.shared.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UpdatePersonRepositoryImpl implements UpdatePersonRepository {

    private final PersonRepositoryJpa personRepositoryJpa;


    @Override
    public Person update(Person person) {
        
        return personRepositoryJpa
                .findById(person.getIdPerson())
                .map(existingPersonJpa -> {
                    // Map new data to EntityJpa
                    PersonEntityMapper.INSTANCE.toEntity(person, existingPersonJpa);
                    // Save new entity updated
                    return personRepositoryJpa.save(existingPersonJpa);
                })
                // Map to Entity
                .map(PersonEntityMapper.INSTANCE::toEntity)
                .orElseThrow(
                        () -> new EntityNotFoundException(Person.class, person.getIdPerson())
                );
    }
}
