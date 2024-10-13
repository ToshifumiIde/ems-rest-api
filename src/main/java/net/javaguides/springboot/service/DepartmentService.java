package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.DepartmentReadDto;
import net.javaguides.springboot.dto.DepartmentRegistrationDto;

import java.util.List;

public interface DepartmentService {
  void createDepartment(DepartmentRegistrationDto departmentRegistrationDto);

  List<DepartmentReadDto> getAllDepartments();

  DepartmentReadDto getDepartmentByUuid(String uuid);
}
