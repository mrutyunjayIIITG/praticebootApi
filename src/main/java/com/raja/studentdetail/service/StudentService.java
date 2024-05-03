package com.raja.studentdetail.service;

import com.raja.studentdetail.dto.StudentDto;
import com.raja.studentdetail.entity.Student;
import com.raja.studentdetail.repository.Studentrepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    private final Studentrepo studentrepo;
    private final ModelMapper modelMapper;

    @Autowired
    public StudentService(Studentrepo studentrepo, ModelMapper modelMapper) {
        this.studentrepo = studentrepo;
        this.modelMapper = modelMapper;
    }

    public Student saveStudent(StudentDto studentDto) {
        Student student = modelMapper.map(studentDto, Student.class);
        return studentrepo.save(student);
    }
    //find by ide

    public Optional<Student> getProfileById(String id)
    {
        return  studentrepo.findById(id);
    }

    public void deleteStudentById(String id) {
        studentrepo.deleteById(id);
    }


}
