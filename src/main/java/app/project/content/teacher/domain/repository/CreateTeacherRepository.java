package app.project.content.teacher.domain.repository;

import app.project.content.teacher.domain.entity.Teacher;

public interface CreateTeacherRepository {

    Long save(Teacher teacher);
}
