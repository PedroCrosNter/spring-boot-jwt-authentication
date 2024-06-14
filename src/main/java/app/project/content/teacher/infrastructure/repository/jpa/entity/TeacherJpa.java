package app.project.content.teacher.infrastructure.repository.jpa.entity;

import app.project.content.person.infrastructure.repository.jpa.entity.PersonJpa;
import app.project.content.student.infrastructure.repository.jpa.entity.StudentJpa;
import app.project.shared.enums.Branch;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "teacher")
@Getter
@Setter
public class TeacherJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_teacher")
    private Long idTeacher;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_person", nullable = false)
    private PersonJpa personJpa;

    @Column(name = "comments", nullable = false)
    private String comments;

    @Column(name = "branch", nullable = false)
    @Enumerated(EnumType.STRING)
    private Branch branch;

    @OneToMany(mappedBy = "teacherJpa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<StudentJpa> students;
}
