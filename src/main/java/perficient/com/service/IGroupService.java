package perficient.com.service;

import perficient.com.dto.GroupDto;
import perficient.com.dto.StudentDto;
import perficient.com.dto.TeacherDto;
import perficient.com.model.Group;

import java.util.Collection;

public interface IGroupService<T> {

    T create (GroupDto groupDto) throws PerficientServiceException;

    T findById (Integer id)  throws PerficientServiceException;

    Collection<T> all() throws PerficientServiceException;

    void deleteById (int id) throws PerficientServiceException;

    void update(GroupDto groupDto, Integer id) throws PerficientServiceException;

    void assignTeacherAndHours(int idGroup, int idTeacher, String hours) throws PerficientServiceException;

    void assingCourse(int idCourse, int idGroup) throws PerficientServiceException;
}
