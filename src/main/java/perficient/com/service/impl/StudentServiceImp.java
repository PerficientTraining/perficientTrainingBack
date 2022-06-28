package perficient.com.service.impl;

import lombok.AllArgsConstructor;
import perficient.com.model.Group;
import perficient.com.persistence.IStudentPersistence;
import perficient.com.service.PerficientServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perficient.com.dto.StudentDto;
import perficient.com.model.Student;
import perficient.com.service.IStudentService;

import java.util.*;

import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Service
public class StudentServiceImp implements IStudentService{

    @Autowired
    private IStudentPersistence studentPersistence;

    @Override
    public Student create(StudentDto studentDto) throws PerficientServiceException {
        try {
            int uniqueId = UUID.randomUUID().hashCode();
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
    public Collection<Student> all() throws PerficientServiceException {
        try {
            return studentPersistence.getAllStudents();
        } catch (Exception e) {
            throw new PerficientServiceException(e.getMessage());
        }
    }

    @Override
    public void update(StudentDto studentDto, Integer id) throws PerficientServiceException {
        try {
            if (studentPersistence.findStudentById(id) != null) {
                studentPersistence.updateStudent(studentDto, id);
            }
        } catch (Exception e) {
            throw new PerficientServiceException(e.getMessage());
        }
    }

    @Override
    public Student authenticationStudent(String userName, String password) throws PerficientServiceException {
        try {
            return studentPersistence.authenticationStudent(userName, password);
        } catch (Exception e) {
            throw new PerficientServiceException(e.getMessage());
        }
    }

    @Override
    public List<Group> groupsRegistered(int id) throws PerficientServiceException {
        try{
            return studentPersistence.groupsRegistered(id);
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
