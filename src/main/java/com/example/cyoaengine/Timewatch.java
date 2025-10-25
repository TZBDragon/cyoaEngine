package com.example.cyoaengine;

public class Timewatch {
    private long startTime;
    private long stopTime;
    private long elapsedTime;
    private boolean isRunning;
    public Timewatch(){
        startTime = 0;
        stopTime = 0;
        isRunning = true;
    }
    public void stop(){
        if(isRunning){
            stopTime = System.currentTimeMillis();
            elapsedTime = stopTime - startTime;
            isRunning = false;
        }
    }
    public void start(){
        if(!isRunning){
            isRunning = true;
            startTime = System.currentTimeMillis();
        }
    }
    public void restart(){
        startTime = System.currentTimeMillis();
        isRunning = true;
    }

    public long getElapsedTime() {
        if(!isRunning) {
            return elapsedTime;
        }
        return 0;
    }
    public long getRunningTime(){
        return stopTime - startTime;
    }
}
