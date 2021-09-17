package perficient.com.persistence;

import perficient.com.dto.CourseDto;
import perficient.com.dto.StudentDto;
import perficient.com.model.Course;
import perficient.com.model.Student;

import java.util.Collection;
import java.util.Optional;

public interface ICoursePersistence {

    void createCourse(Course course) throws PerficientPersistenceException;

    Collection<Course> getAllCourse()throws PerficientPersistenceException;

    Student findCourseById(int id) throws PerficientPersistenceException;

}
