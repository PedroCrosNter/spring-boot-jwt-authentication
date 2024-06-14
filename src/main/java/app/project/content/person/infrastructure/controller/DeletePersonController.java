package app.project.content.person.infrastructure.controller;

import app.project.content.person.application.DeletePersonUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/people")
public class DeletePersonController {

    private final DeletePersonUseCase deletePersonUseCase;


    // DELETE: localhost:8080/people/{idPerson}
    @DeleteMapping("/{idPerson}")
    public ResponseEntity delete(@PathVariable Long idPerson) {
        // TODO devolver NOT_FOUND cuando el id no se ha encontrado : ver
        // TODO devolver NOT_CONTENT cuando el id se ha encontrado y se ha borrado
        // Delete by ID
        deletePersonUseCase.delete(idPerson);

        // Build a ResponseEntity
        return ResponseEntity.ok().build();
    }

}