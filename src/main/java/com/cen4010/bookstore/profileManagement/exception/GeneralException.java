package com.cen4010.bookstore.profileManagement.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

  private final String message;
  private final String variable;

}
