package AssignmentThree.student_management_system;

import AssignmentThree.student_management_system.Student;
import java.util.ArrayList;

public class StudentOperations {

    private static ArrayList<Student> studentList = new ArrayList<>();
    private static int studentCount = 0; // Counter to keep track of number of students

    // Method to add a student to the studentList
    public static void addStudent(String name, int id, int age, double grade) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                System.out.println("Student with ID " + id + " already exists");
                return;
            }
        }

        Student newStudent = new Student(id, name, age, grade);
        studentList.add(newStudent);
        studentCount++;

        System.out.println("Student added successfully");
        return;
    }

    // Method to update a student in the studentList
    public static void updateStudent(
        int id,
        String name,
        int age,
        double grade
    ) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                student.setName(name);
                student.setAge(age);
                student.setGrade(grade);

                System.out.println("Student updated successfully");
                return;
            }
        }

        System.out.println("Student not found");
    }

    // Method to get the list of students in the studentList
    public static void getStudentList() {
        for (Student student : studentList) {
            System.out.println("________________________");
            System.out.println("Name: " + student.getName());
            System.out.println("ID: " + student.getId());
            System.out.println("Age: " + student.getAge());
            System.out.println("Grade: " + student.getGrade());
            System.out.println("________________________");
        }
        return;
    }

    // Method to get a student by ID
    public static void getStudentById(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                System.out.println("________________________");
                System.out.println("Name: " + student.getName());
                System.out.println("ID: " + student.getId());
                System.out.println("Age: " + student.getAge());
                System.out.println("Grade: " + student.getGrade());
                System.out.println("________________________");
                return;
            }
        }

        System.out.println("Student not found");
    }

    // Method to delete a student by ID
    public static void deleteStudentById(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                studentList.remove(student);
                studentCount--;

                System.out.println("Student deleted successfully");
                return;
            }
        }

        System.out.println("Student not found");
    }
}
