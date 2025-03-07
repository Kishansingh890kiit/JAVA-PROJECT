import java.util.Scanner;

public class ParkingLotSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingLot parkingLot = null;

        while (true) {
            String command = scanner.nextLine();
            String[] parts = command.split(" ");

            switch (parts[0]) {
                case "create_parking_lot":
                    parkingLot = new ParkingLot(parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
                    System.out.println("Created parking lot with " + parts[2] + " floors and " + parts[3] + " slots per floor");
                    break;
                case "park_vehicle":
                    if (parkingLot != null) {
                        String ticketId = parkingLot.parkVehicle(new Vehicle(VehicleType.valueOf(parts[1]), parts[2], parts[3]));
                        if (ticketId != null) {
                            System.out.println("Parked vehicle. Ticket ID: " + ticketId);
                        } else {
                            System.out.println("Parking Lot Full");
                        }
                    }
                    break;
                case "unpark_vehicle":
                    if (parkingLot != null) {
                        Vehicle vehicle = parkingLot.unparkVehicle(parts[1]);
                        if (vehicle != null) {
                            System.out.println("Unparked vehicle with Registration Number: " + vehicle.registrationNumber + " and Color: " + vehicle.color);
                        } else {
                            System.out.println("Invalid Ticket");
                        }
                    }
                    break;
                case "display":
                    if (parkingLot != null) {
                        VehicleType type = VehicleType.valueOf(parts[2]);
                        switch (parts[1]) {
                            case "free_count":
                                parkingLot.displayFreeCount(type);
                                break;
                            case "free_slots":
                                parkingLot.displayFreeSlots(type);
                                break;
                            case "occupied_slots":
                                parkingLot.displayOccupiedSlots(type);
                                break;
                        }
                    }
                    break;
                case "exit":
                    return;
            }
        }
    }
}
