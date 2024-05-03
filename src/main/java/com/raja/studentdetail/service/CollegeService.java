package com.raja.studentdetail.service;

import com.raja.studentdetail.dto.CollegeDto;
import com.raja.studentdetail.dto.StudentDto;
import com.raja.studentdetail.entity.College;
import com.raja.studentdetail.entity.Student;
import com.raja.studentdetail.repository.Collegerepo;
import com.raja.studentdetail.repository.Studentrepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollegeService {
    private final Collegerepo collegeRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public CollegeService(Collegerepo collegeRepo, ModelMapper modelMapper) {
        this.collegeRepo = collegeRepo;
        this.modelMapper = modelMapper;
    }

    public College saveCollege(CollegeDto collegeDto) {
        College college = modelMapper.map(collegeDto, College.class);
        return collegeRepo.save(college);
    }
}
