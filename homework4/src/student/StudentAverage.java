package student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentAverage {

    public static boolean allAverage(List<Student> students){
        double a;
        boolean l = true;
        for (int i = 0; i < students.size();i++){
            a = students.get(i).getAverage();
            if(a >= 4){
                l = false;
            }
        }
        return (l);
    }

    public static List<Student> orderByAverages(List<Student> students){
        return students.stream().sorted((a, b) -> {
            if(a.getAverage() < b.getAverage()) return 1;
            else if(a.getAverage() > b.getAverage()) return  -1;
            else return 0;
        }).collect(Collectors.toList());
    }

    public static void showBestNOf( List<Student> students) {
        orderByAverages(students).subList(0,3).forEach(Student::show);
    }


}
