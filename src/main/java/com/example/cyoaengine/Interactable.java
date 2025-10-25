package com.example.cyoaengine;

public abstract class Interactable {
    private String name;
    private String description;
    private String asciiArt;

    public Interactable(String name, String description, String asciiArt){
        this.name = name;
        this.description = description;
        this.asciiArt = asciiArt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAsciiArt() {
        return asciiArt;
    }

    public void setAsciiArt(String asciiArt) {
        this.asciiArt = asciiArt;
    }
}
