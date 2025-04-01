package com.example.wishlistproject.model;

public class Wishlist {
    private Long wishlistId;
    private String name;
    private String description;
    private int ownerId;

    public Wishlist(){

    }

    public Wishlist(Long wishlistId, String name, String description, int ownerId) {
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

    public int getOwnerId() {
        return ownerId;
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

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public void setOwner(User owner) {
        this.ownerId = ownerId;
    }

}
