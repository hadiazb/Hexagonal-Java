package com.sia.sia.infrastructure.repositories.Subject;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.sia.sia.domain.models.subject.SubjectModel;
import com.sia.sia.domain.ports.subject.on.ISubjectRepositoryPort;
import com.sia.sia.infrastructure.entities.subject.SubjectEntity;

@Component
public class SubjectRepositoryAdapter implements ISubjectRepositoryPort {

  private final SubjectRepository subjectRepository;

  public SubjectRepositoryAdapter(SubjectRepository subjectRepository) {
    this.subjectRepository = subjectRepository;
  }

  @Override
  public SubjectModel save(SubjectModel subject) {
    SubjectEntity subjectEntity = SubjectEntity.fromDomainModel(subject);
    SubjectEntity saveSubjectEntity = subjectRepository.save(subjectEntity);

    return saveSubjectEntity.toDomainModel();
  }

  @Override
  public Optional<SubjectModel> findById(Long id) {
    return subjectRepository.findById(id).map(SubjectEntity::toDomainModel);
  }

  @Override
  public List<SubjectModel> findAll() {
    return subjectRepository.findAll().stream().map(SubjectEntity::toDomainModel).collect(Collectors.toList());
  }

  @Override
  public Optional<SubjectModel> update(SubjectModel subject) {
    if (subjectRepository.existsById(subject.getId())) {
      SubjectEntity subjectEntity = SubjectEntity.fromDomainModel(subject);
      SubjectEntity updateSubjectEntity = subjectRepository.save(subjectEntity);

      return Optional.of(updateSubjectEntity.toDomainModel());
    }

    return Optional.empty();
  }

  @Override
  public SubjectModel deleteById(Long id) {
    if (subjectRepository.existsById(id)) {
      SubjectModel subject = this.findById(id).get();
      subjectRepository.deleteById(id);
      return subject;
    }

    return null;
  }

}
