package app.project.content.teacher.infrastructure.controller;

import app.project.content.teacher.application.DeleteTeacherUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teachers")
public class DeleteTeacherController {

    private final DeleteTeacherUseCase deleteTeacherUseCase;

    // DELETE: localhost:8080/teachers/{idTeacher}
    @DeleteMapping("/{idTeacher}")
    public ResponseEntity<?> save(@PathVariable Long idTeacher) {

        // Delete by ID
        deleteTeacherUseCase.delete(idTeacher);

        // Build a ResponseEntity
        return ResponseEntity.ok().build();
    }
}
