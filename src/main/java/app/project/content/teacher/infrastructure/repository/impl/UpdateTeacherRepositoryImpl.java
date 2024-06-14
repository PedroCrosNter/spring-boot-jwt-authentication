package app.project.content.teacher.infrastructure.repository.impl;

import app.project.shared.exceptions.EntityNotFoundException;
import app.project.content.teacher.application.mapper.TeacherEntityMapper;
import app.project.content.teacher.domain.entity.Teacher;
import app.project.content.teacher.domain.repository.UpdateTeacherRepository;
import app.project.content.teacher.infrastructure.repository.jpa.TeacherRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateTeacherRepositoryImpl implements UpdateTeacherRepository {

    private final TeacherRepositoryJpa teacherRepositoryJpa;


    @Override
    public Teacher update(Teacher teacher) {

        return teacherRepositoryJpa
                .findById(teacher.getIdTeacher())
                .map(existingTeacherJpa -> {
                    // Map new data to existing entity
                    TeacherEntityMapper.INSTANCE.toEntity(teacher, existingTeacherJpa);
                    // Save updated entity
                    return teacherRepositoryJpa.save(existingTeacherJpa);
                })
                // Map to domain entity
                .map(TeacherEntityMapper.INSTANCE::toEntity)
                .orElseThrow(
                        () -> new EntityNotFoundException(Teacher.class, teacher.getIdTeacher())
                );
    }
}
