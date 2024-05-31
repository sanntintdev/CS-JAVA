package AssignmentSeven.manager;

import java.util.ArrayList;
import java.util.List;

import AssignmentSeven.data.Grade;

public class GradeManager {
    private List<Grade> grades;

    public GradeManager() {
        grades = new ArrayList<>();
    }

    public void assignGrade(Grade grade) {
        grades.add(grade);
    }

    public List<Grade> getGrades() {
        return grades;
    }
}
