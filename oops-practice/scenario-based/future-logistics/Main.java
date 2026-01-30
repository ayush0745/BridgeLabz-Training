import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Goods Transport details");
        String input = sc.nextLine();

        GoodsTransport gt = Utility.parseDetails(input);
        if (gt == null) return;

        System.out.println("Transporter id : " + gt.getTransportId());
        System.out.println("Date of transport : " + gt.getTransportDate());
        System.out.println("Rating of the transport : " + gt.getTransportRating());

        if (gt instanceof BrickTransport) {
            BrickTransport bt = (BrickTransport) gt;
            System.out.println("Vehicle for transport : " + bt.vehicleSelection());
            System.out.println("Total charge : " + bt.calculateTotalCharge());
        } else {
            TimberTransport tt = (TimberTransport) gt;
            System.out.println("Vehicle for transport : " + tt.vehicleSelection());
            System.out.println("Total charge : " + tt.calculateTotalCharge());
        }
    }
}

//sample input -- RTS120A:12/8/21:5:BrickTransport:6:800:40