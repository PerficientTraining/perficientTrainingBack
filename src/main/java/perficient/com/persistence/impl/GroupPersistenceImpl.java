package perficient.com.persistence.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import perficient.com.dto.GroupDto;
import perficient.com.dto.TeacherDto;
import perficient.com.model.Course;
import perficient.com.model.Group;
import perficient.com.model.Teacher;
import perficient.com.persistence.IGroupPersistence;
import perficient.com.persistence.PerficientPersistenceException;
import perficient.com.persistence.repository.ICourseRepository;
import perficient.com.persistence.repository.IGroupRepository;
import perficient.com.persistence.repository.ITeacherRepository;
import perficient.com.service.ICourseService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Repository
public class GroupPersistenceImpl implements IGroupPersistence {

    @Autowired
    IGroupRepository groupRepository;

    @Autowired
    ITeacherRepository teacherRepository;

    @Autowired
    ICourseRepository courseRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void createGroup(Group group) throws PerficientPersistenceException {
        try{
            groupRepository.save(group);
        }catch (Exception e) {
            throw new PerficientPersistenceException("Failed to created the Course.");
        }
    }

    @Override
    public Collection<Group> getAllGroups() throws PerficientPersistenceException {
        try{
            if(groupRepository.count()!=0){
                return groupRepository.findAll();
            }
        }catch (Exception e){
            throw new PerficientPersistenceException("Groups no found.");
        }
        return groupRepository.findAll();
    }

    @Override
    public Group findGroupById(int id) throws PerficientPersistenceException {
        try {
            Group group = groupRepository.findById(id).get();
            if (!group.equals(null)){
                return group;
            }
        }catch (Exception e){
            throw new PerficientPersistenceException("Student with id: "+ id +" no found.");
        }
        return new Group();
    }

    @Override
    public void deleteGroup(int id) throws PerficientPersistenceException {
        try {
            Group group = groupRepository.getById(id);
            if (!group.equals(null)){
                groupRepository.delete(group);
            }
        }catch (Exception e){
            throw new PerficientPersistenceException("Group with id: "+ id + "no delete");
        }
    }

    @Override
    public void updateGroup(GroupDto groupDto, int id) throws PerficientPersistenceException {
        try {
            Group group = groupRepository.getById(id);
            group.setGroups(groupDto);
            groupRepository.save(group);
        }catch (Exception e){
            throw new PerficientPersistenceException("Group with id: "+ id + "no update");
        }
    }

    @Override
    public void assignTeacherAndHours(int idGroup, int idTeacher, String hours) throws PerficientPersistenceException {
        try{
            Group group = groupRepository.getById(idGroup);
            Teacher teacher = teacherRepository.getById(idTeacher);
            if (!teacher.getHours().contains(hours)){
                teacher.setHours(teacher.getHours()+hours);
                teacherRepository.save(teacher);
                group.setHours(group.getHours()+hours);
                group.setTeacher(teacher);
                groupRepository.save(group);
            }
        }catch (Exception e){
            throw new PerficientPersistenceException("Group with id: "+ idGroup + "no update");
        }
    }

    @Override
    public void assignCourse(int idCourse, int idGroup) throws PerficientPersistenceException {
        try {
            Group group = groupRepository.getById(idGroup);
            Course course = courseRepository.getById(idCourse);
            group.setCourse(course);
            groupRepository.save(group);
        }catch (Exception e){
            throw new PerficientPersistenceException("Group with id: "+ idGroup + "no assing course with id: "+ idCourse);
        }
    }
}
