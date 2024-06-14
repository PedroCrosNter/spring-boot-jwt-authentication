package app.project.content.person.application.impl;

import app.project.content.person.application.CreatePersonUseCase;
import app.project.content.person.domain.entity.Person;
import app.project.content.person.domain.repository.CreatePersonRepository;
import app.project.shared.exceptions.UnprocessableEntityException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePersonUseCaseImpl implements CreatePersonUseCase {

    private final CreatePersonRepository createPersonRepository;


    @Override
    public Long save(Person person) {

        try {
            return createPersonRepository.save(person);
        } catch (Exception ex) {
            throw new UnprocessableEntityException(Person.class);
        }
    }
}
