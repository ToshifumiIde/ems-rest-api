package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.DepartmentRegistrationDto;

public interface DepartmentService {
  void createDepartment(DepartmentRegistrationDto departmentRegistrationDto);
}
