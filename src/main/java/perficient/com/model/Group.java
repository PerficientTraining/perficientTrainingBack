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

    @NotEmpty @NotNull @Column(name = "createdat")
    private Date createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    public Group(int id, GroupDto groupDto, Date createdAt) {
        this.id = id;
        this.hours = groupDto.getHours();
        this.createdAt = createdAt;
    }

    public void setGroups(GroupDto groupDto) {
        this.hours = groupDto.getHours();

    }
}
