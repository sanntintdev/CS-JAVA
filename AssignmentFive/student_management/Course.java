package AssignmentFive.student_management;

class Course {
  private String code;
  private String name;
  private int maxCapacity;
  private static int totalEnrolledStudents = 0;

  public Course(String code, String name, int maxCapacity) {
    this.code = code;
    this.name = name;
    this.maxCapacity = maxCapacity;
  }

  public String getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  public int getMaxCapacity() {
    return maxCapacity;
  }

  public static int getTotalEnrolledStudents() {
    return totalEnrolledStudents;
  }

  public static void incrementTotalEnrolledStudents() {
    totalEnrolledStudents++;
  }
}
