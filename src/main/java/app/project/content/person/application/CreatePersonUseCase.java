package app.project.content.person.application;

import app.project.content.person.domain.entity.Person;

public interface CreatePersonUseCase {

    Long save(Person person);
}
