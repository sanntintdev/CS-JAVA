package AssignmentSix.car_rental_system;

import java.util.Scanner;

public class CarRentalAgency {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRunning = true; // Flag to keep the program running

        while (isRunning) {
            displayMenu();
            int userChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            // Switch statement to handle user choice
            switch (userChoice) {
                case 1:
                    Car car = createCar();
                    displayVehicleDetails(car);
                    break;
                case 2:
                    Motorcycle motorcycle = createMotorcycle();
                    displayVehicleDetails(motorcycle);
                    break;
                case 3:
                    Truck truck = createTruck();
                    displayVehicleDetails(truck);
                    break;
                case 4:
                    System.out.println("Exiting program... Goodbye!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Display menu
    private static void displayMenu() {
        System.out.println("\nWelcome to Sann Tint Aung Car Rental System");
        System.out.println("1. Create Car");
        System.out.println("2. Create Motorcycle");
        System.out.println("3. Create Truck");
        System.out.println("4. Exit");
    }

    public static Car createCar() {
        System.out.print("Enter car make: ");
        String make = scanner.nextLine();

        System.out.print("Enter car model: ");
        String model = scanner.nextLine();

        System.out.print("Enter car year of manufacture: ");
        int yearOfManufacture = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter number of doors: ");
        int numberOfDoors = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter fuel type (petrol, diesel, or electric): ");
        String fuelType = scanner.nextLine();

        return new Car(make, model, yearOfManufacture, numberOfDoors, fuelType);
    }

    public static Motorcycle createMotorcycle() {
        System.out.print("Enter motorcycle make: ");
        String make = scanner.nextLine();

        System.out.print("Enter motorcycle model: ");
        String model = scanner.nextLine();

        System.out.print("Enter motorcycle year of manufacture: ");
        int yearOfManufacture = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter number of wheels: ");
        int numberOfWheels = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter motorcycle type (sport, cruiser, or off-road): ");
        String motorcycleType = scanner.nextLine();

        return new Motorcycle(make, model, yearOfManufacture, numberOfWheels, motorcycleType);
    }

    public static Truck createTruck() {
        System.out.print("Enter truck make: ");
        String make = scanner.nextLine();

        System.out.print("Enter truck model: ");
        String model = scanner.nextLine();

        System.out.print("Enter truck year of manufacture: ");
        int yearOfManufacture = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter cargo capacity (in tons): ");
        double cargoCapacity = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter truck transmission type (automatic or manual): ");
        String transmissionType = scanner.nextLine();

        return new Truck(make, model, yearOfManufacture, cargoCapacity, transmissionType);
    }

    public static void displayVehicleDetails(Vehicle vehicle) {
        System.out.println("\n==================================");
        System.out.println("Vehicle Details:");
        System.out.println("Make: " + vehicle.getMake());
        System.out.println("Model: " + vehicle.getModel());
        System.out.println("Year of Manufacture: " + vehicle.getYearOfManufacture());

        if (vehicle instanceof Car) {
            Car car = (Car) vehicle;
            System.out.println("Number of Doors: " + car.getNumberOfDoors());
            System.out.println("Fuel Type: " + car.getFuelType());
        } else if (vehicle instanceof Motorcycle) {
            Motorcycle motorcycle = (Motorcycle) vehicle;
            System.out.println("Number of Wheels: " + motorcycle.getNumberOfWheels());
            System.out.println("Motorcycle Type: " + motorcycle.getMotorcycleType());
        } else if (vehicle instanceof Truck) {
            Truck truck = (Truck) vehicle;
            System.out.println("Cargo Capacity: " + truck.getCargoCapacity() + " tons");
            System.out.println("Transmission Type: " + truck.getTransmissionType());
        }
        System.out.println("==================================");

        System.out.println();
    }
}
