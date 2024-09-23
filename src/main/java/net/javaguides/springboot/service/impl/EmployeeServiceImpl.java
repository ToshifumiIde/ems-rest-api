package net.javaguides.springboot.service.impl;

import lombok.RequiredArgsConstructor;
import net.javaguides.springboot.entity.Employee;
import net.javaguides.springboot.converter.EmployeeConverter;
import net.javaguides.springboot.dto.EmployeeRegistrationDto;
import net.javaguides.springboot.exception.BusinessException;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeRepository employeeRepository;
  private final EmployeeConverter employeeConverter;

  @Override
  @Transactional
  public void createEmployee(EmployeeRegistrationDto employeeRegistrationDto) {
    Employee converted = employeeConverter.toRegistrationEntity(employeeRegistrationDto);
    int result = employeeRepository.createEmployee(converted);
    if(!Objects.equals(result , 1)){
      throw new BusinessException(HttpStatus.BAD_REQUEST.value() , "CREATE FAILED" ,"failed to generate resource");
    }
  }
}
