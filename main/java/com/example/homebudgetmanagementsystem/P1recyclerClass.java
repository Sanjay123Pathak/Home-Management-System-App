package com.example.homebudgetmanagementsystem;

public class P1recyclerClass {
    int image;
    String name,itemCost,description ,dateText;

    public P1recyclerClass(int image, String name, String itemCost, String description, String dateText) {
        this.image = image;
        this.name = name;
        this.itemCost = itemCost;
        this.description = description;
        this.dateText = dateText;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItemCost() {
        return itemCost;
    }

    public void setItemCost(String itemCost) {
        this.itemCost = itemCost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateText() {
        return dateText;
    }

    public void setDateText(String dateText) {
        this.dateText = dateText;
    }
}
