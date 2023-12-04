package com.sia.sia.application.usecases.student;

import java.util.List;
import java.util.Optional;

import com.sia.sia.domain.models.student.StudentModel;
import com.sia.sia.domain.ports.student.in.IRetrieveStudentUseCase;
import com.sia.sia.domain.ports.student.on.IStudentRepositoryPort;

public class RetrieverStudentUseCase implements IRetrieveStudentUseCase {

  private final IStudentRepositoryPort studentRepositoryPort;

  public RetrieverStudentUseCase(IStudentRepositoryPort studentRepositoryPort) {
    this.studentRepositoryPort = studentRepositoryPort;
  }

  @Override
  public Optional<StudentModel> getStudentById(Long id) {
    return studentRepositoryPort.findById(id);
  }

  @Override
  public List<StudentModel> getAllStudents() {
    return studentRepositoryPort.findAll();
  }

}
