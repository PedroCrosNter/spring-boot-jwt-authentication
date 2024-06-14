package app.project.content.subject.application;

import app.project.content.subject.domain.entity.Subject;

import java.util.List;

public interface RetrieveSubjectUseCase {

    Subject findById(Long idSubject);

    List<Subject> findAll();

    List<Subject> findByIdStudent(Long idStudent);
}
