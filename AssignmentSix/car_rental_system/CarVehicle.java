package AssignmentSix.car_rental_system;

interface CarVehicle {
    int getNumberOfDoors();

    String getFuelType(); // petrol, diesel, or electric

    void setNumberOfDoors(int numberOfDoors);

    void setFuelType(String fuelType);
}