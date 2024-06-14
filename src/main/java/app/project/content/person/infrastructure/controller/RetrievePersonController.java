package app.project.content.person.infrastructure.controller;

import app.project.content.person.application.RetrievePersonUseCase;
import app.project.content.person.application.mapper.PersonDtoMapper;
import app.project.content.person.domain.entity.Person;
import app.project.content.person.infrastructure.controller.dto.output.PersonOutputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class RetrievePersonController {

    private final RetrievePersonUseCase retrievePersonUseCase;


    // GET: localhost:8080/people/{id}
    @GetMapping("/{idPerson}")
    public ResponseEntity<PersonOutputDto> find(@PathVariable Long idPerson) {

        Person person = retrievePersonUseCase.find(idPerson);

        return ResponseEntity
                .ok()
                .body(
                        PersonDtoMapper.INSTANCE.toOutputDto(person)
                );
    }

    // GET: localhost:8080/people
    @GetMapping
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<List<PersonOutputDto>> findAll() {

        List<Person> people = retrievePersonUseCase.findAll();

        List<PersonOutputDto> peopleOutputDto = PersonDtoMapper.INSTANCE.toOutputDtoList(people);

        return  ResponseEntity
                .ok()
                .body(
                        peopleOutputDto
                );
    }
}
