package app.project.content.student.infrastructure.repository.jpa.entity;

import app.project.content.person.infrastructure.repository.jpa.entity.PersonJpa;
import app.project.content.subject.infrastructure.repository.jpa.entity.SubjectJpa;
import app.project.content.teacher.infrastructure.repository.jpa.entity.TeacherJpa;
import app.project.shared.enums.Branch;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "student")
@Getter
@Setter
public class StudentJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student")
    private Long idStudent;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_person", nullable = false)
    private PersonJpa personJpa;

    @Column(name = "num_hours_week", nullable = false)
    private Integer numHoursWeek;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_teacher", nullable = false)
    private TeacherJpa teacherJpa;

    @Column(name = "branch", nullable = false)
    @Enumerated(EnumType.STRING)
    private Branch branch;

    @ManyToMany
    @JoinTable(
            name = "student_subject",
            joinColumns = @JoinColumn(name = "id_student"),
            inverseJoinColumns = @JoinColumn(name = "id_subject")
    )
    private List<SubjectJpa> subjects;
//    private Set<SubjectJpa> subjects;


    public void addSubject(SubjectJpa subject) {

        if (ObjectUtils.isEmpty(subject) || Objects.isNull(subjects)) {
            subjects = new ArrayList<>();
        }

        subjects.add(subject);
    }

    public void removeSubject(SubjectJpa subject) {

        if (ObjectUtils.isEmpty(subject) || Objects.isNull(subjects)) {
            subjects = new ArrayList<>();
        }

        subjects.remove(subject);
    }
}
