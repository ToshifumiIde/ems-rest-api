package net.javaguides.springboot.controller;

import lombok.RequiredArgsConstructor;
import net.javaguides.springboot.dto.DepartmentReadDto;
import net.javaguides.springboot.dto.DepartmentRegistrationDto;
import net.javaguides.springboot.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("*")
@RequestMapping("/api/departments")
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
  @PostMapping
  public ResponseEntity<Void> create(@RequestBody DepartmentRegistrationDto departmentRegistrationDto) {
    departmentService.createDepartment(departmentRegistrationDto);
    return ResponseEntity.ok().build();
  }

  /**
   * UUIDを指定してDepartmentを取得するREST API
   *
   * @param uuid 部署UUID
   * @return DepartmentReadDto 部署取得用DTO
   */
  @GetMapping("{uuid}")
  public ResponseEntity<DepartmentReadDto> getByUuid(@PathVariable("uuid") String uuid) {
    DepartmentReadDto dto = departmentService.getDepartmentByUuid(uuid);
    return new ResponseEntity<>(dto, HttpStatus.OK);
  }
}
