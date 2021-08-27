package perficient.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import perficient.com.dto.StudentDto;
import perficient.com.model.Student;
import perficient.com.service.StudentService;

@RestController
@RequestMapping("/v1/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping()
    public ResponseEntity<?> all() {
        try {
            return new ResponseEntity<>(studentService.all(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(studentService.all(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody StudentDto studentDto) {
        try {
            studentService.create(studentDto);
            return new ResponseEntity<>("Student " + studentDto.getName() + " create", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);

        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        try {
            Student student = studentService.findById(id);
            return new ResponseEntity<>(studentService.findById(id), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody StudentDto studentDto) {
        try {
            studentService.update(studentDto, id);
            return new ResponseEntity<>("Student " + studentDto.getName() + " update", HttpStatus.CONTINUE);
        } catch (Exception e) {
            return (ResponseEntity<String>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> DeleteById(@PathVariable int id) {
        try {
            Student student = studentService.findById(id);
            studentService.deleteById(id);
            return new ResponseEntity<>("Student with id" + id + " delete", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return (ResponseEntity<String>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }

    }

}