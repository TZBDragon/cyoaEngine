package com.example.cyoaengine;

public class Item extends Interactable{
    public Item(String name, String itemDescription, String asciiArt, String inventoryDesc) {
        super(name, itemDescription, asciiArt);
        this.inventoryDesc = inventoryDesc;
    }
    private String inventoryDesc;

    public String getInventoryDesc() {
        return inventoryDesc;
    }

    public void setInventoryDesc(String inventoryDesc) {
        this.inventoryDesc = inventoryDesc;
    }
}