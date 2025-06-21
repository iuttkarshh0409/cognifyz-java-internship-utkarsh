import java.util.*;

class Student {
    Scanner sc = new Scanner(System.in);
    int roll_no;
    String name;
    int eng_marks, hin_marks, phy_marks, chem_marks, math_marks;
    float total_marks;
    char grade;

    void inputData() {
        System.out.println("---Details entry Menu---");

        System.out.print("Enter roll number: ");
        roll_no = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter full name: ");
        name = sc.nextLine();

        System.out.println();

        System.out.println("--Marks entry Menu--");

        System.out.print("Enter marks of English: ");
        eng_marks = sc.nextInt();
        System.out.print("Enter marks of Hindi: ");
        hin_marks = sc.nextInt();
        System.out.print("Enter marks of Physics: ");
        phy_marks = sc.nextInt();
        System.out.print("Enter marks of Chemistry: ");
        chem_marks = sc.nextInt();
        System.out.print("Enter marks of Maths: ");
        math_marks = sc.nextInt();

        sc.close();
    }

    void showDetails() {
        System.out.println("\nStudent Details:");
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + roll_no);
    }

    void calculateGrade() {
        total_marks = eng_marks + hin_marks + phy_marks + chem_marks + math_marks;
        float percentage = (total_marks / 500.0f) * 100;

        if (percentage >= 90) grade = 'A';
        else if (percentage >= 80) grade = 'B';
        else if (percentage >= 70) grade = 'C';
        else if (percentage >= 60) grade = 'D';
        else if (percentage >= 50) grade = 'E';
        else grade = 'F';

        System.out.println("Overall Grade: " + grade + (grade == 'F' ? " (Fail)" : ""));
    }

    void printReportCard() {
        System.out.println("\n--- Report Card ---");
        System.out.println("Subject-wise Marks:");
        System.out.println("English: " + eng_marks);
        System.out.println("Hindi: " + hin_marks);
        System.out.println("Physics: " + phy_marks);
        System.out.println("Chemistry: " + chem_marks);
        System.out.println("Maths: " + math_marks);

        System.out.println("\n--Overall Performance:--");
        System.out.println("Total Marks: " + total_marks + " / 500");
        System.out.printf("Percentage: %.2f%%\n", (total_marks / 500.0f) * 100);
        System.out.println("Grade: " + grade);
    }
}

public class ReportCard {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.inputData();
        s1.showDetails();
        s1.calculateGrade();
        s1.printReportCard();
    }
}
