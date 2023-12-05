package com.sia.sia.application.usecases.subject;

import java.util.Optional;

import com.sia.sia.domain.models.subject.SubjectModel;
import com.sia.sia.domain.ports.subject.in.IDeleteSubjectUseCase;
import com.sia.sia.domain.ports.subject.on.ISubjectRepositoryPort;

public class DeleteSubjectUseCase implements IDeleteSubjectUseCase {

  private final ISubjectRepositoryPort subjectRepositoryPort;

  public DeleteSubjectUseCase(ISubjectRepositoryPort subjectRepositoryPort) {
    this.subjectRepositoryPort = subjectRepositoryPort;
  }

  @Override
  public Optional<SubjectModel> deleteSubject(Long id) {
    return subjectRepositoryPort.deleteById(id);
  }

}
