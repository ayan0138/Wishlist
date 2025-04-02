package com.example.wishlistproject.model;
//SAMME METODE MEN MERE "CLEAN" OG LÆSBAR

import java.util.ArrayList;
import java.util.List;
public class Main2 {


    public class Main {
        public static void main(String[] args) {
            // Opret brugere
            List<User> users = new ArrayList<>();
            users.add(new User(1, "ayan@example.com", "Ayan", "hashed_password_1"));
            users.add(new User(2, "daniel@example.com", "Daniel", "hashed_password_2"));
            users.add(new User(3, "lawand@example.com", "Lawand", "hashed_password_3"));
            users.add(new User(4, "najib@example.com", "Najib", "hashed_password_4"));

            // Opret ønskesedler
            List<Wishlist> wishlists = new ArrayList<>();
            wishlists.add(new Wishlist(1, "Ayans Ønskeseddel", "Ønsker til Eid", 1));
            wishlists.add(new Wishlist(2, "Daniels Ønskeseddel", "Ønsker til Gudsmoder fødsel", 2));
            wishlists.add(new Wishlist(3, "Lawands Ønskeseddel", "Ønsker til Eid", 3));
            wishlists.add(new Wishlist(4, "Najibs Ønskeseddel", "Ønsker til fødselsdag", 4));

            // Opret produkter
            List<Product> products = new ArrayList<>();
            products.add(new Product(1, "iPhone 16", "Nyeste iPhone model", 9999.99, "https://apple.com/iphone16"));
            products.add(new Product(2, "PS5", "Sony PlayStation 5", 4999.99, "https://playstation.com/ps5"));
            products.add(new Product(3, "Louis Vuitton", "Stitch Print Embroidered Sweatshirt", 2490.00, "https://arcecarry.myshopify.com/products/louis-vuitton-stitch-print-embroidered-sweatshirt"));
            products.add(new Product(4, "Bærbar PC", "Lenovo™ ThinkPad X9 Aura Edition", 15634.99, "https://www.proshop.dk/Baerbar/Lenovo-Thinkpad-X9-14-Gen-1-14-Core-Ultra-7-32GB-1TB"));

            // Opret ønskeseddel-produkter relationer
            List<WishlistProduct> wishlistProducts = new ArrayList<>();
            wishlistProducts.add(new WishlistProduct(1, 1));
            wishlistProducts.add(new WishlistProduct(1, 2));
            wishlistProducts.add(new WishlistProduct(2, 2));
            wishlistProducts.add(new WishlistProduct(2, 4));
            wishlistProducts.add(new WishlistProduct(3, 3));
            wishlistProducts.add(new WishlistProduct(3, 4));
            wishlistProducts.add(new WishlistProduct(4, 3));
            wishlistProducts.add(new WishlistProduct(4, 1));

            // Udskriv testdata
            System.out.println("Users:");
            users.forEach(System.out::println);

            System.out.println("\nWishlists:");
            wishlists.forEach(System.out::println);

            System.out.println("\nProducts:");
            products.forEach(System.out::println);

            System.out.println("\nWishlistProducts (Relaterede ønskesedler og produkter):");
            wishlistProducts.forEach(System.out::println);
        }
    }

}
