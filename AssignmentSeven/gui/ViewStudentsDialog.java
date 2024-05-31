package AssignmentSeven.gui;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import AssignmentSeven.data.Enrollment;
import AssignmentSeven.data.Grade;
import AssignmentSeven.data.Student;
import AssignmentSeven.manager.EnrollmentManager;
import AssignmentSeven.manager.GradeManager;
import AssignmentSeven.manager.StudentManager;

import java.awt.*;
import java.util.List;

public class ViewStudentsDialog extends JDialog {
    private JTable studentTable;
    private StudentManager studentManager;
    private EnrollmentManager enrollmentManager;
    private GradeManager gradeManager;
    private StudentTableModel studentTableModel;

    public ViewStudentsDialog(JFrame parent, StudentManager studentManager, EnrollmentManager enrollmentManager,
            GradeManager gradeManager) {
        super(parent, "View Students", true);
        this.studentManager = studentManager;
        this.enrollmentManager = enrollmentManager;
        this.gradeManager = gradeManager;
        initialize();
    }

    private void initialize() {
        setLayout(new BorderLayout());

        studentTableModel = new StudentTableModel(studentManager, enrollmentManager, gradeManager);
        studentTable = new JTable(studentTableModel);

        JScrollPane scrollPane = new JScrollPane(studentTable);
        add(scrollPane, BorderLayout.CENTER);

        setSize(600, 300);
        setLocationRelativeTo(getParent());
    }

    private class StudentTableModel extends AbstractTableModel {
        private final String[] columnNames = { "Student ID", "Student Name", "Student Age", "Courses", "Grades" };
        private final StudentManager studentManager;
        private final EnrollmentManager enrollmentManager;
        private final GradeManager gradeManager;

        public StudentTableModel(StudentManager studentManager, EnrollmentManager enrollmentManager,
                GradeManager gradeManager) {
            this.studentManager = studentManager;
            this.enrollmentManager = enrollmentManager;
            this.gradeManager = gradeManager;
        }

        @Override
        public int getRowCount() {
            return studentManager.getStudentListModel().size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Student student = studentManager.getStudentListModel().getElementAt(rowIndex);

            switch (columnIndex) {
                case 0:
                    return student.getId();
                case 1:
                    return student.getName();
                case 2:
                    return student.getAge();
                case 3:
                    return getCourses(student);
                case 4:
                    return getGrades(student);
                default:
                    return null;
            }
        }

        private String getCourses(Student student) {
            StringBuilder courses = new StringBuilder();
            for (Enrollment enrollment : enrollmentManager.getEnrollments()) {
                if (enrollment.getStudent().equals(student)) {
                    if (courses.length() > 0) {
                        courses.append(", ");
                    }
                    courses.append(enrollment.getCourse());
                }
            }
            return courses.length() > 0 ? courses.toString() : "Not enrolled in any courses";
        }

        private String getGrades(Student student) {
            StringBuilder grades = new StringBuilder();
            for (Grade grade : gradeManager.getGrades()) {
                if (grade.getStudent().equals(student)) {
                    if (grades.length() > 0) {
                        grades.append(", ");
                    }
                    grades.append(grade.getCourse()).append(": ").append(grade.getGrade());
                }
            }
            return grades.length() > 0 ? grades.toString() : "No grades assigned";
        }

    }

    public void refreshTable() {
        studentTableModel.fireTableDataChanged();
    }
}
