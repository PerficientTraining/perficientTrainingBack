package perficient.com.service;

import perficient.com.dto.StudentDto;
import perficient.com.dto.TeacherDto;

import java.util.Collection;

public interface ITeacherService<T>{

    T create (TeacherDto teacherDto) throws PerficientServiceException;

    T findById (Integer id)  throws PerficientServiceException;

    Collection<T> all() throws PerficientServiceException;

    void deleteById (int id) throws PerficientServiceException;

    void update(TeacherDto teacherDto, Integer id) throws PerficientServiceException;
}
