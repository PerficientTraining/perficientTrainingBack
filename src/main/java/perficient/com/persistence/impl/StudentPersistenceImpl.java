package perficient.com.persistence.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import perficient.com.dto.StudentDto;
import perficient.com.model.Student;
import perficient.com.persistence.IStudentPersistence;
import perficient.com.persistence.PerficientPersistenceException;
import perficient.com.persistence.repository.IStudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@NoArgsConstructor
@AllArgsConstructor
@Repository
public class StudentPersistenceImpl implements IStudentPersistence {

    @Autowired
    IStudentRepository studentRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void createStudent(Student student) throws PerficientPersistenceException {
        try{
            studentRepository.save(student);
        }catch (Exception e) {
            throw new PerficientPersistenceException("Failed to created the Student.");
        }
    }

    @Override
    public Collection<Student> getAllStudents() throws PerficientPersistenceException {
        try{
            if(studentRepository.count()!=0){
                return studentRepository.findAll();
            }
        }catch (Exception e){
            throw new PerficientPersistenceException("Students no found.");
        }
        return studentRepository.findAll();
    }
    @Override
    public Student findStudentById(int id) throws PerficientPersistenceException {
        try {
            Student student = studentRepository.getById(id);
            if (!student.equals(null)){
                return student;
            }

        }catch (Exception e){
            throw new PerficientPersistenceException("Student with id: "+ id +" no found.");
        }
        return new Student();
    }
    @Override
    public void deleteStudent(int id) throws PerficientPersistenceException {
        try {
            Student student = studentRepository.getById(id);
            if (!student.equals(null)){
                studentRepository.delete(student);
            }
        }catch (Exception e){
            throw new PerficientPersistenceException("Student with id: "+ id + "no delete");

        }

    }
    @Override
    public void updateStudent(StudentDto studentDto, int id) throws PerficientPersistenceException {
        try {
            Student student = studentRepository.getById(id);
            student.setStudentDto(studentDto);
            studentRepository.save(student);
        }catch (Exception e){
            throw new PerficientPersistenceException("Student with id: "+ id + "no update");
        }
    }
    @Override
    public boolean userIsUnique(String user) throws PerficientPersistenceException {
        try{
            List<Student> listStudent = studentRepository.findAll();
            List<Student> filterUserNames = listStudent
                    .stream()
                    .filter(student -> student.getUserId() == user)
                    .limit(1).collect(Collectors.toList());
            if (filterUserNames.isEmpty()) return true;

        }
        catch (Exception e){
            throw new PerficientPersistenceException("Student with Name: "+ user + "no available");
        }
        return false;
    }
    public boolean mailIsUnique(String mail) throws PerficientPersistenceException {
        try{
            List<Student> listStudent = studentRepository.findAll();
            List<Student> filterUserNames = listStudent.stream()
                    .filter(student -> student.getMail() == mail)
                    .limit(2).collect(Collectors.toList());
            System.out.println(filterUserNames.get(0).toString());
            if (filterUserNames.isEmpty()){
                return true;
            }
        }
        catch (Exception e){
            throw new PerficientPersistenceException("Mail "+ mail + "no available");
        }
        return false;
    }
}
