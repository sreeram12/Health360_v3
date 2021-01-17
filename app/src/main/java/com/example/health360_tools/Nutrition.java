package com.example.health360_tools;

import java.util.HashMap;
import java.util.Map;

public abstract class Nutrition {
    // Unit conversion
    protected static Map<String, Integer> unitConversions = new HashMap<String, Integer>() {{
        put("g", 1);
        put("kcal", 1);
        put("mg", 1000);
        put("mcg", 1000000);
    }};
    protected static String fields = "calories|total fat|total carbohydrate|dietary fiber|protein|sodium";

    protected String servingSize;
    protected Map<String, Double> info;

    @Override
    public String toString() {
        return "Nutrition{" +
                "servingSize='" + servingSize + '\'' +
                ", info=" + info +
                '}';
    }

    public String getFields() {
        return fields;
    }

    public boolean hasField(String fieldName) {
        return info.containsKey(fieldName);
    }

    public Double getField(String fieldName) {
        return info.get(fieldName);
    }

    public String getServingSize() {
        return servingSize;
    }
}
