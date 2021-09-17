package perficient.com.persistence.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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

    }

    @Override
    public Collection<Course> getAllCourse() throws PerficientPersistenceException {
        return null;
    }

    @Override
    public Student findCourseById(int id) throws PerficientPersistenceException {
        return null;
    }
}
