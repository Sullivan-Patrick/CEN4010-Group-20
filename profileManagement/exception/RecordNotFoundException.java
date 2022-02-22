package com.cen4010.bookstore.profileManagement.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RecordNotFoundException extends RuntimeException{

  private String message;

  private String variable;
}
