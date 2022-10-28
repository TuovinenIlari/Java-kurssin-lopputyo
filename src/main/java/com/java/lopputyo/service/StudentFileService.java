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

import com.java.lopputyo.model.Student;

@Service
public class StudentFileService {

    private List<Student> students = new ArrayList<>();

    public StudentFileService(){}

    public void writeStudentsToFile(List<Student> students) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(new File("students.txt"));
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        oos.writeObject(students);

        oos.flush();
        oos.close();
        fos.close();

    }

    public List<Student> readStudentsFromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        File file = new File("students.txt");
        if (file.isFile()) {

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

            
            try {
                
                    students = (ArrayList<Student>) ois.readObject();
                
            } catch (IOException e) {
                System.out.println("End of StudentStream....");
            }
            ois.close();
        }
        return students;
    }

}
