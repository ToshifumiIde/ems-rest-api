package net.javaguides.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DepartmentListDto {
  private String uuid;
  private String name;
}
