import java.util.Scanner;

public class RandomStats {

    public static void main(String[] args) {
        
        int[] randomNumbers = generate4DigitRandomArray(5);

        // Display the generated numbers
        System.out.print("Generated 4-digit numbers: ");
        for (int num : randomNumbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 2. Find Average, Min, and Max
        double[] stats = app.findAverageMinMax(randomNumbers);

        // 3. Display results
        System.out.printf("Average: %.2f%n", stats[0]);
        System.out.printf("Minimum: %.0f%n", stats[1]);
        System.out.printf("Maximum: %.0f%n", stats[2]);
    }

    public static int[] generate4DigitRandomArray(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
           
            numbers[i] = (int) (Math.random() * 9000) + 1000;
        }
        return numbers;
    }


    public double[] findAverageMinMax(int[] numbers) {
        int sum = 0;
        int min = numbers[0];
        int max = numbers[0];

        for (int num : numbers) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        double average = (double) sum / numbers.length;
        return new double[]{average, (double) min, (double) max};
    }
}