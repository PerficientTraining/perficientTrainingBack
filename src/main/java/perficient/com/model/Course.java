package perficient.com.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import perficient.com.dto.CourseDto;
import perficient.com.dto.StudentDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "course", schema = "public")
public class Course implements Serializable {
    @Id
    @NotEmpty @NotNull @Column(name = "id")
    private int id;
    @NotEmpty @NotNull @Column(name = "namecourse")
    private String nameCourse;
    @NotEmpty @NotNull @Column(name = "heavy")
    private int heavy;
    @NotEmpty @NotNull @Column(name = "career")
    private int career;
    @NotEmpty @NotNull @Column(name = "teacher")
    private int teacher;
    @NotEmpty @NotNull @Column(name = "createdAt")
    private Date createdAt;

    public Course(CourseDto courseDto,int id, Date createdAt) {
        this.id = id;
        this.nameCourse = courseDto.getNameCourse();
        this.heavy = courseDto.getHeavy();
        this.career = courseDto.getCareer();
        this.teacher = courseDto.getTeacher();
        this.createdAt = createdAt;
    }

    public void setCourse(CourseDto courseDto){
        this.id = courseDto.getId();
        this.nameCourse = courseDto.getNameCourse();
        this.heavy = courseDto.getHeavy();
        this.career = courseDto.getCareer();
        this.teacher = courseDto.getTeacher();
        this.createdAt = courseDto.getCreatedAt();
    }
}
