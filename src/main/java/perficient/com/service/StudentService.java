/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perficient.com.service;

import java.util.Collection;
import perficient.com.dto.StudentDto;
import perficient.com.model.BaseEntity;
import perficient.com.model.Student;

/**
 *
 * @author brayan.burgosd
 */
public interface StudentService {
    
    Student create (StudentDto userDto);
    
    Student findById (Integer id);
    
    Collection <Student> all();
    
    void deleteById (int id);
   
    void update(StudentDto userDto, Integer id);

}
