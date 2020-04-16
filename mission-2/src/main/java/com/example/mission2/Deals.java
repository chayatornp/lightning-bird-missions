package com.example.mission2;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;
public @Data @NoArgsConstructor @AllArgsConstructor class Deals {
    public UUID id = UUID.randomUUID();
    public String name;
    public String originalPrice;
    public String discountedPrice;
    public Deals(String name, String originalPrice, String discountedPrice) {
        this.name = name;
        this.originalPrice = originalPrice;
        this.discountedPrice = discountedPrice;
    }
    public String getName() {
        return name;
    }
    public UUID getId() {
        return id;
    }

}