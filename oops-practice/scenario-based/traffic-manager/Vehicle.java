// Node representing a vehicle in roundabout
class Vehicle {
    String vehicleNo;
    Vehicle next;

    Vehicle(String vehicleNo) {
        this.vehicleNo = vehicleNo;
        this.next = null;
    }
}
