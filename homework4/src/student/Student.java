package student;

import java.util.ArrayList;

public class Student {

    public final String neptunId;
    public final ArrayList<Integer> grades;

    public Student(String neptunId, ArrayList<Integer> grades){
        this.neptunId = neptunId;
        this.grades = grades;

    }

    public Student(Student student){
        this.neptunId = student.getNeptunIdeptunId();
        this.grades = student.getGrades();
    }

    public String getNeptunIdeptunId(){
        return neptunId;
    }

    public ArrayList<Integer> getGrades(){
        return this.grades;
    }

    public void addGrade(int gr){
        if(gr <= 5 && gr >= 1){
            grades.add(gr);
        }
    }

    public double getAverage(){
        double result = 0;
        for(int i = 0;i < grades.size();i++){
            result += grades.get(i);
        }

        return (result/grades.size());
    }


    public static Student make(String id, ArrayList<Integer> grades) {
        if(id.isEmpty() || id.length() !=6 ) {
            return null;
        }
        return new Student(id, grades);
    }
    public void show() {
        System.out.println(this.neptunId + ", " + getAverage());
    }

    public boolean equals(Student student){
        return student != null && (student.getNeptunIdeptunId().equals(this.neptunId));
    }
}
