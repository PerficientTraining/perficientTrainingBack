package perficient.com.dto;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import perficient.com.model.BaseEntity;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class CourseDto extends BaseEntity implements Serializable {

    private String nameCourse;
    private int heavy;
    private int career;
    private int teacher;
}
