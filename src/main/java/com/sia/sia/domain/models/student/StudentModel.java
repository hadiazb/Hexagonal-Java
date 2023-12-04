package com.sia.sia.domain.models.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class StudentModel {
  private Long id;
  private String name;
  private String lastName;
  private Long age;
  private String sex;
  private boolean alive;
}
