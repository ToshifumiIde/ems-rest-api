package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository {
  Student getStudent();
}
