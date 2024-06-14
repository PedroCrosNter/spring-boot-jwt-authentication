package app.project.content.subject.infrastructure.controller;

import app.project.content.subject.application.CreateSubjectUseCase;
import app.project.content.subject.application.mapper.SubjectEntityMapper;
import app.project.content.subject.domain.entity.Subject;
import app.project.content.subject.infrastructure.controller.dto.input.SubjectCreateInputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subjects")
public class CreateSubjectController {

    private final CreateSubjectUseCase createSubjectUseCase;

    // POST: localhost:8080/subjects
    /**
     * BODY: {
     *   "idStudent": 1,
     *   "name": "Programming",
     *   "comments": "In this subject we're going to learn Spring Boot",
     *   "subjects": [1,2]
     * }
     */
    @PostMapping
    public ResponseEntity<Long> save(@RequestBody SubjectCreateInputDto subjectCreateInputDto) {

        // Mapper FROM InputDto TO SubjectJpa
        Subject subject = SubjectEntityMapper.INSTANCE.toEntity(subjectCreateInputDto);

        // Applying use case
        Long idSubject = createSubjectUseCase.save(subject);

        // Build a ResponseEntity
        return ResponseEntity.status(HttpStatus.CREATED).body(idSubject);
    }
}
