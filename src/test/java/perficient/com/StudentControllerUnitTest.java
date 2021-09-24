package perficient.com;

import org.apache.coyote.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import perficient.com.controller.StudentController;
import perficient.com.dto.StudentDto;
import perficient.com.model.Student;
import perficient.com.persistence.PerficientPersistenceException;
import perficient.com.persistence.impl.StudentPersistenceImpl;
import perficient.com.service.IStudentService;
import perficient.com.service.PerficientServiceException;
import perficient.com.service.impl.StudentServiceImp;

import java.util.*;

import static org.mockito.Mockito.*;


class StudentPersistenceImplUnitTest {

    @Test
    void AllStudentisEmptyTest() throws PerficientPersistenceException {
        StudentPersistenceImpl studentPersistenceImpl = mock(StudentPersistenceImpl.class);
        Collection<Student> allStudents = studentPersistenceImpl.getAllStudents();
        Assert.assertEquals(allStudents,new ArrayList<>());
    }
    /*
    @Test
    void AllStudentIsNotEmptyTest() throws PerficientPersistenceException {
        StudentPersistenceImpl studentPersistenceImpl = mock(StudentPersistenceImpl.class);
        studentPersistenceImpl.createStudent(new Student());
        when(studentPersistenceImpl.createStudent(new Student())).thenReturn(new ArrayList<>());

    }
     */



}
