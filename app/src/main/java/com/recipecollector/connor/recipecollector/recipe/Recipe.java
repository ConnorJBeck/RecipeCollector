package com.recipecollector.connor.recipecollector.recipe;

import java.util.ArrayList;
import java.util.List;


public class Recipe {

    private List<Ingredient> ingredients;
    private List<String> instructions;
    private MealCategory category;

    public Recipe() {
        ingredients = new ArrayList<>();
        instructions = new ArrayList<>();
    }


    public MealCategory getCategory() {
        return category;
    }

    public void setCategory(String category) {
        MealCategory newCategory;
        if (MealCategoryManager.contains(category)) {
            newCategory = MealCategoryManager.getCategory(category);
        } else {
            newCategory = new MealCategory(category, this);
            MealCategoryManager.addCategory(newCategory);
        }
        this.category = newCategory;
    }

    public void addIngredient(String ingredient, int amount, Measure measure) {
        IngredientItem newIngredientItem = getIngredientItem(ingredient);
        ingredients.add(new Ingredient(newIngredientItem, amount, measure, this));
    }

    public void addIngredient(String ingredient, int amount) {
        IngredientItem newIngredientItem = getIngredientItem(ingredient);
        ingredients.add(new Ingredient(newIngredientItem, amount, this));
    }

    public void addIngredient(IngredientItem ingredient, int amount, Measure measure) {
        IngredientItem newIngredientItem = getIngredientItem(ingredient.getName());
        ingredients.add(new Ingredient(newIngredientItem, amount, measure, this));
    }

    /**
     * Maybe not necessary?
     * @param ingredient
     * @param amount
     */
    public void addIngredient(IngredientItem ingredient, int amount) {
        IngredientItem newIngredientItem = getIngredientItem(ingredient.getName());
        ingredients.add(new Ingredient(newIngredientItem, amount, this));
    }

    public void removeIngredient(String ingredient) {
        ingredients.remove(new Ingredient(ingredient, 0, this));
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public void addInstruction(String instruction) {
        instructions.add(instruction);
    }

    public void removeInstruction(String instruction) {
        instructions.add(instruction);
    }

    private IngredientItem getIngredientItem(String ingredient) {
        IngredientItem newIngredientItem;
        if (!IngredientManager.getInstance().containsKey(ingredient)) {
            newIngredientItem = new IngredientItem(ingredient, this);
            IngredientManager.addIngredient(newIngredientItem);
        } else {
            newIngredientItem = IngredientManager.getIngredient(ingredient);
            newIngredientItem.addRecipe(this);
        }
        return newIngredientItem;
    }
}
