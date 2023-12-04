package com.sia.sia.application.usecases.subject;

import java.util.Optional;

import com.sia.sia.domain.models.subject.SubjectModel;
import com.sia.sia.domain.ports.subject.in.IUpdateSubjectUseCase;
import com.sia.sia.domain.ports.subject.on.ISubjectRepositoryPort;

public class UpdateSubjectUseCase implements IUpdateSubjectUseCase {

  private final ISubjectRepositoryPort subjectRepositoryPort;

  public UpdateSubjectUseCase(ISubjectRepositoryPort subjectRepositoryPort) {
    this.subjectRepositoryPort = subjectRepositoryPort;
  }

  @Override
  public Optional<SubjectModel> updateSubject(SubjectModel updateSubject) {
    return subjectRepositoryPort.update(updateSubject);
  }

}
