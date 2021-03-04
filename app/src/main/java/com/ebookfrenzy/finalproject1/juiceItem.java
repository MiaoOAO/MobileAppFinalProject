package com.ebookfrenzy.finalproject1;

import android.widget.TextView;

public class juiceItem {

    private int imageResourse;
    private String title;
    private String key_id;
    private String favStatus;
    private String category;
    private String country;
    private String instructions;
    private String ingredient;
    private String measure;

    public juiceItem(){
    }

    public juiceItem(int imageResourse, String title, String key_id, String favStatus,String category,String country,String instructions,String ingredient,String measure) {
        this.imageResourse = imageResourse;
        this.title = title;
        this.key_id = key_id;
        this.favStatus = favStatus;
        this.category = category;
        this.country = country;
        this.instructions = instructions;
        this.ingredient = ingredient;
        this.measure = measure;
    }

    public int getImageResourse() {
        return imageResourse;
    }

    public void setImageResourse(int imageResourse) {
        this.imageResourse = imageResourse;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getFavStatus() { return favStatus; }

    public void setFavStatus(String favStatus) {
        this.favStatus = favStatus;
    }

    public String getCategory() { return category; }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCountry() { return country; }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getInstructions() { return instructions; }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getIngredient() { return ingredient; }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getMeasure() { return measure; }

    public void setMeasure(String measure) {
        this.measure = measure;
    }
}
