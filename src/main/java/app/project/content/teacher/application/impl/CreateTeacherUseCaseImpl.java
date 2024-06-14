package app.project.content.teacher.application.impl;

import app.project.content.person.application.RetrievePersonUseCase;
import app.project.content.teacher.application.CreateTeacherUseCase;
import app.project.content.teacher.application.mapper.TeacherEntityMapper;
import app.project.content.teacher.domain.entity.Teacher;
import app.project.content.teacher.domain.repository.CreateTeacherRepository;
import app.project.content.teacher.infrastructure.controller.dto.input.TeacherCreateInputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTeacherUseCaseImpl implements CreateTeacherUseCase {

    private final CreateTeacherRepository createTeacherRepository;
    private final RetrievePersonUseCase retrievePersonUseCase;


    @Override
    public Long save(TeacherCreateInputDto teacherCreateInputDto) {

        Teacher teacher = TeacherEntityMapper.INSTANCE.toEntity(teacherCreateInputDto);

        teacher.setPerson(
                retrievePersonUseCase.find(
                        teacherCreateInputDto.getIdPerson()
                )
        );

        return createTeacherRepository.save(teacher);
    }
}
