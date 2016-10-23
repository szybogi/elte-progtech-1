package student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Read {

    private ArrayList<Student> students;

    private ArrayList<Student> read(Scanner sc) {
        ArrayList<Student> result = new ArrayList<>();
        while(sc.hasNextLine()) {
            String[] line = sc.nextLine().split(" ");
            ArrayList<Integer> grade = new ArrayList<>();
            Integer g = Integer.valueOf(line[1]);
            Student student = Student.make(line[0], grade);
            if(result.contains(student)) {
                result.get(result.indexOf(student)).addGrade(g);
            } else {
                result.add(student);
                result.get(result.indexOf(student)).addGrade(g);
            }
        }
        return result;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public Read(File file){
        try(Scanner scn = new Scanner(file)) {
            students = read(scn);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Read(Scanner scn) {
        students = read(scn);
    }

}
