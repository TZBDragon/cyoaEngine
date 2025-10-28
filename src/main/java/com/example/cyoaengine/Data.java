package com.example.cyoaengine;

import java.util.ArrayList;

public class Data {
    private static volatile Data INSTANCE = new Data();

    private Data() {}

    public Data getData(){
        return this;
    }
}
