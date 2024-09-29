package net.javaguides.springboot.controller;

import lombok.RequiredArgsConstructor;
import net.javaguides.springboot.dto.EmployeeReadDto;
import net.javaguides.springboot.dto.EmployeeRegistrationDto;
import net.javaguides.springboot.dto.EmployeeUpdateDto;
import net.javaguides.springboot.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

  private final EmployeeService employeeService;


  /**
   * 従業員を登録する REST API
   *
   * @param employeeRegistrationDto 従業員登録用DTO
   * @return void
   */
  @PostMapping
  public ResponseEntity<Void> create(@RequestBody EmployeeRegistrationDto employeeRegistrationDto) {
    employeeService.createEmployee(employeeRegistrationDto);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  /**
   * UUIDを指定してEmployeeを取得するREST API
   *
   * @param uuid 従業員UUID
   * @return EmployeeReadDto 従業員DTO
   */
  @GetMapping("{uuid}")
  public ResponseEntity<EmployeeReadDto> getByUuid(@PathVariable("uuid") String uuid) {
    EmployeeReadDto employeeReadDto = employeeService.getEmployeeByUuid(uuid);
    return ResponseEntity.ok().body(employeeReadDto);
  }

  /**
   * 全てのEmployeeを取得するREST API
   *
   * @return List<EmployeeDto> 従業員DTOの配列
   */
  @GetMapping
  public ResponseEntity<List<EmployeeReadDto>> getAll() {
    List<EmployeeReadDto> allEmployeeDtos = employeeService.getAllEmployees();
    return new ResponseEntity<>(allEmployeeDtos, HttpStatus.OK);
  }

  /**
   * 指定したUUIDの従業員を更新するREST API
   *
   * @param uuid              従業員UUID
   * @param employeeUpdateDto 従業員更新用DTO
   * @return void
   */
  @PutMapping("{uuid}")
  public ResponseEntity<Void> updateByUuid(@PathVariable("uuid") String uuid, @RequestBody EmployeeUpdateDto employeeUpdateDto) {
    employeeService.updateEmployeeByUuid(uuid, employeeUpdateDto);
    return ResponseEntity.ok().build();
  }

  /**
   * 指定したUUIDの従業員を削除するREST API
   *
   * @param uuid 従業員UUID
   * @return void
   */
  @DeleteMapping("{uuid}")
  public ResponseEntity<Void> deleteByUuid(@PathVariable("uuid") String uuid) {
    employeeService.deleteEmployeeByUuid(uuid);
    return ResponseEntity.ok().build();
  }
}
