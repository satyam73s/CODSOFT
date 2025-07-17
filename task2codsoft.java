import java.util.Scanner;

public class task2codsoft {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(".....Student Grade Calculator.....");

        int totalubjects = 0;
        System.out.print("Enter the number of subjects: ");
        totalsubjects = scanner.nextInt();

        int totalmarks = 0;

        for (int i = 0; i < totalubjects; i++) {
            int marks = -1;
            System.out.printf("Enter marks obtained in subject %d (out of 100): ", (i + 1));
            marks = scanner.nextInt();
            totalmarks += marks;
        }

        double averagepercentage = (double) totalmarks / totalsubjects;

        String grade;
        if (averagepercentage >= 90) {
            grade = "A";
        } else if (averagepercentage >= 80) {
            grade = "B";
        } else if (averagepercentage >= 70) {
            grade = "C";
        } else if (averagepercentage >= 60) {
            grade = "D";
        } else if (averagepercentage >= 50) {
            grade = "E";
        } else {
            grade = "F";
        }

        System.out.println("\n--- Results ---");
        System.out.println("Total Marks: " + totalmarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagepercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
