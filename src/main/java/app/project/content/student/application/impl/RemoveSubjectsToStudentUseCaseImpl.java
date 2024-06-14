package app.project.content.student.application.impl;

import app.project.shared.exceptions.EntityNotFoundException;
import app.project.content.student.application.RemoveSubjectsToStudentUseCase;
import app.project.content.student.application.RetrieveStudentUseCase;
import app.project.content.student.domain.entity.Student;
import app.project.content.student.infrastructure.repository.jpa.StudentRepositoryJpa;
import app.project.content.student.infrastructure.repository.jpa.entity.StudentJpa;
import app.project.content.subject.application.RetrieveSubjectUseCase;
import app.project.content.subject.domain.entity.Subject;
import app.project.content.subject.infrastructure.repository.jpa.entity.SubjectJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RemoveSubjectsToStudentUseCaseImpl implements RemoveSubjectsToStudentUseCase {

//    private final CreateStudentRepository createStudentRepository;
    private final StudentRepositoryJpa studentRepositoryJpa;
    private final RetrieveStudentUseCase retrieveStudentUseCase;
    private final RetrieveSubjectUseCase retrieveSubjectUseCase;


    @Override
    public Student removeSubjects(Long idStudent, List<Long> idsSubjects) {

        Student student = retrieveStudentUseCase.find(idStudent);

        List<Subject> subjectList = new ArrayList<Subject>();

        StudentJpa studentJpa = studentRepositoryJpa.findById(idStudent)
                .orElseThrow(() -> new EntityNotFoundException(Student.class, idStudent));

        List<SubjectJpa> subjectsFromStudentJpa = studentJpa.getSubjects();

        for (SubjectJpa subjectJpa : subjectsFromStudentJpa) {
            studentJpa.removeSubject(subjectJpa);
        }

        studentRepositoryJpa.save(studentJpa);

        return student;
    }
}
