public class FitnessTracker {
    public static void main(String[] args) {
       
        int[] dailyPushUps = {25, 30, 0, 40, 0, 50, 45};
        
        int totalPushUps = 0;
        int activeDays = 0;

       
        for (int count : dailyPushUps) {
            
          
            if (count == 0) {
                continue; 
            }

            totalPushUps += count;
            activeDays++;
        }

      
        double average = (activeDays > 0) ? (double) totalPushUps / activeDays : 0;

        // Output results
        System.out.println(" Sandeep Weekly Progress");
        System.out.println("Total Push-ups: " + totalPushUps);
        System.out.println("Average per active day: " + String.format("%.2f", average));
        System.out.println("Days skipped: " + (dailyPushUps.length - activeDays));
    }
}