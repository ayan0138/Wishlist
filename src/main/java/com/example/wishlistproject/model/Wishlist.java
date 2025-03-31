package com.example.wishlistproject.model;

public class Wishlist {
    private Long wishlistId;
    private String name;
    private String description;
    private String ownerId;

    public Wishlist(Long wishlistId, String name, String description, String ownerId){
        this.wishlistId = wishlistId;
        this.name = name;
        this.description = description;
        this.ownerId = ownerId;
    }

    public Long getWishlistId() {
        return wishlistId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setWishlistId(Long wishlistId) {
        this.wishlistId = wishlistId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "wishlistId=" + wishlistId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ownerId='" + ownerId + '\'' +
                '}';
    }
}
