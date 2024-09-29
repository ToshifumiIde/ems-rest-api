package net.javaguides.springboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EmployeeUpdateDto {
  private String firstName;
  private String lastName;
  private String email;

  public EmployeeUpdateDto(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  @NotNull
  @Size(min = 1, max = 255)
  @Schema(name = "firstName", example = "太郎", description = "姓名_名", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("firstName")
  public String getFirstName() {
    return firstName;
  }

  @NotNull
  @Size(min = 1, max = 255)
  @Schema(name = "lastName", example = "山田", description = "姓名_姓", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("lastName")
  public String getLastName() {
    return lastName;
  }

  @NotNull
  @Size(min = 1, max = 255)
  @Schema(name = "email", example = "yamada@gmail.com", description = "メールアドレス", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }
}
