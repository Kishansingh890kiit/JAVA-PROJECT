class ParkingSlot {
    int slotNumber;
    VehicleType type;
    Vehicle vehicle;

    public ParkingSlot(int slotNumber, VehicleType type) {
        this.slotNumber = slotNumber;
        this.type = type;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle unpark() {
        Vehicle v = this.vehicle;
        this.vehicle = null;
        return v;
    }
}
