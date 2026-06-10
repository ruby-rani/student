package com.ruby.student.Repository;

import com.ruby.student.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository  extends JpaRepository<Student,Integer> {
     Student findByEmail(String email);
}
