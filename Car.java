import java.util.Scanner;

public class Car {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cardetails[] carArr = {
                new Cardetails("Toyota", "Supra", 2007, 100000, false),
                new Cardetails("Nissan", "GTR", 2014, 200000, true),
                new Cardetails("Porsche", "GT3RS", 2020, 400000, false),
        };
        int cont=0;
        int choice = 0;
        while (cont == 0) {
            System.out.println("Car Management System");
            System.out.println("1. Display all available cars");
            System.out.println("2. Display all cars");
            System.out.println("3. Show the most expensive car");
            System.out.println("4. Calculate the average price of cars");
            System.out.println("5. Lease a car");

            System.out.print("Choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    displayAvCars(carArr);
                    break;
                case 2:
                    displayAll(carArr);
                    break;
                case 3:
                    System.out.println("The most expensive car is:");
                    mostExpensive(carArr).displayInfo();
                    break;
                case 4:
                    System.out.println("The average price of cars is: " + average(carArr));
                    break;
                case 5:
                    System.out.print("Enter the index (0-" + (carArr.length - 1) + ") of the car you want to lease: ");
                    int leaseChoice = sc.nextInt();
                    leaseCar(carArr, leaseChoice);
                    cont=1;
                    break;

            }
        }
        sc.close();
    }

    public static void displayAvCars(Cardetails[] car) {
        System.out.println("Available Cars (Not Leased):");
        for (Cardetails c : car) {
            if (!c.isLeased()) {
                c.displayInfo();
            }
        }
    }

    public static void displayAll(Cardetails[] car) {
        System.out.println("All Cars:");
        for (Cardetails c : car) {
            c.displayInfo();
        }
    }

    public static Cardetails mostExpensive(Cardetails[] car) {
        Cardetails mostExp = car[0];
        for (Cardetails c : car) {
            if (c.getPrice() > mostExp.getPrice()) {
                mostExp = c;
            }
        }
        return mostExp;
    }

    public static double average(Cardetails[] car) {
        int sum = 0;
        for (Cardetails c : car) {
            sum += c.getPrice();
        }
        return (double) sum / car.length;
    }

    public static void leaseCar(Cardetails[] car, int leaseChoice) {
        if (leaseChoice >= 0 && leaseChoice < car.length) {
            car[leaseChoice].leaseCar();
        }
    }
}

class Cardetails {
    private String make;
    private String model;
    private int year;
    private int price;
    private boolean isLeased;

    public Cardetails(String make, String model, int year, int price, boolean isLeased) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.isLeased = isLeased;
    }

    public void displayInfo() {
        System.out.println("Make: " + make + " / Model: " + model + " / Year: " + year +
                " / Price: " + price + " / Leased: " + isLeased);
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    public boolean isLeased() {
        return isLeased;
    }

    public void leaseCar() {
        if (!isLeased) {
            isLeased = true;
            System.out.println("The car " + make + " " + model + " has been leased.");
        } else {
            System.out.println("The car " + make + " " + model + " is already leased.");
        }
    }
}
