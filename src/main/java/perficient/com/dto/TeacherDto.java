package perficient.com.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import perficient.com.model.BaseEntity;
import perficient.com.model.Group;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class TeacherDto extends BaseEntity implements Serializable {
    private int personalId;
    private String lastName;
    private String firstName;
    private String secondName;
    private String career;
    private String mail;
    private String hours;
}
