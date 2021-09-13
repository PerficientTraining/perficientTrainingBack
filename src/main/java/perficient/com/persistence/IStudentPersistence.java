package perficient.com.persistence;

import java.util.Collection;
import perficient.com.model.Student;

public interface IStudentPersistence  {
    
     void addStudent(Student student) throws PerficientPersistenceException;

    Collection<Student> getAllStudents()throws PerficientPersistenceException;

    Student getStudentByName(String nameStudent)throws PerficientPersistenceException;
    
    Student getStudentById(int id) throws PerficientPersistenceException;

    void saveStudent(Student student)throws PerficientPersistenceException;
    
}
