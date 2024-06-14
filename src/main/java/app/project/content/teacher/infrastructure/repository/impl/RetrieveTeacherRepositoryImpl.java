package app.project.content.teacher.infrastructure.repository.impl;

import app.project.shared.exceptions.EntityNotFoundException;
import app.project.content.teacher.application.mapper.TeacherEntityMapper;
import app.project.content.teacher.domain.entity.Teacher;
import app.project.content.teacher.domain.repository.RetrieveTeacherRepository;
import app.project.content.teacher.infrastructure.repository.jpa.TeacherRepositoryJpa;
import app.project.content.teacher.infrastructure.repository.jpa.entity.TeacherJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RetrieveTeacherRepositoryImpl implements RetrieveTeacherRepository {

    private final TeacherRepositoryJpa teacherRepositoryJpa;


    @Override
    public Teacher find(Long idTeacher) {

        return TeacherEntityMapper.INSTANCE.toEntity(
                teacherRepositoryJpa.findById(idTeacher)
                        .orElseThrow( () -> new EntityNotFoundException(Teacher.class, idTeacher))
        );

//        TeacherJpa teacherJpa = teacherRepositoryJpa.findById(idTeacher).get();
//        teacherJpa.getStudents();
//
//        Teacher teacher = TeacherEntityMapper.INSTANCE.toEntity(teacherJpa);
//        teacher.getStudents();
//
//        return teacher;
    }

    @Override
    public List<Teacher> findAll() {

        List<TeacherJpa> teacherJpaList = teacherRepositoryJpa.findAll();

        return teacherJpaList.stream()
                .map(TeacherEntityMapper.INSTANCE::toEntity)
                .collect(Collectors.toList());
    }
}
