package com.java.lopputyo.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java.lopputyo.model.Course;

@Service
public class CourseFileService {
    private List<Course> courses = new ArrayList<>();

    public void writeCourseTofile(List<Course> courses) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(new File("courses.txt"));
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(courses);

        oos.flush();
        oos.close();
        fos.close();
    }

    public List<Course> readCoursesFromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        File file = new File("courses.txt");
        if (file.isFile()) {

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

            try {

                courses = (ArrayList<Course>) ois.readObject();

            } catch (IOException e) {
                System.out.println("End of CourseStream....");
            }
            ois.close();
        }

        return courses;
    }
}
