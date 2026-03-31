import java.util.*;
public class Book {
	String title;
	String author;
	double price;
	
	//default constructor
	 Book() {
	        title = "Unknown";
	        author = "Unknown";
	        price = 0.0;
	    }
	// Parameterized Constructor 
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
  
public static void main(String[] args) {
	Book b1 = new Book();  
    Book b2 = new Book("Clean Code", "Robert C. Martin", 450.0);

    System.out.println(b1.title + ", " + b1.author + ", " + b1.price);
    System.out.println(b2.title + ", " + b2.author + ", " + b2.price);
        
    }

}
