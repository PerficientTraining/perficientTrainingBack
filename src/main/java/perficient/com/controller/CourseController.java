package perficient.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import perficient.com.dto.CourseDto;
import perficient.com.service.ICourseService;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/course")
public class CourseController {

    @Autowired
    ICourseService courseService;

    @GetMapping()
    public ResponseEntity<?> all() {
        try {
            return new ResponseEntity<>(courseService.all(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody CourseDto courseDto) {
        try {
            courseService.create(courseDto);
            return new ResponseEntity<>("Course create.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Course not Created", HttpStatus.CONFLICT);

        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(courseService.findById(id), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("Course with id: " + id + " not found.", HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody CourseDto courseDto) {
        try {
            courseService.update(courseDto, id);
            return new ResponseEntity<>("Course " + courseDto.getCourseName()+" update.", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("Course with id " + courseDto.getCourseName() + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        try {
            courseService.findById(id);
            courseService.deleteById(id);
            return new ResponseEntity<>("Course with id " + id + " delete.", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("Course with id " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }
}
