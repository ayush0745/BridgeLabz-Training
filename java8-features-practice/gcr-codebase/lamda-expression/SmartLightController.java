@FunctionalInterface
interface LightAction {
    void activate();
}
public class SmartLightController {

    public static void main(String[] args) {

        // Motion detected
        LightAction motionTrigger = () ->
                System.out.println("Lights ON at full brightness");

        // Time-based (night)
        LightAction nightTrigger = () ->
                System.out.println("Lights ON in dim warm mode");

        // Voice command
        LightAction voiceTrigger = () ->
                System.out.println("Lights set to party mode 🎉");

        // Execute directly
        motionTrigger.activate();
        nightTrigger.activate();
        voiceTrigger.activate();
    }
}
