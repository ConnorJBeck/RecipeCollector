package com.recipecollector.connor.recipecollector.recipe;


import java.util.HashSet;
import java.util.Set;

public class IngredientItem {

    private String name;
    private Set<Recipe> recipes;


    public IngredientItem(String name, Recipe recipe) {
        this.name = name;
        recipes = new HashSet<>();
        recipes.add(recipe);
    }

    public String getName() {
        return name;
    }

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    public void removeRecipe(Recipe recipe) {
        recipes.remove(recipe);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IngredientItem that = (IngredientItem) o;

        return name.equals(that.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
