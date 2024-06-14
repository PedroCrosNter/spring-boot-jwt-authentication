package app.project.content.teacher.application.mapper;

import app.project.content.teacher.domain.entity.Teacher;
import app.project.content.teacher.infrastructure.repository.jpa.entity.TeacherJpa;

public abstract interface TeacherForeignEntityMapper {

    TeacherJpa toEntityJpa(Teacher teacher);
}
