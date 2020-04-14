package com.example.mission2;
import lombok.Data;
@Data
public class Deals {
    private String id;
    private String name;
    private String originalPrice;
    private String discountedPrice;
    public Deals(String id, String name, String originalPrice, String discountedPrice) {
        this.id = id;
        this.name = name;
        this.originalPrice = originalPrice;
        this.discountedPrice = discountedPrice;
    }
}



