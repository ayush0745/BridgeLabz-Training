abstract class GoodsTransport{
	private String transportId;
	private String transportDate;
	private int transportRating;
	
	public GoodsTransport( String transportId,String transportDate,int transportRating) {
		this.transportDate = transportDate;
		this.transportId = transportId;
		this.transportRating = transportRating;
		
	}
	public void setTransportId(String transportId) {
		this.transportId = transportId;
	}
	public String getTransportId() {
		return transportId;
	}
	
	public void setTransportDate(String transportDate) {
		this.transportDate = transportDate;
	}
	public String getTransportDate() {
		return transportDate;
	}
	
	public void setTransportrating(int transportRating) {
		this.transportRating = transportRating;
	}
	public int getTransportRating() {
		return transportRating;
	}
	
	
	public abstract String vehicleSelection();
	
	public abstract float calculateTotalCharge();
}