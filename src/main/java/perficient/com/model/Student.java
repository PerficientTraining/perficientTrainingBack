package perficient.com.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
  @NotNull
  @Column(name = "personalid")
  private int personalId;
  @NotEmpty
  @NotNull
  @Column(name = "lastname")
  private String lastName;
  @NotEmpty
  @NotNull
  @Column(name = "firstname")
  private String firstName;
  @NotEmpty
  @NotNull
  @Column(name = "secondname")
  private String secondName;
  @NotEmpty
  @NotNull
  @Column(name = "career")
  private String career;
  @NotEmpty
  @NotNull
  @Column(name = "borndate")
  private Date bornDate;
  @NotEmpty
  @NotNull
  @Column(name = "userid")
  private String userId;
  @NotEmpty
  @NotNull
  @Column(name = "password")
  private String password;
  @NotEmpty
  @NotNull
  @Column(name = "mail")
  private String mail;
  @NotEmpty
  @NotNull
  @Column(name = "createdat")
  private Date createdAt;

  public Student(StudentDto studentDto, int uniqueId, Date created) {
    this.personalId = studentDto.getPersonalId();
    this.lastName = studentDto.getLastName();
    this.firstName = studentDto.getFirstName();
    this.secondName = studentDto.getSecondName();
    this.career = studentDto.getCareer();
    this.bornDate = studentDto.getBornDate();
    this.userId = studentDto.getUserId();
    this.password = studentDto.getPassword();
    this.mail = studentDto.getMail();
    this.id = uniqueId;
    this.createdAt = created;
  }

  public void setStudentDto(StudentDto studentDto) {
    this.personalId = studentDto.getPersonalId();
    this.lastName = studentDto.getLastName();
    this.firstName = studentDto.getFirstName();
    this.secondName = studentDto.getSecondName();
    this.career = studentDto.getCareer();
    this.bornDate = studentDto.getBornDate();
    this.userId = studentDto.getUserId();
    this.password = studentDto.getPassword();
    this.mail = studentDto.getMail();
  }
}
