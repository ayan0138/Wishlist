package com.example.wishlistproject.model;


public class Wishlist {
    private Long wishlistId;

    private String name;
    private String description;
    private String imageUrl;

    private User user;


    public Wishlist(){
    }

    public Wishlist(Long wishlistId, String name, String description,String imageUrl, User user) {
        this.wishlistId = wishlistId;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
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

    public String getImageUrl(){
        return imageUrl;
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

    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
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
