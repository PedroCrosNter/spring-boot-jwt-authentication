package app.project.content.student.application;

import app.project.content.student.domain.entity.Student;

import java.util.List;

public interface RemoveSubjectsToStudentUseCase {

    Student removeSubjects(Long idStudent, List<Long> idsSubjects);
}
