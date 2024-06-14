package app.project.content.subject.domain.entity;

import app.project.content.student.domain.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Subject {

    private Long idSubject;
//    private Long idStudent;
    private List<Student> students;
    private String name;
    private String comment;
    private LocalDate initialDate;
    private LocalDate finishDate;
}
