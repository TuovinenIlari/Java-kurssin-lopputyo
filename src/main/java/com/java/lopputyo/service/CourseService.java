package com.java.lopputyo.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.lopputyo.model.Course;

@Service
public class CourseService {

    @Autowired
    CourseFileService fileService;

    private List<Course> courses = new ArrayList<>();

    public void savePersistentData() {
        try {
            fileService.writeCourseTofile(courses);
            System.out.println("saved courses");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addCourse(Course course) {
        courses.add(course);
        savePersistentData();
    }

    public Course getByID(int id) {
        for (Course course : courses) {
            if (course.getCourseId() == id) {
                return course;
            }
        }
        return null;
    }

    public boolean removeCourse(int id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseId() == id) {
                courses.remove(i);
                savePersistentData();
                return true;
            }
        }
        return false;
    }

    public boolean updateCourse(Course course) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseId() == course.getCourseId()) {
                courses.set(i, course);
                savePersistentData();
                return true;
            }
        }

        return false;
    }

    public List<Course> getCourses() {

        try {
            courses = fileService.readCoursesFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return courses;
    }

    public boolean addStudentToCourse(int studentId, int courseId) {

        for (Course course : courses) {
            if (course.getCourseId() == courseId) {
                if (course.getCourseStudents().contains(studentId)) {
                    return false;
                } else {
                    course.setStudents(studentId);
                    savePersistentData();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean removeStudentFromCourse(int studentId, int courseId) {

        for (Course course : courses) {
            if (course.getCourseId() == courseId) {
                for (int i = 0; i < course.getCourseStudents().size(); i++) {
                    if (course.getCourseStudents().get(i) == studentId) {
                        course.getCourseStudents().remove(i);
                        savePersistentData();
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
