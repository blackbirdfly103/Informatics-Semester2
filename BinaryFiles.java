import java.io.*;
import java.util.Random;

public class BinaryFiles {
    public static void main(String[] args) {
        String filename = "students.dat";
        Random rand = new Random();

        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(filename))) {
            Student(out, 1001, "Alice Johnson", "11th Grade", rand);
            Student(out, 1002, "Brian Smith", "12th Grade", rand);
            Student(out, 1003, "Clara Lee", "10th Grade", rand);
            Student(out, 1004, "David Kim", "11th Grade", rand);
            Student(out, 1005, "Eva Torres", "9th Grade", rand);

            System.out.println("Student data with random GPA written to " + filename);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

        try (DataInputStream in = new DataInputStream(new FileInputStream(filename))) {
            System.out.println("\nStudent Records:");
            while (true) {
                int id = in.readInt();
                String name = in.readUTF();
                String grade = in.readUTF();
                double gpa = in.readDouble();

                System.out.println(" ID: "+id+", Name: "+name+", Grade: "+ grade+", GPA: " + gpa);
            }
        } catch (EOFException e) {
            System.out.println("\nFinished reading student records.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static void Student(DataOutputStream out, int id, String name, String grade, Random rand) throws IOException {
        double rawGPA = 2.0 + rand.nextDouble() * 2.0;
        double roundedGPA = Math.round(rawGPA * 10.0) / 10.0;
        out.writeInt(id);
        out.writeUTF(name);
        out.writeUTF(grade);
        out.writeDouble(roundedGPA);
    }
}
