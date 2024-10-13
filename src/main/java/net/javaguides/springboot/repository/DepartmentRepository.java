package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.Department;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository {
  /**
   * 部署を保存する
   *
   * @param department 部署エンティティ
   * @return int 保存成功時1、失敗時0
   */
  int createDepartment(Department department);

  /**
   * UUIDを指定してDBから部署を取得する
   *
   * @param uuid 部署UUID
   * @return Department 部署エンティティ
   */
  Department getDepartmentByUuid(String uuid);
}
