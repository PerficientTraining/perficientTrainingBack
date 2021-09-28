package perficient.com.persistence.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import perficient.com.dto.StudentDto;
import perficient.com.model.Group;
import perficient.com.model.Student;
import perficient.com.persistence.IStudentPersistence;
import perficient.com.persistence.PerficientPersistenceException;
import perficient.com.persistence.repository.IStudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;
import javax.persistence.Query;


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
            Student student = studentRepository.findById(id).get();
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
    public Student authenticationStudent(String userName, String password) throws PerficientPersistenceException {
        try {
            Query query = entityManager.createNativeQuery("select * from student where userid=? AND password= ?",Student.class);
            query.setParameter(1, userName);
            query.setParameter(2, password);
            List<Student> listStudent = query.getResultList();
            System.out.println(listStudent.get(0).getId());
            if (listStudent.size()>0){
                return listStudent.get(0);
            }
                throw new PerficientPersistenceException("Student doesn't exist");

        }catch (Exception e){
            e.printStackTrace();
            throw new PerficientPersistenceException("Error");
        }
    }

    @Override
    public List<Group> groupsRegistered(int id) throws PerficientPersistenceException {
        try {
            Query query = entityManager
                    .createNativeQuery("select * from \"group\" g " +
                            "where id in (select distinct group_id " +
                                          "from group_studentsregister " +
                                          "where studentsregister_id  = ?)", Group.class);
            query.setParameter(1, id);
            return query.getResultList();
        }catch (Exception e){
            throw new PerficientPersistenceException("Student doesn't exist");
        }



    }


}
