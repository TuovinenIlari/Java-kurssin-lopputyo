package com.java.lopputyo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.lopputyo.model.ClassRoomCourse;
import com.java.lopputyo.model.Course;
import com.java.lopputyo.model.OnlineCourse;
import com.java.lopputyo.model.Student;
import com.java.lopputyo.service.CourseService;
import com.java.lopputyo.service.StudentService;

@RestController
public class LopputyoController implements RestControllerInterface {

    @Autowired
    StudentService myStudentService;
    @Autowired
    CourseService myCourseService;

    // Student CRUD operations

    public ResponseEntity<List<Student>> getStudents() {
        if (myStudentService.getStudents().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(myStudentService.getStudents(), HttpStatus.OK);
    }

    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        myStudentService.addStudent(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    public ResponseEntity<Student> getStudentByID(@PathVariable int id) {
        if (myStudentService.getByID(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(myStudentService.getByID(id), HttpStatus.OK);
    }

    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        boolean response = myStudentService.removeStudent(id);

        if (response) {
            return new ResponseEntity<>("Delete success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid id", HttpStatus.NOT_MODIFIED);
        }
    }

    public ResponseEntity<String> updateStudent(@RequestBody Student student) {
        boolean response = myStudentService.updateStudent(student);
        if (response) {
            return new ResponseEntity<>("Update success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Update failed", HttpStatus.NOT_MODIFIED);
        }
    }

    public ResponseEntity<List<Course>> getCourses() {
        if (myCourseService.getCourses().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(myCourseService.getCourses(), HttpStatus.OK);
    }

    public ResponseEntity<String> addOnlineCourse(@RequestBody OnlineCourse course) {
        myCourseService.addOnlineCourse(course);
        return new ResponseEntity<>("Course added.", HttpStatus.OK);
    }

    public ResponseEntity<String> addClassRoomCourse(@RequestBody ClassRoomCourse course) {
        myCourseService.addClassRoomCourse(course);
        return new ResponseEntity<>("Course added.", HttpStatus.OK);
    }

    public ResponseEntity<Course> getCourseByID(@PathVariable int id) {
        if (myCourseService.getByID(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(myCourseService.getByID(id), HttpStatus.OK);
    }

    public ResponseEntity<String> deleteCourse(@PathVariable int id) {
        boolean response = myCourseService.removeCourse(id);
        if (response) {
            return new ResponseEntity<>("Delete success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid id", HttpStatus.NOT_MODIFIED);
        }
    }

    public ResponseEntity<String> updateOnlineCourse(@RequestBody OnlineCourse course) {
        boolean response = myCourseService.updateOnlineCourse(course);
        if (response) {
            return new ResponseEntity<>("Update Success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Update failed", HttpStatus.NOT_MODIFIED);
        }
    }

    public ResponseEntity<String> updateClassroomCourse(@RequestBody ClassRoomCourse course) {
        boolean response = myCourseService.updateClassRoomCourse(course);
        if (response) {
            return new ResponseEntity<>("Update Success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Update failed", HttpStatus.NOT_MODIFIED);
        }
    }

    public ResponseEntity<String> addStudentToCourse(@PathVariable int studentId, @PathVariable int courseId) {

        boolean sresponse = myStudentService.addStudentToCourse(studentId, courseId);
        boolean cresponse = myCourseService.addStudentToCourse(studentId, courseId);
        if (sresponse && cresponse) {
            return new ResponseEntity<>("Student added to course", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    public ResponseEntity<String> removeStudentFromCourse(@PathVariable int studentId, @PathVariable int courseId) {

        boolean sresponse = myStudentService.removeStudentFromCourse(studentId, courseId);
        boolean cresponse = myCourseService.removeStudentFromCourse(studentId, courseId);
        if (sresponse && cresponse) {
            return new ResponseEntity<>("Student removed from course", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }
}
