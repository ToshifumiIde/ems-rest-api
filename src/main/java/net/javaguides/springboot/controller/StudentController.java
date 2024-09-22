package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {


  @GetMapping("student")
  public ResponseEntity<Student> getStudent() {
    Student student = new Student(1, "Ramesh", "Fadatare");
    //  return new ResponseEntity<>(student , HttpStatus.OK);
    return ResponseEntity
      .ok()
      .header("CustomHeader", "Custom Value")
      .body(student);
  }

  @GetMapping
  public ResponseEntity<List<Student>> getStudents() {
    List students = new ArrayList<>();
    students.add(new Student(1, "Ramesh", "Fadatare"));
    students.add(new Student(2, "umesh", "Fadatare"));
    students.add(new Student(3, "Ramesh", "Jadhav"));
    students.add(new Student(4, "Sanjay", "Pawar"));
    return ResponseEntity.ok(students);
  }

  @PostMapping
  public ResponseEntity<Student> createStudentByRequestBody(@RequestBody Student student) {
    System.out.println(student.getId());
    System.out.println(student.getLastName());
    System.out.println(student.getFirstName());
    return new ResponseEntity<>(student, HttpStatus.CREATED);
  }

  // {id} - path variable
  // @PathVariable
  @GetMapping("{id}")
//  public Student getStudentByPathVariable(@PathVariable("id") int id){
//    return new Student(id , "Ramesh" , "Fadatare");
//  }
  public ResponseEntity<Student> getStudentByPathVariable(@PathVariable("id") int id) {
    Student student = new Student(id, "Ramesh", "Fadatare");
    return new ResponseEntity<>(student, HttpStatus.OK);
  }

  @PutMapping("{id}")
  public ResponseEntity<Student> putStudentById(@PathVariable("id") int id, @RequestBody Student student) {
    System.out.println(student.getId());
    System.out.println(student.getLastName());
    System.out.println(student.getFirstName());
    return ResponseEntity.ok(student);
  }


  @DeleteMapping("{id}")
  public ResponseEntity<String> deleteStudentById(@PathVariable("id") int id) {
    System.out.println(id);
    return ResponseEntity.ok("delete success");
  }


  @GetMapping("{id}/{first-name}/{last-name}")
  public ResponseEntity<Student> getStudentByPathVariables(
    @PathVariable("id") int id,
    @PathVariable("first-name") String firstName,
    @PathVariable("last-name") String lastName
  ) {
    Student student = new Student(id, firstName, lastName);
    return ResponseEntity.ok(student);
  }

  @GetMapping("query")
  public ResponseEntity<Student> getStudentByRequestParam(
    @RequestParam int id,
    @RequestParam String firstName,
    @RequestParam String lastName
  ) {
    Student student = new Student(id, firstName, lastName);
    return ResponseEntity.ok(student);
  }
}
