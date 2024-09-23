package net.javaguides.springboot.service;

import lombok.RequiredArgsConstructor;
import net.javaguides.springboot.entity.Student;
import net.javaguides.springboot.exception.BusinessException;
import net.javaguides.springboot.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class StudentService {

  private final StudentRepository studentRepository;

  public Student getStudent(){
    Student student = studentRepository.getStudent();
    if(Objects.isNull(student)){
      throw new BusinessException(HttpStatus.NOT_FOUND.value(), "NOT FOUND" , "resource not found");
    }
    return student;
  }
}
