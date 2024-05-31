package AssignmentSeven.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import AssignmentSeven.data.Course;
import AssignmentSeven.data.Enrollment;
import AssignmentSeven.data.Student;
import AssignmentSeven.manager.CourseManager;
import AssignmentSeven.manager.EnrollmentManager;
import AssignmentSeven.manager.StudentManager;

public class EnrollStudentDialog extends JDialog {
    private JComboBox<String> courseComboBox;
    private JComboBox<Student> studentComboBox;
    private JButton enrollButton;
    private EnrollmentManager enrollmentManager;

    public EnrollStudentDialog(JFrame parent, StudentManager studentManager, CourseManager courseManager,
            EnrollmentManager enrollmentManager) {
        super(parent, "Enroll Student in Course", true);
        initialize(studentManager, courseManager, enrollmentManager);
    }

    private void initialize(StudentManager studentManager, CourseManager courseManager,
            EnrollmentManager enrollmentManager) {
        setLayout(new GridLayout(3, 2));

        JLabel selectCourseLabel = new JLabel("Select Course:");
        courseComboBox = new JComboBox<>(courseManager.getCourseNames());
        JLabel selectStudentLabel = new JLabel("Select Student:");
        studentComboBox = new JComboBox<>(getStudentArray(studentManager));
        enrollButton = new JButton("Enroll");

        enrollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student selectedStudent = (Student) studentComboBox.getSelectedItem();
                String selectedCourseName = (String) courseComboBox.getSelectedItem();
                if (selectedStudent != null && selectedCourseName != null) {
                    Course selectedCourse = courseManager.getCourseByName(selectedCourseName);
                    selectedStudent.enrollInCourse(selectedCourse);
                    enrollmentManager.enrollStudent(new Enrollment(selectedStudent, selectedCourse));
                    if (getParent() instanceof ViewStudentsDialog) {
                        ((ViewStudentsDialog) getParent()).refreshTable();
                    }
                    dispose();
                }
            }
        });

        add(selectCourseLabel);
        add(courseComboBox);
        add(selectStudentLabel);
        add(studentComboBox);
        add(new JLabel());
        add(enrollButton);

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