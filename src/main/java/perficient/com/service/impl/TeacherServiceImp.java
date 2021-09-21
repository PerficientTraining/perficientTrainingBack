package perficient.com.service.impl;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perficient.com.dto.TeacherDto;
import perficient.com.model.Student;
import perficient.com.model.Teacher;
import perficient.com.persistence.ITeacherPersistence;
import perficient.com.service.ITeacherService;
import perficient.com.service.PerficientServiceException;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;


@NoArgsConstructor
@Service
public class TeacherServiceImp implements ITeacherService<Teacher> {

    @Autowired
    private ITeacherPersistence teacherPersistence;

    @Override
    public Teacher create(TeacherDto teacherDto) throws PerficientServiceException {
        try {
            int uniqueId = (int) UUID.randomUUID().hashCode();
            Teacher teacher = new Teacher(uniqueId, teacherDto, new Date());
            teacherPersistence.createTeacher(teacher);
            return teacher;
        } catch (Exception e) {
            throw new PerficientServiceException(e.getMessage());
        }
    }

    @Override
    public Teacher findById(Integer id) throws PerficientServiceException {
        try {
            return teacherPersistence.findTeacherById(id);
        } catch (Exception e) {
            throw new PerficientServiceException(e.getMessage());
        }

    }

    @Override
    public Collection<Teacher> all() throws PerficientServiceException {
        try {
            return (Collection) teacherPersistence.getAllTeacher();
        } catch (Exception e) {
            throw new PerficientServiceException(e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) throws PerficientServiceException {
        try {
            if (teacherPersistence.findTeacherById(id)!=null){
                teacherPersistence.deleteTeacher(id);
            }

        }catch (Exception e){
            throw new PerficientServiceException(e.getMessage());
        }
    }

    @Override
    public void update(TeacherDto teacherDto, Integer id) throws PerficientServiceException {
        try {
            if (teacherPersistence.findTeacherById(id) != null) {
                teacherPersistence.updateTeacher(teacherDto, id);
            }
        } catch (Exception e) {
            throw new PerficientServiceException(e.getMessage());
        }
    }
}
