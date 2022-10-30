package com.java.lopputyo.model;

public class OnlineCourse extends Course {

    private String coursePlatform;

    OnlineCourse() {
        this("def", "def", "def");
    };

    OnlineCourse(String courseName, String courseTeacher, String coursePlatform) {
        super(courseName, courseTeacher);
        this.coursePlatform = coursePlatform;

    }

    public String getCoursePlatform() {
        return this.coursePlatform;
    }

    public void setCoursePlatform(String coursePlatform) {
        this.coursePlatform = coursePlatform;
    }
}
