package app.project.content.student.application.impl;

import app.project.content.person.application.RetrievePersonUseCase;
import app.project.content.student.application.CreateStudentUseCase;
import app.project.content.student.application.mapper.StudentEntityMapper;
import app.project.content.student.domain.entity.Student;
import app.project.content.student.domain.repository.CreateStudentRepository;
import app.project.content.student.infrastructure.controller.dto.input.StudentCreateInputDto;
import app.project.content.teacher.application.RetrieveTeacherUseCase;
import app.project.shared.enums.Branch;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CreateStudentUseCaseImpl implements CreateStudentUseCase {

    // Repository -> CreateStudent
    private final CreateStudentRepository createStudentRepository;
    // Use Case
        // -> RetrievePerson
        private final RetrievePersonUseCase retrievePersonUseCase;
        // -> RetrieveTeacher
        private final RetrieveTeacherUseCase retrieveTeacherUseCase;


    @Override
    public Long save(StudentCreateInputDto studentCreateInputDto) {

        if (Objects.isNull(studentCreateInputDto.getBranch().toString()) || StringUtils.isBlank(studentCreateInputDto.getBranch().toString())) {
            studentCreateInputDto.setBranch(Branch.UNASSIGNED);
        }

        // Create entity
        Student student = StudentEntityMapper.INSTANCE.toEntity(studentCreateInputDto);

        // SET -> Person
        student.setPerson(
                // TODO lanzar excepción en caso de que 'studentCreateInputDto.getIdPerson()' no exista en bd
                retrievePersonUseCase.find(studentCreateInputDto.getIdPerson())
        );

        // SET -> Teacher
        student.setTeacher(
                // TODO lanzar excepción en caso de que 'studentCreateInputDto.getIdTeacher()' no exista en bd
                retrieveTeacherUseCase.find(studentCreateInputDto.getIdTeacher())
        );

        // Repository -> SAVE(Student)
        return createStudentRepository.save(student);
    }
}
