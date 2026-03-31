class Product {
    int id;
    String name;
    double price;
    int stock;

    public Product(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public void display() {
        System.out.println(id + " | " + name + " | Price: " + price + " | Stock: " + stock);
    }
}
