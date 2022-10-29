package com.java.lopputyo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {

     long studentId;
     String fname;
     String lname;
     String email;
     List<Integer> studentCourses = new ArrayList<>();

     static int count = 0;

    public Student(){
        this(" ", " ", " ");
    }

    public Student(String fname, String lname, String email) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        studentId = count++;
      
    }
    public String getFname() {
        return this.fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return this.lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public int getStudentId() {
        return this.studentId;
    }
    public void setCourse(Integer courseId){
        
        studentCourses.add(courseId);
    }
    public List<Integer> getStudentCourses(){
        return studentCourses;
    }
}
