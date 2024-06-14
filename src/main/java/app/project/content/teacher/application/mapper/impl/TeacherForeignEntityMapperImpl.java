package app.project.content.teacher.application.mapper.impl;

import app.project.content.person.application.RetrievePersonUseCase;
import app.project.content.person.application.mapper.PersonEntityMapper;
import app.project.content.teacher.application.mapper.TeacherEntityMapper;
import app.project.content.teacher.application.mapper.TeacherForeignEntityMapper;
import app.project.content.teacher.domain.entity.Teacher;
import app.project.content.teacher.infrastructure.repository.jpa.entity.TeacherJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeacherForeignEntityMapperImpl implements TeacherForeignEntityMapper {

    private final RetrievePersonUseCase retrievePersonUseCase;


    @Override
    public TeacherJpa toEntityJpa(Teacher teacher) {

        TeacherJpa teacherJpa = TeacherEntityMapper.INSTANCE.toEntityJpa(teacher);

        teacherJpa.setPersonJpa(
                PersonEntityMapper.INSTANCE.toEntityJpa(
                        retrievePersonUseCase.find(
                                    teacher
                                        .getPerson()
                                        .getIdPerson()
                        )
                )
        );

        return teacherJpa;
    }
}
