package com.ruby.student.exception;

public class StudentEmailAlreadyExistsException extends RuntimeException {
     public StudentEmailAlreadyExistsException (String email){
         super(" email already exist : " +email);
     }
}
