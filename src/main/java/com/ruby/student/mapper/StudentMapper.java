package com.ruby.student.mapper;

import com.ruby.student.Entity.Student;
import com.ruby.student.dto.StudentRequestDTO;
import com.ruby.student.dto.StudentResponseDTO;

public class StudentMapper {
    public static Student dtoToStudent(StudentRequestDTO requestDTO){
        Student student=new Student();
        student.setName(requestDTO.getName());
        student.setAge(requestDTO.getAge());
        student.setEmail(requestDTO.getEmail());
        return student;
    }
    public static StudentResponseDTO studentToDto(Student student){
        StudentResponseDTO responseDTO=new StudentResponseDTO();
        responseDTO.setName(student.getName());
        responseDTO.setAge(student.getAge());
        responseDTO.setEmail(student.getEmail());
        return responseDTO;

    }
}
