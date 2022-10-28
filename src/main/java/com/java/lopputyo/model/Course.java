package com.java.lopputyo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Course implements Serializable{
    int courseId;
    String courseName;
    String courseTeacher;
    List<Integer> CourseStudents = new ArrayList<>();

    private static int count = 0;

    public Course() {
        this(" ", " ");
    }

    public Course(String courseName, String courseTeacher) {
        this.courseName = courseName;
        this.courseTeacher = courseTeacher;
        courseId = count++;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseTeacher() {
        return this.courseTeacher;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    public int getCourseId() {
        return this.courseId;
    }
    public void setStudents(Integer StudentId){
        CourseStudents.add(StudentId);
    }
    public List<Integer> getCourseStudents(){
        return CourseStudents;
    }
}
