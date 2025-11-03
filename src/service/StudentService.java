package service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import model.Student;

public class StudentService {
    private static List<Student> students = new ArrayList<>();

    public static void loadStudents(){
        try {
           var lines = Files.readAllLines(Paths.get("../students.txt"));
           lines.forEach(l->{
            var data = l.split(",");
            students.add(new Student(data[0],Double.parseDouble(data[1])));
           });
        } catch (Exception e) {
          System.out.println("ERROR: "+e);
        }
    }

    public static void getStudents(){
        students.stream().map(s-> s.toString().toUpperCase()).forEach(s -> System.out.println(s));
    }

    public static void getOrderedStudents(){
        students.stream().sorted(Comparator.comparing(Student::getGrade).reversed()).forEach(s-> System.out.println(s));;
    }
    public static void addStudent(Student student){
        students.add(student);
        try {
            Files.writeString(Paths.get("../students.txt"), student.toString(), StandardOpenOption.APPEND);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void calculate_average(){
       var avergae= students.stream().collect(Collectors.averagingDouble(Student::getGrade));
       System.out.println("THE TOTAL AVERAGE IS: " + avergae);
    }

}
