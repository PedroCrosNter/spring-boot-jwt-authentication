package app.project.content.student.domain.repository;

import app.project.content.student.domain.entity.Student;

import java.util.List;

public interface RetrieveStudentRepository {

    Student findById(Long idStudent);

    List<Student> findAll();
}
