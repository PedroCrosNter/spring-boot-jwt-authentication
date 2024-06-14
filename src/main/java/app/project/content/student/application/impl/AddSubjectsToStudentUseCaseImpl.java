package app.project.content.student.application.impl;

import app.project.content.student.application.AddSubjectsToStudentUseCase;
import app.project.content.student.application.RetrieveStudentUseCase;
import app.project.content.student.application.mapper.StudentEntityMapper;
import app.project.content.student.domain.entity.Student;
import app.project.content.student.infrastructure.repository.jpa.StudentRepositoryJpa;
import app.project.content.student.infrastructure.repository.jpa.entity.StudentJpa;
import app.project.content.subject.application.RetrieveSubjectUseCase;
import app.project.content.subject.application.mapper.SubjectEntityMapper;
import app.project.content.subject.domain.entity.Subject;
import app.project.content.subject.infrastructure.repository.jpa.entity.SubjectJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddSubjectsToStudentUseCaseImpl implements AddSubjectsToStudentUseCase {

//    private final CreateStudentRepository createStudentRepository;
    private final StudentRepositoryJpa studentRepositoryJpa;
    private final RetrieveStudentUseCase retrieveStudentUseCase;
    private final RetrieveSubjectUseCase retrieveSubjectUseCase;


    @Override
    public Student addSubjects(Long idStudent, List<Long> idsSubjects) {

        Student student = retrieveStudentUseCase.find(idStudent);

        List<Subject> subjectList = new ArrayList<Subject>();

        StudentJpa studentJpa = StudentEntityMapper.INSTANCE.toEntityJpa(student);

        for (Long idSubject : idsSubjects) {

            Subject subject = retrieveSubjectUseCase.findById(idSubject);
            SubjectJpa subjectJpa = SubjectEntityMapper.INSTANCE.toEntityJpa(subject);
            studentJpa.addSubject(subjectJpa);
        }

        studentRepositoryJpa.save(studentJpa);

        return student;
    }
}
