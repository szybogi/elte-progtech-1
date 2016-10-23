import student.Student;
import student.StudentAverage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<Student> studentsFromFile1 = Student.read(new File("src/test1.txt"));
        studentsFromFile1.forEach(student -> student.getGrades().forEach(System.out::println));
        for (int i = 0;i < studentsFromFile1.size();i++){
            System.out.println(studentsFromFile1.get(i).getAverage());
        }
        System.out.println("Igaz e, hogy minden tanulónak az átlaga legalább négyes? "
                + StudentAverage.allAverage(studentsFromFile1));
        System.out.println("A legjobb 3 átlaggal rendelkező: ");
        StudentAverage.showBestNOf(studentsFromFile1);
    }
}