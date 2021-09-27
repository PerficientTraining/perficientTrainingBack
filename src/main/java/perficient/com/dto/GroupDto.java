package perficient.com.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import perficient.com.model.BaseEntity;
import perficient.com.model.Course;
import perficient.com.model.Teacher;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class GroupDto extends BaseEntity implements Serializable {
    private Teacher teacher;
    private Course course;
    private String hours;
    private int capacity;
}
