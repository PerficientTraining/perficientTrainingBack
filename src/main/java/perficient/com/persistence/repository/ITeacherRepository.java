package perficient.com.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import perficient.com.model.Teacher;

public interface ITeacherRepository extends JpaRepository<Teacher, Integer> {
}
