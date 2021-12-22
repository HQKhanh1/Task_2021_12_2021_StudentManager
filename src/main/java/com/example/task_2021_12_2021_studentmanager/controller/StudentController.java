package com.example.task_2021_12_2021_studentmanager.controller;

import com.example.task_2021_12_2021_studentmanager.exception.StudentAlreadyExistedException;
import com.example.task_2021_12_2021_studentmanager.model.Student;
import com.example.task_2021_12_2021_studentmanager.service.StudentService;
import com.example.task_2021_12_2021_studentmanager.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("ALL")
@RestController
//@Profile({"prod","dev"})
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    private List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("/page")
    public Page<Student> getStudents(@RequestParam Optional<Integer> page, @RequestParam Optional<String> sortBy) {
        return studentService.getStudent(page, sortBy);
    }

    @GetMapping("/student/{id}")
    private Student getStudent(@PathVariable("id") int id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/student/{id}")
    private String deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
        return "delete successfully";
    }

    @PostMapping("/student")
    private String saveStudent(@RequestBody @Valid Student student) throws StudentAlreadyExistedException {
        studentService.saveStudent(student);
        return "save successfully";
    }

    @PutMapping("/student/{id}")
    public String updateStudent(@PathVariable("id") int id, @RequestBody @Valid Student student) throws StudentNotFoundException {
        studentService.updateStudent(id, student);
        return "update successfully";
    }

    @GetMapping("/age/{id}")
    private int getAgeStudent(@PathVariable("id") int id) {
        return studentService.ageNumbers(id);
    }
}
