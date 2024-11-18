package com.tcs.krishna.restapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
 private Long id;
 private String name;
 @DateTimeFormat(pattern="yyyy-MM-dd")
 private LocalDate Dateofjoining;
 @JsonProperty("isActive")
 private boolean isActive;
}
