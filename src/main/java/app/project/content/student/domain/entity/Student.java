package app.project.content.student.domain.entity;

import app.project.content.person.domain.entity.Person;
import app.project.content.teacher.domain.entity.Teacher;
import app.project.shared.enums.Branch;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {

    private Long idStudent;
    private Person person;
    private Integer numHoursWeek;
    private Teacher teacher;
    private Branch branch;
}
