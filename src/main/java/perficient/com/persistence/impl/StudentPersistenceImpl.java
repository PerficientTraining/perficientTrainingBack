package perficient.com.persistence.impl;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import perficient.com.model.Student;

import java.util.Collection;
import javax.activation.DataSource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import perficient.com.persistence.IStudentPersistence;
import perficient.com.persistence.PerficientPersistenceException;

@Repository
@NoArgsConstructor
public class StudentPersistenceImpl implements IStudentPersistence{
    
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    @Autowired
    public void setDataSourve(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate((javax.sql.DataSource) dataSource);
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate((javax.sql.DataSource) dataSource);
    }
    
    @Autowired 
    IStudentPersistence studentRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addStudent(Student student) throws PerficientPersistenceException {
        try {
            StringBuilder sql = new StringBuilder(100);
            sql.append("INSERT INTO public.student");
            sql.append(" VALUES (:id,:personalid");
        } catch (Exception e) {
            throw new PerficientPersistenceException("Failed to create Student");
        }
    }
    @Override
    public Collection<Student> getAllStudents() throws PerficientPersistenceException {
        try {
            return studentRepository.getAllStudents();
        } catch (Exception e) {
            throw new PerficientPersistenceException("Users No Found");
        }
    }

    @Override
    public void saveStudent(Student student) throws PerficientPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Student getStudentByName(String nameStudent) throws PerficientPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Student getStudentById(int id) throws PerficientPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
