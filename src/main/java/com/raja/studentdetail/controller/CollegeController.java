package com.raja.studentdetail.controller;

import com.raja.studentdetail.dto.CollegeDto;
import com.raja.studentdetail.dto.StudentDto;
import com.raja.studentdetail.entity.College;
import com.raja.studentdetail.entity.Student;
import com.raja.studentdetail.service.CollegeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/colleges")
@CrossOrigin(origins = "*")
public class CollegeController {


    private final CollegeService collegeService;

    public CollegeController(CollegeService collegeService) {
        this.collegeService = collegeService;
    }

    @PostMapping("/create")
    public ResponseEntity<College> saveCollege(@RequestBody CollegeDto CollegeDTO) {
        College savedCollege = collegeService.saveCollege(CollegeDTO);
        return new ResponseEntity<>(savedCollege, HttpStatus.CREATED);
    }


}
