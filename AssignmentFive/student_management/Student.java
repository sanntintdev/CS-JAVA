package AssignmentFive.student_management;

import java.util.HashMap;
import java.util.Map;

public class Student {
  private String name;
  private int id;
  private Map<Course, Double> enrolledCourses;

  public Student(String name, int id) {
    this.name = name;
    this.id = id;
    enrolledCourses = new HashMap<>();
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public boolean enrollCourse(Course course) {
    if (Course.getTotalEnrolledStudents() >= course.getMaxCapacity()) {
      return false;
    }
    enrolledCourses.put(course, null);
    Course.incrementTotalEnrolledStudents();
    return true;
  }

  public void assignGrade(Course course, double grade) {
    enrolledCourses.put(course, grade);
  }

  public Map<Course, Double> getEnrolledCourses() {
    return enrolledCourses;
  }
}
