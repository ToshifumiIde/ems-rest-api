package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository {
  int createEmployee(Employee employee);
}
