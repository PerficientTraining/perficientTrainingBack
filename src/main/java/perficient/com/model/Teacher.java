package perficient.com.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import perficient.com.dto.TeacherDto;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "teacher", schema = "public")
public class Teacher implements Serializable {
    @Id
    @Column(name = "id")
    private int id;
    @NotEmpty
    @NotNull
    @Column(name = "personalid")
    private int personalId;
    @NotEmpty @NotNull @Column(name = "lastname")
    private String lastName;
    @NotEmpty @NotNull @Column(name = "firstname")
    private String firstName;
    @NotEmpty @NotNull @Column(name = "secondname")
    private String secondName;
    @NotEmpty @NotNull @Column(name = "career")
    private String career;
    @NotEmpty @NotNull @Column(name = "mail")
    private String mail;
    @NotEmpty @NotNull @Column(name = "createdat")
    private Date createdAt;
    @NotEmpty @NotNull @Column(name = "hours")
    private String hours;

    public Teacher(int id, TeacherDto teacherDto, Date createdAt) {
        this.personalId = teacherDto.getPersonalId();
        this.lastName = teacherDto.getLastName();
        this.firstName = teacherDto.getFirstName();
        this.secondName = teacherDto.getSecondName();
        this.career = teacherDto.getCareer();
        this.mail = teacherDto.getMail();
        this.id = id;
        this.createdAt = createdAt;
        this.hours = teacherDto.getHours();
    }

    public void setTeacherDto(TeacherDto teacherDto) {
        this.personalId = teacherDto.getPersonalId();
        this.lastName = teacherDto.getLastName();
        this.firstName = teacherDto.getFirstName();
        this.secondName = teacherDto.getSecondName();
        this.career = teacherDto.getCareer();
        this.mail = teacherDto.getMail();
        this.hours = teacherDto.getHours();
    }
}
