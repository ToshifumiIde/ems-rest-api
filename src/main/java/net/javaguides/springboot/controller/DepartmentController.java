package net.javaguides.springboot.controller;

import lombok.RequiredArgsConstructor;
import net.javaguides.springboot.dto.DepartmentListDto;
import net.javaguides.springboot.dto.DepartmentReadDto;
import net.javaguides.springboot.dto.DepartmentRegistrationDto;
import net.javaguides.springboot.dto.DepartmentUpdateDto;
import net.javaguides.springboot.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin("*")
@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class DepartmentController {

  private final DepartmentService departmentService;

  /**
   * 部署を登録する REST API
   *
   * @param departmentRegistrationDto 部署登録用DTO
   * @return void
   */
  @PostMapping("departments")
  public ResponseEntity<Void> create(@RequestBody DepartmentRegistrationDto departmentRegistrationDto) {
    departmentService.createDepartment(departmentRegistrationDto);
    return ResponseEntity.ok().build();
  }

  /**
   * 部署を全件取得する REST API
   *
   * @return List<DepartmentReadDto> 部署取得用DTOのList
   */
  @GetMapping("departments")
  public ResponseEntity<List<DepartmentReadDto>> getAll() {
    List<DepartmentReadDto> dtos = departmentService.getAllDepartments();
    return new ResponseEntity<>(dtos, HttpStatus.OK);
  }

  /**
   * UUIDを指定して部署を取得する REST API
   *
   * @param uuid 部署UUID
   * @return DepartmentReadDto 部署取得用DTO
   */
  @GetMapping("departments/{uuid}")
  public ResponseEntity<DepartmentReadDto> getByUuid(@PathVariable("uuid") String uuid) {
    DepartmentReadDto dto = departmentService.getDepartmentByUuid(uuid);
    return new ResponseEntity<>(dto, HttpStatus.OK);
  }

  /**
   * UUIDを指定して部署を更新する REST API
   *
   * @param uuid                部署UUID
   * @param departmentUpdateDto 部署更新用DTO
   * @return void
   */
  @PutMapping("departments/{uuid}")
  public ResponseEntity<Void> updateByUuid(@PathVariable("uuid") String uuid, @RequestBody DepartmentUpdateDto departmentUpdateDto) {
    departmentService.updateDepartmentByUuid(uuid, departmentUpdateDto);
    return ResponseEntity.ok().build();
  }

  /**
   * UUIDを指定して部署を削除する REST API
   *
   * @param uuid 部署UUID
   * @return void
   */
  @DeleteMapping("departments/{uuid}")
  public ResponseEntity<Void> deleteByUuid(@PathVariable("uuid") String uuid) {
    departmentService.deleteDepartmentByUuid(uuid);
    return ResponseEntity.ok().build();
  }

  /**
   * 動的セレクトボックス用の部署一覧を取得する REST API
   *
   * @return List<DepartmentListDto> セレクトボックス用の部署Dto
   */
  @GetMapping("departments:list")
  public ResponseEntity<List<DepartmentListDto>> getDepartmentsList() {
    return new ResponseEntity<>(departmentService.getDepartmentsList(), HttpStatus.OK);
  }

}
