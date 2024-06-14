package app.project.content.person.application.impl;

import app.project.content.person.application.RetrievePersonUseCase;
import app.project.content.person.application.UpdatePersonUseCase;
import app.project.content.person.domain.entity.Person;
import app.project.content.person.domain.repository.UpdatePersonRepository;
import app.project.shared.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatePersonUseCaseImpl implements UpdatePersonUseCase {

    // Update -> Repository
    private final UpdatePersonRepository updatePersonRepository;
    // Retrieve -> UseCase
    private final RetrievePersonUseCase retrievePersonUseCase;


    @Override
    public Long update(Person person) throws EntityNotFoundException {

        Person existingPerson;

        // Find person in repository
        try {
            existingPerson = retrievePersonUseCase.find(person.getIdPerson());
        } catch (Exception ex) {
            throw new EntityNotFoundException(Person.class, person.getIdPerson());
        }

        // Update person AND return updated person's ID
        return updatePersonRepository.update(person).getIdPerson();
    }
}
