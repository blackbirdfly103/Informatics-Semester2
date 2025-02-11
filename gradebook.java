import java.util.Scanner;

public class gradebook {
    public static void main(String[] args) {
        String[] students = {"Nikoleta", "Vasil", "Martin","Svetoslav","Irina", "Aleksandar"};
        int[] grades = {99, 49, 89, 45, 35, 78};
        Scanner sc = new Scanner(System.in);
        System.out.println("Average: " + calculateAverage(grades));
        System.out.println("Highest Grade Student: " + findHighestGradeStudent(students,grades));
        System.out.println("Lowest Grade Student: " + findLowestGradeStudent(students,grades));
        System.out.println("Failing Students: " + countFailedStudents(grades));
        System.out.println("................................................................");
        System.out.println("Score: " + lookupStudentGrade(students, grades, sc.nextLine()));

        /* Implement a switch case for the menu:
         * 2. Display the student with the highest grade
         * 3. Display the student with the lowest grade
         * 4. Display the count of students who are failing (>50 is failing)
         * 5. Look up student grade with user input.
         * 6. Exit. */
    }

    private static double calculateAverage(int[] grades) {
        int sum = 0;
        for(int i = 0; i < grades.length; i++){
            sum+=grades[i];
        }
        double average = (double)sum/grades.length;
        return average;
    }

    private static String findHighestGradeStudent(String[] studentNames, int[] grades) {
        int highest = 0;
        int pos = 0;
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] > highest) {
                highest = grades[i];
                pos = i;
            }
        }
        return studentNames[pos];
    }

    private static String findLowestGradeStudent(String[] studentNames, int[] grades) {
        int lowest = 100;
        int pos = 0;
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] < lowest) {
                lowest = grades[i];
                pos = i;
            }
        }
        return studentNames[pos];
    }

    private static int countFailedStudents(int[] grades) {
        int failed = 0;
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] < 50) {
                failed++;
            }
        }
        return failed;
    }

    private static int lookupStudentGrade(String[] studentNames, int[] grades, String studentToLookup) {
        int s =0;
        for (int i = 0; i < studentNames.length; i++) {
            if (studentNames[i].equals(studentToLookup)) {
                s = i;
            }
        }
        return grades[s];
    }
}