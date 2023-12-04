package com.sia.sia.application.usecases.student;

import com.sia.sia.domain.models.student.StudentModel;
import com.sia.sia.domain.ports.student.in.ICreateStudentUseCase;
import com.sia.sia.domain.ports.student.on.IStudentRepositoryPort;

public class CreateStudentUseCase implements ICreateStudentUseCase {

  private final IStudentRepositoryPort studentRepositoryPort;

  public CreateStudentUseCase(IStudentRepositoryPort studentRepositoryPort) {
    this.studentRepositoryPort = studentRepositoryPort;
  }

  @Override
  public StudentModel createStudent(StudentModel student) {
    return studentRepositoryPort.save(student);
  }

}
