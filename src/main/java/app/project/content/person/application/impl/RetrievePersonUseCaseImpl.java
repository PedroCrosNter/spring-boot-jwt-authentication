package app.project.content.person.application.impl;

import app.project.content.person.application.RetrievePersonUseCase;
import app.project.content.person.domain.entity.Person;
import app.project.content.person.domain.repository.RetrievePersonRepository;
import app.project.shared.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RetrievePersonUseCaseImpl implements RetrievePersonUseCase {

    private final RetrievePersonRepository retrievePersonRepository;


    @Override
    public Person find(Long idPerson) throws EntityNotFoundException {

        Person person;

        try {
            person = retrievePersonRepository.find(idPerson);
        } catch (Exception e) {
            throw new EntityNotFoundException(Person.class, idPerson);
        }

        return person;
    }

    @Override
    public List<Person> findAll() {
        return retrievePersonRepository.findAll();
    }
}