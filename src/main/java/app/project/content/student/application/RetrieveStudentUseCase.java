package app.project.content.student.application;

import app.project.shared.exceptions.EntityNotFoundException;
import app.project.content.student.domain.entity.Student;
import app.project.content.subject.domain.entity.Subject;

import java.util.List;

public interface RetrieveStudentUseCase {

    Student find(Long idStudent) throws EntityNotFoundException;

    List<Student> findAll();

    List<Subject> findSubjectsByIdStudent(Long idStudent);
}
