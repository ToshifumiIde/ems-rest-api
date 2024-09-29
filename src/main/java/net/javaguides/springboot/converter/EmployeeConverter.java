package net.javaguides.springboot.converter;

import net.javaguides.springboot.dto.EmployeeReadDto;
import net.javaguides.springboot.dto.EmployeeUpdateDto;
import net.javaguides.springboot.entity.Employee;
import net.javaguides.springboot.dto.EmployeeRegistrationDto;
import net.javaguides.springboot.util.UuidGenerate;
import org.springframework.stereotype.Component;


@Component
public class EmployeeConverter {

  public EmployeeReadDto toDto(Employee employee) {
    return new EmployeeReadDto(
      employee.getUuid(),
      employee.getFirstName(),
      employee.getLastName(),
      employee.getEmail()
    );
  }

  public Employee toRegistrationEntity(EmployeeRegistrationDto employeeRegistrationDto) {
    return new Employee(
      UuidGenerate.generate(),
      employeeRegistrationDto.getFirstName(),
      employeeRegistrationDto.getLastName(),
      employeeRegistrationDto.getEmail()
    );
  }

  public Employee toEditEntity(EmployeeUpdateDto employeeUpdateDto) {
    return new Employee(
      employeeUpdateDto.getFirstName(),
      employeeUpdateDto.getLastName(),
      employeeUpdateDto.getEmail()
    );
  }
}
