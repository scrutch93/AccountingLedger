package com.pluralsight;

public class VendorTransaction {
    private String date;
    private String name;
    private String description;
    private float amount;


    public VendorTransaction(String date, String name, String description, float amount) {
        this.date = date;
        this.name = name;
        this.description = description;
        this.amount = amount;


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

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}