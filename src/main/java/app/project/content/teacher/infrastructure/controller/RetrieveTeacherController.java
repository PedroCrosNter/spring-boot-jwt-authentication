package app.project.content.teacher.infrastructure.controller;

import app.project.content.teacher.application.RetrieveTeacherUseCase;
import app.project.content.teacher.application.mapper.TeacherDtoMapper;
import app.project.content.teacher.domain.entity.Teacher;
import app.project.content.teacher.infrastructure.controller.dto.output.TeacherOutputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teachers")
public class RetrieveTeacherController {

    private final RetrieveTeacherUseCase retrieveTeacherUseCase;


    // GET: localhost:8080/teachers/{idTeacher}
    @GetMapping("/{idTeacher}")
    public ResponseEntity findById(
            @PathVariable Long idTeacher
            ,@RequestParam(value = "outerType", required = false, defaultValue = "simple") String outerType
    ) {

        Teacher teacher = retrieveTeacherUseCase.find(idTeacher);

        Object output;

        if ("full".equalsIgnoreCase(outerType)) {
            output = TeacherDtoMapper.INSTANCE.toOutputDtoDetails(teacher);
        } else {
            output = TeacherDtoMapper.INSTANCE.toOutputDto(teacher);
        }

        return ResponseEntity
                .ok()
                .body(
                        output
                );
    }

    // GET: localhost:8080/people
    @GetMapping
    public ResponseEntity<List<TeacherOutputDto>> findAll() {

        List<Teacher> teacher = retrieveTeacherUseCase.findAll();

        List<TeacherOutputDto> teacherOutputDto = TeacherDtoMapper.INSTANCE.toOutputDtoList(teacher);

        return  ResponseEntity
                .ok()
                .body(
                        teacherOutputDto
                );
    }

}
