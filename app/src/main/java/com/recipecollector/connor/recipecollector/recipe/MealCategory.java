package com.recipecollector.connor.recipecollector.recipe;


import java.util.ArrayList;
import java.util.List;

public class MealCategory {

    private String category;
    private List<Recipe> recipes;


    public MealCategory(String category, Recipe recipe) {
        this.category = category;
        recipes = new ArrayList<>();
        recipes.add(recipe);
    }

    public MealCategory(String category) {
        this.category = category;
        recipes = new ArrayList<>();
    }

    public String getCategory() {
        return category;
    }
}
