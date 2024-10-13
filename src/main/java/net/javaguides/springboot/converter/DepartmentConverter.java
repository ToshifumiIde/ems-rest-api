package net.javaguides.springboot.converter;

import net.javaguides.springboot.dto.DepartmentRegistrationDto;
import net.javaguides.springboot.entity.Department;
import net.javaguides.springboot.util.UuidGenerate;
import org.springframework.stereotype.Component;

@Component
public class DepartmentConverter {
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
}
