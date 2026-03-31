import java.util.List;
class Invoice {
    int transactionId;

    Invoice(int transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "Invoice created for Transaction ID: " + transactionId;
    }
}

public class InvoiceCreation {

    public static void main(String[] args) {

        List<Integer> transactionIds = List.of(501, 502, 503);

        // Create Invoice objects using constructor reference
        transactionIds.stream()
                      .map(Invoice::new)
                      .forEach(System.out::println);
    }
}
