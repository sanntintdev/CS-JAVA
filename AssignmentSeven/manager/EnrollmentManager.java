package AssignmentSeven.manager;

import java.util.ArrayList;
import java.util.List;

import AssignmentSeven.data.Enrollment;

public class EnrollmentManager {
    private List<Enrollment> enrollments;

    public EnrollmentManager() {
        enrollments = new ArrayList<>();
    }

    public void enrollStudent(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }
}
