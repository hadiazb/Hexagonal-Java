package com.sia.sia.application.usecases.subject;

import java.util.List;
import java.util.Optional;

import com.sia.sia.domain.models.subject.SubjectModel;
import com.sia.sia.domain.ports.subject.in.IRetrieveSubjectUseCase;
import com.sia.sia.domain.ports.subject.on.ISubjectRepositoryPort;

public class RetrieverSubjectUseCase implements IRetrieveSubjectUseCase {

  private final ISubjectRepositoryPort subjectRepositoryPort;

  public RetrieverSubjectUseCase(ISubjectRepositoryPort subjectRepositoryPort) {
    this.subjectRepositoryPort = subjectRepositoryPort;
  }

  @Override
  public Optional<SubjectModel> getSubjectById(Long id) {
    return subjectRepositoryPort.findById(id);
  }

  @Override
  public List<SubjectModel> getAllSubjects() {
    return subjectRepositoryPort.findAll();
  }

}
