package com.example.wishlistproject.model;

import java.time.LocalDate;

public class WishlistProduct {
    private int wishlistId;
    private int productId;
    private LocalDate dateAdded;

    public WishlistProduct(int wishlistProductId, int wishlistId, int productId, LocalDate dateAdded){
        this.wishlistId = wishlistId;
        this.productId = productId;
        this.dateAdded = dateAdded;
    }

    public WishlistProduct(int wishlistProductId, int wishlistId) {
    }

    public int getWishlistId() {
        return wishlistId;
    }

    public int getProductId() {
        return productId;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setWishlistId(int wishlistId) {
        this.wishlistId = wishlistId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public String toString() {
        return "WishlistProduct{" +
                "wishlistId=" + wishlistId +
                ", productId=" + productId +
                ", dateAdded=" + dateAdded +
                '}';
    }
}
