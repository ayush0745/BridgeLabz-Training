class Product {
    int itemId;
    String itemName;
    int quantity;
    double price;
    Product next;

    public Product(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class ProductList {
    Product head;
    int size;

    // 1. Add at beginning
    public void addAtBeginning(int id, String name, int qty, double price) {
        Product p = new Product(id, name, qty, price);
        p.next = head;
        head = p;
        size++;
    }

    // 2. Add at end
    public void addAtEnd(int id, String name, int qty, double price) {
        Product p = new Product(id, name, qty, price);

        if (head == null) {
            head = p;
        } else {
            Product temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = p;
        }
        size++;
    }

    // 3. Add at position (1-based)
    public void addAtPosition(int pos, int id, String name, int qty, double price) {
        if (pos <= 1) {
            addAtBeginning(id, name, qty, price);
            return;
        }

        Product p = new Product(id, name, qty, price);
        Product temp = head;

        for (int i = 1; i < pos - 1 && temp.next != null; i++)
            temp = temp.next;

        p.next = temp.next;
        temp.next = p;
        size++;
    }

    // 4. Remove by Item ID
    public void removeById(int id) {
        if (head == null) return;

        if (head.itemId == id) {
            head = head.next;
            size--;
            return;
        }

        Product prev = head;
        Product curr = head.next;

        while (curr != null) {
            if (curr.itemId == id) {
                prev.next = curr.next;
                size--;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    // 5. Update quantity
    public void updateQuantity(int id, int newQty) {
        Product temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                return;
            }
            temp = temp.next;
        }
    }

    // 6. Search by ID
    public void searchById(int id) {
        Product temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                display(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    // 7. Search by Name
    public void searchByName(String name) {
        Product temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                display(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("Item not found");
    }

    // 8. Total inventory value
    public double totalInventoryValue() {
        double total = 0;
        Product temp = head;

        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        return total;
    }

    // 9. Display inventory
    public void displayInventory() {
        Product temp = head;
        while (temp != null) {
            display(temp);
            temp = temp.next;
        }
    }

    private void display(Product p) {
        System.out.println(
            "ID: " + p.itemId +
            ", Name: " + p.itemName +
            ", Qty: " + p.quantity +
            ", Price: " + p.price
        );
    }

    // 10. Merge Sort
    public void sortByName(boolean ascending) {
        head = mergeSort(head, ascending, true);
    }

    public void sortByPrice(boolean ascending) {
        head = mergeSort(head, ascending, false);
    }

    private Product mergeSort(Product h, boolean asc, boolean sortByName) {
        if (h == null || h.next == null) return h;

        Product mid = getMiddle(h);
        Product nextMid = mid.next;
        mid.next = null;

        Product left = mergeSort(h, asc, sortByName);
        Product right = mergeSort(nextMid, asc, sortByName);

        return sortedMerge(left, right, asc, sortByName);
    }

    private Product sortedMerge(Product a, Product b, boolean asc, boolean sortByName) {
        if (a == null) return b;
        if (b == null) return a;

        boolean condition;
        if (sortByName)
            condition = asc ? a.itemName.compareToIgnoreCase(b.itemName) <= 0
                            : a.itemName.compareToIgnoreCase(b.itemName) > 0;
        else
            condition = asc ? a.price <= b.price : a.price > b.price;

        if (condition) {
            a.next = sortedMerge(a.next, b, asc, sortByName);
            return a;
        } else {
            b.next = sortedMerge(a, b.next, asc, sortByName);
            return b;
        }
    }

    private Product getMiddle(Product h) {
        if (h == null) return h;

        Product slow = h, fast = h.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

public class InventryManagementSystem {
    public static void main(String[] args) {
        ProductList inventory = new ProductList();

        inventory.addAtEnd(101, "Laptop", 5, 60000);
        inventory.addAtEnd(102, "Mouse", 20, 500);
        inventory.addAtBeginning(103, "Keyboard", 10, 1500);

        System.out.println("Inventory:");
        inventory.displayInventory();

        System.out.println("\nTotal Inventory Value: " + inventory.totalInventoryValue());

        System.out.println("\nSorted by Price (Ascending):");
        inventory.sortByPrice(true);
        inventory.displayInventory();

        System.out.println("\nSearch by Name: Mouse");
        inventory.searchByName("Mouse");
    }
}
