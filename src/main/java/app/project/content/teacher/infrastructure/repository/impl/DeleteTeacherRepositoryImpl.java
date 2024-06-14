package app.project.content.teacher.infrastructure.repository.impl;

import app.project.content.teacher.domain.repository.DeleteTeacherRepository;
import app.project.content.teacher.infrastructure.repository.jpa.TeacherRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DeleteTeacherRepositoryImpl implements DeleteTeacherRepository {

    private final TeacherRepositoryJpa teacherRepositoryJpa;


    @Override
    public void delete(Long idTeacher) {
        teacherRepositoryJpa.deleteById(idTeacher);
    }
}
