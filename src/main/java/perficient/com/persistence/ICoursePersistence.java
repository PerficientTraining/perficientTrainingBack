package perficient.com.persistence;

import perficient.com.dto.CourseDto;
import perficient.com.model.Course;
import java.util.Collection;


public interface ICoursePersistence {

    void createCourse(Course course) throws PerficientPersistenceException;

    Collection<Course> getAllCourse()throws PerficientPersistenceException;

    Course findCourseById(int id) throws PerficientPersistenceException;

    void deleteCourse(int id)throws PerficientPersistenceException;

    void updateCourse(CourseDto courseDto, int id)throws PerficientPersistenceException;

}
