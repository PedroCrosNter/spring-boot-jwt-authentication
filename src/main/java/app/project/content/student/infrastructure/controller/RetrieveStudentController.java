package app.project.content.student.infrastructure.controller;

import app.project.content.student.application.RetrieveStudentUseCase;
import app.project.content.student.application.mapper.StudentDtoMapper;
import app.project.content.student.domain.entity.Student;
import app.project.content.student.infrastructure.controller.dto.output.StudentOutputDto;
import app.project.content.subject.application.mapper.SubjectDtoMapper;
import app.project.content.subject.domain.entity.Subject;
import app.project.content.subject.infrastructure.controller.dto.output.SubjectOutputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class RetrieveStudentController {

    private final RetrieveStudentUseCase retrieveStudentUseCase;


    // GET: localhost:8080/students/{idStudent}
    @GetMapping("/{idStudent}")
    public ResponseEntity findById(
            @PathVariable Long idStudent
            ,@RequestParam(value = "outerType", required = false, defaultValue = "simple") String outerType
    ) {

        Student student = retrieveStudentUseCase.find(idStudent);

        Object output;

        if ("full".equalsIgnoreCase(outerType)) {
            output = StudentDtoMapper.INSTANCE.toOutputDtoDetails(student);
        } else {
            output = StudentDtoMapper.INSTANCE.toOutputDto(student);
        }


        return ResponseEntity
                .ok()
                .body(
                        output
                );
    }

    // GET: localhost:8080/students
    @GetMapping
    public ResponseEntity<List<StudentOutputDto>> findAll() {

        List<Student> students = retrieveStudentUseCase.findAll();

        List<StudentOutputDto> studentOutputDtoList = StudentDtoMapper.INSTANCE.toOutputDtoList(students);

        return  ResponseEntity
                .ok()
                .body(
                        studentOutputDtoList
                );
    }

    // GET: localhost:8080/students/{idStudent}
    @GetMapping("/{idStudent}/subjects")
    public ResponseEntity<List<SubjectOutputDto>> findSubjectsByIdStudent(
            @PathVariable Long idStudent
    ) {

        List<Subject> subjectList = retrieveStudentUseCase.findSubjectsByIdStudent(idStudent);

        List<SubjectOutputDto> subjectOutputDtoList = SubjectDtoMapper.INSTANCE.toOutputDtoList(subjectList);

        return ResponseEntity
                .ok()
                .body(
                        subjectOutputDtoList
                );
    }
}
