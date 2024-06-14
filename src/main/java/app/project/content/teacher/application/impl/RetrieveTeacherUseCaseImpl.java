package app.project.content.teacher.application.impl;

import app.project.content.teacher.application.RetrieveTeacherUseCase;
import app.project.content.teacher.domain.entity.Teacher;
import app.project.content.teacher.domain.repository.RetrieveTeacherRepository;
import app.project.shared.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RetrieveTeacherUseCaseImpl implements RetrieveTeacherUseCase {

    private final RetrieveTeacherRepository retrieveTeacherRepository;


    @Override
    public Teacher find(Long idTeacher) throws EntityNotFoundException {

        Teacher teacher;

        try {
            teacher = retrieveTeacherRepository.find(idTeacher);
        } catch (Exception e) {
            throw new EntityNotFoundException(Teacher.class, idTeacher);
        }

        return teacher;
    }

    @Override
    public List<Teacher> findAll() {
        return retrieveTeacherRepository.findAll();
    }
}
