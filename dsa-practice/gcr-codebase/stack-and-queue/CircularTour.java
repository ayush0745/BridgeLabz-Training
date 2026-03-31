public class CircularTour {

    public static int findStartingPoint(int[] petrol, int[] distance) {

        int totalPetrol = 0;
        int currentPetrol = 0;
        int start = 0;

        for (int i = 0; i < petrol.length; i++) {

            int gain = petrol[i] - distance[i];
            totalPetrol += gain;
            currentPetrol += gain;

            // If we can't reach next station
            if (currentPetrol < 0) {
                start = i + 1;
                currentPetrol = 0;
            }
        }

        return totalPetrol >= 0 ? start : -1;
    }

    public static void main(String[] args) {

        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int start = findStartingPoint(petrol, distance);

        if (start == -1) {
            System.out.println("No possible circular tour");
        } else {
            System.out.println("Start at petrol pump index: " + start);
        }
    }
}
