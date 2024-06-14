package app.project.content.student.infrastructure.repository.impl;

import app.project.content.student.domain.repository.DeleteStudentRepository;
import app.project.content.student.infrastructure.repository.jpa.StudentRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DeleteStudentRepositoryImpl implements DeleteStudentRepository {

    private final StudentRepositoryJpa studentRepositoryJpa;


    @Override
    public void delete(Long idStudent) {
        studentRepositoryJpa.deleteById(idStudent);
    }
}
