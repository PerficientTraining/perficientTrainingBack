package perficient.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import perficient.com.dto.GroupDto;
import perficient.com.dto.TeacherDto;
import perficient.com.model.Group;
import perficient.com.service.IGroupService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/group")
public class GroupController {

    @Autowired
    IGroupService groupService;

    @GetMapping()
    public ResponseEntity<?> all() {
        try {
            return new ResponseEntity<>(groupService.all(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody GroupDto groupDto, @RequestParam int idCourse, @RequestParam int idTeacher) {
        try {
            return new ResponseEntity<>(groupService.create(groupDto, idCourse, idTeacher), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Group not Created", HttpStatus.CONFLICT);

        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(groupService.findById(id), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("Group with id: " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}/")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody GroupDto groupDto) {
        try {
            groupService.update(groupDto, id);
            return new ResponseEntity<>("Group " + id + " update.", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("Group with id " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        try {
            groupService.findById(id);
            groupService.deleteById(id);
            return new ResponseEntity<>("Group with id " + id + " delete.", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("Group with id " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/assingStudents")
    public ResponseEntity<?> assingStudents(@RequestParam int idStudent,@RequestParam int idGroup) {
        try {
            groupService.assingStudents(idStudent, idGroup);
            return new ResponseEntity<>("Student assigned to group " + idStudent, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("Group not assigned", HttpStatus.CONFLICT);

        }
    }

    @PutMapping("/unenrollmentStudents")
    public ResponseEntity<?> unenrollmentStudents(@RequestParam int idStudent,@RequestParam int idGroup) {
        try {
            groupService.unenrollmentStudents(idStudent, idGroup);
            return new ResponseEntity<>("Student unenrollment to group " + idStudent, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("Student not unenrollment", HttpStatus.CONFLICT);

        }
    }

}
