package AssignmentSix.car_rental_system;

interface MotorVehicle {
    int getNumberOfWheels();

    String getMotorcycleType(); // sport, cruiser, or off-road

    void setNumberOfWheels(int numberOfWheels);

    void setMotorcycleType(String motorcycleType);
}
