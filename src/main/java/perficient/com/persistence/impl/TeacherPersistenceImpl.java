package perficient.com.persistence.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import perficient.com.dto.TeacherDto;
import perficient.com.model.Student;
import perficient.com.model.Teacher;
import perficient.com.persistence.ITeacherPersistence;
import perficient.com.persistence.PerficientPersistenceException;
import perficient.com.persistence.repository.ITeacherRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Repository
public class TeacherPersistenceImpl implements ITeacherPersistence {

    @Autowired
    ITeacherRepository teacherRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void createTeacher(Teacher teacher) throws PerficientPersistenceException {
        try{
            teacherRepository.save(teacher);
        }catch (Exception e) {
            throw new PerficientPersistenceException("Failed to created the Teacher.");
        }
    }

    @Override
    public Collection<Teacher> getAllTeacher() throws PerficientPersistenceException {
        try{
            if(teacherRepository.count()!=0){
                return teacherRepository.findAll();
            }
        }catch (Exception e){
            throw new PerficientPersistenceException("Teachers no found.");
        }
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findTeacherById(int id) throws PerficientPersistenceException {
        try {
            Teacher teacher = teacherRepository.findById(id).get();
            if (!teacher.equals(null)){
                return teacher;
            }

        }catch (Exception e){
            throw new PerficientPersistenceException("Student with id: "+ id +" no found.");
        }
        return new Teacher();
    }

    @Override
    public void deleteTeacher(int id) throws PerficientPersistenceException {
        try {
            Teacher teacher = teacherRepository.getById(id);
            if (!teacher.equals(null)){
                teacherRepository.delete(teacher);
            }
        }catch (Exception e){
            throw new PerficientPersistenceException("Teacher with id: "+ id + "no delete");

        }
    }

    @Override
    public void updateTeacher(TeacherDto teacherDto, int id) throws PerficientPersistenceException {
        try {
            Teacher teacher = teacherRepository.getById(id);
            teacher.setTeacherDto(teacherDto);
            teacherRepository.save(teacher);
        }catch (Exception e){
            throw new PerficientPersistenceException("Teacher with id: "+ id + "no update");
        }
    }
}
