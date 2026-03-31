// LegacyAPI class
class LegacyAPI {

    // Old method, marked as deprecated
    @Deprecated
    public void oldFeature() {
        System.out.println("This is the old feature. Avoid using it!");
    }

    // New recommended method
    public void newFeature() {
        System.out.println("This is the new feature. Use this instead!");
    }
}

// Main class to test
public class DeprecatedAnnotation {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();

        // Calling the old deprecated method
        api.oldFeature(); // This will show a warning in the IDE/compiler

        // Calling the new method
        api.newFeature();
    }
}
