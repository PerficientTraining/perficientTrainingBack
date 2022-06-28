package perficient.com.controller;

import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import perficient.com.dto.StudentDto;
import perficient.com.model.Group;
import perficient.com.model.Student;
import perficient.com.service.IStudentService;
import perficient.com.service.PerficientServiceException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/students")
public class StudentController {

    @Autowired
    public IStudentService studentService;

    @GetMapping()
    public ResponseEntity<Collection <Student>> all() throws PerficientServiceException {
        return new ResponseEntity<>(studentService.all(), HttpStatus.ACCEPTED);
    }
    @PostMapping()
    public ResponseEntity<String> create(@RequestBody StudentDto studentDto) throws PerficientServiceException {
        studentService.create(studentDto);
        return new ResponseEntity<>("Student with personalId : " + studentDto.getPersonalId(), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable int id) throws PerficientServiceException {
        return new ResponseEntity<>(studentService.findById(id), HttpStatus.ACCEPTED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody StudentDto studentDto)
        throws PerficientServiceException {
        studentService.update(studentDto, id);
        return new ResponseEntity<>("Student " + studentDto.getUserId() + " update.", HttpStatus.ACCEPTED);


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) throws PerficientServiceException {
        studentService.findById(id);
        studentService.deleteById(id);
        return new ResponseEntity<>("Student with id " + id + " delete.", HttpStatus.ACCEPTED);
    }
    @PostMapping("authenticationStudent")
    public ResponseEntity<String> authenticationStudent(@RequestParam String userName, @RequestParam String password)
        throws PerficientServiceException {
        studentService.authenticationStudent(userName, password);
        return new ResponseEntity<>("Authentication Student with user name : "+userName+"and password : " + password,
            HttpStatus.OK);
    }

    @GetMapping("groupsRegistered")
    public ResponseEntity<List<Group>> groupsRegistered(@RequestParam int id) throws PerficientServiceException {
        return new ResponseEntity<>(studentService.groupsRegistered(id), HttpStatus.ACCEPTED);
    }
}
