import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    String parkingLotId;
    List<ParkingFloor> floors;

    public ParkingLot(String parkingLotId, int numFloors, int numSlotsPerFloor) {
        this.parkingLotId = parkingLotId;
        this.floors = new ArrayList<>();
        for (int i = 1; i <= numFloors; i++) {
            floors.add(new ParkingFloor(i, numSlotsPerFloor));
        }
    }

    public String parkVehicle(Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            ParkingSlot slot = floor.getFirstAvailableSlot(vehicle.type);
            if (slot != null) {
                slot.park(vehicle);
                return parkingLotId + "_" + floor.floorNumber + "_" + slot.slotNumber;
            }
        }
        return null;
    }

    public Vehicle unparkVehicle(String ticketId) {
        String[] parts = ticketId.split("_");
        int floorNumber = Integer.parseInt(parts[1]);
        int slotNumber = Integer.parseInt(parts[2]);
        ParkingFloor floor = floors.get(floorNumber - 1);
        ParkingSlot slot = floor.slots.get(slotNumber - 1);
        return slot.unpark();
    }

    public void displayFreeCount(VehicleType type) {
        for (ParkingFloor floor : floors) {
            System.out.println("No. of free slots for " + type + " on Floor " + floor.floorNumber + ": " + floor.getFreeSlotCount(type));
        }
    }

    public void displayFreeSlots(VehicleType type) {
        for (ParkingFloor floor : floors) {
            System.out.println("Free slots for " + type + " on Floor " + floor.floorNumber + ": " + floor.getFreeSlots(type));
        }
    }

    public void displayOccupiedSlots(VehicleType type) {
        for (ParkingFloor floor : floors) {
            System.out.println("Occupied slots for " + type + " on Floor " + floor.floorNumber + ": " + floor.getOccupiedSlots(type));
        }
    }
}
