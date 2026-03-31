// This program demonstrates reading a custom @Author annotation at runtime using reflection.
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

@Author(name = "Author Name")
class AnnotatedClass {
    public void doWork() {
        System.out.println("Working...");
    }
}

public class AuthorAnnotationReflection {
    public static void main(String[] args) {
        Class<AnnotatedClass> cls = AnnotatedClass.class;
        if (cls.isAnnotationPresent(Author.class)) {
            Author author = cls.getAnnotation(Author.class);
            System.out.println("Author name : " + author.name());
        } else {
            System.out.println("No @Author *annotation present.");
        }
    }
}


