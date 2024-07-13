import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;

public class steamAPI {
    public static void main(String[] args) {
        Student s1 = new Student(1,"swati","323","A");
        Student s2 = new Student(1,"vikitha","323y","A");
        Student s3 = new Student(1,"nishitha","323","A");
        Student s4 = new Student(1,"ajay","323y","A");
        Student s5 = new Student(1,"nishitha","323","B");
        Student s6 = new Student(1,"nishitha","323","A");
        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);
        
        List<Student> res = students.stream().sorted((a,b)->a.getName().compareTo(b.getName())).collect(Collectors.toList());  
        System.out.println(res);

        List<Student> duplicate =students.stream().distinct().collect(Collectors.toList());
        System.out.println(duplicate);
        
        Map<String, List<Student>> map = students.stream().filter(a->a.getGrade().equals("B")).collect(Collectors.groupingBy(a->a.getGrade()));
        map.forEach((grade, list) -> {
            System.out.println("Grade " + grade + ":\n" + list);
            
        });
    }
}
class Student{
    int age;
    String name;
    String address;
    String grade;
    public Student(int age, String name, String address, String grade) {
        this.age = age;
        this.name = name;
        this.address = address;
        this.grade = grade;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for address
    public String getAddress() {
        return address;
    }

    // Setter for address
    public void setAddress(String address) {
        this.address = address;
    }

    // Getter for grade
    public String getGrade() {
        return grade;
    }

    // Setter for grade
    public void setGrade(String grade) {
        this.grade = grade;
    }

    // Optional: Override toString method for better representation
    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", grade='" + grade + '\'' +
                "}\n";
    }
    @Override
    public boolean equals(Object obj) {
         Student s = (Student) obj;
        return this.age==s.getAge() && this.name.equals(s.getName())
        && this.grade.equals(s.getGrade()) && this.address.equals(s.getAddress());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(age, name, address, grade);
    }
}