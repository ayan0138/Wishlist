package com.example.wishlistproject.model;


public class Wishlist {
    private Long wishlistId;

    private String name;
    private String description;

    private User user;


    public Wishlist(){
    }

    public Wishlist(Long wishlistId, String name, String description, User user) {
        this.wishlistId = wishlistId;
        this.name = name;
        this.description = description;
        this.user = user;

    }

    public Wishlist(int wishlistId, String Ønskeseddel, String Ønsker, int ønskerId) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUserId(long userId) {
    }
}
