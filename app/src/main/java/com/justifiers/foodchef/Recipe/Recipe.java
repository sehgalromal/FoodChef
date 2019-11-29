package com.justifiers.foodchef.Recipe;

public class Recipe {
    private String rImage;
    private String rname;
    private String rtime;
    private String rtype;

    private String recent_keywords;

    public Recipe() {
    }

    public Recipe(String rImage,String rname, String rtime, String rtype) {
        this.rImage = rImage;
        this.rname = rname;
        this.rtime = rtime;
        this.rtype = rtype;
    }

    public String getRtype() {
        return rtype;
    }

    public String getRecent_keywords() {
        return recent_keywords;
    }

    public void setRecent_keywords(String recent_keywords) {
        this.recent_keywords = recent_keywords;
    }

    public void setRtype(String rtype) {
        this.rtype = rtype;
    }

    public String getrImage() {
        return rImage;
    }

    public void setrImage(String rImage) {
        this.rImage = rImage;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRtime() {
        return rtime;
    }

    public void setRtime(String rtime) {
        this.rtime = rtime;
    }
}
