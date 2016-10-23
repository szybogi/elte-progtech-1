import student.Student;
import student.StudentAverage;
import java.io.File;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args){

            ArrayList<Student> studentsFromFile1 = new Read(new File("src/test1.txt")).getStudents();
            for (int i = 0;i < studentsFromFile1.size();i++){
                System.out.println(studentsFromFile1.get(i).getAverage());
            }
            System.out.println("Igaz e, hogy minden tanulónak az átlaga legalább négyes? "
                    + StudentAverage.allAverage(studentsFromFile1));
            System.out.println("A legjobb 3 átlaggal rendelkező: ");
            StudentAverage.showBestNOf(studentsFromFile1);




    }

}
