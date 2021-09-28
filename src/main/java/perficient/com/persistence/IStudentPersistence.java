package perficient.com.persistence;

import java.util.Collection;
import java.util.List;

import perficient.com.dto.StudentDto;
import perficient.com.model.Group;
import perficient.com.model.Student;

public interface IStudentPersistence  {
    
    void createStudent(Student student) throws PerficientPersistenceException;

    Collection<Student> getAllStudents()throws PerficientPersistenceException;
    
    Student findStudentById(int id) throws PerficientPersistenceException;

    void deleteStudent(int id)throws PerficientPersistenceException;

    void updateStudent(StudentDto studentDto, int id)throws PerficientPersistenceException;

    Student authenticationStudent(String userName, String password) throws PerficientPersistenceException;

    List<Group> groupsRegistered(int id)throws PerficientPersistenceException;
}
