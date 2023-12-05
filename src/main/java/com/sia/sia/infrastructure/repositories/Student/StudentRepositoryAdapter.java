package com.sia.sia.infrastructure.repositories.Student;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.sia.sia.domain.models.student.StudentModel;
import com.sia.sia.domain.ports.student.on.IStudentRepositoryPort;
import com.sia.sia.infrastructure.entities.student.StudentEntity;

@Component
public class StudentRepositoryAdapter implements IStudentRepositoryPort {

  private final StudentRepository studentRepository;

  public StudentRepositoryAdapter(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Override
  public StudentModel save(StudentModel student) {
    StudentEntity studentEntity = StudentEntity.fromDomainModel(student);
    StudentEntity saveStudentEntity = studentRepository.save(studentEntity);
    return saveStudentEntity.toDomainModel();
  }

  @Override
  public Optional<StudentModel> findById(Long id) {
    return studentRepository.findById(id).map(StudentEntity::toDomainModel);
  }

  @Override
  public List<StudentModel> findAll() {
    return studentRepository.findAll().stream().map(StudentEntity::toDomainModel).collect(Collectors.toList());
  }

  @Override
  public Optional<StudentModel> update(StudentModel student) {
    if (studentRepository.existsById(student.getId())) {
      StudentEntity studentEntity = StudentEntity.fromDomainModel(student);
      StudentEntity updateStudentEntity = studentRepository.save(studentEntity);

      return Optional.of(updateStudentEntity.toDomainModel());
    }

    return Optional.empty();

  }

  @Override
  public Optional<StudentModel> deleteById(Long id) {
    if (studentRepository.existsById(id)) {
      StudentModel student = this.findById(id).get();
      studentRepository.deleteById(id);
      return Optional.of(student);
    }

    return Optional.empty();
  }

}
