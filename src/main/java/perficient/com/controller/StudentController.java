package perficient.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import perficient.com.dto.StudentDto;
import perficient.com.service.IStudentService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/students")
public class StudentController {

    @Autowired
    IStudentService studentService;

    @GetMapping()
    public ResponseEntity<?> all() {
        try {
            return new ResponseEntity<>(studentService.all(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping()
    public ResponseEntity<?> create(@RequestBody StudentDto studentDto) {
        try {
            studentService.create(studentDto);
            return new ResponseEntity<>("Student create.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("User not Created", HttpStatus.CONFLICT);

        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(studentService.findById(id), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("Student with id: " + id + " not found.", HttpStatus.NOT_FOUND);
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody StudentDto studentDto) {
        try {
            studentService.update(studentDto, id);
            return new ResponseEntity<>("Student " + studentDto.getUserId() + " update.", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("Student with id " + studentDto.getUserId() + " not found.", HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        try {
            studentService.findById(id);
            studentService.deleteById(id);
            return new ResponseEntity<>("Student with id " + id + " delete.", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("Student with id " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("authenticationStudent")
    public ResponseEntity<?> authenticationStudent(@RequestParam String userName, @RequestParam String password) {
        try {
            return new ResponseEntity<>(studentService.authenticationStudent(userName, password), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    @GetMapping("groupsRegistered")
    public ResponseEntity<?> groupsRegistered(@RequestParam int id) {
        try {
            return new ResponseEntity<>(studentService.groupsRegistered(id), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }



}
