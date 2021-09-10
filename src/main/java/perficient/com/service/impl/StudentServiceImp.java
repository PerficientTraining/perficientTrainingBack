package perficient.com.service.impl;

import perficient.com.service.PerficientServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perficient.com.dto.StudentDto;
import perficient.com.model.Student;
import perficient.com.persistence.impl.StudentPersistenceImpl;
import perficient.com.service.StudentService;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
public class StudentServiceImp implements StudentService<Student> {
    
    @Autowired
    StudentPersistenceImpl studentRepository;

    @Override
    public Student create(StudentDto studentDto) throws PerficientServiceException {
        try {
            int uniqueId = (int) UUID.randomUUID().hashCode();
            Student createStudent = new Student(studentDto, uniqueId, new Date());
            studentRepository.addStudent(createStudent);
            return createStudent;
        } catch (Exception e) {
            throw new PerficientServiceException(e.getMessage());
        }
    }

    @Override
    public Student findById(Integer id) throws PerficientServiceException {
        try {
            studentRepository.getStudentById(id);
            return studentRepository.getStudentById(id);
        } catch (Exception e) {
            throw new PerficientServiceException(e.getMessage());
        }
        
    }

    @Override
    public Collection<Student> all() throws PerficientServiceException{
        try {
            return (Collection) studentRepository.getAllStudents();
        } catch (Exception e) {
            throw new PerficientServiceException(e.getMessage());
        }
    }



    @Override
    public void update(StudentDto studentDto, Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(int id) throws PerficientServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }




    
    

}
