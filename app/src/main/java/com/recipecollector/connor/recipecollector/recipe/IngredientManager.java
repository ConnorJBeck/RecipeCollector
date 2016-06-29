package com.recipecollector.connor.recipecollector.recipe;

import java.util.*;

public class IngredientManager {

    private static Map<String,IngredientItem> ingredientList;

    private IngredientManager() {
        ingredientList = new HashMap<>();
    }

    public static Map<String,IngredientItem> getInstance() {
        if (ingredientList == null) {
            new IngredientManager();
        }
        return Collections.unmodifiableMap(ingredientList);
    }

    public static void addIngredient(IngredientItem ingredient) {
        ingredientList.put(ingredient.getName(), ingredient);
    }

    public static boolean contains(String ingredientName) {
        return ingredientList.containsKey(ingredientName);
    }

    public static IngredientItem getIngredient(IngredientItem ingredient) {
        return ingredientList.get(ingredient.getName());
    }

    public static IngredientItem getIngredient(String ingredientName) {
        return ingredientList.get(ingredientName);
    }




}
