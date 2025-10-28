package com.example.cyoaengine;

public abstract class switchingDevice extends Interactable{
    private int states;
    private Interactable controls;
    private int currentState;
    private int triggerState;
    private boolean locksInTrigger;

    public switchingDevice(String name, String description, String asciiArt, int states, Interactable controls, int currentState, int triggerState, boolean locksInTrigger) {
        super(name, description, asciiArt);
        this.states = states;
        this.controls = controls;
        this.currentState = currentState;
        this.triggerState = triggerState;
        this.locksInTrigger = locksInTrigger;
    }

    public int getStates() {
        return states;
    }

    public void setStates(int states) {
        this.states = states;
    }

    public Interactable getControls() {
        return controls;
    }

    public void setControls(Interactable controls) {
        this.controls = controls;
    }

    public int getCurrentState() {
        return currentState;
    }

    public void setCurrentState(int currentState) {
        this.currentState = currentState;
    }

    public int getTriggerState() {
        return triggerState;
    }

    public void setTriggerState(int triggerState) {
        this.triggerState = triggerState;
    }

    public boolean isLocksInTrigger() {
        return locksInTrigger;
    }

    public void setLocksInTrigger(boolean locksInTrigger) {
        this.locksInTrigger = locksInTrigger;
    }
}
