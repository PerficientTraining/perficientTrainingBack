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
    public ResponseEntity<?> create(@RequestBody GroupDto groupDto) {
        try {
            return new ResponseEntity<>(groupService.create(groupDto), HttpStatus.CREATED);
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

    @PutMapping("/assignTeacherAndHours")
    public ResponseEntity<?> assignTeacherAndHours(@RequestParam int idGroup, @RequestParam int idTeacher, @RequestParam String hours) {
        try {
            groupService.assignTeacherAndHours(idGroup, idTeacher, hours);
            return new ResponseEntity<>("Teacher " + idTeacher + " assign.", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("Teacher with id " + idTeacher + " not found.", HttpStatus.NOT_FOUND);
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

    @PutMapping("/assingCourse")
    public ResponseEntity<?> assingCourse(@RequestParam int idCourse,@RequestParam int idGroup) {
        try {
            groupService.assingCourse(idCourse, idGroup);
            return new ResponseEntity<>("Course assigned to group " +idGroup, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("Group not assigned", HttpStatus.CONFLICT);

        }
    }

}
