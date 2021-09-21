package perficient.com.persistence.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import perficient.com.dto.GroupDto;
import perficient.com.model.Group;
import perficient.com.persistence.IGroupPersistence;
import perficient.com.persistence.PerficientPersistenceException;
import perficient.com.persistence.repository.IGroupRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Repository
public class GroupPersistenceImpl implements IGroupPersistence {

    @Autowired
    IGroupRepository groupRepository;

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
            Group group = groupRepository.getById(id);
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
}
