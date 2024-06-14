package app.project.content.teacher.application;

import app.project.shared.exceptions.EntityNotFoundException;
import app.project.content.teacher.domain.entity.Teacher;

import java.util.List;

public interface RetrieveTeacherUseCase {

    Teacher find(Long idTeacher) throws EntityNotFoundException;

    List<Teacher> findAll() throws EntityNotFoundException;
}
