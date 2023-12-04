package com.sia.sia.domain.ports.subject.in;

import com.sia.sia.domain.models.subject.SubjectModel;

public interface ICreateSubjectUseCase {
  SubjectModel createSubject(SubjectModel subject);
}
