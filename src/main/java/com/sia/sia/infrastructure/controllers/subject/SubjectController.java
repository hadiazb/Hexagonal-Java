package com.sia.sia.infrastructure.controllers.subject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sia.sia.application.services.subject.SubjectService;
import com.sia.sia.domain.models.subject.SubjectModel;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

  @Autowired
  private SubjectService subjectService;

  @GetMapping({ "/", "" })
  public ResponseEntity<List<SubjectModel>> findAll() {
    try {
      List<SubjectModel> subjects = subjectService.getAllSubjects();
      return new ResponseEntity<List<SubjectModel>>(subjects, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<SubjectModel> find(@PathVariable Long id) {
    try {
      return subjectService.getSubjectById(id)
          .map(subject -> new ResponseEntity<SubjectModel>(subject, HttpStatus.OK))
          .orElse(new ResponseEntity<SubjectModel>(HttpStatus.NOT_FOUND));
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping()
  public ResponseEntity<SubjectModel> create(@RequestBody SubjectModel subject) {
    try {
      SubjectModel newSubject = subjectService.createSubject(subject);
      return new ResponseEntity<SubjectModel>(newSubject, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping()
  public ResponseEntity<SubjectModel> update(@RequestBody SubjectModel subject) {
    try {
      return subjectService.updateSubject(subject)
          .map(updateSubject -> new ResponseEntity<SubjectModel>(updateSubject, HttpStatus.OK))
          .orElse(new ResponseEntity<SubjectModel>(HttpStatus.NOT_FOUND));
    } catch (Exception e) {
      return new ResponseEntity<SubjectModel>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<SubjectModel> delete(@PathVariable Long id) {
    try {
      return subjectService.deleteSubject(id)
          .map(subject -> new ResponseEntity<SubjectModel>(subject, HttpStatus.OK))
          .orElse(new ResponseEntity<SubjectModel>(HttpStatus.NOT_FOUND));
    } catch (Exception e) {
      return new ResponseEntity<SubjectModel>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
