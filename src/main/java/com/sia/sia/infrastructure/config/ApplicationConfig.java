package com.sia.sia.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sia.sia.application.services.student.StudentService;
import com.sia.sia.application.services.subject.SubjectService;
import com.sia.sia.application.usecases.student.CreateStudentUseCase;
import com.sia.sia.application.usecases.student.DeleteStudentUseCase;
import com.sia.sia.application.usecases.student.RetrieverStudentUseCase;
import com.sia.sia.application.usecases.student.UpdateStudentUseCase;
import com.sia.sia.application.usecases.subject.CreateSubjectUseCase;
import com.sia.sia.application.usecases.subject.DeleteSubjectUseCase;
import com.sia.sia.application.usecases.subject.RetrieverSubjectUseCase;
import com.sia.sia.application.usecases.subject.UpdateSubjectUseCase;
import com.sia.sia.domain.ports.student.on.IStudentRepositoryPort;
import com.sia.sia.domain.ports.subject.on.ISubjectRepositoryPort;
import com.sia.sia.infrastructure.repositories.Student.StudentRepositoryAdapter;
import com.sia.sia.infrastructure.repositories.Subject.SubjectRepositoryAdapter;

@Configuration
public class ApplicationConfig {
  @Bean
  public StudentService studentService(IStudentRepositoryPort studentRepositoryPort) {
    return new StudentService(
        new CreateStudentUseCase(studentRepositoryPort),
        new DeleteStudentUseCase(studentRepositoryPort),
        new UpdateStudentUseCase(studentRepositoryPort),
        new RetrieverStudentUseCase(studentRepositoryPort));
  }

  @Bean
  public SubjectService subjectService(ISubjectRepositoryPort subjectRepositoryPort) {
    return new SubjectService(
        new CreateSubjectUseCase(subjectRepositoryPort),
        new DeleteSubjectUseCase(subjectRepositoryPort),
        new RetrieverSubjectUseCase(subjectRepositoryPort),
        new UpdateSubjectUseCase(subjectRepositoryPort));
  }

  @Bean
  public IStudentRepositoryPort studentRepositoryPort(StudentRepositoryAdapter studentRepositoryAdapter) {
    return studentRepositoryAdapter;
  }

  @Bean
  public ISubjectRepositoryPort subjectRepositoryPort(SubjectRepositoryAdapter subjectRepositoryAdapter) {
    return subjectRepositoryAdapter;
  }
}
