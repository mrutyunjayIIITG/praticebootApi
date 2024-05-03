package com.raja.studentdetail.service;


import com.raja.studentdetail.dto.StudentNameCollegeDto;
import com.raja.studentdetail.entity.College;
import com.raja.studentdetail.entity.Student;
import com.raja.studentdetail.repository.Collegerepo;
import com.raja.studentdetail.repository.Studentrepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentNameCollegeService {

    private final Studentrepo studentrepo;
    private final Collegerepo collegeRepo;
    private final ModelMapper modelMapper;
    @Autowired
    public StudentNameCollegeService(Studentrepo studentrepo, Collegerepo collegeRepo, ModelMapper modelMapper) {
        this.studentrepo = studentrepo;
        this.collegeRepo = collegeRepo;
        this.modelMapper = modelMapper;
    }
//     public Optional<StudentNameCollegeDto> getStudentDetailsByEmail(String email) {
//         Student student = studentrepo.findByEmail(email);
//         if(student == null) {
//             System.out.println("Student not found");
//         }
//         College college = student.getCollege();
//         if(college == null) {
//             System.out.println("College not found");
//         }
//         // Map the student entity and college entity to StudentNameCollegeDto
//         StudentNameCollegeDto studentNameCollegeDto = new StudentNameCollegeDto();
//         studentNameCollegeDto.setEmail(student.getEmail());
//         studentNameCollegeDto.setFirstName(student.getFirstName());
//         studentNameCollegeDto.setCollegeName(college.getCollegeName());
//
//         return Optional.of(studentNameCollegeDto);
//     }

    public StudentNameCollegeDto getStudentDetailsByEmail(String email) {
        Optional<Student> studentOptional = Optional.ofNullable(studentrepo.findByEmail(email));
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            College college = student.getCollege();
            if (college != null) {
                // Construct and return StudentNameCollegeDto
                StudentNameCollegeDto studentDto = new StudentNameCollegeDto();
                studentDto.setEmail(student.getEmail());
                studentDto.setFirstName(student.getFirstName());
                studentDto.setCollegeName(college.getCollegeName());
                return studentDto;
            } else {
                // Handle case where student's college is null
                // For example, throw an exception or return null
                return null;
            }
        } else {
            // Handle case where student is not found
            // For example, throw an exception or return null
            return null;
        }
    }





}
