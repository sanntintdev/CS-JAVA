package AssignmentSix.car_rental_system;

interface TruckVehicle {
    double getCargoCapacity(); // in tons

    String getTransmissionType(); // manual or automatic

    void setCargoCapacity(double cargoCapacity);

    void setTransmissionType(String transmissionType);
}
