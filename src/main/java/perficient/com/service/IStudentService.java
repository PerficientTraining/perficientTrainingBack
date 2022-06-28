/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perficient.com.service;

import java.util.Collection;
import java.util.List;

import perficient.com.dto.StudentDto;
import perficient.com.model.Group;
import perficient.com.model.Student;

public interface IStudentService{
    Student create (StudentDto studentDto) throws PerficientServiceException;
    Student findById (Integer id)  throws PerficientServiceException;
    Collection <Student> all() throws PerficientServiceException;
    void deleteById (int id) throws PerficientServiceException;
    void update(StudentDto studentDto, Integer id) throws PerficientServiceException;
    Student authenticationStudent(String userName, String password) throws PerficientServiceException;
    List<Group> groupsRegistered(int id)throws PerficientServiceException;
}
