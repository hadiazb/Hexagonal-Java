package com.sia.sia.infrastructure.entities.student;

import java.io.Serializable;

import com.sia.sia.domain.models.student.StudentModel;

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
@Table(name = "student")
public class StudentEntity implements Serializable {

  public static StudentEntity fromDomainModel(StudentModel student) {
    return new StudentEntity(student.getId(), student.getName(), student.getLastName(), student.getAge(),
        student.getSex(), student.isAlive());
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "student_sequence")
  @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 100)
  private Long id;
  @Column(name = "name")
  private String name;
  @Column(name = "lastName")
  private String lastName;
  @Column(name = "age")
  private Long age;
  @Column(name = "sex")
  private String sex;
  @Column(name = "alive")
  private boolean alive;

  public StudentModel toDomainModel() {
    return new StudentModel(id, name, lastName, age, sex, alive);
  }

}