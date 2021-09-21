package perficient.com.service;

import perficient.com.dto.GroupDto;
import perficient.com.dto.StudentDto;

import java.util.Collection;

public interface IGroupService<T> {

    T create (GroupDto groupDto) throws PerficientServiceException;

    T findById (Integer id)  throws PerficientServiceException;

    Collection<T> all() throws PerficientServiceException;

    void deleteById (int id) throws PerficientServiceException;

    void update(GroupDto groupDto, Integer id) throws PerficientServiceException;
}
