package perficient.com.persistence.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import perficient.com.dto.CourseDto;
import perficient.com.model.Course;
import perficient.com.model.Student;
import perficient.com.persistence.ICoursePersistence;
import perficient.com.persistence.IStudentPersistence;
import perficient.com.persistence.PerficientPersistenceException;
import perficient.com.persistence.repository.ICourseRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Repository
public class CoursePersistenceImpl implements ICoursePersistence {

    @Autowired
    ICourseRepository courseRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void createCourse(Course course) throws PerficientPersistenceException {
        try{
            courseRepository.save(course);
        }catch (Exception e) {
            throw new PerficientPersistenceException("Failed to created the Course.");
        }
    }
    @Override
    public Collection<Course> getAllCourse() throws PerficientPersistenceException {
        try{
            if(courseRepository.count()!=0){
                return courseRepository.findAll();
            }
        }catch (Exception e){
            throw new PerficientPersistenceException("Course no found.");
        }
        return courseRepository.findAll();
    }

    @Override
    public Course findCourseById(int id) throws PerficientPersistenceException {
        try {
            Course course = courseRepository.getById(id);
            if (!course.equals(null)){
                return course;
            }

        }catch (Exception e){
            throw new PerficientPersistenceException("Course with id: "+ id +" no found.");
        }
        return new Course();
    }

    @Override
    public void deleteCourse(int id) throws PerficientPersistenceException {
        try {
            Course course = courseRepository.getById(id);
            if (!course.equals(null)){
                courseRepository.delete(course);
            }
        }catch (Exception e){
            throw new PerficientPersistenceException("Course with id: "+ id + "no delete");

        }

    }

    @Override
    public void updateCourse(CourseDto courseDto, int id) throws PerficientPersistenceException {
        try {
            Course course = courseRepository.getById(id);
            course.setCourseDto(courseDto);
            courseRepository.save(course);
        }catch (Exception e){
            throw new PerficientPersistenceException("Course with id: "+ id + "no update");
        }
    }
}
