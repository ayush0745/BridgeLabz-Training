class ResumeEvaluator {

    public static <T extends JobRole> void evaluateResume(Resume<T> resume) {
        System.out.println(
            "Evaluating resume of " + resume.getCandidateName() +
            " for role: " + resume.getJobRole().getRoleName()
        );
        System.out.println("Key Skill Required: " +
            resume.getJobRole().getKeySkill());
        System.out.println("Experience: " +
            resume.getExperience() + " years\n");
    }
}
