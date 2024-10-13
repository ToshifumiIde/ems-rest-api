package net.javaguides.springboot.service.impl;

import lombok.RequiredArgsConstructor;
import net.javaguides.springboot.converter.DepartmentConverter;
import net.javaguides.springboot.dto.DepartmentReadDto;
import net.javaguides.springboot.dto.DepartmentRegistrationDto;
import net.javaguides.springboot.entity.Department;
import net.javaguides.springboot.exception.BusinessException;
import net.javaguides.springboot.repository.DepartmentRepository;
import net.javaguides.springboot.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

  private final DepartmentConverter departmentConverter;
  private final DepartmentRepository departmentRepository;

  /**
   * 部署登録用Dtoを用いて部署を登録する
   *
   * @param dto 従業員登録用DTO
   * @throws BusinessException 登録失敗時の例外処理
   */
  @Override
  @Transactional
  public void createDepartment(DepartmentRegistrationDto dto) {
    Department department = departmentConverter.toRegistrationEntity(dto);
    int result = departmentRepository.createDepartment(department);
    if (!Objects.equals(result, 1)) {
      throw new BusinessException(HttpStatus.BAD_REQUEST.value(), "CREATE FAILED", "failed to generate resource");
    }
  }

  /**
   * UUIDを指定して部署を取得する
   *
   * @param uuid 従業員UUID
   * @return DepartmentReadDto 部署DTO
   * @throws BusinessException 指定したUUIDの部署が見つからない場合の例外処理
   */
  @Override
  @Transactional(readOnly = true)
  public DepartmentReadDto getDepartmentByUuid(String uuid) {
    Department department = departmentRepository.getDepartmentByUuid(uuid);
    if (Objects.isNull(department)) {
      throw new BusinessException(HttpStatus.NOT_FOUND.value(), "NOT FOUND", "failed to get resource");
    }
    DepartmentReadDto dto = departmentConverter.toReadDto(department);
    return dto;
  }
}
