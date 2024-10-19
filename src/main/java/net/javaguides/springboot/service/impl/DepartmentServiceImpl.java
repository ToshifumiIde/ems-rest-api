package net.javaguides.springboot.service.impl;

import lombok.RequiredArgsConstructor;
import net.javaguides.springboot.converter.DepartmentConverter;
import net.javaguides.springboot.dto.DepartmentListDto;
import net.javaguides.springboot.dto.DepartmentReadDto;
import net.javaguides.springboot.dto.DepartmentRegistrationDto;
import net.javaguides.springboot.dto.DepartmentUpdateDto;
import net.javaguides.springboot.entity.Department;
import net.javaguides.springboot.exception.BusinessException;
import net.javaguides.springboot.repository.DepartmentRepository;
import net.javaguides.springboot.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
   * 部署を全件取得する
   *
   * @return List<DepartmentDto> 部署読み取り用DTOのリスト
   */
  @Override
  @Transactional(readOnly = true)
  public List<DepartmentReadDto> getAllDepartments() {
    List<Department> allDepartments = departmentRepository.getAllDepartments();
    return allDepartments.stream().map(departmentConverter::toReadDto).collect(Collectors.toList());
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
    return departmentConverter.toReadDto(department);
  }

  /**
   * UUIDを指定して部署を更新する
   *
   * @param uuid                部署UUID
   * @param departmentUpdateDto 部署更新用DTO
   * @throws BusinessException 指定したUUIDの部署が見つからなかった場合の404エラー
   * @throws BusinessException 指定したUUIDの部署の更新が失敗した場合の400エラー
   */
  @Override
  @Transactional
  public void updateDepartmentByUuid(String uuid, DepartmentUpdateDto departmentUpdateDto) {
    Department targetDepartment = departmentRepository.getDepartmentByUuid(uuid);
    if (Objects.isNull(targetDepartment)) {
      throw new BusinessException(HttpStatus.NOT_FOUND.value(), "NOT FOUND", "failed to get resource");
    }
    Department updateDepartment = departmentConverter.toEditEntity(departmentUpdateDto);

    int result = departmentRepository.updateDepartmentByUuid(uuid, updateDepartment);

    if (!Objects.equals(result, 1)) {
      throw new BusinessException(HttpStatus.BAD_REQUEST.value(), "UPDATED FAILED", "failed to update resource");
    }
  }

  /**
   * UUIDを指定して部署を削除する
   *
   * @param uuid                部署UUID
   * @throws BusinessException 指定したUUIDの部署が見つからなかった場合の404エラー
   * @throws BusinessException 指定したUUIDの部署の削除が失敗した場合の400エラー
   */
  @Override
  @Transactional
  public void deleteDepartmentByUuid(String uuid) {
    Department targetDepartment = departmentRepository.getDepartmentByUuid(uuid);
    if (Objects.isNull(targetDepartment)) {
      throw new BusinessException(HttpStatus.NOT_FOUND.value(), "NOT FOUND", "failed to get resource");
    }

    int result = departmentRepository.deleteDepartmentByUuid(uuid);

    if (!Objects.equals(result, 1)) {
      throw new BusinessException(HttpStatus.BAD_REQUEST.value(), "DELETE FAILED", "failed to delete resource");
    }
  }

  /**
   * 登録されている部署のUUIDと名前のListを返却する
   *
   * @return List<DepartmentListDto> セレクトボックス用の部署のDtoのList
   * */
  @Override
  public List<DepartmentListDto> getDepartmentsList() {
    List<Department> departmentsList = departmentRepository.getDepartmentsList();
    return departmentsList.stream().map(departmentConverter::toDepartmentListDto).collect(Collectors.toList());
  }
}
