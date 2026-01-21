public class Main{
    public static void main(String[] args) {

        Meal<VegetarianMeal> vegMeal =
            MealGenerator.generateMeal("Ayush", new VegetarianMeal());

        Meal<VeganMeal> veganMeal =
            MealGenerator.generateMeal("Riya", new VeganMeal());

        Meal<KetoMeal> ketoMeal =
            MealGenerator.generateMeal("Aman", new KetoMeal());

        System.out.println(vegMeal.getUserName() + " → " +
                vegMeal.getMealPlan().getMealType());

        System.out.println(veganMeal.getUserName() + " → " +
                veganMeal.getMealPlan().getMealType());

        System.out.println(ketoMeal.getUserName() + " → " +
                ketoMeal.getMealPlan().getMealType());
    }
}
