package com.sia.sia.domain.models.subject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SubjectModel {
  private Long id;
  private String name;
  private String description;
  private String teacher;
  private Long scheduleLong;
}
