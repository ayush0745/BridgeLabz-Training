abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private boolean isBorrowed;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public String getItemDetails() {
        return "[" + itemId + "] " + title + " by " + author + 
               " | Status: " + (isBorrowed ? "Checked Out" : "Available");
    }

    
    public abstract int getLoanDuration();

  
    public String getTitle() { return title; }
    public boolean isBorrowed() { return isBorrowed; }
    public void setBorrowed(boolean status) { this.isBorrowed = status; }
}
interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}
class Book extends LibraryItem implements Reservable {
    public Book(String id, String title, String author) { super(id, title, author); }

    @Override
    public int getLoanDuration() { return 21; } 

    @Override
    public void reserveItem(String name) {
        System.out.println("Book '" + getTitle() + "' reserved for " + name);
    }

    @Override
    public boolean checkAvailability() { return !isBorrowed(); }
}

class Magazine extends LibraryItem {
    public Magazine(String id, String title, String author) { super(id, title, author); }

    @Override
    public int getLoanDuration() { return 7; } 
}

class DVD extends LibraryItem implements Reservable {
    public DVD(String id, String title, String author) { super(id, title, author); }

    @Override
    public int getLoanDuration() { return 3; } 
    @Override
    public void reserveItem(String name) {
        System.out.println("DVD '" + getTitle() + "' reserved for " + name);
    }

    @Override
    public boolean checkAvailability() { return !isBorrowed(); }
}
class LibraryManagementSystem {
    public static void main(String[] args) {
       
        LibraryItem[] inventory = {
            new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald"),
            new Magazine("M001", "National Geographic", "Various"),
            new DVD("D001", "Inception", "Christopher Nolan")
        };

        System.out.println("--- Library Inventory Report ---\n");

        for (LibraryItem item : inventory) {
            
            System.out.println(item.getItemDetails());

           
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

           
            if (item instanceof Reservable) {
                Reservable res = (Reservable) item;
                if (res.checkAvailability()) {
                    res.reserveItem("John Doe");
                }
            } else {
                System.out.println("Note: Magazines cannot be reserved.");
            }
            System.out.println("-----------------------------------");
        }
    }
}