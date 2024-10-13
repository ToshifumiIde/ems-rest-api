package net.javaguides.springboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Setter;

@Setter
@Schema(name = "DepartmentUpdateDto", description = "部署更新用Dto")
public class DepartmentUpdateDto {

  private String name;
  private String description;

  public DepartmentUpdateDto(String name, String description) {
    this.name = name;
    this.description = description;
  }

  @NotNull
  @Size(min = 1, max = 255)
  @Schema(name = "name", example = "開発部", description = "部署名")
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @NotNull
  @Size(min = 1, max = 255)
  @Schema(name = "description", example = "プロダクトの開発を行います", description = "部署の説明")
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }
}

