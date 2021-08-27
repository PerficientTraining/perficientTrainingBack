
package perficient.com.service;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
import org.springframework.stereotype.Service;
import perficient.com.dto.StudentDto;
import perficient.com.model.BaseEntity;
import perficient.com.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
    
    private HashMap <Integer, Student> students = new HashMap<>();

    @Override
    
    public Student create(StudentDto userDto) {
   
        Student createStudent = new Student(userDto);
        int uniqueId = (int) UUID.randomUUID().hashCode();
        createStudent.setId(uniqueId);
        Date date = createStudent.getCreatedAt();
        createStudent.insertStack(date);
        System.out.println(uniqueId);
        return students.put(uniqueId ,createStudent);
    }


    @Override
    public Collection<Student> all() {
       return students.values();
    }

    @Override
    public void deleteById(int id) {
        System.out.println(students);
        students.remove(id);
    }

    @Override
    public Student findById(Integer id) {
       return students.get(id);
    }

    @Override
    public void update(StudentDto userDto, Integer id) {
        Student student = students.get(id);
        student.setStudentDto(userDto);
        student.insertStack(new Date());
        students.replace(id, student);


    }

}
