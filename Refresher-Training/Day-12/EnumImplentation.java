enum Season {
    WINTER("Cold"),
    SPRING("Mild"),
    SUMMER("Hot"),
    FALL("Cool");

    private final String description;

    Season(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

public class Main {
    public static void main(String[] args) {

        for (Season season : Season.values()) {
            System.out.println(season.name() + " - " + season.getDescription());
        }

        System.out.println();

        Season current = Season.SUMMER;

        switch (current) {
            case SUMMER:
                System.out.println("It is hot in summer!");
                break;

            default:
                System.out.println("It is not summer.");
        }
    }
}