package perficient.com.persistence;

import perficient.com.dto.GroupDto;
import perficient.com.model.Group;

import java.util.Collection;

public interface IGroupPersistence {

    void createGroup(Group group) throws PerficientPersistenceException;

    Collection<Group> getAllGroups()throws PerficientPersistenceException;

    Group findGroupById(int id) throws PerficientPersistenceException;

    void deleteGroup(int id)throws PerficientPersistenceException;

    void updateGroup(GroupDto groupDto, int id)throws PerficientPersistenceException;

}
