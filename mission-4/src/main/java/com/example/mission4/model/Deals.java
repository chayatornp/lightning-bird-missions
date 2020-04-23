package com.example.mission4.model;
import lombok.Data;
import java.util.UUID;

public @Data class Deals {
    public UUID id = UUID.randomUUID();
    public String name;
    public String originalPrice;
    public String discountedPrice;

    //GETTER & SETTER
    public String getName() {
        return name;
    }
    public String getOriginalPrice(){
        return originalPrice;
    }
    public String getDiscountedPrice(){
        return discountedPrice;
    }
    public void setId(String id) {
        this.id = UUID.fromString(id);
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }
    public void setDiscountedPrice(String discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
}