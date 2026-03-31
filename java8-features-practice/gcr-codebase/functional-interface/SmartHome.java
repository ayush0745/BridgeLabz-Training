public class SmartHome {

    // Interface
    interface SmartDevice {
        void turnOn();
        void turnOff();
    }

    // Light class
    static class Light implements SmartDevice {
        public void turnOn() {
            System.out.println("Light is ON");
        }

        public void turnOff() {
            System.out.println("Light is OFF");
        }
    }

    // AC class
    static class AC implements SmartDevice {
        public void turnOn() {
            System.out.println("AC is cooling");
        }

        public void turnOff() {
            System.out.println("AC is OFF");
        }
    }

    // TV class
    static class TV implements SmartDevice {
        public void turnOn() {
            System.out.println("TV is ON");
        }

        public void turnOff() {
            System.out.println("TV is OFF");
        }
    }

    // Main method
    public static void main(String[] args) {

        SmartDevice light = new Light();
        SmartDevice ac = new AC();
        SmartDevice tv = new TV();

        light.turnOn();
        ac.turnOn();
        tv.turnOn();

        light.turnOff();
        ac.turnOff();
        tv.turnOff();
    }
}
