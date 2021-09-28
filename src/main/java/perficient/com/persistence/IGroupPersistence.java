package perficient.com.persistence;

import perficient.com.dto.GroupDto;
import perficient.com.model.Group;

import java.util.Collection;

public interface IGroupPersistence {

    void createGroup(Group group, int idCourse, int idTeacher) throws PerficientPersistenceException;

    Collection<Group> getAllGroups()throws PerficientPersistenceException;

    Group findGroupById(int id) throws PerficientPersistenceException;

    void deleteGroup(int id)throws PerficientPersistenceException;

    void updateGroup(GroupDto groupDto, int id)throws PerficientPersistenceException;

    void assingStudents(int idStudent, int idGroup)throws PerficientPersistenceException;

    void unenrollmentStudents(int idStudent, int idGroup)throws PerficientPersistenceException;
}
