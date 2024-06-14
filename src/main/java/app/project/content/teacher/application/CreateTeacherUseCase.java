package app.project.content.teacher.application;

import app.project.content.teacher.infrastructure.controller.dto.input.TeacherCreateInputDto;

public interface CreateTeacherUseCase {

    Long save(TeacherCreateInputDto teacherCreateInputDto);
}
