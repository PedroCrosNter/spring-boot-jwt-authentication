package app.project.content.student.application.impl;

import app.project.shared.exceptions.EntityNotFoundException;
import app.project.content.student.application.RetrieveStudentUseCase;
import app.project.content.student.domain.entity.Student;
import app.project.content.student.domain.repository.RetrieveStudentRepository;
import app.project.content.subject.application.RetrieveSubjectUseCase;
import app.project.content.subject.domain.entity.Subject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RetrieveStudentUseCaseImpl implements RetrieveStudentUseCase {

    private final RetrieveStudentRepository retrieveStudentRepository;
    private final RetrieveSubjectUseCase retrieveSubjectUseCase;


    @Override
    public Student find(Long idStudent) throws EntityNotFoundException {

        return retrieveStudentRepository.findById(idStudent);
    }

        @Override
    public List<Student> findAll() {
        return retrieveStudentRepository.findAll();
    }

    @Override
    public List<Subject> findSubjectsByIdStudent(Long idStudent) {
        return retrieveSubjectUseCase.findByIdStudent(idStudent);
    }
}
