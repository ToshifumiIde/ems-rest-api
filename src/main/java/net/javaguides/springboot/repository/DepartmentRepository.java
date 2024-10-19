package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

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
   * 部署を全件取得する
   *
   * @return List<Department> 部署のList
   */
  List<Department> getAllDepartments();

  /**
   * UUIDを指定してDBから部署を取得する
   *
   * @param uuid 部署UUID
   * @return Department 部署エンティティ
   */
  Department getDepartmentByUuid(String uuid);

  /**
   * UUIDを指定してDBの部署を更新する
   *
   * @param uuid       部署UUID
   * @param department 部署エンティティ
   * @return int 削除成功時1、失敗時0
   */
  int updateDepartmentByUuid(String uuid, Department department);

  /**
   * UUIDを指定してDBの部署を削除する
   *
   * @param uuid 部署UUID
   * @return int 削除成功時1、失敗時0
   */
  int deleteDepartmentByUuid(String uuid);

  /**
   * 動的セレクトボックス用の部署の一覧を取得する
   *
   * @return List<Department> 部署のList
   */
  List<Department> getDepartmentsList();
}
