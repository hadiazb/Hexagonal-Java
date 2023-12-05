package com.sia.sia.application.services.subject;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sia.sia.application.usecases.subject.CreateSubjectUseCase;
import com.sia.sia.application.usecases.subject.DeleteSubjectUseCase;
import com.sia.sia.application.usecases.subject.RetrieverSubjectUseCase;
import com.sia.sia.application.usecases.subject.UpdateSubjectUseCase;
import com.sia.sia.domain.models.subject.SubjectModel;
import com.sia.sia.domain.ports.subject.in.ICreateSubjectUseCase;
import com.sia.sia.domain.ports.subject.in.IDeleteSubjectUseCase;
import com.sia.sia.domain.ports.subject.in.IRetrieveSubjectUseCase;
import com.sia.sia.domain.ports.subject.in.IUpdateSubjectUseCase;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SubjectService
    implements ICreateSubjectUseCase, IDeleteSubjectUseCase, IRetrieveSubjectUseCase, IUpdateSubjectUseCase {

  private final CreateSubjectUseCase createSubjectUseCase;
  private final DeleteSubjectUseCase deleteSubjectUseCase;
  private final RetrieverSubjectUseCase retrieverSubjectUseCase;
  private final UpdateSubjectUseCase updateSubjectUseCase;

  public SubjectService(
      CreateSubjectUseCase createSubjectUseCase,
      DeleteSubjectUseCase deleteSubjectUseCase,
      RetrieverSubjectUseCase retrieverSubjectUseCase,
      UpdateSubjectUseCase updateSubjectUseCase) {
    this.createSubjectUseCase = createSubjectUseCase;
    this.deleteSubjectUseCase = deleteSubjectUseCase;
    this.retrieverSubjectUseCase = retrieverSubjectUseCase;
    this.updateSubjectUseCase = updateSubjectUseCase;
  }

  @Override
  public Optional<SubjectModel> updateSubject(SubjectModel updateSubject) {
    return updateSubjectUseCase.updateSubject(updateSubject);
  }

  @Override
  public Optional<SubjectModel> getSubjectById(Long id) {
    return retrieverSubjectUseCase.getSubjectById(id);
  }

  @Override
  public List<SubjectModel> getAllSubjects() {
    return retrieverSubjectUseCase.getAllSubjects();
  }

  @Override
  public Optional<SubjectModel> deleteSubject(Long id) {
    return deleteSubjectUseCase.deleteSubject(id);
  }

  @Override
  public SubjectModel createSubject(SubjectModel subject) {
    return createSubjectUseCase.createSubject(subject);
  }

}
