import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        VesselUtil util = new VesselUtil();
        util.setVesselList(new ArrayList<>());

        System.out.println("Enter the number of vessels to be added");
        int n = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter vessel details");

        for (int i = 0; i < n; i++) {

            String input = sc.nextLine();

            String[] data = input.split(":");

            String vesselId = data[0];
			String vesselName = data[1];
            double averageSpeed = Double.parseDouble(data[2]);
            String vesselType = data[3];

            Vessel vessel = new Vessel(
                    vesselId,
                    vesselName,
                    averageSpeed,
                    vesselType
            );

            util.addVesselPerformance(vessel);
        }

        System.out.println("Enter the Vessel Id to check speed");

        String id = sc.nextLine();

        Vessel vessel = util.getVesselById(id);

        if (vessel != null) {
            System.out.println(
                    vessel.getVesselId() + " | " +
                    vessel.getVesselName() + " | " +
                    vessel.getVesselType() + " | " +
                    vessel.getAverageSpeed() + " knots"
            );
        } else {
            System.out.println("Vessel Id " + id + " not found");
        }

        System.out.println("High performance vessels are");

        List<Vessel> highPerformance =
                util.getHighPerformanceVessels();

        for (Vessel v : highPerformance) {
            System.out.println(
                    v.getVesselId() + " | " +
                    v.getVesselName() + " | " +
                    v.getVesselType() + " | " +
                    v.getAverageSpeed() + " knots"
            );
        }

        sc.close();
    }
}