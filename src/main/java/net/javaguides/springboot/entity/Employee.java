package net.javaguides.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
  private int id;
  private String uuid;
  private String firstName;
  private String lastName;
  private String email;
  private int departmentId;
  private String departmentUuid;

  public Employee(String uuid, String firstName, String lastName, String email , int departmentId) {
    this.uuid = uuid;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.departmentId = departmentId;
  }

  public Employee(String firstName, String lastName, String email , int departmentId) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.departmentId = departmentId;
  }
}
