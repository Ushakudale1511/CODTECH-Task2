import java.util.ArrayList;
import java.util.Scanner;

class StudentGradeTracker {
    private ArrayList<Double> grades;

    public StudentGradeTracker() {
        grades = new ArrayList<>();
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public double calculateAverage() {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public String getLetterGrade(double average) {
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public double calculateGPA(double average) {
        if (average >= 90) {
            return 4.0;
        } else if (average >= 80) {
            return 3.0;
        } else if (average >= 70) {
            return 2.0;
        } else if (average >= 60) {
            return 1.0;
        } else {
            return 0.0;
        }
    }

    public void displayGrades() {
        System.out.println("Grades: " + grades);
        double average = calculateAverage();
        System.out.printf("Average Grade: %.2f\n", average);
        System.out.println("Letter Grade: " + getLetterGrade(average));
        System.out.printf("GPA: %.2f\n", calculateGPA(average));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentGradeTracker tracker = new StudentGradeTracker();

        System.out.println("Enter grades (type 'done' to finish):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                double grade = Double.parseDouble(input);
                tracker.addGrade(grade);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric grade or 'done' to finish.");
            }
        }

        tracker.displayGrades();
        scanner.close();
    }
}
