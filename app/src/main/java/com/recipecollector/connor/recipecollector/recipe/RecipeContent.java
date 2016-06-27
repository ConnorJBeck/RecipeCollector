package com.recipecollector.connor.recipecollector.recipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Connor on 2016-06-27.
 */
public class RecipeContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Recipe> ITEMS = new ArrayList<Recipe>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Recipe> ITEM_MAP = new HashMap<String, Recipe>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createRecipe(i));
        }
    }

    private static void addItem(Recipe item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static Recipe createRecipe(int position) {
        return new Recipe(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class Recipe {
        public final String id;
        public final String content;
        public final String details;

        public Recipe(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
