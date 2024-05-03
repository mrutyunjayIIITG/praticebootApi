package com.raja.studentdetail.controller;
import com.raja.studentdetail.dto.StudentDto;
import com.raja.studentdetail.entity.Student;
import com.raja.studentdetail.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping("/create")
    public ResponseEntity<Student> saveStudent(@RequestBody StudentDto studentDTO) {
        Student savedStudent = studentService.saveStudent(studentDTO);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }


    @GetMapping("/home")
    public String homePage()
    {
        return "hello worrld";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getProfileById(@PathVariable String id) {
        Optional<Student> optionalProfile = studentService.getProfileById(id);
        if (optionalProfile.isPresent()) {
            Student profile = optionalProfile.get(); // Extract the Student object from Optional
            return new ResponseEntity<>(profile, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable String id) {
        studentService.deleteStudentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
