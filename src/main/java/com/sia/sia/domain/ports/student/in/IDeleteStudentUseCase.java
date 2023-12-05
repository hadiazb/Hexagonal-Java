package com.sia.sia.domain.ports.student.in;

import java.util.Optional;

import com.sia.sia.domain.models.student.StudentModel;

public interface IDeleteStudentUseCase {
  Optional<StudentModel> deleteStudent(Long id);
}
