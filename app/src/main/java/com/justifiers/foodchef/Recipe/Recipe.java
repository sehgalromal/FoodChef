package com.justifiers.foodchef.Recipe;

public class Recipe {
    private Object ingredients;
    private String likes;
    private String rImage;
    private String rName;
    private String rTime;
    private String rType;

    public Recipe(Object ingredients, String likes, String rImage, String rName, String rTime, String rType) {
        this.ingredients = ingredients;
        this.likes = likes;
        this.rImage = rImage;
        this.rName = rName;
        this.rTime = rTime;
        this.rType = rType;
    }

    public Recipe() {
    }


    public Object getIngredients() {
        return ingredients;
    }

    public void setIngredients(Object ingredients) {
        this.ingredients = ingredients;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getrImage() {
        return rImage;
    }

    public void setrImage(String rImage) {
        this.rImage = rImage;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public String getrTime() {
        return rTime;
    }

    public void setrTime(String rTime) {
        this.rTime = rTime;
    }

    public String getRType() {
        return rType;
    }

    public void setRType(String RType) {
        this.rType = RType;
    }
}
