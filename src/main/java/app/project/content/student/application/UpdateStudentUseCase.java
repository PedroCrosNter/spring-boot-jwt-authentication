package app.project.content.student.application;

import app.project.content.student.domain.entity.Student;

public interface UpdateStudentUseCase {

    Long update(Student student);
}
