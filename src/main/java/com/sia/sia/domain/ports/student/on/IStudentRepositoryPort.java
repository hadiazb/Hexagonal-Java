package com.sia.sia.domain.ports.student.on;

import java.util.List;
import java.util.Optional;

import com.sia.sia.domain.models.student.StudentModel;

public interface IStudentRepositoryPort {
  StudentModel save(StudentModel student);

  Optional<StudentModel> findById(Long id);

  List<StudentModel> findAll();

  Optional<StudentModel> update(StudentModel student);

  Optional<StudentModel> deleteById(Long id);
}
