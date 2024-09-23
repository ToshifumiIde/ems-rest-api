package net.javaguides.springboot.converter;

import net.javaguides.springboot.entity.Employee;
import net.javaguides.springboot.dto.EmployeeRegistrationDto;
import net.javaguides.springboot.util.UuidGenerate;
import org.springframework.stereotype.Component;


@Component
public class EmployeeConverter {

//  public EmployeeRegistrationDto toDto(Employee employee){
//    return new EmployeeRegistrationDto(
//      employee.getId(),
//      employee.getUuid(),
//      employee.getFirstName(),
//      employee.getLastName(),
//      employee.getEmail()
//    );
//  }

  public Employee toRegistrationEntity(EmployeeRegistrationDto employeeRegistrationDto){
    return new Employee(
      UuidGenerate.generate(),
      employeeRegistrationDto.getFirstName(),
      employeeRegistrationDto.getLastName(),
      employeeRegistrationDto.getEmail()
    );
  }
}
