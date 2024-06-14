package app.project.content.person.infrastructure.controller;

import app.project.content.person.application.UpdatePersonUseCase;
import app.project.content.person.application.mapper.PersonEntityMapper;
import app.project.content.person.domain.entity.Person;
import app.project.content.person.infrastructure.controller.dto.input.PersonUpdateInputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/people")
public class UpdatePersonController {

    private final UpdatePersonUseCase updatePersonUseCase;


    // PUT: localhost:8080/people
    /**
     * BODY: {
     *     "idPerson": 2,
     *     "username": "PEDROCROS", // length >= 6 && <= 10
     *     "password": "12345678900987654321",
     *     "name": "PEDRO",
     *     "surname": "CROS",
     *     "companyEmail": "pedro.cros@nter.es",
     *     "personalEmail": "pedro.cros@gmail.com",
     *     "city": "Jaén",
     *     "active": true,
     *     "createdDate": "2025-06-15T00:00:00Z",// "2024-05-25 17:10:00",
     *     "imageUrl": "http://example.com/pedro.cros.jpg",
     *     "terminationDate": "2025-06-15T00:00:00Z"
     * }
     */
    @PutMapping
    public ResponseEntity<Long> update(@RequestBody PersonUpdateInputDto personUpdateInputDto) {
        // Mapper FROM InputDto TO PersonJpa
        Person person = PersonEntityMapper.INSTANCE.toEntity(personUpdateInputDto);

        // Applying use case
        Long personId = updatePersonUseCase.update(person);

        // Build a ResponseEntity
        return ResponseEntity.status(HttpStatus.CREATED).body(personId);
    }

}
