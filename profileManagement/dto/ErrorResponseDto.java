package com.cen4010.bookstore.profileManagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ErrorResponseDto {

  private final String message;

  private final String variable;

  @JsonProperty("error_code")
  private final String errorCode;
}
