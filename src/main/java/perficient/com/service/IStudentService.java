/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perficient.com.service;

import java.util.Collection;
import perficient.com.dto.StudentDto;

public interface IStudentService<T> {
    
    T create (StudentDto studentDto) throws PerficientServiceException;
    
    T findById (Integer id)  throws PerficientServiceException;
    
    Collection <T> all() throws PerficientServiceException;
    
    void deleteById (int id) throws PerficientServiceException;
   
    void update(StudentDto studentDto, Integer id) throws PerficientServiceException;

}
