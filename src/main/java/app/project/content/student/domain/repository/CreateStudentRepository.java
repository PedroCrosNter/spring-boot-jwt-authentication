package app.project.content.student.domain.repository;

import app.project.content.student.domain.entity.Student;

public interface CreateStudentRepository {

    Long save(Student student);
}
