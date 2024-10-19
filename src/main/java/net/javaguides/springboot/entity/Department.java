package net.javaguides.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
  private int id;
  private String uuid;
  private String name;
  private String description;

  public Department(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public Department(String uuid , String name , String description){
    this.uuid = uuid;
    this.name = name;
    this.description = description;
  }
}
