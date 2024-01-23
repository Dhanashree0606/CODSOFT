import java.util.Scanner;

public class GradeCalculator 
{

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("           Student Grade Calculator");
        System.out.println("Enter marks (out of 100) for each subject:");

        int totalSubjects = 5;
        int maxMarksPerSubject = 100;

        int[] subjectMarks = new int[totalSubjects];
        for (int i = 0; i < totalSubjects; i++) 
        {
            System.out.print("Subject " + (i + 1) + ": ");
            subjectMarks[i] = getValidMarks(scanner, maxMarksPerSubject);
        }

        int totalMarks = calculateTotalMarks(subjectMarks);
        double averagePercentage = calculateAveragePercentage(totalMarks, totalSubjects, maxMarksPerSubject);

        char grade = calculateGrade(averagePercentage);

        System.out.println("\nResults:");
        displaySubjectWiseMarks(subjectMarks);
        System.out.println("Total Marks: " + totalMarks + " out of " + (totalSubjects * maxMarksPerSubject));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    private static int getValidMarks(Scanner scanner, int maxMarks)
     {
        int marks;
        do 
        {
            marks = scanner.nextInt();
            if (marks < 0 || marks > maxMarks) 
            {
                System.out.println("Invalid input. Marks should be between 0 and " + maxMarks + ". Please enter again:");
            }
        } while (marks < 0 || marks > maxMarks);
        return marks;
    }

    private static int calculateTotalMarks(int[] marks) 
    {
        int totalMarks = 0;
        for (int mark : marks) 
        {
            totalMarks += mark;
        }
        return totalMarks;
    }

    private static double calculateAveragePercentage(int totalMarks, int totalSubjects, int maxMarksPerSubject) 
    {
        return (double) totalMarks / (totalSubjects * maxMarksPerSubject) * 100;
    }

    private static char calculateGrade(double averagePercentage) 
    {
        if (averagePercentage >= 90) 
        {
            return 'A';
        } else if (averagePercentage >= 80) 
        {
            return 'B';
        } else if (averagePercentage >= 70) 
        {
            return 'C';
        } else if (averagePercentage >= 50) 
        {
            return 'D';
        } else if (averagePercentage >= 38) 
        {
            return 'E';
        } else 
        {
            return 'F';
        }
    }

    private static void displaySubjectWiseMarks(int[] marks) 
    {
        System.out.println("Subject-wise Marks:");
        for (int i = 0; i < marks.length; i++) 
        {
            System.out.println("Subject " + (i + 1) + ": " + marks[i]);
        }
    }
}