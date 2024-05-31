package AssignmentSeven.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private int age;
    private int id;
    private static int idCounter = 1;
    private Map<String, String> courses;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = idCounter++;
        this.courses = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void enrollInCourse(Course course) {
        String courseName = course.getName();
        courses.put(courseName, "");
    }

    public void assignGrade(String course, String grade) {
        if (courses.containsKey(course)) {
            courses.put(course, grade);
        }
    }

    public java.util.List<String> getCourses() {
        return new ArrayList<>(courses.keySet());
    }

    @Override
    public String toString() {
        return "(ID: " + id + ")" + name + " is " + age + " years old.";
    }
}
