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

import AssignmentSeven.data.Student;
import AssignmentSeven.manager.StudentManager;

public class UpdateStudentDialog extends JDialog {
    private JComboBox<Student> studentComboBox;
    private JTextField nameField;
    private JTextField ageField;
    private JButton updateButton;
    private StudentManager studentManager;

    public UpdateStudentDialog(JFrame parent, StudentManager studentManager) {
        super(parent, "Update Student", true);
        this.studentManager = studentManager;
        initialize();
    }

    private void initialize() {
        setLayout(new GridLayout(4, 2));

        JLabel selectLabel = new JLabel("Select Student:");
        studentComboBox = new JComboBox<>(getStudentArray());
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel ageLabel = new JLabel("Age:");
        ageField = new JTextField();
        updateButton = new JButton("Update");

        studentComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student selectedStudent = (Student) studentComboBox.getSelectedItem();
                if (selectedStudent != null) {
                    nameField.setText(selectedStudent.getName());
                    ageField.setText(String.valueOf(selectedStudent.getAge()));
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student selectedStudent = (Student) studentComboBox.getSelectedItem();
                if (selectedStudent != null) {
                    selectedStudent.setName(nameField.getText());
                    selectedStudent.setAge(Integer.parseInt(ageField.getText()));
                    studentManager.updateStudent(selectedStudent);
                    if (getParent() instanceof ViewStudentsDialog) {
                        ((ViewStudentsDialog) getParent()).refreshTable();
                    }
                    dispose();
                }
            }
        });

        add(selectLabel);
        add(studentComboBox);
        add(nameLabel);
        add(nameField);
        add(ageLabel);
        add(ageField);
        add(new JLabel());
        add(updateButton);

        pack();
        setLocationRelativeTo(getParent());
    }

    private Student[] getStudentArray() {
        Student[] students = new Student[studentManager.getStudentListModel().size()];
        for (int i = 0; i < studentManager.getStudentListModel().size(); i++) {
            students[i] = studentManager.getStudentListModel().getElementAt(i);
        }
        return students;
    }
}