package com.example.cyoaengine;

public class NeedsItem extends Interactable{
    Item required;
    String successText;
    boolean lockOrExit;
    Exits connectedExit;
    Lock connectedLock;
    public NeedsItem(String name, String description, String asciiArt, Item required, String successText, boolean lockOrExit, Lock connectedLock, Exits connectedExit) {
        super(name, description, asciiArt);
        this.required = required;
        this.successText = successText;
        this.lockOrExit = lockOrExit;
        this.connectedLock = connectedLock;
        this.connectedExit = connectedExit;
    }

    public String attemptSolve(Item item){
        if(item == required){
            if(lockOrExit){

            }else{
                connectedExit.unlock(null);
            }
            return successText;
        }
        return "That doesn't seem like the correct item";
    }

    public Item getRequired() {
        return required;
    }

    public void setRequired(Item required) {
        this.required = required;
    }

    public String getSuccessText() {
        return successText;
    }

    public void setSuccessText(String successText) {
        this.successText = successText;
    }

    public boolean isLockOrExit() {
        return lockOrExit;
    }

    public void setLockOrExit(boolean lockOrExit) {
        this.lockOrExit = lockOrExit;
    }

    public Exits getConnectedExit() {
        return connectedExit;
    }

    public void setConnectedExit(Exits connectedExit) {
        this.connectedExit = connectedExit;
    }

    public Lock getConnectedLock() {
        return connectedLock;
    }

    public void setConnectedLock(Lock connectedLock) {
        this.connectedLock = connectedLock;
    }
}
