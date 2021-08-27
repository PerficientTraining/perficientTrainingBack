package perficient.com.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import perficient.com.model.BaseEntity;

/**
 * Simple JavaBean domain object representing an StudentDto.
 *
 * @author brayan burgos
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder(toBuilder = true)
public class StudentDto implements Serializable {

    private int personalId;
    private String lastName;
    private String name;
    private String secondName;
    private String carreer;
    private Date bornDate;
    private String userId;
    private String password;
    private String mail;
    
}
