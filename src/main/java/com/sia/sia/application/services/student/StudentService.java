package com.sia.sia.application.services.student;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sia.sia.application.usecases.student.CreateStudentUseCase;
import com.sia.sia.application.usecases.student.DeleteStudentUseCase;
import com.sia.sia.application.usecases.student.RetrieverStudentUseCase;
import com.sia.sia.application.usecases.student.UpdateStudentUseCase;
import com.sia.sia.domain.models.student.StudentModel;
import com.sia.sia.domain.ports.student.in.ICreateStudentUseCase;
import com.sia.sia.domain.ports.student.in.IDeleteStudentUseCase;
import com.sia.sia.domain.ports.student.in.IRetrieveStudentUseCase;
import com.sia.sia.domain.ports.student.in.IUpdateStudentUseCase;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentService
    implements ICreateStudentUseCase, IDeleteStudentUseCase, IUpdateStudentUseCase, IRetrieveStudentUseCase {

  private final CreateStudentUseCase createStudentUseCase;
  private final DeleteStudentUseCase deleteStudentUseCase;
  private final RetrieverStudentUseCase retrieveStudentUseCase;
  private final UpdateStudentUseCase updateStudentUseCase;

  public StudentService(
      CreateStudentUseCase createStudentUseCase,
      DeleteStudentUseCase deleteStudentUseCase,
      UpdateStudentUseCase updateStudentUseCase,
      RetrieverStudentUseCase retrieveStudentUseCase) {
    this.createStudentUseCase = createStudentUseCase;
    this.deleteStudentUseCase = deleteStudentUseCase;
    this.retrieveStudentUseCase = retrieveStudentUseCase;
    this.updateStudentUseCase = updateStudentUseCase;
  }

  @Override
  public Optional<StudentModel> updateStudent(StudentModel updateStudent) {
    return updateStudentUseCase.updateStudent(updateStudent);
  }

  @Override
  public Optional<StudentModel> getStudentById(Long id) {
    return retrieveStudentUseCase.getStudentById(id);
  }

  @Override
  public List<StudentModel> getAllStudents() {
    return retrieveStudentUseCase.getAllStudents();
  }

  @Override
  public Optional<StudentModel> deleteStudent(Long id) {
    return deleteStudentUseCase.deleteStudent(id);
  }

  @Override
  public StudentModel createStudent(StudentModel student) {
    return createStudentUseCase.createStudent(student);
  }

}
