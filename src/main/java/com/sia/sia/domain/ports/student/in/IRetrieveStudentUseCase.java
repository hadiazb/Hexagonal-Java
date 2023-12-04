package com.sia.sia.domain.ports.student.in;

import java.util.List;
import java.util.Optional;

import com.sia.sia.domain.models.student.StudentModel;

public interface IRetrieveStudentUseCase {
  Optional<StudentModel> getStudentById(Long id);

  List<StudentModel> getAllStudents();
}
