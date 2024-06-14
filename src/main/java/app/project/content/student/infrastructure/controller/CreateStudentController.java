package app.project.content.student.infrastructure.controller;

import app.project.content.student.application.AddSubjectsToStudentUseCase;
import app.project.content.student.application.CreateStudentUseCase;
import app.project.content.student.application.RetrieveStudentUseCase;
import app.project.content.student.application.mapper.StudentDtoMapper;
import app.project.content.student.application.mapper.StudentEntityMapper;
import app.project.content.student.domain.entity.Student;
import app.project.content.student.infrastructure.controller.dto.input.StudentCreateInputDto;
import app.project.content.student.infrastructure.controller.dto.input.StudentManageSubjectsInputDto;
import app.project.content.student.infrastructure.controller.dto.output.StudentDetailsOutputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class CreateStudentController {

    private final CreateStudentUseCase createStudentUseCase;
    private final RetrieveStudentUseCase retrieveStudentUseCase;
    private final AddSubjectsToStudentUseCase addSubjectsToStudentUseCase;


    // POST: localhost:8080/students
    /**
     * BODY: {
     *   "id_person": 3,
     *   "numHoursWeek": 20,
     *   "id_teacher": 2001,
     *   "branch": "FRONT"
     * }
     */
    @PostMapping
    public ResponseEntity<Long> save(@RequestBody StudentCreateInputDto studentCreateInputDto) {

        // Mapper FROM InputDto TO StudentJpa
        Student student = StudentEntityMapper.INSTANCE.toEntity(studentCreateInputDto);

        // Applying use case
        Long idStudent = createStudentUseCase.save(studentCreateInputDto);

        // Build a ResponseEntity
        return ResponseEntity.status(HttpStatus.CREATED).body(idStudent);
    }


    @PostMapping("/subjects")
    public ResponseEntity<StudentDetailsOutputDto> addSubjectsByIdStudent(@RequestBody StudentManageSubjectsInputDto studentManageSubjectsInputDto) {

        // Mapper FROM InputDto TO StudentJpa
        Student student = addSubjectsToStudentUseCase.addSubjects(
                studentManageSubjectsInputDto.getIdStudent()
                ,studentManageSubjectsInputDto.getIdsSubjects()
        );

        StudentDetailsOutputDto output = StudentDtoMapper.INSTANCE.toOutputDtoDetails(student);

        // Build a ResponseEntity
        return ResponseEntity.status(HttpStatus.CREATED).body(output);
    }
}
