package app.project.content.person.application;

import app.project.content.person.domain.entity.Person;
import app.project.shared.exceptions.EntityNotFoundException;

public interface UpdatePersonUseCase {

    Long update(Person person) throws EntityNotFoundException;
}
