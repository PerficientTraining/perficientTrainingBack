package perficient.com.persistence.impl;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import perficient.com.model.Student;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.Query;
import perficient.com.persistence.IStudentPersistence;
import perficient.com.persistence.repository.IStudentRepository;
import perficient.com.persistence.PerficientPersistenceException;

@Repository
@NoArgsConstructor
public class StudentPersistenceImpl implements IStudentPersistence{
    
    @Autowired 
    IStudentRepository studentRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addStudent(Student student) throws PerficientPersistenceException {
        try {
            studentRepository.save(student);
        } catch (Exception e) {
            throw new PerficientPersistenceException("Failed to create Student");
        }
    }
    @Override
    public Collection<Student> getAllStudents() throws PerficientPersistenceException {
        try {
            if (studentRepository.count()>0)
            return studentRepository.findAll();
        } catch (Exception e) {
            throw new PerficientPersistenceException("Users No Found");
        }
        return studentRepository.findAll();
    }

    @Override
    public void saveStudent(Student student) throws PerficientPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Student getStudentByName(String nameStudent) throws PerficientPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Student getStudentById(int id) throws PerficientPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
