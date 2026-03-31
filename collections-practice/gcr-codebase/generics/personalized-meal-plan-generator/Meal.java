class Meal<T extends MealPlan> {
    private final String userName;
    private final T mealPlan;

    public Meal(String userName, T mealPlan) {
        this.userName = userName;
        this.mealPlan = mealPlan;
    }

    public T getMealPlan() {
        return mealPlan;
    }

    public String getUserName() {
        return userName;
    }
}
