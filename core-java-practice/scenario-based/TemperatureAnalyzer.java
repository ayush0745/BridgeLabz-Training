public class TemperatureAnalyzer {

    public static void main(String[] args) {

        // Sample temperature data (7 days, 24 hours)
        float[][] temperatures = new float[7][24];

        // Fill with sample values
        for (int day = 0; day < 7; day++) {
            for (int hour = 0; hour < 24; hour++) {
                temperatures[day][hour] = 20 + day + (hour * 0.1f);
            }
        }

        int hottestDay = findHottestDay(temperatures);
        int coldestDay = findColdestDay(temperatures);
        float[] averages = averageTemperaturePerDay(temperatures);

        System.out.println("Hottest Day: Day " + (hottestDay + 1));
        System.out.println("Coldest Day: Day " + (coldestDay + 1));

        System.out.println("\nAverage Temperature Per Day:");
        for (int i = 0; i < averages.length; i++) {
            System.out.println("Day " + (i + 1) + ": " + averages[i]);
        }
    }

    // Method to find hottest day
    public static int findHottestDay(float[][] temps) {
        float maxTemp = Float.MIN_VALUE;
        int hottestDay = 0;

        for (int day = 0; day < temps.length; day++) {
            for (int hour = 0; hour < temps[day].length; hour++) {
                if (temps[day][hour] > maxTemp) {
                    maxTemp = temps[day][hour];
                    hottestDay = day;
                }
            }
        }
        return hottestDay;
    }

    // Method to find coldest day
    public static int findColdestDay(float[][] temps) {
        float minTemp = Float.MAX_VALUE;
        int coldestDay = 0;

        for (int day = 0; day < temps.length; day++) {
            for (int hour = 0; hour < temps[day].length; hour++) {
                if (temps[day][hour] < minTemp) {
                    minTemp = temps[day][hour];
                    coldestDay = day;
                }
            }
        }
        return coldestDay;
    }

    // Method to calculate average temperature per day
    public static float[] averageTemperaturePerDay(float[][] temps) {
        float[] averages = new float[temps.length];

        for (int day = 0; day < temps.length; day++) {
            float sum = 0;
            for (int hour = 0; hour < temps[day].length; hour++) {
                sum += temps[day][hour];
            }
            averages[day] = sum / temps[day].length;
        }
        return averages;
    }
}
