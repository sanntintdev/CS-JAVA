package AssignmentSeven.gui;

import AssignmentSeven.manager.StudentManager;
import AssignmentSeven.manager.CourseManager;
import AssignmentSeven.manager.EnrollmentManager;
import AssignmentSeven.manager.GradeManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;

public class StudentManagementGUI {
    private JFrame frame;
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private StudentManager studentManager;
    private CourseManager courseManager;
    private EnrollmentManager enrollmentManager;
    private GradeManager gradeManager;

    public StudentManagementGUI() {
        studentManager = new StudentManager();
        courseManager = new CourseManager();
        enrollmentManager = new EnrollmentManager();
        gradeManager = new GradeManager();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Student Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

        JPanel menuPanel = new JPanel();
        JButton addStudentButton = new JButton("Add Student");
        JButton updateStudentButton = new JButton("Update Student");
        JButton viewStudentButton = new JButton("View Student Details");
        JButton enrollStudentButton = new JButton("Enroll Student in Course");
        JButton assignGradeButton = new JButton("Assign Grade");

        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddStudentDialog(frame, studentManager).setVisible(true);
            }
        });

        updateStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateStudentDialog(frame, studentManager).setVisible(true);
            }
        });

        viewStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewStudentsDialog(frame, studentManager, enrollmentManager, gradeManager).setVisible(true);
            }
        });

        enrollStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EnrollStudentDialog(frame, studentManager, courseManager, enrollmentManager).setVisible(true);
            }
        });

        assignGradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AssignGradeDialog(frame, studentManager, courseManager, gradeManager).setVisible(true);
            }
        });

        menuPanel.add(addStudentButton);
        menuPanel.add(updateStudentButton);
        menuPanel.add(viewStudentButton);
        menuPanel.add(enrollStudentButton);
        menuPanel.add(assignGradeButton);

        mainPanel.add(menuPanel, "Menu");

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                StudentManagementGUI window = new StudentManagementGUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
