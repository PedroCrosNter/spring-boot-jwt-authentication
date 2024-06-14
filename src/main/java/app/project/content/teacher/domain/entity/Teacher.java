package app.project.content.teacher.domain.entity;

import app.project.content.person.domain.entity.Person;
import app.project.content.student.domain.entity.Student;
import app.project.shared.enums.Branch;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    private Long idTeacher;
    private Person person;
    private String comments;
    private Branch branch;
    private List<Student> students;
}
