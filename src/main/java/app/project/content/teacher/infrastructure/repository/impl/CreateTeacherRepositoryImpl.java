package app.project.content.teacher.infrastructure.repository.impl;

import app.project.content.person.domain.entity.Person;
import app.project.shared.exceptions.ForeignKeyException;
import app.project.content.teacher.application.mapper.TeacherForeignEntityMapper;
import app.project.content.teacher.domain.entity.Teacher;
import app.project.content.teacher.domain.repository.CreateTeacherRepository;
import app.project.content.teacher.infrastructure.repository.jpa.TeacherRepositoryJpa;
import app.project.content.teacher.infrastructure.repository.jpa.entity.TeacherJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CreateTeacherRepositoryImpl implements CreateTeacherRepository {

    private final TeacherRepositoryJpa teacherRepositoryJpa;
    private final TeacherForeignEntityMapper teacherForeignEntityMapper;


    @Override
    public Long save(Teacher teacher) {
        // We can validate here
//        TeacherJpa teacherJpa = TeacherEntityMapper.INSTANCE.toEntityJpa(teacher);

//        return teacherRepositoryJpa.save(
//                teacherForeignEntityMapper.toEntityJpa(teacher)
//        ).getIdTeacher();

        TeacherJpa teacherJpa = teacherForeignEntityMapper.toEntityJpa(teacher);

        Long idTeacher = null;
        try {
            idTeacher = teacherRepositoryJpa.save(teacherJpa).getIdTeacher();
        } catch (Exception e) {
            throw new ForeignKeyException(Teacher.class, null, Person.class, teacher.getPerson().getIdPerson());
        }

        return idTeacher;
    }
}
