package com.sia.sia.domain.ports.subject.on;

import java.util.List;
import java.util.Optional;

import com.sia.sia.domain.models.subject.SubjectModel;

public interface ISubjectRepositoryPort {
  SubjectModel save(SubjectModel subject);

  Optional<SubjectModel> findById(Long id);

  List<SubjectModel> findAll();

  Optional<SubjectModel> update(SubjectModel subject);

  Optional<SubjectModel> deleteById(Long id);
}
