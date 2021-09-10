package perficient.com.repository;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import perficient.com.model.Student;

import java.util.Collection;

@Repository
@NoArgsConstructor
public class StudentRepository{

    @Autowired
    private IStudentRepository studentRepository;

    public void createStudent (Student student) throws Exception{
        studentRepository.save(student);
    }

    public Collection<Student> findAllUsers(){
        return studentRepository.findAll();
    }
    

}
