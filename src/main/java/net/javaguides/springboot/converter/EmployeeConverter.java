package net.javaguides.springboot.converter;

import net.javaguides.springboot.dto.EmployeeReadDto;
import net.javaguides.springboot.dto.EmployeeUpdateDto;
import net.javaguides.springboot.entity.Employee;
import net.javaguides.springboot.dto.EmployeeRegistrationDto;
import net.javaguides.springboot.util.UuidGenerate;
import org.springframework.stereotype.Component;


@Component
public class EmployeeConverter {

  /**
   * 従業員エンティティから従業員読み取りDTOに変換する
   *
   * @param employee 従業員エンティティ
   * @return EmployeeReadDto 従業員読み取りDTO
   */
  public EmployeeReadDto toReadDto(Employee employee) {
    return new EmployeeReadDto(
      employee.getUuid(),
      employee.getFirstName(),
      employee.getLastName(),
      employee.getEmail()
    );
  }

  /**
   * 登録用DTOからEntityに変換する
   *
   * @param employeeRegistrationDto 従業員編集用DTO
   * @return Employee 従業員のエンティティ
   */
  public Employee toRegistrationEntity(EmployeeRegistrationDto employeeRegistrationDto) {
    return new Employee(
      UuidGenerate.generate(),
      employeeRegistrationDto.getFirstName(),
      employeeRegistrationDto.getLastName(),
      employeeRegistrationDto.getEmail()
    );
  }

  /**
   * 編集用DTOからEntityに変換する
   *
   * @param employeeUpdateDto 従業員編集用DTO
   * @return Employee 従業員のエンティティ
   */
  public Employee toEditEntity(EmployeeUpdateDto employeeUpdateDto) {
    return new Employee(
      employeeUpdateDto.getFirstName(),
      employeeUpdateDto.getLastName(),
      employeeUpdateDto.getEmail()
    );
  }
}
