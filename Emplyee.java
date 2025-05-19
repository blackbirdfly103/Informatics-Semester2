import java.io.*;
import java.util.*;

class Employee implements Serializable {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + "}";
    }
}

public class Emplyee {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter name: ");
            String name = scan.nextLine();
            System.out.print("Enter age: ");
            int age = Integer.parseInt(scan.nextLine());
            System.out.print("Enter salary: ");
            double salary = Double.parseDouble(scan.nextLine());
            employees.add(new Employee(name, age, salary));
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employees.txt" ))) {
            for (Employee e : employees) out.writeObject(e);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("employees.txt"))) {
            while (true) {
                Employee e = (Employee) in.readObject();
                System.out.println(e);
            }
        } catch (EOFException e) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
