package com.sia.sia.domain.models.subject;

import java.util.Date;

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
  private String author;
  private Date dateOfAppearance;
}
