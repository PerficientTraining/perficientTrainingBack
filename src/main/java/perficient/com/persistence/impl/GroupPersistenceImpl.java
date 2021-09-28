package perficient.com.persistence.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import perficient.com.dto.GroupDto;
import perficient.com.model.Course;
import perficient.com.model.Group;
import perficient.com.model.Student;
import perficient.com.model.Teacher;
import perficient.com.persistence.IGroupPersistence;
import perficient.com.persistence.IStudentPersistence;
import perficient.com.persistence.PerficientPersistenceException;
import perficient.com.persistence.repository.ICourseRepository;
import perficient.com.persistence.repository.IGroupRepository;
import perficient.com.persistence.repository.IStudentRepository;
import perficient.com.persistence.repository.ITeacherRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Stream;

@NoArgsConstructor
@AllArgsConstructor
@Repository
public class GroupPersistenceImpl implements IGroupPersistence {

    @Autowired
    IStudentPersistence studentPersistence;

    @Autowired
    IGroupRepository groupRepository;

    @Autowired
    ITeacherRepository teacherRepository;

    @Autowired
    ICourseRepository courseRepository;

    @Autowired
    IStudentRepository studentRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void createGroup(Group group, int idCourse, int idTeacher) throws PerficientPersistenceException {
        try{
            group = assignTeacher(group, idTeacher);
            group = assignCourse(group, idCourse);
            groupRepository.save(group);
            Teacher teacher = group.getTeacher();
            teacherRepository.save(teacher);
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

    private Group assignTeacher(Group group, int idTeacher) throws PerficientPersistenceException {
        try{
            Teacher teacher = teacherRepository.getById(idTeacher);
            List<String> groupHours= Arrays.asList(group.getHours().split(";"));
            if (!groupHours.stream().anyMatch((groupH) -> teacher.getHours().contains(groupH))){
                teacher.setHours(teacher.getHours()+group.getHours());
                group.setHours(group.getHours());
                group.setTeacher(teacher);
                return group;
            }
            throw new PerficientPersistenceException("Group with id: "+ group.getId() + "no update");
        }catch (Exception e){
            throw new PerficientPersistenceException("Group with id: "+ group.getId() + "no update");
        }
    }

    private Group assignCourse(Group group, int idCourse) throws PerficientPersistenceException {
        try {
            Course course = courseRepository.getById(idCourse);
            group.setCourse(course);
            return group;
        }catch (Exception e){
            throw new PerficientPersistenceException("Group with id: "+ group.getId() + "no assing course with id: "+ idCourse);
        }
    }

    @Override
    public void assingStudents(int idStudent, int idGroup) throws PerficientPersistenceException {
        try{
            Group group = groupRepository.getById(idGroup);
            List<String> groupHours = Arrays.asList(group.getHours().split(";"));
            List<Group> groups = studentPersistence.groupsRegistered(idStudent);
            Stream<String> hoursGroupsList = groups.stream().map((currentG) -> currentG.getHours());
            if(!hoursGroupsList.anyMatch((currentH)
                    -> groupHours.stream().anyMatch((currentGH)
                    -> currentH.contains(currentGH)))) {
                    Student student = studentRepository.getById(idStudent);
                    Set<Student> studentsRegister = group.getStudentsRegister();
                    studentsRegister.add(student);
                    group.setStudentsRegister(studentsRegister);
                    groupRepository.save(group);
            }else {
                throw new PerficientPersistenceException("Cruce de horarios");
            }
        }catch (Exception e){
            throw new PerficientPersistenceException("Student with id: "+ idStudent + "no assing group with id: "+ idGroup);
        }
    }

    @Override
    @Transactional
    public void unenrollmentStudents(int idStudent, int idGroup) throws PerficientPersistenceException {
        try {
            Query query = entityManager.createNativeQuery("delete from group_studentsregister where group_id=? AND studentsregister_id=?");
            query.setParameter(1, idGroup);
            query.setParameter(2, idStudent);
            query.executeUpdate();
        }catch (Exception e){


            throw new PerficientPersistenceException("student and group doesn't have a relation");
        }
    }
}
