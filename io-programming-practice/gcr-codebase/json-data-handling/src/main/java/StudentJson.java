import com.fasterxml.jackson.databind.ObjectMapper;

class Student {
    private String name;
    private int age;
    
   
    public Student() {}

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
       
    }

    // getters & setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

   
}
public class StudentJson {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Student st = new Student("ayush",22);
            // Convert Java Object to JSON String
            String jsonString = objectMapper.writeValueAsString(st);
            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
