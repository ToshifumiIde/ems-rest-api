package net.javaguides.springboot.converter;

import net.javaguides.springboot.dto.DepartmentListDto;
import net.javaguides.springboot.dto.DepartmentReadDto;
import net.javaguides.springboot.dto.DepartmentRegistrationDto;
import net.javaguides.springboot.dto.DepartmentUpdateDto;
import net.javaguides.springboot.entity.Department;
import net.javaguides.springboot.util.UuidGenerate;
import org.springframework.stereotype.Component;

@Component
public class DepartmentConverter {

  /**
   * 部署エンティティから部署読み取りDTOに変換する
   */
  public DepartmentReadDto toReadDto(Department department) {
    return new DepartmentReadDto(
      department.getUuid(),
      department.getName(),
      department.getDescription()
    );
  }

  /**
   * 登録用DTOからEntityに変換する
   *
   * @param dto 部署登録用DTO
   * @return Department 部署のエンティティ
   */
  public Department toRegistrationEntity(DepartmentRegistrationDto dto) {
    return new Department(
      UuidGenerate.generate(),
      dto.getName(),
      dto.getDescription()
    );
  }

  /**
   * 編集用DTOからEntityに変換する
   *
   * @param dto 部署編集用DTO
   * @return Department 部署のエンティティ
   */
  public Department toEditEntity(DepartmentUpdateDto dto) {
    return new Department(dto.getName(), dto.getDescription());
  }

  /**
   * Entityから動的セレクトボックス用のDtoに変換する
   *
   * @param department 部署のエンティティ
   * @return DepartmentListDto 動的セレクトボックス用の部署DTO
   */
  public DepartmentListDto toDepartmentListDto(Department department) {
    return new DepartmentListDto(department.getUuid(), department.getName());
  }
}
