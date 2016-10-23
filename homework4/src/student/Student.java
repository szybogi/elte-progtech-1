package student;

import java.util.ArrayList;
import java.util.List;

public class Student {

    public final String neptunId;
    public final List<Integer> grades;

    public Student(String neptunId, ArrayList<Integer> grades){
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


    public static Student make(String id, ArrayList<Integer> grades) {
        if(id.isEmpty() || id.length() !=6 ) {
            return null;
        }
        return new Student(id, grades);
    }
    public void show() {
        System.out.println(neptunId + ", " + getAverage());
    }

    public boolean equals(Student student){
        return student != null && student.getNeptunIdeptunId().equals(neptunId);
    }
}
