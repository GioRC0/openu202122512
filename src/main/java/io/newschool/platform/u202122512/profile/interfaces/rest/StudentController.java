package io.newschool.platform.u202122512.profile.interfaces.rest;

import io.newschool.platform.u202122512.profile.domain.services.StudentCommandService;
import io.newschool.platform.u202122512.profile.interfaces.rest.resources.CreateStudentResource;
import io.newschool.platform.u202122512.profile.interfaces.rest.transform.CreateStudentFromResourceAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/students", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {
    private final StudentCommandService studentCommandService;

    public StudentController(StudentCommandService studentCommandService) {
        this.studentCommandService = studentCommandService;
    }

    @PostMapping
    public ResponseEntity createStudent(@RequestBody CreateStudentResource resource){
        var command = CreateStudentFromResourceAssembler.toCommandFrom(resource);
        var studentId = studentCommandService.handle(command);

        return new ResponseEntity(HttpStatus.CREATED);
    }
}
