package AssignmentSeven.data;

public class Grade {
    private Student student;
    private Course course;
    private String grade;

    public Grade(Student student, Course course, String grade) {
        this.student = student;
        this.course = course;
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
