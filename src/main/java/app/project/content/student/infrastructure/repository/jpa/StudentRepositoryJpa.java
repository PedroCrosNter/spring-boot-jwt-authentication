package app.project.content.student.infrastructure.repository.jpa;

import app.project.content.student.infrastructure.repository.jpa.entity.StudentJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositoryJpa extends JpaRepository<StudentJpa, Long> {
}
