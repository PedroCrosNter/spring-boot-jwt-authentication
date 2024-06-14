package app.project.content.student.application.impl;

import app.project.content.person.domain.repository.DeletePersonRepository;
import app.project.content.student.application.DeleteStudentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteStudentUseCaseImpl implements DeleteStudentUseCase {

    private final DeletePersonRepository deletePersonRepository;


    @Override
    public Boolean delete(Long idStudent) {
        return deletePersonRepository.delete(idStudent);
    }
}
