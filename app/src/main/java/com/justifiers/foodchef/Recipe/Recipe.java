package com.justifiers.foodchef.Recipe;


import com.justifiers.foodchef.Instructions.InstructionItem;

import java.util.List;

public class Recipe {

    private Object ingredients;
    private String likes;
    private String rImage;
    private String rName;
    private String rNameFr;
    private String rNameUk;
    private String rNameHi;
    private String rTime;
    private String rType;
    private String rTypeFr;
    private String rTypeUk;
    private String rTypeHi;
    private String rVideo;
    private List<InstructionItem> rInstructionSteps;

    public Recipe(Object ingredients, String likes, String rImage, String rName, String rNameFr, String rNameUk, String rNameHi, String rTime, String rType, String rTypeFr, String rTypeUk, String rTypeHi, String rVideo, List<InstructionItem> rInstructionSteps) {
        this.ingredients = ingredients;
        this.likes = likes;
        this.rImage = rImage;
        this.rName = rName;
        this.rNameFr = rNameFr;
        this.rNameUk = rNameUk;
        this.rNameHi = rNameHi;
        this.rTime = rTime;
        this.rType = rType;
        this.rTypeFr = rTypeFr;
        this.rTypeUk = rTypeUk;
        this.rTypeHi = rTypeHi;
        this.rVideo = rVideo;
        this.rInstructionSteps = rInstructionSteps;
    }

    public Recipe() {
    }

    public String getrNameFr() {
        return rNameFr;
    }

    public void setrNameFr(String rNameFr) {
        this.rNameFr = rNameFr;
    }

    public String getrNameUk() {
        return rNameUk;
    }

    public void setrNameUk(String rNameUk) {
        this.rNameUk = rNameUk;
    }

    public String getrNameHi() {
        return rNameHi;
    }

    public void setrNameHi(String rNameHi) {
        this.rNameHi = rNameHi;
    }

    public String getrTypeFr() {
        return rTypeFr;
    }

    public void setrTypeFr(String rTypeFr) {
        this.rTypeFr = rTypeFr;
    }

    public String getrTypeUk() {
        return rTypeUk;
    }

    public void setrTypeUk(String rTypeUk) {
        this.rTypeUk = rTypeUk;
    }

    public String getrTypeHi() {
        return rTypeHi;
    }

    public void setrTypeHi(String rTypeHi) {
        this.rTypeHi = rTypeHi;
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

    public void setRType(String rType) {
        this.rType = rType;
    }

    public String getrVideo() {
        return rVideo;
    }

    public void setrVideo(String rVideo) {
        this.rVideo = rVideo;
    }

    public List<InstructionItem> getrInstructionSteps() {
        return rInstructionSteps;
    }

    public void setrInstructionSteps(List<InstructionItem> rInstructionSteps) {
        this.rInstructionSteps = rInstructionSteps;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "ingredients=" + ingredients +
                ", likes='" + likes + '\'' +
                ", rImage='" + rImage + '\'' +
                ", rName='" + rName + '\'' +
                ", rNameFr='" + rNameFr + '\'' +
                ", rNameUk='" + rNameUk + '\'' +
                ", rNameHi='" + rNameHi + '\'' +
                ", rTime='" + rTime + '\'' +
                ", rType='" + rType + '\'' +
                ", rTypeFr='" + rTypeFr + '\'' +
                ", rTypeUk='" + rTypeUk + '\'' +
                ", rTypeHi='" + rTypeHi + '\'' +
                ", rVideo='" + rVideo + '\'' +
                ", rInstructionSteps=" + rInstructionSteps +
                '}';
    }
}
