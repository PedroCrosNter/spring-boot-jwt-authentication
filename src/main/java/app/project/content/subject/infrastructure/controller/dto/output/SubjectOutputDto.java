package app.project.content.subject.infrastructure.controller.dto.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SubjectOutputDto {

    private Long idSubject;

    private String name;

    private LocalDate initialDate;
}
