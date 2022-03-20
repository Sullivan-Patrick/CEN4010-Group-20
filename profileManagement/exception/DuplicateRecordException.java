package com.cen4010.bookstore.profileManagement.exception;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class DuplicateRecordException extends RuntimeException {

  private final String message;
  private final String variable;

}
