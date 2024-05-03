package com.raja.studentdetail.repository;

import com.raja.studentdetail.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Collegerepo extends JpaRepository<College, Integer> {
}
