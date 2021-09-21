package perficient.com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import perficient.com.dto.TeacherDto;
import perficient.com.service.ITeacherService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/teacher")
public class TeacherController {

    @Autowired
    ITeacherService teacherService;

    @GetMapping()
    public ResponseEntity<?> all() {
        try {
            return new ResponseEntity<>(teacherService.all(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody TeacherDto teacherDto) {
        try {
            teacherService.create(teacherDto);
            return new ResponseEntity<>("Teacher create.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Teacher not Created", HttpStatus.CONFLICT);

        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(teacherService.findById(id), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("Teacher with id: " + id + " not found.", HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody TeacherDto teacherDto) {
        try {
            teacherService.update(teacherDto, id);
            return new ResponseEntity<>("Student " + id + " update.", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("Student with id " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        try {
            teacherService.findById(id);
            teacherService.deleteById(id);
            return new ResponseEntity<>("Teacher with id " + id + " delete.", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("Teacher with id " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }

}
