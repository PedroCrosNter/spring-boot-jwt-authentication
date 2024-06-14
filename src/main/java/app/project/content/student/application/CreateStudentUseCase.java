package app.project.content.student.application;

import app.project.content.student.infrastructure.controller.dto.input.StudentCreateInputDto;

public interface CreateStudentUseCase {

    Long save(StudentCreateInputDto studentCreateInputDto);
}
