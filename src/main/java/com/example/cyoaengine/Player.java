package com.example.cyoaengine;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public Player(String name, List<Item> inventory) {
        this.name = name;
        this.inventory = inventory;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void removeItem(int i) {
        inventory.remove(i);
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    private String name;
    private List<Item> inventory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // Need to implement a way to track clues/hints and add them to the player
    // I'm tempted to add solved puzzles and other small details as well
    // That way the player class can be saved as a almost progress class

}