package perficient.com.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import perficient.com.model.Course;

public interface ICourseRepository extends JpaRepository<Course, Integer> {
}
