package app.project.content.person.domain.repository;

import app.project.content.person.domain.entity.Person;

import java.util.List;

public interface RetrievePersonRepository {

    Person find(Long idPerson);

    List<Person> findAll();
}
