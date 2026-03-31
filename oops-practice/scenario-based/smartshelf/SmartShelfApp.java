public class SmartShelfApp {
    public static void main(String[] args) {

        SmartShelf shelf = new SmartShelf();

        shelf.addBook("Java Programming");
        shelf.addBook("Algorithms");
        shelf.addBook("Data Structures");
        shelf.addBook("Artificial Intelligence");

        shelf.displayShelf();
    }
}
