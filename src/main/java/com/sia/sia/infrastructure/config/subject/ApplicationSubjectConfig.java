package com.sia.sia.infrastructure.config.subject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sia.sia.application.services.subject.SubjectService;
import com.sia.sia.application.usecases.subject.CreateSubjectUseCase;
import com.sia.sia.application.usecases.subject.DeleteSubjectUseCase;
import com.sia.sia.application.usecases.subject.RetrieverSubjectUseCase;
import com.sia.sia.application.usecases.subject.UpdateSubjectUseCase;
import com.sia.sia.domain.ports.subject.on.ISubjectRepositoryPort;
import com.sia.sia.infrastructure.repositories.Subject.SubjectRepositoryAdapter;

@Configuration
public class ApplicationSubjectConfig {

  @Bean
  public SubjectService subjectService(ISubjectRepositoryPort subjectRepositoryPort) {
    return new SubjectService(
        new CreateSubjectUseCase(subjectRepositoryPort),
        new DeleteSubjectUseCase(subjectRepositoryPort),
        new RetrieverSubjectUseCase(subjectRepositoryPort),
        new UpdateSubjectUseCase(subjectRepositoryPort));
  }

  @Bean
  public ISubjectRepositoryPort subjectRepositoryPort(SubjectRepositoryAdapter subjectRepositoryAdapter) {
    return subjectRepositoryAdapter;
  }
}
