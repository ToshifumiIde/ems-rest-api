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
   * @return int 保存成功時1、失敗時0
   */
  int createEmployee(Employee employee);

  /**
   * UUIDを指定してDBから従業員を取得する
   *
   * @param uuid 従業員UUID
   * @retun Employee 従業員エンティティ
   */
  Employee getEmployeeByUuid(String uuid);

  /**
   * 従業員を全件取得する
   *
   * @return List<Employee> 従業員エンティティ
   */
  List<Employee> getAllEmployees();

  /**
   * UUIDを指定してDBの従業員を更新する
   *
   * @param uuid     従業員UUID
   * @param employee 従業員エンティティ
   * @return int 保存成功時1、失敗時0
   */
  int updateEmployeeByUuid(String uuid, Employee employee);
}
