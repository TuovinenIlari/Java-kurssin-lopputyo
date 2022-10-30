package com.java.lopputyo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.lopputyo.model.ClassRoomCourse;
import com.java.lopputyo.model.Course;
import com.java.lopputyo.model.OnlineCourse;
import com.java.lopputyo.model.Student;
import com.java.lopputyo.service.CourseService;
import com.java.lopputyo.service.StudentService;

@RestController
public class LopputyoController {

    @Autowired
    StudentService myStudentService;
    @Autowired
    CourseService myCourseService;

    // Student CRUD operations
    @GetMapping("/students")
    public List<Student> getStudents() {
        return myStudentService.getStudent();
    }

    @GetMapping("/savestudents")
    public void saveStudentsData() {
        myStudentService.savePersistentData();
    }

    @PostMapping("/addstudent")
    public Student addStudent(@RequestBody Student student) {
        myStudentService.addStudent(student);
        return student;
    }

    @GetMapping("/getstudentid/{id}")
    public ResponseEntity<Student> getStudentByID(@PathVariable int id) {
        return new ResponseEntity<>(myStudentService.getByID(id), HttpStatus.OK);
    }

    @GetMapping("/deletestudent/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        boolean response = myStudentService.removeStudent(id);

        if (response) {
            return new ResponseEntity<>("Delete success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid id", HttpStatus.NOT_MODIFIED);
        }
    }

    @PostMapping("/updatestudent") // Uses studentId to update
    public ResponseEntity<String> updateStudent(@RequestBody Student student) {
        boolean response = myStudentService.updateStudent(student);
        if (response) {
            return new ResponseEntity<>("Update success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Update failed", HttpStatus.NOT_MODIFIED);
        }
    }

    // Course CRUD operations
    @GetMapping("/courses")
    public List<Course> getCourses() {
        return myCourseService.getCourses();
    }

    @PostMapping("/addonlinecourse")
    public ResponseEntity<String> addOnlineCourse(@RequestBody OnlineCourse course) {
        myCourseService.addOnlineCourse(course);
        return new ResponseEntity<>("Course added.", HttpStatus.OK);
    }
    @PostMapping("/addclassroomcourse")
    public ResponseEntity<String> addClassRoomCourse(@RequestBody ClassRoomCourse course) {
        myCourseService.addClassRoomCourse(course);
        return new ResponseEntity<>("Course added.", HttpStatus.OK);
    }

    @GetMapping("/savecourses")
    public void saveCoursesData() {
        myCourseService.savePersistentData();
    }

    @GetMapping("/getcourse/{id}")
    public ResponseEntity<Course> getCourseByID(@PathVariable int id) {
        return new ResponseEntity<>(myCourseService.getByID(id), HttpStatus.OK);
    }

    @GetMapping("/deletecourse/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable int id) {
        boolean response = myCourseService.removeCourse(id);
        if (response) {
            return new ResponseEntity<>("Delete success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid id", HttpStatus.NOT_MODIFIED);
        }
    }

    @PostMapping("/updateonlinecourse") // Uses courseId to update
    public ResponseEntity<String> updateOnlineCourse(@RequestBody OnlineCourse course) {
        boolean response = myCourseService.updateOnlineCourse(course);
        if (response) {
            return new ResponseEntity<>("Update Success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Update failed", HttpStatus.NOT_MODIFIED);
        }
    }
    @PostMapping("/updateclassroomcourse") // Uses courseId to update
    public ResponseEntity<String> updateClassroomCourse(@RequestBody ClassRoomCourse course) {
        boolean response = myCourseService.updateClassRoomCourse(course);
        if (response) {
            return new ResponseEntity<>("Update Success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Update failed", HttpStatus.NOT_MODIFIED);
        }
    }

    // Add student to course
    @GetMapping("/addstudenttocourse/{studentId}/{courseId}")
    public ResponseEntity<String> addStudentToCourse(@PathVariable int studentId, @PathVariable int courseId) {

        boolean sresponse = myStudentService.addStudentToCourse(studentId, courseId);
        boolean cresponse = myCourseService.addStudentToCourse(studentId, courseId);
        if (sresponse && cresponse) {
            return new ResponseEntity<>("Student added to course", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    // Remove student from course
    @GetMapping("/removestudentfromcourse/{studentId}/{courseId}")
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
