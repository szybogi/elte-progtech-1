package student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {

    public final String neptunId;
    public final List<Integer> grades;

    public Student(String neptunId, List<Integer> grades){
        this.neptunId = neptunId;
        this.grades = grades;
    }

    public Student(Student student){
        neptunId = student.getNeptunIdeptunId();
        grades = student.getGrades();
    }

    public String getNeptunIdeptunId(){
        return neptunId;
    }

    public List<Integer> getGrades(){
        return new ArrayList<Integer>(grades);
    }

    public void addGrade(int gr){
        if(gr <= 5 && gr >= 1){
            grades.add(gr);
        }
    }

    public double getAverage(){
        if(grades.size() == 0) { return 0; }
        double result = 0;
        for(int i = 0;i < grades.size();i++){
            result += grades.get(i);
        }
        return result/grades.size();
    }


    public static Student make(String id, List<Integer> grades) {
        if(id.isEmpty() || id.length() !=6 ) {
            return null;
        }
        return new Student(id, grades);
    }
    public void show() {
        System.out.println(neptunId + ", " + getAverage());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return neptunId != null ? neptunId.equals(student.neptunId) : student.neptunId == null;

    }

    public static List<Student> read(File file) throws FileNotFoundException {
        try(Scanner scn = new Scanner(file)) {
            List<Student> result = new ArrayList<>();
            while(scn.hasNextLine()) {
                String[] line = scn.nextLine().split(" ");
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
    }
}
