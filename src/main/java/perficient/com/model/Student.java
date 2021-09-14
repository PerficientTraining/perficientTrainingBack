package perficient.com.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import perficient.com.dto.StudentDto;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "student", schema = "public")
public class Student implements Serializable {
    
    @Id
    @Column(name = "id")
    private int id;
    @NotEmpty
    @Column(name = "personalid")
    private int personalId;
    @NotEmpty
    @Column(name = "lastname")
    private String lastName;
    @NotEmpty
    @Column(name = "firstname")
    private String firstName;
    @NotEmpty
    @Column(name = "secondname")
    private String secondName;
    @NotEmpty
    @Column(name = "career")
    private String career;
    @NotEmpty
    @Column(name = "borndate")
    private Date bornDate;
    @NotEmpty
    @Column(name = "userid")
    private String userId;
    @NotEmpty
    @Column(name = "password")
    private String password;
    @NotEmpty
    @Column(name = "mail")
    private String mail;
    @NotEmpty
    @Column(name = "createdat")
    private Date createdAt; 

    public Student(StudentDto studentDto,  int uniqueId, Date created) {
        this.personalId = studentDto.getPersonalId();
        this.lastName = studentDto.getLastName();
        this.firstName = studentDto.getLastName();
        this.secondName = studentDto.getSecondName();
        this.career = studentDto.getCareer();
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
        this.firstName = studentDto.getLastName();
        this.secondName = studentDto.getSecondName();
        this.career = studentDto.getCareer();
        this.bornDate = studentDto.getBornDate();
        this.userId = studentDto.getUserId();
        this.password = studentDto.getPassword();
        this.mail = studentDto.getPassword();
    }
}
