package com.java.lopputyo.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.lopputyo.model.Student;

@Service
public class StudentService {
    @Autowired
    StudentFileService fileService;

    private List<Student> students = new ArrayList<>();

    public void savePersistentData() {
        try {
            fileService.writeStudentsToFile(students);
            System.out.println("saved students");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addStudent(Student student) {
        students.add(student);
        savePersistentData();

    }

    public Student getByID(int id) {

        for (Student student : students) {
            if (student.getStudentId() == id) {
                return student;
            }
        }
        return null;
    }

    public boolean removeStudent(int id) {

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId() == id) {
                students.remove(i);
                savePersistentData();
                return true;
            }
        }

        return false;
    }

    public boolean updateStudent(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId() == student.getStudentId()) {
                students.set(i, student);
                savePersistentData();
                return true;
            }
        }

        return false;
    }

    public List<Student> getStudents() {
        try {
            students = fileService.readStudentsFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    public boolean addStudentToCourse(int studentId, int courseId) {

        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                if (student.getStudentCourses().contains(courseId)) {
                    return false;
                } else {
                    student.setCourse(courseId);
                    savePersistentData();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean removeStudentFromCourse(int studentId, int courseId) {

        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                for (int i = 0; i < student.getStudentCourses().size(); i++) {
                    if (student.getStudentCourses().get(i) == courseId) {
                        student.getStudentCourses().remove(i);
                        savePersistentData();
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
