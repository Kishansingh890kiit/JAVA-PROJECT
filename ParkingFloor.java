import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    int floorNumber;
    List<ParkingSlot> slots;

    public ParkingFloor(int floorNumber, int numSlots) {
        this.floorNumber = floorNumber;
        this.slots = new ArrayList<>();
        for (int i = 1; i <= numSlots; i++) {
            if (i == 1) {
                slots.add(new ParkingSlot(i, VehicleType.TRUCK));
            } else if (i == 2 || i == 3) {
                slots.add(new ParkingSlot(i, VehicleType.BIKE));
            } else {
                slots.add(new ParkingSlot(i, VehicleType.CAR));
            }
        }
    }

    public ParkingSlot getFirstAvailableSlot(VehicleType type) {
        for (ParkingSlot slot : slots) {
            if (slot.type == type && slot.isAvailable()) {
                return slot;
            }
        }
        return null;
    }

    public int getFreeSlotCount(VehicleType type) {
        int count = 0;
        for (ParkingSlot slot : slots) {
            if (slot.type == type && slot.isAvailable()) {
                count++;
            }
        }
        return count;
    }

    public List<Integer> getFreeSlots(VehicleType type) {
        List<Integer> freeSlots = new ArrayList<>();
        for (ParkingSlot slot : slots) {
            if (slot.type == type && slot.isAvailable()) {
                freeSlots.add(slot.slotNumber);
            }
        }
        return freeSlots;
    }

    public List<Integer> getOccupiedSlots(VehicleType type) {
        List<Integer> occupiedSlots = new ArrayList<>();
        for (ParkingSlot slot : slots) {
            if (slot.type == type && !slot.isAvailable()) {
                occupiedSlots.add(slot.slotNumber);
            }
        }
        return occupiedSlots;
    }
}
