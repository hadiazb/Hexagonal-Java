package com.sia.sia.domain.ports.subject.in;

import java.util.Optional;

import com.sia.sia.domain.models.subject.SubjectModel;

public interface IDeleteSubjectUseCase {
  Optional<SubjectModel> deleteSubject(Long id);
}
