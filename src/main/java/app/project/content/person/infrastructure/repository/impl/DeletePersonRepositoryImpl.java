package app.project.content.person.infrastructure.repository.impl;

import app.project.content.person.domain.repository.DeletePersonRepository;
import app.project.content.person.infrastructure.repository.jpa.PersonRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DeletePersonRepositoryImpl implements DeletePersonRepository {

    private final PersonRepositoryJpa personRepositoryJpa;


    @Override
    public Boolean delete(Long idPerson) {

        if (personRepositoryJpa.existsById(idPerson)) {
            personRepositoryJpa.deleteById(idPerson);
            return true;
        }
        return false;
    }

    @Override
    public void delete(String idPerson) {
        this.delete(Long.valueOf(idPerson));
    }
}
