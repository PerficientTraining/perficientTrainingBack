package perficient.com.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import perficient.com.model.BaseEntity;

@NoArgsConstructor
@Getter
@Setter
public class StudentDto extends BaseEntity implements Serializable {

    private int personalId;
    private String lastName;
    private String firstName;
    private String secondName;
    private String career;
    private Date bornDate;
    private String userId;
    private String password;
    private String mail;
    
}
