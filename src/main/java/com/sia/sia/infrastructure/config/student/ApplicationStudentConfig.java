package com.sia.sia.infrastructure.config.student;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sia.sia.application.services.student.StudentService;
import com.sia.sia.application.usecases.student.CreateStudentUseCase;
import com.sia.sia.application.usecases.student.DeleteStudentUseCase;
import com.sia.sia.application.usecases.student.RetrieverStudentUseCase;
import com.sia.sia.application.usecases.student.UpdateStudentUseCase;
import com.sia.sia.domain.ports.student.on.IStudentRepositoryPort;
import com.sia.sia.infrastructure.repositories.Student.StudentRepositoryAdapter;

@Configuration
public class ApplicationStudentConfig {
  @Bean
  public StudentService studentService(IStudentRepositoryPort studentRepositoryPort) {
    return new StudentService(
        new CreateStudentUseCase(studentRepositoryPort),
        new DeleteStudentUseCase(studentRepositoryPort),
        new UpdateStudentUseCase(studentRepositoryPort),
        new RetrieverStudentUseCase(studentRepositoryPort));
  }

  @Bean
  public IStudentRepositoryPort studentRepositoryPort(StudentRepositoryAdapter studentRepositoryAdapter) {
    return studentRepositoryAdapter;
  }
}
