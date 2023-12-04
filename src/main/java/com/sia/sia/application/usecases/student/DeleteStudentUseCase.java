package com.sia.sia.application.usecases.student;

import com.sia.sia.domain.models.student.StudentModel;
import com.sia.sia.domain.ports.student.in.IDeleteStudentUseCase;
import com.sia.sia.domain.ports.student.on.IStudentRepositoryPort;

public class DeleteStudentUseCase implements IDeleteStudentUseCase {

  private final IStudentRepositoryPort studentRepositoryPort;

  public DeleteStudentUseCase(IStudentRepositoryPort studentRepositoryPort) {
    this.studentRepositoryPort = studentRepositoryPort;
  }

  @Override
  public StudentModel deleteStudent(Long id) {
    return studentRepositoryPort.deleteById(id);
  }

}
