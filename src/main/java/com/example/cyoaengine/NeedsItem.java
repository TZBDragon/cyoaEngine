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
}
