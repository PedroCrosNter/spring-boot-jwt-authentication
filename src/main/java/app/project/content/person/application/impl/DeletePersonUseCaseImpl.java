package app.project.content.person.application.impl;

import app.project.content.person.application.DeletePersonUseCase;
import app.project.content.person.domain.repository.DeletePersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeletePersonUseCaseImpl implements DeletePersonUseCase {

    private final DeletePersonRepository deletePersonRepository;


    @Override
    public void delete(Long idPerson) {
        deletePersonRepository.delete(idPerson);
    }

    @Override
    public void delete(String idPerson) {
        this.delete(Long.valueOf(idPerson));
    }
}
