package perficient.com.service.impl;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perficient.com.dto.CourseDto;
import perficient.com.model.Course;
import perficient.com.persistence.ICoursePersistence;
import perficient.com.service.ICourseService;
import perficient.com.service.PerficientServiceException;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@Service
public class CourseServiceImp implements ICourseService {

    @Autowired
    private ICoursePersistence coursePersistence;

    @Override
    public Course create(CourseDto courseDto) throws PerficientServiceException {
        try {
            int uniqueId = (int) UUID.randomUUID().hashCode();
            Course course = new Course(courseDto, uniqueId, new Date());
            coursePersistence.createCourse(course);
            return course;
        } catch (Exception e) {
            throw new PerficientServiceException(e.getMessage());
        }
    }

    @Override
    public Course findById(Integer id) throws PerficientServiceException {
        try {
            return coursePersistence.findCourseById(id);
        } catch (Exception e) {
            throw new PerficientServiceException(e.getMessage());
        }
    }

    @Override
    public Collection all() throws PerficientServiceException {
        try {
            return (Collection) coursePersistence.getAllCourse();
        } catch (Exception e) {
            throw new PerficientServiceException(e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) throws PerficientServiceException {
        try {
            if (coursePersistence.findCourseById(id)!=null){
                coursePersistence.deleteCourse(id);
            }
        }catch (Exception e){
            throw new PerficientServiceException(e.getMessage());
        }
    }

    @Override
    public void update(CourseDto courseDto, Integer id) throws PerficientServiceException {
        try {
            if (coursePersistence.findCourseById(id)!=null){
                coursePersistence.updateCourse(courseDto, id);
            }
        }catch (Exception e){
            throw new PerficientServiceException(e.getMessage());
        }
    }
}
