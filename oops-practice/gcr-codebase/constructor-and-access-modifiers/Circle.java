class Circle {
    double radius;

    // Default constructor
    Circle() {
        this(1.0);
    }

    // Parameterized constructor
    Circle(double radius) {
        this.radius = radius;
    }

    // Area method 
    public double area() {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        Circle area1 = new Circle();
        Circle area2 = new Circle(2);

        System.out.println(area1.area());
        System.out.println(area2.area());
    }
}
