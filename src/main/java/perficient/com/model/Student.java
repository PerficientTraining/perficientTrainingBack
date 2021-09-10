package perficient.com.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import perficient.com.dto.StudentDto;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Student{
    
    @Id
    private int id;
    private int personalId;
    private String lastName;
    private String name;
    private String secondName;
    private String carreer;
    private Date bornDate;
    private String userId;
    private String password;
    private String mail;
    private Date createdAt; 

    public Student(StudentDto studentDto,  int uniqueId, Date created) {
        this.personalId = studentDto.getPersonalId();
        this.lastName = studentDto.getLastName();
        this.name = studentDto.getLastName();
        this.secondName = studentDto.getSecondName();
        this.carreer = studentDto.getCarreer();
        this.bornDate = studentDto.getBornDate();
        this.userId = studentDto.getUserId();
        this.password = studentDto.getPassword();
        this.mail = studentDto.getPassword();
        this.id = uniqueId;
        this.createdAt = created;
        
       

    
    }
    
     public void setStudentDto(StudentDto studentDto) {
        this.personalId = studentDto.getPersonalId();
        this.lastName = studentDto.getLastName();
        this.name = studentDto.getLastName();
        this.secondName = studentDto.getSecondName();
        this.carreer = studentDto.getCarreer();
        this.bornDate = studentDto.getBornDate();
        this.userId = studentDto.getUserId();
        this.password = studentDto.getPassword();
        this.mail = studentDto.getPassword();
    
    }
    
}
