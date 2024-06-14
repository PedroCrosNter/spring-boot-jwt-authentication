package app.project.content.teacher.domain.repository;

import app.project.content.teacher.domain.entity.Teacher;

import java.util.List;

public interface RetrieveTeacherRepository {

    Teacher find(Long idTeacher);

    List<Teacher> findAll();
}
