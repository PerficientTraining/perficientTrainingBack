package perficient.com.service.impl;

import perficient.com.persistence.IStudentPersistence;
import perficient.com.service.PerficientServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perficient.com.dto.StudentDto;
import perficient.com.model.Student;
import perficient.com.persistence.impl.StudentPersistenceImpl;
import perficient.com.service.IStudentService;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;
import lombok.NoArgsConstructor;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@NoArgsConstructor
@Service
public class StudentServiceImp implements IStudentService<Student> {
    
    @Autowired
    private IStudentPersistence studentPersistence;

    @Override
    public Student create(StudentDto studentDto) throws PerficientServiceException {
        try {
            int uniqueId = (int) UUID.randomUUID().hashCode();
            Student student = new Student(studentDto, uniqueId, new Date());
            studentPersistence.createStudent(student);
            return student;
        } catch (Exception e) {
            throw new PerficientServiceException(e.getMessage());
        }
    }

    @Override
    public Student findById(Integer id) throws PerficientServiceException {
        try {
            return studentPersistence.findStudentById(id);
        } catch (Exception e) {
            throw new PerficientServiceException(e.getMessage());
        }
        
    }

    @Override
    public Collection<Student> all() throws PerficientServiceException{
        try {
            return (Collection) studentPersistence.getAllStudents();
        } catch (Exception e) {
            throw new PerficientServiceException(e.getMessage());
        }
    }

    @Override
    public void update(StudentDto studentDto, Integer id) throws PerficientServiceException {
        try {
            if (studentPersistence.findStudentById(id)!=null){
                studentPersistence.updateStudent(studentDto, id);
            }
        }catch (Exception e){
            throw new PerficientServiceException(e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) throws PerficientServiceException {
        try {
            if (studentPersistence.findStudentById(id)!=null){
                studentPersistence.deleteStudent(id);
            }

        }catch (Exception e){
            throw new PerficientServiceException(e.getMessage());
        }
    }
}
