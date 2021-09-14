package perficient.com.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import perficient.com.model.Student;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
}
