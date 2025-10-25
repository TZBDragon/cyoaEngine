package com.example.cyoaengine;

import java.util.List;

public class Room {
    public Room(String name, String enterText, List<Exits> exits, List<Item> items) {
        this.name = name;
        this.enterText = enterText;
        this.exits = exits;
        this.items = items;
    }

    public Room(String name, String enterText) {
        this.name = name;
        this.enterText = enterText;
        exits = null;
        items = null;
    }

    public void setExits(List<Exits> exits) {
        this.exits = exits;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setEnterText(String enterText) {
        this.enterText = enterText;
    }

    public String getEnterText() {
        return enterText;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Exits> getExits() {
        return exits;
    }

    public List<Item> getItems() {
        return items;
    }

    public void removeItem(int i) {
        items.remove(i);
    }

    private String name;
    private String enterText;
    private List<Exits> exits;
    private List<Item> items;

}