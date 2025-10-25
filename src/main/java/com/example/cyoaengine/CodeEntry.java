package com.example.cyoaengine;

import java.util.ArrayList;

public class CodeEntry extends Interactable{
    private ArrayList<Integer> code;
    private String failureText;
    private String successText;
    boolean lockOrExit;
    Exits connectedExit;
    Lock connectedLock;
    int nSolved;

    public CodeEntry(String name, String description, String asciiArt, ArrayList<Integer> code, String failureText, String successText, boolean lockOrExit, Lock connectedLock, Exits connectedExit) {
        super(name, description, asciiArt);
        this.code = code;
        this.failureText = failureText;
        this.successText = successText;
        this.lockOrExit = lockOrExit;
        this.connectedLock =connectedLock;
        this.connectedExit = connectedExit;
        nSolved = 0;
    }

    public String inputCode(int attempt){
        if(code.size() > 1){
            if(code.get(nSolved) == attempt){
                nSolved++;
                if(nSolved == code.size()){
                    if(lockOrExit){

                    }else{
                        connectedExit.unlock(null);
                    }
                    return successText;
                }
            }else{
                nSolved = 0;
                return failureText;
            }
        }else{
            if(code.get(0) == attempt){
                if(lockOrExit){

                }else{
                    connectedExit.unlock(null);
                }
                return successText;
            }else{
                return failureText;
            }
        }
        return "Something Went Wrong";
    }
}
