package AssignmentThree.student_management_system;

import AssignmentThree.student_management_system.Student;
import AssignmentThree.student_management_system.StudentOperations;
import java.util.Scanner;

public class StudentManagement {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRunning = true; // Flag to keep the program running

        while (isRunning) {
            displayMenu();

            try {
                int userChoice = scanner.nextInt();

                // Switch statement to handle user choice
                switch (userChoice) {
                    case 1:
                        StudentOperations.getStudentList();
                        break;
                    case 2:
                        System.out.println("Enter student ID: ");
                        int id = scanner.nextInt();
                        StudentOperations.getStudentById(id);
                        break;
                    case 3:
                        System.out.println("Enter student name: ");
                        String name = scanner.next();
                        System.out.println("Enter student ID: ");
                        int studentId = scanner.nextInt();
                        System.out.println("Enter student age: ");
                        int age = scanner.nextInt();
                        System.out.println("Enter student grade: ");
                        double grade = scanner.nextDouble();
                        StudentOperations.addStudent(
                            name,
                            studentId,
                            age,
                            grade
                        );
                        break;
                    case 4:
                        System.out.println("Enter student ID: ");
                        int updateId = scanner.nextInt();
                        System.out.println("Enter student name: ");
                        String updateName = scanner.next();
                        System.out.println("Enter student age: ");
                        int updateAge = scanner.nextInt();
                        System.out.println("Enter student grade: ");
                        double updateGrade = scanner.nextDouble();
                        StudentOperations.updateStudent(
                            updateId,
                            updateName,
                            updateAge,
                            updateGrade
                        );
                        break;
                    case 5:
                        System.out.println("Enter student ID: ");
                        int deleteId = scanner.nextInt();
                        StudentOperations.deleteStudentById(deleteId);
                        break;
                    case 6:
                        isRunning = false;
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }
        }
    }

    // Display menu
    private static void displayMenu() {
        System.out.println(
            "\nWelcome to Sann Tint Aung Student Management System"
        );
        System.out.println("1. Get Student Lists");
        System.out.println("2. Get A Student By ID");
        System.out.println("3. Add Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
    }
}
