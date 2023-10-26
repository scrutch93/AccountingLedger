package com.pluralsight;

public class VendorTransaction {
    private String date;
    private String name;
    private String description;
    private float amount;

    private String action;


    public VendorTransaction(String date, String name, String description, float amount, String action) {
        this.date = date;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.action = action;


    }

    public String getDate() {
        return this.date;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public float getAmount() {
        return this.amount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAction() {
        return this.action;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return date + "|" + name + "|" + description + "|"+ amount + "|" + action;
    }
}