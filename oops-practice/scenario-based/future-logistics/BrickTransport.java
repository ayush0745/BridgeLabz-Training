public class BrickTransport extends GoodsTransport {

    private float brickSize;
    private int brickQuantity;
    private float brickPrice;

    public BrickTransport(String transportId, String transportDate, int transportRating,
                          float brickSize, int brickQuantity, float brickPrice) {
        super(transportId, transportDate, transportRating);
        this.brickSize = brickSize;
        this.brickQuantity = brickQuantity;
        this.brickPrice = brickPrice;
    }

    public String vehicleSelection() {
        if (brickQuantity < 300)
            return "Truck";
        else if (brickQuantity <= 500)
            return "Lorry";
        else
            return "MonsterLorry";
    }

    public float calculateTotalCharge() {
        float price = brickPrice * brickQuantity;
        float tax = price * 0.3f;

        float vehiclePrice = 0;
        String vehicle = vehicleSelection().toLowerCase();

        if (vehicle.equals("truck"))
            vehiclePrice = 1000;
        else if (vehicle.equals("lorry"))
            vehiclePrice = 1700;
        else
            vehiclePrice = 3000;

        float discount = 0;
        if (getTransportRating()== 5)
            discount = price * 0.20f;
        else if (getTransportRating() == 3 || getTransportRating() == 4)
            discount = price * 0.10f;

        return (price + tax + vehiclePrice) - discount;
    }
}
