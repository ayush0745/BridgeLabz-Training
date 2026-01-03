class Device {
    private String deviceId;
    private String status;

    // Constructor
    Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    // Getters
    public String getDeviceId() {
        return deviceId;
    }

    public String getStatus() {
        return status;
    }

    // Method to display device status
    void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}

class Thermostat extends Device {
    private int temperatureSetting;

    // Constructor
    Thermostat(String deviceId, String status, int temperatureSetting) {
        super(deviceId, status); // call Device constructor
        this.temperatureSetting = temperatureSetting;
    }

    // Getter
    public int getTemperatureSetting() {
        return temperatureSetting;
    }

    // Override displayStatus
    @Override
    void displayStatus() {
        super.displayStatus(); 
        System.out.println("Temperature Setting: " + temperatureSetting + "C");
    }
}

public class SmartHomeSystem {
    public static void main(String[] args) {
        Thermostat thermostat1 = new Thermostat(
                "TH-01",
                "ON",
                24
        );

        thermostat1.displayStatus();
    }
}
