import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class MathQuestions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine().trim();
        String fileName = userName + "-answers.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (int i = 1; i <= 5; i++) {
                int num1 = rand.nextInt(50) + 1;
                int num2 = rand.nextInt(50) + 1;
                char operator;
                int correctAns;

                int op = rand.nextInt(3);
                if (op == 0) {
                    operator = '+';
                    correctAns = num1 + num2;
                } else if (op == 1) {
                    operator = '-';
                    correctAns = num1 - num2;
                } else {
                    operator = '*';
                    correctAns = num1 * num2;
                }

                System.out.print("Question " + i + ": " + num1 + " " + operator + " " + num2 + " = ");
                int userAnswer = scanner.nextInt();

                boolean isCorrect = (userAnswer == correctAns);

                writer.println("Question " + i + ": " + num1 + " " + operator + " " + num2 + " = " + userAnswer
                        + " | Correct Answer: " + correctAns + " | " + (isCorrect ? "Correct" : "Incorrect"));
            }

            System.out.println("Results saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
