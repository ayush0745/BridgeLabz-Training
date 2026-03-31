import java.util.List;

public class Main {
    public static void main(String[] args) {

        Resume<SoftwareEngineer> seResume =
            new Resume<>("Ayush", 3, new SoftwareEngineer());

        Resume<DataScientist> dsResume =
            new Resume<>("Riya", 2, new DataScientist());

        Resume<ProductManager> pmResume =
            new Resume<>("Aman", 5, new ProductManager());

        ResumeEvaluator.evaluateResume(seResume);
        ResumeEvaluator.evaluateResume(dsResume);
        ResumeEvaluator.evaluateResume(pmResume);

        List<JobRole> roles = List.of(
            new SoftwareEngineer(),
            new DataScientist(),
            new ProductManager()
        );

        ScreeningPipeline.processRoles(roles);
    }
}
