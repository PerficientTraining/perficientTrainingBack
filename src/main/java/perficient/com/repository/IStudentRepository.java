package perficient.com.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import perficient.com.model.Student;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
    @Query("SELECT u FROM Student u.username' = ?1 AND u.password = ?2")
    Student autenticationStudent(String username, String password);


}
