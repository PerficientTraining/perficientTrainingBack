/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perficient.com.service;

import java.util.Collection;
import perficient.com.dto.StudentDto;
import perficient.com.model.Student;


public interface StudentService<T> {
    
    T create (StudentDto studentDto) throws Exception;
    
    T findById (Integer id)  throws Exception;
    
    Collection <T> all() throws Exception;
    
    void deleteById (int id) throws Exception;
   
    void update(StudentDto studentDto, Integer id) throws Exception;

}
