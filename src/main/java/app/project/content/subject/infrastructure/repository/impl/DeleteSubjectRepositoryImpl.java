package app.project.content.subject.infrastructure.repository.impl;

import app.project.content.subject.domain.repository.DeleteSubjectRepository;
import app.project.content.subject.infrastructure.repository.jpa.SubjectRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DeleteSubjectRepositoryImpl implements DeleteSubjectRepository {

    private final SubjectRepositoryJpa subjectRepositoryJpa;


    @Override
    public Boolean delete(Long idSubject) {

        if (subjectRepositoryJpa.existsById(idSubject)) {
            subjectRepositoryJpa.deleteById(idSubject);
            return true;
        }

        return false;
    }
}
