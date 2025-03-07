import java.util.*;



class Vehicle {
    String registrationNumber;
    String color;
    VehicleType type;

    public Vehicle(VehicleType type, String registrationNumber, String color) {
        this.type = type;
        this.registrationNumber = registrationNumber;
        this.color = color;
    }
}
