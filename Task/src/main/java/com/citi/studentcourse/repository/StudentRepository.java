package com.citi.studentcourse.repository;

import com.citi.studentcourse.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * The only repository in the app. There is no CourseRepository — course operations
 * mutate the embedded {@code courses} list on the owning Student and re-save the parent.
 */
@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
}
