package perficient.com.service;

import perficient.com.dto.CourseDto;
import perficient.com.model.Student;

import java.util.Collection;
import java.util.Optional;

public interface ICourseService<T> {
    T create (CourseDto courseDto) throws PerficientServiceException;

    T findById (Integer id)  throws PerficientServiceException;

    Collection<T> all() throws PerficientServiceException;

    void deleteById (int id) throws PerficientServiceException;

    void update(CourseDto courseDto, Integer id) throws PerficientServiceException;

}
