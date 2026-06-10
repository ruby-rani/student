package com.ruby.student.Service;

import com.ruby.student.Entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public Student addStudent(Student student) ;

    public Student getStudent(Integer id);
//
    public List<Student> getAllStudents();

    public Optional<Student> getById(Integer id);


   public  Student update(Integer id, Student studentDetails);

   public Optional<Student> delete(Integer id);

    Student updateStudent(Integer id, Student studentDetails);

}
