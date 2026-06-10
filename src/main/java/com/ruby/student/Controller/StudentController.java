package com.ruby.student.Controller;

import com.ruby.student.Entity.Student;
import com.ruby.student.Service.StudentService;
import com.ruby.student.dto.StudentRequestDTO;
import com.ruby.student.dto.StudentResponseDTO;
import com.ruby.student.exception.StudentNotFoundException;
import com.ruby.student.mapper.StudentMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v3/api")
public class StudentController {

    @Autowired
    public final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello Developers");
    }

    @PostMapping (path="/student")
    public ResponseEntity<String> addStudent(@Valid @RequestBody StudentRequestDTO RequestDTO) {
        Student student= StudentMapper.dtoToStudent(RequestDTO);
        Student intializeStudent = studentService.addStudent(student);
        StudentResponseDTO responseDTO = StudentMapper.studentToDto(intializeStudent);
//


        return ResponseEntity.status(HttpStatus.CREATED).body("Student is Created : " + responseDTO.toString());
    }


    @GetMapping(path="/student")
    public ResponseEntity<List<Student>> getAllStudents(){
        System.out.println("debug");
        List<Student> students=studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Optional<Student>> getStudent(@PathVariable Integer id){
        Optional<Student> student = studentService.getById(id);
        if(student.isEmpty()){
            throw new StudentNotFoundException(id);
        }
        return ResponseEntity.ok(student);
    }
    @PutMapping  ("/student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student studentDetails) {
        Student updatedStudent = studentService.update(id, studentDetails);
        return ResponseEntity.ok(updatedStudent);
    }
    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
        Optional<Student> student=studentService.delete(id);
        return ResponseEntity.ok("Student deleted successfully." + student.toString());
    }


}

