package student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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

    public static Student maxAverage(List<Student> students){
        Student student = students.get(0);
        for(int i = 1;i < students.size();i++){
            if(students.get(i).getAverage() > student.getAverage()){
                student = students.get(i);
            }
        }
        return student;
    }

    public static boolean allAverage(List<Student> students){
        double a;
        boolean l = true;
        for (int i = 0; i < students.size();i++){
            a = students.get(i).getAverage();
            if(a >= 4){
                l = false;
            }
        }
        return l;
    }

    public static List<Student> orderByAverages(List<Student> students){
        return students.stream().sorted((a, b) -> {
            if(a.getAverage() < b.getAverage()) return 1;
            else if(a.getAverage() > b.getAverage()) return  -1;
            else return 0;
        }).collect(Collectors.toList());
    }

    public static List<Student> bestThree(List<Student> students) {
        List<Student> bestThree = new ArrayList<>();
        List<Student> studentsCopy = new ArrayList<>(students);
        for (int i = 0; i < 3; i++) {
            Student student = max(studentsCopy);
            studentsCopy.remove(student);
            bestThree.add(student);
        }
        return bestThree;
    }

    public static Student max(List<Student> students) {
        return students.stream().max((a, b) -> {
            if(a.getAverage() > b.getAverage()) return 1;
            else if(b.getAverage() > a.getAverage()) return -1;
            else return 0;
        }).get();
    }

    public void show() {
        System.out.println(neptunId + ", " + getAverage());
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return neptunId != null ? neptunId.equals(student.neptunId) : student.neptunId == null;

    }
}
