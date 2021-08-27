package perficient.com.model;

import java.util.Date;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import perficient.com.dto.StudentDto;

@Entity
public class Student extends BaseEntity {

    private StudentDto studentDto;
    
    public Student() {
    }

    public Student(StudentDto studentDto) {
        this.studentDto = studentDto;
    }
    
    public StudentDto getStudentDto() {
        return studentDto;
    }

    public void setStudentDto(StudentDto studentDto) {
        this.studentDto = studentDto;
    }

    @Override
    public String toString() {
        return "Student{" + "studentDto=" + studentDto + '}';
    }
    

}
