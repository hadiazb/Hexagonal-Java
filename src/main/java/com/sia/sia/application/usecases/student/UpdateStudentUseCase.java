package com.sia.sia.application.usecases.student;

import java.util.Optional;

import com.sia.sia.domain.models.student.StudentModel;
import com.sia.sia.domain.ports.student.in.IUpdateStudentUseCase;
import com.sia.sia.domain.ports.student.on.IStudentRepositoryPort;

public class UpdateStudentUseCase implements IUpdateStudentUseCase {

  private final IStudentRepositoryPort studentRepositoryPort;

  public UpdateStudentUseCase(IStudentRepositoryPort studentRepositoryPort) {
    this.studentRepositoryPort = studentRepositoryPort;
  }

  @Override
  public Optional<StudentModel> updateStudent(StudentModel updateStudent) {
    return studentRepositoryPort.update(updateStudent);
  }

}
