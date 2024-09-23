package net.javaguides.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeReadDto {
  private String uuid;
  private String firstName;
  private String lastName;
  private String email;
}
