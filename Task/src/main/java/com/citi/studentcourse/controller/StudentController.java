package com.citi.studentcourse.controller;

import com.citi.studentcourse.model.Course;
import com.citi.studentcourse.model.Student;
import com.citi.studentcourse.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // ---------- Student endpoints ----------

    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
        return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable String id,
                                                 @Valid @RequestBody Student student) {
        return ResponseEntity.ok(studentService.updateStudent(id, student));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Student> patchStudent(@PathVariable String id,
                                                @RequestBody Student patch) {
        return ResponseEntity.ok(studentService.patchStudent(id, patch));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    // ---------- Course endpoints ----------

    @PostMapping("/{id}/courses")
    public ResponseEntity<Student> addCourse(@PathVariable String id,
                                             @Valid @RequestBody Course course) {
        return new ResponseEntity<>(studentService.addCourse(id, course), HttpStatus.CREATED);
    }

    @GetMapping("/{id}/courses")
    public ResponseEntity<List<Course>> getCourses(@PathVariable String id) {
        return ResponseEntity.ok(studentService.getCourses(id));
    }

    @GetMapping("/{id}/courses/{courseId}")
    public ResponseEntity<Course> getCourse(@PathVariable String id,
                                            @PathVariable String courseId) {
        return ResponseEntity.ok(studentService.getCourse(id, courseId));
    }

    @PutMapping("/{id}/courses/{courseId}")
    public ResponseEntity<Course> updateCourse(@PathVariable String id,
                                               @PathVariable String courseId,
                                               @Valid @RequestBody Course course) {
        return ResponseEntity.ok(studentService.updateCourse(id, courseId, course));
    }

    @DeleteMapping("/{id}/courses/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String id,
                                             @PathVariable String courseId) {
        studentService.deleteCourse(id, courseId);
        return ResponseEntity.noContent().build();
    }
}
