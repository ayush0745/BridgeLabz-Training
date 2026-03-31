import java.util.List;

class ScreeningPipeline {

    public static void processRoles(List<? extends JobRole> roles) {
        for (JobRole role : roles) {
            System.out.println(
                "AI Screening enabled for role: " +
                role.getRoleName()
            );
        }
    }
}
