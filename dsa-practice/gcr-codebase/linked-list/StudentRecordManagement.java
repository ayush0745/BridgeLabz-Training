class Student {
    public String name;
    public int age;
    public char grade;
    public int roll_number;
    Student next;

    public Student(String name, int age, char grade, int roll_number) {
        this.age = age;
        this.name = name;
        this.grade = grade;
        this.roll_number = roll_number;
        this.next = null;
    }
}

class Record {
    Student head;
    Student tail;
    int size;

    // Add at beginning
    public void addAtBeginning(String name, int age, char grade, int roll) {
        Student newStudent = new Student(name, age, grade, roll);
        if (head == null) {
            head = tail = newStudent;
        } else {
            newStudent.next = head;
            head = newStudent;
        }
        size++;
    }

    // Add at end
    public void addAtEnd(String name, int age, char grade, int roll) {
        Student newStudent = new Student(name, age, grade, roll);
        if (head == null) {
            head = tail = newStudent;
        } else {
            tail.next = newStudent;
            tail = newStudent;
        }
        size++;
    }

    // Add at specific position (1-based index)
    public void addAtPosition(String name, int age, char grade, int roll, int position) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 1) {
            addAtBeginning(name, age, grade, roll);
            return;
        }

        if (position == size + 1) {
            addAtEnd(name, age, grade, roll);
            return;
        }

        Student newStudent = new Student(name, age, grade, roll);
        Student temp = head;

        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
        }

        newStudent.next = temp.next;
        temp.next = newStudent;
        size++;
    }

    // Delete by Roll Number
    public void deleteByRollNumber(int roll) {
        if (head == null) {
            System.out.println("Record is empty");
            return;
        }

        if (head.roll_number == roll) {
            head = head.next;
            size--;
            return;
        }

        Student temp = head;
        while (temp.next != null && temp.next.roll_number != roll) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student not found");
        } else {
            if (temp.next == tail) {
                tail = temp;
            }
            temp.next = temp.next.next;
            size--;
        }
    }

    // Search by Roll Number
    public Student searchByRollNumber(int roll) {
        Student temp = head;
        while (temp != null) {
            if (temp.roll_number == roll) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Update Grade
    public void updateGrade(int roll, char newGrade) {
        Student student = searchByRollNumber(roll);
        if (student == null) {
            System.out.println("Student not found");
        } else {
            student.grade = newGrade;
            System.out.println("Grade updated successfully");
        }
    }

    // Display all students
    public void displayRecords() {
        if (head == null) {
            System.out.println("No records found");
            return;
        }

        Student temp = head;
        while (temp != null) {
            System.out.println(
                "Roll: " + temp.roll_number +
                ", Name: " + temp.name +
                ", Age: " + temp.age +
                ", Grade: " + temp.grade
            );
            temp = temp.next;
        }
    }
}

// Test Class
public class StudentRecordManagement {
    public static void main(String[] args) {
        Record record = new Record();

        record.addAtBeginning("Ayush", 21, 'A', 101);
        record.addAtEnd("Rahul", 22, 'B', 102);
        record.addAtPosition("Neha", 20, 'A', 103, 2);

        System.out.println("All Student Records:");
        record.displayRecords();

        System.out.println("\nSearching Roll No 102:");
        Student s = record.searchByRollNumber(102);
        if (s != null) {
            System.out.println(s.name + " found");
        }

        record.updateGrade(102, 'A');

        record.deleteByRollNumber(101);

        System.out.println("\nAfter Deletion:");
        record.displayRecords();
    }
}
