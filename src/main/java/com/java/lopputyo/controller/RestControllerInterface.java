package com.java.lopputyo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.java.lopputyo.model.ClassRoomCourse;
import com.java.lopputyo.model.Course;
import com.java.lopputyo.model.OnlineCourse;
import com.java.lopputyo.model.Student;

public interface RestControllerInterface {

    // Student CRUD operations
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents();

    @PostMapping("/students/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student);

    @GetMapping("/students/get/{id}")
    public ResponseEntity<Student> getStudentByID(@PathVariable int id);

    @GetMapping("/students/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id);

    @PostMapping("/students/update") // Uses studentId to update... send full copy of student with modification or lose data
    public ResponseEntity<String> updateStudent(@RequestBody Student student);

    // Course CRUD operations
    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getCourses();

    @PostMapping("/courses/add/online")
    public ResponseEntity<String> addOnlineCourse(@RequestBody OnlineCourse course);

    @PostMapping("/courses/add/classroom")
    public ResponseEntity<String> addClassRoomCourse(@RequestBody ClassRoomCourse course);

    @GetMapping("/courses/get/{id}")
    public ResponseEntity<Course> getCourseByID(@PathVariable int id);

    @GetMapping("/courses/delete/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable int id);

    @PostMapping("/courses/update/online") //Uses courseId to update... send full copy of course with modification or lose data
    public ResponseEntity<String> updateOnlineCourse(@RequestBody OnlineCourse course);

    @PostMapping("/courses/update/classroom") //Uses courseId to update... send full copy of course with modification or lose data
    public ResponseEntity<String> updateClassroomCourse(@RequestBody ClassRoomCourse course);

    // Add student to course
    @GetMapping("/add/student/course/{studentId}/{courseId}")
    public ResponseEntity<String> addStudentToCourse(@PathVariable int studentId, @PathVariable int courseId);

    // Remove student from course
    @GetMapping("/remove/student/course/{studentId}/{courseId}")
    public ResponseEntity<String> removeStudentFromCourse(@PathVariable int studentId, @PathVariable int courseId);

}
