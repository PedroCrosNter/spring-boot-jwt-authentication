package app.project.content.subject.application.impl;

import app.project.shared.exceptions.EntityNotFoundException;
import app.project.content.subject.application.RetrieveSubjectUseCase;
import app.project.content.subject.domain.entity.Subject;
import app.project.content.subject.domain.repository.RetrieveSubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RetrieveSubjectUseCaseImpl implements RetrieveSubjectUseCase {

    private final RetrieveSubjectRepository retrieveSubjectRepository;


    @Override
    public Subject findById(Long idSubject) throws EntityNotFoundException {

        Subject subject;

        try {
            subject = retrieveSubjectRepository.findById(idSubject);
        } catch (Exception e) {
            throw new EntityNotFoundException(Subject.class, idSubject);
        }

        return subject;
    }

    @Override
    public List<Subject> findAll() {

//        return retrieveSubjectRepository.findAll();

        List<Subject> subjectList = retrieveSubjectRepository.findAll();
        return subjectList;
    }

    @Override
    public List<Subject> findByIdStudent(Long idStudent) {

        return retrieveSubjectRepository.findByIdStudent(idStudent);
    }
}
