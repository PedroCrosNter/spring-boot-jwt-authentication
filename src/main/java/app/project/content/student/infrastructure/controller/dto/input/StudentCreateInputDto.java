package app.project.content.student.infrastructure.controller.dto.input;

import app.project.shared.enums.Branch;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentCreateInputDto {

    @NonNull
    private Long idPerson;

    @NonNull
    private Integer numHoursWeek;

    @NonNull
    private Long idTeacher;

    @NonNull
    private Branch branch;
}
