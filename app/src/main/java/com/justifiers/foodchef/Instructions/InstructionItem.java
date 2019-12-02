package com.justifiers.foodchef.Instructions;

import java.io.Serializable;

public class InstructionItem implements Serializable {

    String rDescription;
    String videoUrl;

    public InstructionItem() {}

    public InstructionItem(String rDescription, String videoUrl) {
        this.rDescription = rDescription;
        this.videoUrl = videoUrl;
    }

    public String getrDescription() {
        return rDescription;
    }

    public void setrDescription(String rDescription) {
        this.rDescription = rDescription;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @Override
    public String toString() {
        return "InstructionItem{" +
                "rDescription='" + rDescription + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                '}';
    }
}
