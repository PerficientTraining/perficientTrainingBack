package perficient.com.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.annotations.One;
import perficient.com.dto.CourseDto;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "course", schema = "public")
public class Course implements Serializable {
    @Id
    @Column(name = "id")
    private int id;

    @NotEmpty @NotNull @Column(name = "namecourse")
    private String nameCourse;

    @NotEmpty @NotNull @Column(name = "heavy")
    private int heavy;

    @NotEmpty @NotNull @Column(name = "career")
    private String career;

    @NotEmpty @NotNull @Column(name = "createdAt")
    private Date createdAt;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Group> groups;

    public Course(CourseDto courseDto,int id, Date createdAt) {

        this.nameCourse = courseDto.getNameCourse();
        this.heavy = courseDto.getHeavy();
        this.career = courseDto.getCareer();
        this.groups = courseDto.getGroups();
        this.id = id;
        this.createdAt = createdAt;
    }

    public void setCourseDto(CourseDto courseDto){
        this.nameCourse = courseDto.getNameCourse();
        this.heavy = courseDto.getHeavy();
        this.career = courseDto.getCareer();
        this.groups = courseDto.getGroups();
    }
}
