package app.project.content.subject.infrastructure.repository.jpa.entity;

import app.project.content.student.infrastructure.repository.jpa.entity.StudentJpa;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "subject")
@Getter
@Setter
public class SubjectJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subject")
    private Long idSubject;

//    @ManyToMany(mappedBy = "subjects")
    @ManyToMany
    @JoinTable(
            name = "student_subject",
            joinColumns = @JoinColumn(name = "id_subject"),
            inverseJoinColumns = @JoinColumn(name = "id_student")
    )
    private List<StudentJpa> students;

    @Column(name = "name")
    private String name;

    @Column(name = "comment")
    private String comment;

    @Column(name = "initial_date")
    private LocalDate initialDate;

    @Column(name = "finish_date")
    private LocalDate finishDate;
}
