package com.sia.sia.domain.ports.student.in;

import com.sia.sia.domain.models.student.StudentModel;

public interface IDeleteStudentUseCase {
  StudentModel deleteStudent(Long id);
}
