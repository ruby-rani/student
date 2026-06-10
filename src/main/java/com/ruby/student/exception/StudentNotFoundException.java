package com.ruby.student.exception;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(Integer id){
        super("StudentNotFoundException with : "+id);
    }
}
