package app.project.content.subject.infrastructure.controller;

import app.project.content.subject.application.DeleteSubjectUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subjects")
public class DeleteSubjectController {

    private final DeleteSubjectUseCase deleteSubjectUseCase;

    // POST: localhost:8080/subjects
    /**
     * BODY: {
     *   "idStudent": 1,
     *   "name": "Programming",
     *   "comments": "In this subject we're going to learn Spring Boot",
     *   "subjects": [1,2]
     * }
     */
    @DeleteMapping("/{idSubject}")
    public ResponseEntity<Boolean> save(@PathVariable Long idSubject) {

        // Applying use case
        Boolean deleted = deleteSubjectUseCase.delete(idSubject);

        // Build a ResponseEntity
        return ResponseEntity.status(HttpStatus.CREATED).body(deleted);
    }
}
