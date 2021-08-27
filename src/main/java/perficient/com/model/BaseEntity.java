package perficient.com.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Stack;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    
    private Stack<Date> updateStack = new Stack();
    private Date createdAt = new Date();

    public Stack getUpdateStack() {
        return updateStack;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isNew() {
        return this.id == null;
    }
    
    public void insertStack (Date date){
        updateStack.add(date);
    }

    public void setUpdateStack(Stack<Date> updateStack) {
        this.updateStack = updateStack;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    
}
