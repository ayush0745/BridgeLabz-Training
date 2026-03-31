class TicketSorter {

    // Quick Sort method
    public static void quickSort(Ticket[] tickets, int low, int high) {

        if (low < high) {

            int pivotIndex = partition(tickets, low, high);

            // Recursively sort left and right partitions
            quickSort(tickets, low, pivotIndex - 1);
            quickSort(tickets, pivotIndex + 1, high);
        }
    }

    // Partition method
    private static int partition(Ticket[] tickets, int low, int high) {

        int pivot = tickets[high].price; // Choose last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {

            // Move smaller prices to left
            if (tickets[j].price <= pivot) {
                i++;
                swap(tickets, i, j);
            }
        }

        swap(tickets, i + 1, high);
        return i + 1; // Final pivot position
    }

    // Swap two tickets
    private static void swap(Ticket[] tickets, int i, int j) {
        Ticket temp = tickets[i];
        tickets[i] = tickets[j];
        tickets[j] = temp;
    }
}
