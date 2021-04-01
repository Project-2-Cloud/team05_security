package com.example.product;

public class Consultant {

    private String id;
    private String name;
    private String shortSummary;
    private String description;
    private String thumbnail_url;
    private float price;

    public Consultant() {

    }

    public Consultant(String id, String name, String shortSummary, String description, String thumbnail_url, float price) {
        super();
        this.id = id;
        this.name = name;
        this.shortSummary = shortSummary;
        this.description = description;
        this.thumbnail_url = thumbnail_url;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getShortSummary() {
        return this.shortSummary;
    }

    public void setShortSummary(String summary) {
        this.shortSummary = summary;
    }

    }