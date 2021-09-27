package perficient.com.service.impl;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perficient.com.dto.GroupDto;
import perficient.com.dto.TeacherDto;
import perficient.com.model.Group;
import perficient.com.persistence.IGroupPersistence;
import perficient.com.service.IGroupService;
import perficient.com.service.PerficientServiceException;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@Service
public class GroupServiceImp implements IGroupService<Group> {

    @Autowired
    private IGroupPersistence groupPersistence;
    
    @Override
    public Group create(GroupDto groupDto) throws PerficientServiceException {
        try {
            int uniqueId = (int) UUID.randomUUID().hashCode();
            Group group = new Group(uniqueId, groupDto, new Date());
            groupPersistence.createGroup(group);
            return group;
        } catch (Exception e) {
            throw new PerficientServiceException(e.getMessage());
        }
    }

    @Override
    public Group findById(Integer id) throws PerficientServiceException {
        try {
            return groupPersistence.findGroupById(id);
        } catch (Exception e) {
            throw new PerficientServiceException(e.getMessage());
        }

    }

    @Override
    public Collection<Group> all() throws PerficientServiceException {
        try {
            return (Collection) groupPersistence.getAllGroups();
        } catch (Exception e) {
            throw new PerficientServiceException(e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) throws PerficientServiceException {
        try {
            if (groupPersistence.findGroupById(id)!=null){
                groupPersistence.deleteGroup(id);
            }

        }catch (Exception e){
            throw new PerficientServiceException(e.getMessage());
        }
    }

    @Override
    public void update(GroupDto groupDto, Integer id) throws PerficientServiceException {
        try {
            if (groupPersistence.findGroupById(id) != null) {
                groupPersistence.updateGroup(groupDto, id);
            }
        } catch (Exception e) {
            throw new PerficientServiceException(e.getMessage());
        }
    }

    @Override
    public void assignTeacherAndHours(int idGroup, int idTeacher, String hours) throws PerficientServiceException{
        try {
            groupPersistence.assignTeacherAndHours(idGroup, idTeacher, hours);
        } catch (Exception e) {
            throw new PerficientServiceException(e.getMessage());
        }
    }

    @Override
    public void assingCourse(int idCourse, int idGroup) throws PerficientServiceException {
        try {
            groupPersistence.assignCourse(idCourse, idGroup);
        } catch (Exception e) {
            throw new PerficientServiceException(e.getMessage());
        }
    }

}

