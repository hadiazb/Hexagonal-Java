package com.sia.sia.application.usecases.subject;

import com.sia.sia.domain.models.subject.SubjectModel;
import com.sia.sia.domain.ports.subject.in.ICreateSubjectUseCase;
import com.sia.sia.domain.ports.subject.on.ISubjectRepositoryPort;

public class CreateSubjectUseCase implements ICreateSubjectUseCase {

  private final ISubjectRepositoryPort subjectRepositoryPort;

  public CreateSubjectUseCase(ISubjectRepositoryPort subjectRepositoryPort) {
    this.subjectRepositoryPort = subjectRepositoryPort;
  }

  @Override
  public SubjectModel createSubject(SubjectModel subject) {
    return subjectRepositoryPort.save(subject);
  }

}
