package AssignmentSeven.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import AssignmentSeven.data.Student;
import AssignmentSeven.manager.StudentManager;

public class AddStudentDialog extends JDialog {
    private JTextField nameField;
    private JTextField ageField;
    private JButton saveButton;
    private StudentManager studentManager;

    public AddStudentDialog(JFrame parent, StudentManager studentManager) {
        super(parent, "Add Student", true);
        this.studentManager = studentManager;
        initialize();
    }

    private void initialize() {
        setLayout(new GridLayout(4, 2));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(150, 30)); // Set preferred size for the text field

        JLabel ageLabel = new JLabel("Age:");
        ageField = new JTextField();
        ageField.setPreferredSize(new Dimension(150, 30)); // Set preferred size for the text field

        saveButton = new JButton("Save");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                Student student = new Student(name, age);
                studentManager.addStudent(student);
                dispose();
            }
        });

        add(nameLabel);
        add(nameField);
        add(ageLabel);
        add(ageField);
        add(new JLabel());
        add(saveButton);

        pack();
        setLocationRelativeTo(getParent());
    }
}
