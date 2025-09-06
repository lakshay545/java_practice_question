import java.util.ArrayList;
import java.util.Scanner;

// Parent class
class Person {
    String name;

    Person() {}

    Person(String name) {
        this.name = name;
    }
}

// Child class Student
class Student extends Person {
    int rollNo;
    String course;
    double marks;
    char grade;

    // default constructor
    Student() {}

    // parameterized constructor
    Student(int rollNo, String name, String course, double marks) {
        super(name);
        this.rollNo = rollNo;
        this.course = course;
        this.marks = marks;
        calculateGrade();
    }

    // method to take input
    void inputDetails(Scanner sc) {
        System.out.print("Enter Roll No: ");
        rollNo = sc.nextInt();
        sc.nextLine(); // to avoid newline problem
        System.out.print("Enter Name: ");
        name = sc.nextLine();
        System.out.print("Enter Course: ");
        course = sc.nextLine();
        System.out.print("Enter Marks: ");
        marks = sc.nextDouble();
        calculateGrade();
    }

    // method to calculate grade
    void calculateGrade() {
        if (marks >= 90) {
            grade = 'A';
        } else if (marks >= 75) {
            grade = 'B';
        } else if (marks >= 50) {
            grade = 'C';
        } else {
            grade = 'D';
        }
    }

    // method to display details
    void displayDetails() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
        System.out.println("--------------------");
    }
}

public class StudentRecordSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int choice;
        do {
            System.out.println("===== Student Record Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                Student s = new Student();
                s.inputDetails(sc);
                students.add(s);
            } else if (choice == 2) {
                if (students.size() == 0) {
                    System.out.println("No student records found!");
                } else {
                    for (Student stu : students) {
                        stu.displayDetails();
                    }
                }
            } else if (choice == 3) {
                System.out.println("Exiting the application. Goodbye!");
            } else {
                System.out.println("Invalid choice, try again.");
            }
        } while (choice != 3);

        sc.close();
    }
}
