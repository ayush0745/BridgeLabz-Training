import java.util.Scanner;

class Circle {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    public void display() {
      
        System.out.printf("Area of circle: %.2f%n", calculateArea());
        System.out.printf("Circumference of circle: %.2f%n", calculateCircumference());
    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter radius: ");
        double r = scanner.nextDouble();

        Circle c1 = new Circle(r);
        c1.display();

        scanner.close(); 
    }
}