package perficient.com.service;

import perficient.com.dto.GroupDto;

import java.util.Collection;

public interface IGroupService<T> {

    T create(GroupDto groupDto, int idCourse, int idTeacher) throws PerficientServiceException;

    T findById (Integer id)  throws PerficientServiceException;

    Collection<T> all() throws PerficientServiceException;

    void deleteById (int id) throws PerficientServiceException;

    void update(GroupDto groupDto, Integer id) throws PerficientServiceException;

    void assingStudents(int idStudent,int idGroup) throws PerficientServiceException;

    void unenrollmentStudents(int idStudent, int idGroup)  throws PerficientServiceException;

}
