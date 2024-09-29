package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.EmployeeReadDto;
import net.javaguides.springboot.dto.EmployeeRegistrationDto;
import net.javaguides.springboot.dto.EmployeeUpdateDto;
import net.javaguides.springboot.entity.Employee;

import java.util.List;


public interface EmployeeService {

  void createEmployee(EmployeeRegistrationDto employeeRegistrationDto);

  EmployeeReadDto getEmployeeByUuid(String uuid);

  List<EmployeeReadDto> getAllEmployees();

  void updateEmployeeByUuid(String uuid, EmployeeUpdateDto employeeUpdateDto);
}
