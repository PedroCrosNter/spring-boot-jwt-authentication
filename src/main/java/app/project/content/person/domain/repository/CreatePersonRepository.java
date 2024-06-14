package app.project.content.person.domain.repository;

import app.project.content.person.domain.entity.Person;

public interface CreatePersonRepository {

    Long save(Person person);
}
