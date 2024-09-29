package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository {
  /**
   * 従業員をDBに保存する
   *
   * @param employee 従業員エンティティ
   * @return int 保存成功時1、
   */
  int createEmployee(Employee employee);

  /**
   * UUIDを指定してDBから従業員を取得する
   *
   * @param uuid 従業員UUID
   * @retun Employee 従業員エンティティ
   */
  Employee getEmployeeByUuid(String uuid);

  List<Employee> getAllEmployees();
}
