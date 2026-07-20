package com.citi.studentcourse.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Embedded document stored inside the {@code courses} array of a {@link Student}.
 * This is intentionally NOT a {@code @Document} — courses have no collection of their own.
 */
public class Course {

    @NotBlank(message = "courseId is required")
    private String courseId;

    @NotBlank(message = "courseName is required")
    private String courseName;

    @NotNull(message = "credits is required")
    @Min(value = 1, message = "credits must be at least 1")
    @Max(value = 6, message = "credits must be at most 6")
    private Integer credits;

    @NotBlank(message = "grade is required")
    private String grade;

    public Course() {
    }

    public Course(String courseId, String courseName, Integer credits, String grade) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
        this.grade = grade;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
