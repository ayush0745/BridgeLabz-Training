import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Program {

    // Register a creator
    public void registerCreator(CreatorStats record) {
        CreatorStats.EngagementBoard.add(record);
        System.out.println("Creator registered successfully");
    }

    // Get top posts based on like threshold
    public Map<String, Integer> getTopPostCounts(double likeThreshold) {
        Map<String, Integer> topPosts = new HashMap<>();

        for (CreatorStats creator : CreatorStats.EngagementBoard) {
            int count = 0;
            for (double like : creator.getWeeklyLikes()) {
                if (like >= likeThreshold) {
                    count++;
                }
            }
            if (count > 0) {
                topPosts.put(creator.getCreatorName(), count);
            }
        }

        return topPosts;
    }

    // Calculate average weekly likes
    public double calculateAverageLikes() {
        if (CreatorStats.EngagementBoard.isEmpty()) {
            return 0;
        }

        double totalLikes = 0;
        int totalWeeks = 0;

        for (CreatorStats creator : CreatorStats.EngagementBoard) {
            for (double like : creator.getWeeklyLikes()) {
                totalLikes += like;
                totalWeeks++;
            }
        }

        return totalLikes / totalWeeks;
    }

    // Main method
    public static void main(String[] args) {
        Program program = new Program();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Register Creator");
            System.out.println("2. Show Top Posts");
            System.out.println("3. Calculate Average Likes");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            String choiceInput = sc.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(choiceInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Try again.");
                continue;
            }

            switch (choice) {
                case 1:
                    // Register a new creator
                    System.out.print("Enter Creator Name: ");
                    String name = sc.nextLine();

                    double[] likes = new double[4];
                    System.out.println("Enter weekly likes (Week 1 to 4):");
                    for (int i = 0; i < 4; i++) {
                        while (true) {
                            System.out.print("Week " + (i + 1) + ": ");
                            try {
                                likes[i] = Double.parseDouble(sc.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Enter a numeric value:");
                            }
                        }
                    }

                    CreatorStats record = new CreatorStats(name, likes);
                    program.registerCreator(record);
                    break;

                case 2:
                    // Show top posts
                    System.out.print("Enter like threshold: ");
                    double threshold;
                    while (true) {
                        try {
                            threshold = Double.parseDouble(sc.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Enter a numeric value:");
                        }
                    }

                    Map<String, Integer> topPosts = program.getTopPostCounts(threshold);
                    if (topPosts.isEmpty()) {
                        System.out.println("No top-performing posts this week");
                    } else {
                        for (String creatorName : topPosts.keySet()) {
                            System.out.println(creatorName + " - " + topPosts.get(creatorName));
                        }
                    }
                    break;

                case 3:
                    // Calculate average likes
                    double average = program.calculateAverageLikes();
                    System.out.println("Overall average weekly likes: " + Math.round(average));
                    break;

                case 4:
                    System.out.println("Logging off - Keep Creating with StreamBuzz!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }

        sc.close();
    }
}
