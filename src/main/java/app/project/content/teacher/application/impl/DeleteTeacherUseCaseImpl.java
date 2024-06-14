package app.project.content.teacher.application.impl;

import app.project.content.teacher.application.DeleteTeacherUseCase;
import app.project.content.teacher.domain.repository.DeleteTeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteTeacherUseCaseImpl implements DeleteTeacherUseCase {

    private final DeleteTeacherRepository deleteTeacherRepository;


    @Override
    public void delete(Long idTeacher) {
        deleteTeacherRepository.delete(idTeacher);
    }
}
