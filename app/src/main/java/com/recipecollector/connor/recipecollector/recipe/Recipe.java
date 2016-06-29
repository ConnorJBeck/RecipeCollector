package com.recipecollector.connor.recipecollector.recipe;

import java.util.ArrayList;
import java.util.List;


public class Recipe {

    private List<Ingredient> ingredients;
    private List<Instruction> instructions;
    private MealCategory category;

    public Recipe() {
        ingredients = new ArrayList<>();
        instructions = new ArrayList<>();
    }


    public MealCategory getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = new MealCategory(category);
    }

    public void addIngredient(String ingredient, int amount, Measure measure) {

        IngredientItem newIngredientItem = getIngredientFromManager(ingredient);
        ingredients.add(new Ingredient(newIngredientItem, amount, measure, this));
    }

    public void addIngredient(String ingredient, int amount) {
        IngredientItem newIngredientItem = getIngredientFromManager(ingredient);
        ingredients.add(new Ingredient(ingredient, amount, this));
    }

    public void addIngredient(IngredientItem ingredient, int amount, Measure measure) {
        IngredientItem newIngredientItem = getIngredientFromManager(ingredient.getName());
        ingredients.add(new Ingredient(ingredient, amount, measure, this));
    }

    /**
     * Maybe not necessary?
     * @param ingredient
     * @param amount
     */
    public void addIngredient(IngredientItem ingredient, int amount) {
        IngredientItem newIngredientItem = getIngredientFromManager(ingredient.getName());
        ingredients.add(new Ingredient(ingredient, amount, this));
    }

    public void removeIngredient(String ingredient) {
        ingredients.remove(new Ingredient(ingredient, 0, this));
    }

    private IngredientItem getIngredientFromManager(String ingredient) {
        IngredientItem newIngredientItem;
        if (!IngredientManager.getInstance().containsKey(ingredient)) {
            newIngredientItem = new IngredientItem(ingredient, this);
            IngredientManager.addIngredient(newIngredientItem);
        } else {
            newIngredientItem = IngredientManager.getIngredient(ingredient);
        }
        return newIngredientItem;
    }
}
