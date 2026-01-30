public class Utility {

    public static boolean validate(String transportId) {
        return transportId.matches("[A-Z]{3}[0-9]{3}[A-Z]");
    }

    public static GoodsTransport parseDetails(String input) {

        String[] data = input.split(":");
        String transportId = data[0];

        if (!validate(transportId)) {
            System.out.println("Transport id " + transportId + " is invalid");
            System.out.println("Please provide a valid record");
            return null;
        }

        String transportDate = data[1];
        int transportRating = Integer.parseInt(data[2]);
        String transportType = data[3];

        if (transportType.equalsIgnoreCase("BrickTransport")) {

            return new BrickTransport(
                    transportId,
                    transportDate,
                    transportRating,
                    Float.parseFloat(data[4]),
                    Integer.parseInt(data[5]),
                    Float.parseFloat(data[6])
            );

        } else { // TimberTransport

            return new TimberTransport(
                    transportId,
                    transportDate,
                    transportRating,
                    Float.parseFloat(data[4]),
                    Float.parseFloat(data[5]),
                    data[6],
                    Float.parseFloat(data[7])
            );
        }
    }

    public static String findObjectType(GoodsTransport goodsTransport) {

        if (goodsTransport instanceof TimberTransport)
            return "TimberTransport";
        else
            return "BrickTransport";
    }
}
