package com.example.wishlistproject.model;

public class Wishlist {
    private int wishlistId;
    private String name;
    private String description;

    public Wishlist(int wishlistId, String name, String description){
        this.wishlistId = wishlistId;
        this.name = name;
        this.description = description;
    }

    public int getWishlistId() {
        return wishlistId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setWishlistId(int wishlistId) {
        this.wishlistId = wishlistId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "wishlistId=" + wishlistId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
