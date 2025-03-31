package com.example.wishlistproject.model;

public class Wishlist {
    private Long wishlistId;
    private String name;
    private String description;
    private String owner;

    public Wishlist(){
        this.wishlistId = wishlistId;
        this.name = name;
        this.description = description;
        this.owner = owner;
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(User user) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "wishlistId=" + wishlistId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
