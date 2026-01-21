class MealGenerator {

    public static <T extends MealPlan> Meal<T> generateMeal(
            String userName, T mealPlan) {

        if (mealPlan.getCalories() > 900) {
            throw new IllegalArgumentException("Calorie limit exceeded!");
        }
        return new Meal<>(userName, mealPlan);
    }
}
