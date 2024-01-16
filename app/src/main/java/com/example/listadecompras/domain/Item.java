package com.example.listadecompras.domain;
public class Item {
    private String nameItem;
    private boolean bought;

    public Item (String nameItem) {
        this.nameItem = nameItem;
        this.bought = false;
    }

    public String getNameItem() {
        return this.nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }

    public boolean getBought() {
        return this.bought;
    }


}