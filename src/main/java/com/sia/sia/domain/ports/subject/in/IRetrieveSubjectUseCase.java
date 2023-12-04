package com.sia.sia.domain.ports.subject.in;

import java.util.List;
import java.util.Optional;

import com.sia.sia.domain.models.subject.SubjectModel;

public interface IRetrieveSubjectUseCase {
  Optional<SubjectModel> getSubjectById(Long id);

  List<SubjectModel> getAllSubjects();
}
