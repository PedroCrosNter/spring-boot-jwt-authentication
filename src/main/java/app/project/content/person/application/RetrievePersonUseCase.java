package app.project.content.person.application;

import app.project.content.person.domain.entity.Person;
import app.project.shared.exceptions.EntityNotFoundException;

import java.util.List;

public interface RetrievePersonUseCase {

    Person find(Long personId) throws EntityNotFoundException;

    List<Person> findAll();
}
