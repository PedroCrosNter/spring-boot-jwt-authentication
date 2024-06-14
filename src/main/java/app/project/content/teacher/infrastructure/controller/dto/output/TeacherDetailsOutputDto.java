package app.project.content.teacher.infrastructure.controller.dto.output;

import app.project.content.person.domain.entity.Person;
import app.project.content.student.domain.entity.Student;
import app.project.shared.enums.Branch;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TeacherDetailsOutputDto {

    @NonNull
    private Long idTeacher;

    @NonNull
    private String comments;

    @NonNull
    private Branch branch;

    Person person;

    List<Student> students;
}
