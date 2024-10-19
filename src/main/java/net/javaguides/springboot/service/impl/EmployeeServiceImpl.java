package net.javaguides.springboot.service.impl;

import lombok.RequiredArgsConstructor;
import net.javaguides.springboot.converter.EmployeeConverter;
import net.javaguides.springboot.dto.EmployeeReadDto;
import net.javaguides.springboot.dto.EmployeeRegistrationDto;
import net.javaguides.springboot.dto.EmployeeUpdateDto;
import net.javaguides.springboot.entity.Department;
import net.javaguides.springboot.entity.Employee;
import net.javaguides.springboot.exception.BusinessException;
import net.javaguides.springboot.repository.DepartmentRepository;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

  private final DepartmentRepository departmentRepository;
  private final EmployeeRepository employeeRepository;
  private final EmployeeConverter employeeConverter;

  /**
   * 従業員登録用DTOを用いて従業員を登録する
   *
   * @param employeeRegistrationDto 従業員登録用DTO
   * @throws BusinessException 登録失敗時の例外処理
   */
  @Override
  @Transactional
  public void createEmployee(EmployeeRegistrationDto employeeRegistrationDto) {

    Department department = departmentRepository.getDepartmentByUuid(employeeRegistrationDto.getDepartmentUuid());
    if(Objects.isNull(department)){
      throw new BusinessException(HttpStatus.NOT_FOUND.value(), "NOT FOUND" , "resource not found");
    }

    Employee converted = employeeConverter.toRegistrationEntity(employeeRegistrationDto ,department.getId());
    int result = employeeRepository.createEmployee(converted);
    if (!Objects.equals(result, 1)) {
      throw new BusinessException(HttpStatus.BAD_REQUEST.value(), "CREATE FAILED", "failed to generate resource");
    }
  }


  /**
   * UUIDを指定して従業員を取得する
   *
   * @param uuid 従業員UUID
   * @return EmployeeReadDto 従業員DTO
   * @throws BusinessException 指定したUUIDの従業員が見つからない場合の例外処理
   */
  @Override
  @Transactional(readOnly = true)
  public EmployeeReadDto getEmployeeByUuid(String uuid) {
    Employee employee = employeeRepository.getEmployeeByUuid(uuid);
    if (Objects.isNull(employee)) {
      throw new BusinessException(HttpStatus.NOT_FOUND.value(), "NOT FOUND", "failed to get resource");
    }
    return employeeConverter.toReadDto(employee);
  }

  /**
   * 従業員を全件取得する
   *
   * @return List<EmployeeReadDto> 全従業員Dto
   */
  @Override
  @Transactional(readOnly = true)
  public List<EmployeeReadDto> getAllEmployees() {
    List<Employee> allEmployees = employeeRepository.getAllEmployees();
    return allEmployees.stream().map(employeeConverter::toReadDto).collect(Collectors.toList());
  }

  /**
   * UUIDを指定して従業員を更新する
   *
   * @param uuid              従業員UUID
   * @param employeeUpdateDto 従業員更新用Dto
   * @throws BusinessException 指定したUUIDの従業員が見つからなかった場合の404エラー
   * @throws BusinessException 指定したUUIDの従業員の更新が失敗した場合の400エラー
   */
  @Override
  @Transactional
  public void updateEmployeeByUuid(String uuid, EmployeeUpdateDto employeeUpdateDto) {
    Employee targetEmployee = employeeRepository.getEmployeeByUuid(uuid);
    if (Objects.isNull(targetEmployee)) {
      throw new BusinessException(HttpStatus.NOT_FOUND.value(), "NOT FOUND", "failed to get resource");
    }

    Department department = departmentRepository.getDepartmentByUuid(employeeUpdateDto.getDepartmentUuid());
    if (Objects.isNull(department)) {
      throw new BusinessException(HttpStatus.NOT_FOUND.value(), "NOT FOUND", "failed to get resource");
    }

    Employee updateEmployee = employeeConverter.toEditEntity(employeeUpdateDto , department.getId());

    int result = employeeRepository.updateEmployeeByUuid(uuid, updateEmployee);

    if (!Objects.equals(result, 1)) {
      throw new BusinessException(HttpStatus.BAD_REQUEST.value(), "UPDATED FAILED", "failed to update resource");
    }
  }

  /**
   * UUIDを指定して従業員を削除する
   *
   * @param uuid 従業員UUID
   * @throws BusinessException 指定したUUIDの従業員が見つからなかった場合の404エラー
   * @throws BusinessException 指定したUUIDの従業員の削除が失敗した場合の400エラー
   */
  @Override
  public void deleteEmployeeByUuid(String uuid) {
    Employee targetEmployee = employeeRepository.getEmployeeByUuid(uuid);
    if (Objects.isNull(targetEmployee)) {
      throw new BusinessException(HttpStatus.NOT_FOUND.value(), "NOT FOUND", "failed to get resource");
    }

    int result = employeeRepository.deleteEmployeeByUuid(uuid);

    if (!Objects.equals(result, 1)) {
      throw new BusinessException(HttpStatus.BAD_REQUEST.value(), "DELETE FAILED", "failed to delete resource");
    }
  }
}
