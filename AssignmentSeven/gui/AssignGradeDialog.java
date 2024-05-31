package AssignmentSeven.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import AssignmentSeven.data.Course;
import AssignmentSeven.data.Grade;
import AssignmentSeven.data.Student;
import AssignmentSeven.manager.CourseManager;
import AssignmentSeven.manager.GradeManager;
import AssignmentSeven.manager.StudentManager;

public class AssignGradeDialog extends JDialog {
    private JComboBox<Student> studentComboBox;
    private JComboBox<String> courseComboBox;
    private JTextField gradeField;
    private JButton assignButton;

    public AssignGradeDialog(JFrame parent, StudentManager studentManager, CourseManager courseManager,
            GradeManager gradeManager) {
        super(parent, "Assign Grade", true);
        initialize(studentManager, courseManager, gradeManager);
    }

    private void initialize(StudentManager studentManager, CourseManager courseManager, GradeManager gradeManager) {
        setLayout(new GridLayout(4, 2));

        JLabel selectStudentLabel = new JLabel("Select Student:");
        studentComboBox = new JComboBox<>(getStudentArray(studentManager));
        JLabel selectCourseLabel = new JLabel("Select Course:");
        courseComboBox = new JComboBox<>(courseManager.getCourseNames());
        JLabel gradeLabel = new JLabel("Grade:");
        gradeField = new JTextField();
        assignButton = new JButton("Assign");

        studentComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student selectedStudent = (Student) studentComboBox.getSelectedItem();
                if (selectedStudent != null) {
                    courseComboBox.removeAllItems();
                    for (String course : selectedStudent.getCourses()) {
                        courseComboBox.addItem(course);
                    }
                }
            }
        });

        assignButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student selectedStudent = (Student) studentComboBox.getSelectedItem();
                String selectedCourseName = (String) courseComboBox.getSelectedItem();
                String grade = gradeField.getText();
                if (selectedStudent != null && selectedCourseName != null && !grade.isEmpty()) {
                    Course selectedCourse = courseManager.getCourseByName(selectedCourseName);
                    String courseName = selectedCourse.getName();
                    selectedStudent.assignGrade(courseName, grade);
                    gradeManager.assignGrade(new Grade(selectedStudent, selectedCourse, grade));

                    if (getParent() instanceof ViewStudentsDialog) {
                        ((ViewStudentsDialog) getParent()).refreshTable();
                    }
                    dispose();
                }
            }
        });

        add(selectStudentLabel);
        add(studentComboBox);
        add(selectCourseLabel);
        add(courseComboBox);
        add(gradeLabel);
        add(gradeField);
        add(new JLabel());
        add(assignButton);

        pack();
        setLocationRelativeTo(getParent());
    }

    private Student[] getStudentArray(StudentManager studentManager) {
        Student[] students = new Student[studentManager.getStudentListModel().size()];
        for (int i = 0; i < studentManager.getStudentListModel().size(); i++) {
            students[i] = studentManager.getStudentListModel().getElementAt(i);
        }
        return students;
    }
}