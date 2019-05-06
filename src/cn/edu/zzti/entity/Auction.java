package cn.edu.zzti.entity;

import java.util.UUID;

/**
 * Created by guoli on 17/5/14.
 */
public class Auction {
    private String id;
    private String title;
    private String description;
    private float price;
    public Auction(String title,String disc,float price){
        this.title = title;
        this.description = disc;
        this.price = price;
        this.id = UUID.randomUUID().toString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
