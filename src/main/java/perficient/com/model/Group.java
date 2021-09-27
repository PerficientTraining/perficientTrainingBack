package perficient.com.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import perficient.com.dto.GroupDto;
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
@Table(name = "group", schema = "public")
public class Group implements Serializable {
    @Id
    @Column(name = "id")
    private int id;

    @NotEmpty @NotNull
    @Column(name = "hours")
    private String hours;

    @NotEmpty @NotNull
    @Column(name = "capacity")
    private int capacity;

    @NotEmpty @NotNull @Column(name = "createdat")
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToMany
    private List<Student> studentsRegister;

    public Group(int id, GroupDto groupDto, Date createdAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.hours = groupDto.getHours();
        this.capacity = groupDto.getCapacity();
        this.course = groupDto.getCourse();

    }

    public void setGroups(GroupDto groupDto) {
        this.hours = groupDto.getHours();
        this.capacity = groupDto.getCapacity();

    }
}
