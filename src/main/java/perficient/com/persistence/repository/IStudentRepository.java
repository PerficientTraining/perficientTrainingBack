package perficient.com.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import perficient.com.model.Course;
import perficient.com.model.Student;
import perficient.com.persistence.PerficientPersistenceException;

import java.util.Optional;

public interface IStudentRepository extends JpaRepository<Student, Integer> {}
