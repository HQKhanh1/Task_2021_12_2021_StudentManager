package com.example.task_2021_12_2021_studentmanager.service;

import com.example.task_2021_12_2021_studentmanager.exception.StudentAlreadyExistedException;
import com.example.task_2021_12_2021_studentmanager.model.Student;
import com.example.task_2021_12_2021_studentmanager.exception.StudentNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudent();

    Student getStudentById(int id);

    void saveStudent(Student student) throws StudentAlreadyExistedException, StudentAlreadyExistedException;

    void updateStudent(int id, Student student) throws StudentNotFoundException, StudentNotFoundException;

    void deleteStudent(int id);

    boolean checkEmail(Student student);

    int ageNumbers(int id);

    Page<Student> getStudent(Optional<Integer> page, Optional<String> sortBy);
}
