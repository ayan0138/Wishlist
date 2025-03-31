package com.example.wishlistproject.model;

import java.util.List;

public class UserManager extends User{
    private List<Wishlist> wishlists;
    private List<Reservation> reservations;

    public UserManager(int userId, String email, String name, String password,
                       List<Wishlist> wishlists, List<Reservation> reservations){
        super(userId, email, name, password);
        this.wishlists = wishlists;
        this.reservations = reservations;
    }

    public List<Wishlist> getWishlists(){
        return wishlists;
    }

    public void setWishlists(List<Wishlist> wishlists){
        this.wishlists = wishlists;
    }

    public List<Reservation> getReservations(){
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "UserManager{" +
                "userId=" + getUserId() +
                ", email='" + getEmail() + '\'' +
                ", name='" + getName() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", wishlists=" + wishlists +
                ", reservations=" + reservations +
         '}';
    }
}
