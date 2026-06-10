package com.ruby.student.Service;

import com.ruby.student.Entity.Student;
import com.ruby.student.Repository.StudentRepository;
import com.ruby.student.exception.StudentEmailAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addStudent(Student student) {
        if(studentRepository.findByEmail(student.getEmail()) != null){
            throw new StudentEmailAlreadyExistsException(student.getEmail());
        }

        return studentRepository.save(student);
    }

    @Override
    public Student getStudent(Integer id) {
        return null;
    }


    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getById(Integer id) {
        return studentRepository.findById(id);
    }



    @Override
    public Student update(Integer id, Student studentDetails) {
        return null;
    }


    @Override
    public Student updateStudent(Integer id, Student studentDetails) {
        // 1. Find the existing student
        return studentRepository.findById(id).map(existingStudent -> {
            // 2. Update the fields (assuming your Entity has these setters)
            existingStudent.setName(studentDetails.getName());
            existingStudent.setEmail(studentDetails.getEmail());
            // 3. Save the updated entity
            return studentRepository.save(existingStudent);
        }).orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }



    @Override
    public Optional<Student> delete(Integer id) {
        Optional<Student> student;
        // Check if exists before deleting to avoid errors
        if (studentRepository.existsById(id)) {
            student=studentRepository.findById(id);
            studentRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cannot delete. Student not found with id: " + id);
        }
        return student;
    }
}































