package com.sia.sia.domain.ports.subject.in;

import java.util.Optional;

import com.sia.sia.domain.models.subject.SubjectModel;

public interface IUpdateSubjectUseCase {
  Optional<SubjectModel> updateSubject(SubjectModel updateSubject);
}
