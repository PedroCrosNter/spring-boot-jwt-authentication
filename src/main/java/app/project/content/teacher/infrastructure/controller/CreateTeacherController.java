package app.project.content.teacher.infrastructure.controller;

import app.project.content.teacher.application.CreateTeacherUseCase;
import app.project.content.teacher.infrastructure.controller.dto.input.TeacherCreateInputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teachers")
public class CreateTeacherController {

    private final CreateTeacherUseCase createTeacherUseCase;


    // POST: localhost:8080/teachers
    /**
     * BODY: {
     *     "name": "PEDRO",
     * }
     */
    @PostMapping
    public ResponseEntity<Long> save(@RequestBody TeacherCreateInputDto teacherCreateInputDto) {

        // Applying use case
        Long idTeacher = createTeacherUseCase.save(teacherCreateInputDto);

        // Build a ResponseEntity
        return ResponseEntity.status(HttpStatus.CREATED).body(idTeacher);
    }
}
