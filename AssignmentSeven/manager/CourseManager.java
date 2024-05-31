package AssignmentSeven.manager;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

import AssignmentSeven.data.Course;
import AssignmentSeven.data.Student;

public class CourseManager {

    private List<Course> courses;

    public CourseManager() {
        // Example courses
        courses = new ArrayList<>();
        courses.add(new Course("Math"));
        courses.add(new Course("Science"));
        courses.add(new Course("History"));
        courses.add(new Course("Art"));
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Course getCourseByName(String courseName) {
        for (Course course : courses) {
            if (course.getName().equalsIgnoreCase(courseName)) {
                return course;
            }
        }
        return null; // or throw an exception if preferred
    }

    public String[] getCourseNames() {
        return courses.stream().map(Course::getName).toArray(String[]::new);
    }
}
