package com.example.cyoaengine;

public class Lock extends Interactable{
    private boolean isLocked;
    private Interactable conceals;

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public Interactable getConceals() {
        return conceals;
    }

    public void setConceals(Interactable conceals) {
        this.conceals = conceals;
    }
    public void notIsLocked(){
        isLocked = !isLocked;
    }

    public Lock(String name, String description, String asciiArt, Interactable conceals) {
        super(name, description, asciiArt);
        isLocked = true;
        this.conceals = conceals;
    }
}
