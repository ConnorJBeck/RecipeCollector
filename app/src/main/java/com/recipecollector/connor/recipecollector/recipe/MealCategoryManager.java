package com.recipecollector.connor.recipecollector.recipe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MealCategoryManager {

    private static Map<String,MealCategory> mealCategories;

    private MealCategoryManager() {
        mealCategories = new HashMap<>();
    }

    public static Map<String,MealCategory> getInstance() {
        if (mealCategories == null) {
            new MealCategoryManager();
        }
        return Collections.unmodifiableMap(mealCategories);
    }

    public static void addCategory(MealCategory category) {
        mealCategories.put(category.getCategory(), category);
    }

    public static boolean contains(String category) {
        return mealCategories.containsKey(category);
    }

    public static MealCategory getCategory(MealCategory category) {
        return mealCategories.get(category.getCategory());
    }

    public static MealCategory getCategory(String category) {
        return mealCategories.get(category);
    }


}
