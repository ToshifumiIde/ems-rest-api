package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.EmployeeReadDto;
import net.javaguides.springboot.dto.EmployeeRegistrationDto;


public interface EmployeeService {

  void createEmployee(EmployeeRegistrationDto employeeRegistrationDto);
  EmployeeReadDto getEmployeeByUuid(String uuid);
}
