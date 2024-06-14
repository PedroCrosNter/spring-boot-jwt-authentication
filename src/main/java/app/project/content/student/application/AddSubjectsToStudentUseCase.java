package app.project.content.student.application;

import app.project.content.student.domain.entity.Student;

import java.util.List;

public interface AddSubjectsToStudentUseCase {

    Student addSubjects(Long idStudent, List<Long> idsSubjects);
}
