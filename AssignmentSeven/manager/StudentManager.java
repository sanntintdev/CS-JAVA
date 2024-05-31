package AssignmentSeven.manager;

import javax.swing.DefaultListModel;

import AssignmentSeven.data.Student;

public class StudentManager {
    private DefaultListModel<Student> studentListModel;

    public StudentManager() {
        studentListModel = new DefaultListModel<>();
    }

    public void addStudent(Student student) {
        studentListModel.addElement(student);
    }

    public void updateStudent(Student student) {
        int index = studentListModel.indexOf(student);
        if (index >= 0) {
            studentListModel.set(index, student);
        }
    }

    public DefaultListModel<Student> getStudentListModel() {
        return studentListModel;
    }
}
