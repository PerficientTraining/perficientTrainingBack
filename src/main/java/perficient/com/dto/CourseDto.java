package perficient.com.dto;

import com.fasterxml.jackson.databind.ser.Serializers;
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
public class CourseDto extends BaseEntity implements Serializable {

    private String courseName;
    private int heavy;
    private String career;
}
