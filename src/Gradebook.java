import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gradebook {
    private List<Student> students;
    private Scanner scanner;

    public Gradebook() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addStudent(String name) {
        Student student = new Student(name);
        students.add(student);
        System.out.println("Student '" + name + "' added.");
    }

    public void updateGrade(String studentName, int grade) {
        for (Student student : students) {
            if (student.getName().equals(studentName)) {
                student.addGrade(grade);
                System.out.println("Grade updated for " + studentName);
                return;
            }
        }
        System.out.println("Student not found: " + studentName);
    }

    public double calculateClassAverage() {
        if (students.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        int count = 0;
        for (Student student : students) {
            double average = student.calculateAverage();
            if (average > 0) {
                sum += average;
                count++;
            }
        }
        if (count == 0) {
            return 0.0;
        }
        return sum / count;
    }

    public void runGradebook() {
        while (true) {
            System.out.println("Options:");
            System.out.println("1. Add Student");
            System.out.println("2. Update Grade");
            System.out.println("3. Calculate Class Average");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the student's name: ");
                    String name = scanner.nextLine();
                    addStudent(name);
                    break;
                case 2:
                    System.out.print("Enter the student's name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter the grade: ");
                    int grade = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    updateGrade(studentName, grade);
                    break;
                case 3:
                    double classAverage = calculateClassAverage();
                    System.out.println("Class Average: " + classAverage);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        Gradebook gradebook = new Gradebook();
        gradebook.runGradebook();
    }
}
