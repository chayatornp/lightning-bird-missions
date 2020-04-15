package com.example.mission2;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;
public @Data @NoArgsConstructor class Deals {
    private UUID id = UUID.randomUUID();
    private String name;
    private String originalPrice;
    private String discountedPrice;
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



