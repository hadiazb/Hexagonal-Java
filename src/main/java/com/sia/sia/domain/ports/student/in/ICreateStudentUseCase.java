package com.sia.sia.domain.ports.student.in;

import com.sia.sia.domain.models.student.StudentModel;

public interface ICreateStudentUseCase {
  StudentModel createStudent(StudentModel student);
}
