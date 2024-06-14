package app.project.content.student.infrastructure.controller;

import app.project.content.student.application.DeleteStudentUseCase;
import app.project.content.student.application.RemoveSubjectsToStudentUseCase;
import app.project.content.student.application.mapper.StudentDtoMapper;
import app.project.content.student.domain.entity.Student;
import app.project.content.student.infrastructure.controller.dto.input.StudentManageSubjectsInputDto;
import app.project.content.student.infrastructure.controller.dto.output.StudentDetailsOutputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class DeleteStudentController {

    private final DeleteStudentUseCase deleteStudentUseCase;
    private final RemoveSubjectsToStudentUseCase removeSubjectsToStudentUseCase;


    // DELETE: localhost:8080/students/{idStudent}
    @DeleteMapping("/{idStudent}")
    public ResponseEntity<Boolean> delete(@PathVariable Long idStudent) {

        // Applying use case
        Boolean deleted = deleteStudentUseCase.delete(idStudent);

        // Build a ResponseEntity
        return ResponseEntity.status(HttpStatus.CREATED).body(deleted);
    }

    // DELETE: localhost:8080/students/{idStudent}
    @DeleteMapping("/subjects")
    public ResponseEntity<StudentDetailsOutputDto> removeSubjectsByIdStudent(@RequestBody StudentManageSubjectsInputDto studentManageSubjectsInputDto) {

        // Applying use case
        Student student = removeSubjectsToStudentUseCase.removeSubjects(
                studentManageSubjectsInputDto.getIdStudent()
                ,studentManageSubjectsInputDto.getIdsSubjects()
        );

        StudentDetailsOutputDto output = StudentDtoMapper.INSTANCE.toOutputDtoDetails(student);

        // Build a ResponseEntity
        return ResponseEntity.status(HttpStatus.CREATED).body(output);
    }
}
