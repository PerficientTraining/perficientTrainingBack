package perficient.com.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import perficient.com.model.Course;
import perficient.com.model.Student;
import perficient.com.persistence.PerficientPersistenceException;

import java.util.Optional;

public interface IStudentRepository extends JpaRepository<Student, Integer> {

    /*
    Optional<Student> findByMail(String mail) throws PerficientPersistenceException;
    Optional<Student> findByUserName(String userName) throws PerficientPersistenceException;
     */
}
