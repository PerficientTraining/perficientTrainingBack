package perficient.com.persistence;

import perficient.com.dto.TeacherDto;
import perficient.com.model.Teacher;

import java.util.Collection;

public interface ITeacherPersistence {
    void createTeacher(Teacher teacher) throws PerficientPersistenceException;
    Collection<Teacher> getAllTeacher()throws PerficientPersistenceException;
    Teacher findTeacherById(int id) throws PerficientPersistenceException;
    void deleteTeacher(int id)throws PerficientPersistenceException;
    void updateTeacher(TeacherDto teacherDto, int id)throws PerficientPersistenceException;


}
