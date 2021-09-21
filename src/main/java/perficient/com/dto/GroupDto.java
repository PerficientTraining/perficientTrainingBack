package perficient.com.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import perficient.com.model.BaseEntity;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class GroupDto extends BaseEntity implements Serializable {

    private int idTeacher;
    private int idCourse;
    private String hours;
}
