package app.project.content.student.infrastructure.controller.dto.output;

import app.project.content.person.domain.entity.Person;
import app.project.content.teacher.domain.entity.Teacher;
import app.project.shared.enums.Branch;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentDetailsOutputDto {

    @NonNull
    private Long idStudent;

    @NonNull // Foreign key
    private Person person;

    @NonNull
    private Integer numHoursWeek;

    private Teacher teacher;

    @NonNull
    private Branch branch;
}
