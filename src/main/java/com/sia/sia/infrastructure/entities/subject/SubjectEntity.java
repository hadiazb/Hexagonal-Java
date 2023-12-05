package com.sia.sia.infrastructure.entities.subject;

import java.io.Serializable;

import com.sia.sia.domain.models.subject.SubjectModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "subject")
public class SubjectEntity implements Serializable {
  public static SubjectEntity fromDomainModel(SubjectModel subject) {
    return new SubjectEntity(subject.getId(), subject.getName(), subject.getDescription(), subject.getTeacher(),
        subject.getScheduleLong());
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "subject_sequence")
  @SequenceGenerator(name = "subject_sequence", sequenceName = "subject_sequence", allocationSize = 100)
  private Long id;
  @Column(name = "name")
  private String name;
  @Column(name = "description")
  private String description;
  @Column(name = "teacher")
  private String teacher;
  @Column(name = "scheduleLong")
  private Long scheduleLong;

  public SubjectModel toDomainModel() {
    return new SubjectModel(id, name, description, teacher, scheduleLong);
  }

}