package net.javaguides.springboot.service;

import lombok.RequiredArgsConstructor;
import net.javaguides.springboot.bean.Student;
import net.javaguides.springboot.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

  private final StudentRepository studentRepository;

  public Student getStudent(){
    Student student = studentRepository.getStudent();
    return student;
  }
}
