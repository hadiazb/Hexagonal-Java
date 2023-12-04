package com.sia.sia.domain.ports.student.in;

import java.util.Optional;

import com.sia.sia.domain.models.student.StudentModel;

public interface IUpdateStudentUseCase {
  Optional<StudentModel> updateStudent(StudentModel updateStudent);
}
