package com.recipecollector.connor.recipecollector.recipe;



public class Ingredient {

    private IngredientItem ingredient;
    private int amount;
    private Measure measure;
    private String qualifier;
    private String preparatation;
    private Recipe recipe;

    public Ingredient(IngredientItem ingredient, int amount, Measure measure, Recipe recipe) {
        this.ingredient = ingredient;
        this.amount = amount;
        this.measure = measure;
        this.recipe = recipe;
    }

    public Ingredient(IngredientItem ingredient, int amount, Recipe recipe) {
        this.ingredient = ingredient;
        this.amount = amount;
        this.measure = null;
        this.recipe = recipe;
    }

    public Ingredient(String ingredient, int amount, Measure measure, Recipe recipe) {
        this.ingredient = new IngredientItem(ingredient, recipe);
        this.amount = amount;
        this.measure = measure;
        this.recipe = recipe;
    }

    public Ingredient(String ingredient, int amount, Recipe recipe) {
        this.ingredient = new IngredientItem(ingredient, recipe);
        this.amount = amount;
        this.measure = null;
        this.recipe = recipe;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }

    public IngredientItem getIngredient() {
        return ingredient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingredient that = (Ingredient) o;

        return ingredient.equals(that.ingredient);

    }

    @Override
    public int hashCode() {
        return ingredient.hashCode();
    }
}
