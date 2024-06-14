package app.project.content.subject.infrastructure.controller;

import app.project.content.subject.application.RetrieveSubjectUseCase;
import app.project.content.subject.application.mapper.SubjectDtoMapper;
import app.project.content.subject.domain.entity.Subject;
import app.project.content.subject.infrastructure.controller.dto.output.SubjectOutputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class RetrieveSubjectController {

    private final RetrieveSubjectUseCase retrieveSubjectUseCase;


    // GET: localhost:8080/subjects/{id}
    @GetMapping("/{idSubject}")
    public ResponseEntity find(
            @PathVariable Long idSubject
            ,@RequestParam(value = "outerType", required = false, defaultValue = "simple") String outerType
    ) {

        Subject subject = retrieveSubjectUseCase.findById(idSubject);

        Object output;

        if ("full".equalsIgnoreCase(outerType)) {
            output = SubjectDtoMapper.INSTANCE.toOutputDtoDetails(subject);
        } else {
            output = SubjectDtoMapper.INSTANCE.toOutputDto(subject);
        }


        return ResponseEntity
                .ok()
                .body(
                        output
                );
    }

    // GET: localhost:8080/subjects
    @GetMapping
    public ResponseEntity<List<SubjectOutputDto>> findAll() {

        List<Subject> subjects = retrieveSubjectUseCase.findAll();

        List<SubjectOutputDto> subjectsOutputDto = SubjectDtoMapper.INSTANCE.toOutputDtoList(subjects);

        return  ResponseEntity
                .ok()
                .body(
                        subjectsOutputDto
                );
    }
}
