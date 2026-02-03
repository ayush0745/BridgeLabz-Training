import com.fasterxml.jackson.databind.ObjectMapper;

class Car {
    private String brand;
    private int year;
    private double price;

    // Required by Jackson
    public Car() {}

    public Car(String brand, int year, double price) {
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    // getters & setters
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
 
 public class CarJson {
     public static void main(String[] args) {
         try {
             ObjectMapper mapper = new ObjectMapper();

             Car car = new Car("Tesla", 2024, 55000.50);

             String json = mapper.writeValueAsString(car);
             System.out.println(json);

         } catch (Exception e) {
             e.printStackTrace();
         }
     }
 }
