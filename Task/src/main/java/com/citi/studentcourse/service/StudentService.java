package com.citi.studentcourse.service;

import com.citi.studentcourse.exception.ResourceNotFoundException;
import com.citi.studentcourse.model.Course;
import com.citi.studentcourse.model.Student;
import com.citi.studentcourse.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // ---------- Student-level operations ----------

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(String id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
    }

    public Student updateStudent(String id, Student updated) {
        Student existing = getStudentById(id);
        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setDepartment(updated.getDepartment());
        if (updated.getCourses() != null) {
            existing.setCourses(updated.getCourses());
        }
        return studentRepository.save(existing);
    }

    public Student patchStudent(String id, Student patch) {
        Student existing = getStudentById(id);
        if (patch.getName() != null) {
            existing.setName(patch.getName());
        }
        if (patch.getEmail() != null) {
            existing.setEmail(patch.getEmail());
        }
        if (patch.getDepartment() != null) {
            existing.setDepartment(patch.getDepartment());
        }
        if (patch.getCourses() != null && !patch.getCourses().isEmpty()) {
            existing.setCourses(patch.getCourses());
        }
        return studentRepository.save(existing);
    }

    public void deleteStudent(String id) {
        Student existing = getStudentById(id);
        studentRepository.delete(existing);
    }

    // ---------- Course-level operations (mutate embedded list, re-save parent) ----------

    public Student addCourse(String studentId, Course course) {
        Student student = getStudentById(studentId);
        boolean exists = student.getCourses().stream()
                .anyMatch(c -> c.getCourseId().equals(course.getCourseId()));
        if (exists) {
            throw new IllegalArgumentException(
                    "Course already exists with courseId: " + course.getCourseId());
        }
        student.getCourses().add(course);
        return studentRepository.save(student);
    }

    public List<Course> getCourses(String studentId) {
        return getStudentById(studentId).getCourses();
    }

    public Course getCourse(String studentId, String courseId) {
        return findCourse(getStudentById(studentId), courseId);
    }

    public Course updateCourse(String studentId, String courseId, Course updated) {
        Student student = getStudentById(studentId);
        Course course = findCourse(student, courseId);
        course.setCourseName(updated.getCourseName());
        course.setCredits(updated.getCredits());
        course.setGrade(updated.getGrade());
        studentRepository.save(student);
        return course;
    }

    public void deleteCourse(String studentId, String courseId) {
        Student student = getStudentById(studentId);
        Course course = findCourse(student, courseId);
        student.getCourses().remove(course);
        studentRepository.save(student);
    }

    private Course findCourse(Student student, String courseId) {
        return student.getCourses().stream()
                .filter(c -> c.getCourseId().equals(courseId))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Course not found with courseId: " + courseId
                                + " for student: " + student.getId()));
    }
}
