package app.project.content.teacher.infrastructure.controller;

import app.project.content.teacher.application.UpdateTeacherUseCase;
import app.project.content.teacher.application.mapper.TeacherEntityMapper;
import app.project.content.teacher.domain.entity.Teacher;
import app.project.content.teacher.infrastructure.controller.dto.input.TeacherUpdateInputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teachers")
public class UpdateTeacherController {

    private final UpdateTeacherUseCase updateTeacherUseCase;


    // PUT: localhost:8080/teachers
    /**
     * BODY: {
     *     "name": "PEDRO",
     * }
     */
    @PutMapping
    public ResponseEntity<Long> update(@RequestBody TeacherUpdateInputDto teacherUpdateInputDto) {
        // Mapper FROM InputDto TO TeacherJpa
        Teacher teacher = TeacherEntityMapper.INSTANCE.toEntity(teacherUpdateInputDto);

        // Applying use case
        Long idTeacher = updateTeacherUseCase.update(teacher);

        // Build a ResponseEntity
        return ResponseEntity.status(HttpStatus.CREATED).body(idTeacher);
    }
}
