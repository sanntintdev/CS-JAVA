package AssignmentFive.student_management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseManagement {
  static List<Course> courses = new ArrayList<>();
  static Map<Student, Map<Course, Double>> overallGrades = new HashMap<>();
  static Map<Student, Map<Course, Double>> enrolledStudents = new HashMap<>();

  public static void addCourse(String code, String name, int maxCapacity) {
    Course course = new Course(code, name, maxCapacity);
    courses.add(course);
  }

  public static boolean enrollStudent(Student student, Course course, List<Student> studentList) {
    boolean success = student.enrollCourse(course);
    if (success) {
      enrolledStudents.put(student, new HashMap<>());
      studentList.add(student);
    }
    return success;
  }

  public static void assignGrade(Student student, Course course, double grade, List<Student> studentList) {
    Map<Course, Double> studentGrades = enrolledStudents.get(student);
    if (studentGrades != null) {
      studentGrades.put(course, grade);
      overallGrades.put(student, studentGrades);
    } else {
      System.out.println("Student is not enrolled in any course.");
    }
  }

  public static double calculateOverallGrade(Student student) {
    Map<Course, Double> studentGrades = overallGrades.get(student);
    if (studentGrades == null || studentGrades.isEmpty()) {
      return 0.0;
    }

    double totalGrade = 0.0;
    for (double grade : studentGrades.values()) {
      totalGrade += grade;
    }
    return totalGrade / studentGrades.size();
  }
}
