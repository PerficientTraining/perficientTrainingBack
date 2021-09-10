package perficient.com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perficient.com.dto.StudentDto;
import perficient.com.model.Student;
import perficient.com.repository.StudentRepository;
import perficient.com.service.StudentService;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
public class StudentServiceImp implements StudentService<Student> {
    
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student create(StudentDto studentDto) throws Exception {
        try {
            int uniqueId = (int) UUID.randomUUID().hashCode();
            Student createStudent = new Student(studentDto, uniqueId, new Date());
            studentRepository.createStudent(createStudent);
            return createStudent;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Student findById(Integer id) throws Exception {
       return null; 
    }

    @Override
    public Collection<Student> all() throws Exception{
        try {
            return (Collection) studentRepository.findAllUsers();
        } catch (Exception e) {
            throw new Exception (e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) {
        
    }

    @Override
    public void update(StudentDto studentDto, Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }




    
    

}
