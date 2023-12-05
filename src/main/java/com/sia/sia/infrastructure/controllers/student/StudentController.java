package com.sia.sia.infrastructure.controllers.student;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.sia.sia.SiaApplication;
import com.sia.sia.application.services.student.StudentService;
import com.sia.sia.domain.models.student.StudentModel;

@RestController
@RequestMapping("/api/student")
public class StudentController {

  @Autowired
  private StudentService studentService;

  private final Logger logger = LoggerFactory.getLogger(SiaApplication.class);

  @GetMapping({ "/", "" })
  public ResponseEntity<List<StudentModel>> findAll() {
    try {
      List<StudentModel> students = studentService.getAllStudents();
      return new ResponseEntity<List<StudentModel>>(students, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<StudentModel> find(@PathVariable Long id) {
    try {
      return studentService.getStudentById(id)
          .map(student -> new ResponseEntity<StudentModel>(student, HttpStatus.OK))
          .orElse(new ResponseEntity<StudentModel>(HttpStatus.NOT_FOUND));
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping({ "/", "" })
  public ResponseEntity<StudentModel> create(@RequestBody StudentModel student) {
    try {
      StudentModel newStudent = studentService.createStudent(student);
      return new ResponseEntity<StudentModel>(newStudent, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping({ "/", "" })
  public ResponseEntity<StudentModel> update(@RequestBody StudentModel student) {
    try {
      return studentService.updateStudent(student)
          .map(newStudent -> new ResponseEntity<StudentModel>(newStudent, HttpStatus.OK))
          .orElse(new ResponseEntity<StudentModel>(HttpStatus.NOT_FOUND));
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<StudentModel> delete(@PathVariable Long id) {
    try {
      return studentService.deleteStudent(id)
          .map(student -> new ResponseEntity<StudentModel>(student, HttpStatus.OK))
          .orElse(new ResponseEntity<StudentModel>(HttpStatus.NOT_FOUND));
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
