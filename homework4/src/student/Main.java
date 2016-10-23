package student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<Student> studentsFromFile1 = Student.read(new File("src/test1.txt"));
        for (int i = 0;i < studentsFromFile1.size();i++){
            System.out.println(studentsFromFile1.get(i).getAverage());
        }
        System.out.println("Igaz e, hogy minden tanulónak az átlaga legalább négyes? "
                + Student.allAverage(studentsFromFile1));
        System.out.println("A legjobb 3 átlaggal rendelkező: ");
        for (Student student: Student.bestThree(studentsFromFile1)) {
            student.show();
        }
    }
}