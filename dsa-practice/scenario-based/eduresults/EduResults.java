public class EduResults {

    public static void main(String[] args) {

        Student[] students = {
            new Student(85, "Aman"),
            new Student(92, "jay"),
            new Student(85, "sandeep"),
            new Student(78, "arpit"),
            new Student(92, "ayush")
        };

        System.out.println("Before Sorting:");
        for (Student s : students) {
            System.out.println(s.name + " - " + s.marks);
        }

        mergeSort(students, 0, students.length - 1);

        System.out.println("\nFinal State-wise Rank List:");
        for (Student s : students) {
            System.out.println(s.name + " - " + s.marks);
        }
    }

    // ---- Merge Sort Logic ----

    static void mergeSort(Student[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(Student[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Student[] L = new Student[n1];
        Student[] R = new Student[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            // Stable sort
            if (L[i].marks <= R[j].marks)
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }
}
