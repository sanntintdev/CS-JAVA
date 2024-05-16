package AssignmentFive.student_management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin {
  private static Scanner scanner = new Scanner(System.in);
  private static List<Student> studentList = new ArrayList<>();

  public static void main(String[] args) {
    boolean exit = false;
    while (!exit) {
      displayMenu();
      int choice = scanner.nextInt();
      scanner.nextLine(); // Consume newline character

      switch (choice) {
        case 1:
          addCourse();
          break;
        case 2:
          enrollStudent();
          break;
        case 3:
          assignGrade();
          break;
        case 4:
          calculateOverallGrade();
          break;
        case 5:
          exit = true;
          break;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    }
  }

  private static void displayMenu() {
    System.out.println("\nCourse Enrollment and Grade Management System");
    System.out.println("1. Add a new course");
    System.out.println("2. Enroll a student");
    System.out.println("3. Assign grade");
    System.out.println("4. Calculate overall grade");
    System.out.println("5. Exit");
    System.out.print("Enter your choice: ");
  }

  private static void addCourse() {
    System.out.print("Enter course code: ");
    String code = scanner.nextLine();
    System.out.print("Enter course name: ");
    String name = scanner.nextLine();
    System.out.print("Enter maximum capacity: ");
    int maxCapacity = scanner.nextInt();
    scanner.nextLine(); // Consume newline character

    CourseManagement.addCourse(code, name, maxCapacity);
    System.out.println("Course added successfully.");
  }

  private static void enrollStudent() {
    System.out.print("Enter student name: ");
    String studentName = scanner.nextLine();
    System.out.print("Enter student ID: ");
    int studentId = scanner.nextInt();
    scanner.nextLine();

    Student student = new Student(studentName, studentId);
    System.out.print("Enter course code: ");
    String courseCode = scanner.nextLine();

    Course course = null;
    for (Course c : CourseManagement.courses) {
      if (c.getCode().equals(courseCode)) {
        course = c;
        break;
      }
    }

    if (course != null) {
      boolean success = CourseManagement.enrollStudent(student, course, studentList);
      if (success) {
        System.out.println("Student enrolled successfully.");
      } else {
        System.out.println("Course is full.");
      }
    } else {
      System.out.println("Course not found.");
    }
  }

  private static void assignGrade() {
    System.out.print("Enter student ID: ");
    int studentId = scanner.nextInt();
    scanner.nextLine(); // Consume newline character

    Student student = null;
    for (Student s : CourseManagement.enrolledStudents.keySet()) {
      System.out.println(s.getId());
      if (s.getId() == studentId) {
        student = s;
        break;
      }
    }

    if (student != null) {
      System.out.print("Enter course code: ");
      String courseCode = scanner.nextLine();

      Course course = null;
      for (Course c : CourseManagement.courses) {
        if (c.getCode().equals(courseCode)) {
          course = c;
          break;
        }
      }

      if (course != null) {
        System.out.print("Enter grade: ");
        double grade = scanner.nextDouble();

        CourseManagement.assignGrade(student, course, grade, studentList);
        System.out.println("Grade assigned successfully.");
      } else {
        System.out.println("Course not found.");
      }
    } else {
      System.out.println("Student not found.");
    }
  }

  private static void calculateOverallGrade() {
    System.out.print("Enter student ID: ");
    int studentId = scanner.nextInt();
    scanner.nextLine(); // Consume newline character

    Student student = null;
    for (Student s : CourseManagement.overallGrades.keySet()) {
      if (s.getId() == studentId) {
        student = s;
        break;
      }
    }

    if (student != null) {
      double overallGrade = CourseManagement.calculateOverallGrade(student);
      System.out.println("Overall grade for " + student.getName() + ": " + overallGrade);
    } else {
      System.out.println("Student not found.");
    }
  }
}
