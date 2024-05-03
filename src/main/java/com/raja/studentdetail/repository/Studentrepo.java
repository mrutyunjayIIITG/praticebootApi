package com.raja.studentdetail.repository;

import com.raja.studentdetail.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Studentrepo extends JpaRepository<Student,String> {
    Student findByEmail(String email);
}
