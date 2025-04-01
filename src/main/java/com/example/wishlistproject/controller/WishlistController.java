package com.example.wishlistproject.controller;

import com.example.wishlistproject.model.Wishlist;
import com.example.wishlistproject.service.WishlistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
;

@Controller
@RequestMapping("/wishlist")
public class WishlistController {
    private final WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    // 👇 GET: Viser formularen
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("wishlist", new Wishlist());
        return "create-wishlist"; // svarer til create-wishlist.html
    }


    // 👇 Post behandler formularen
    @PostMapping("/create")
    public String createWishlist(@ModelAttribute Wishlist wishlist, Model model) {
        wishlistService.createWishlist(
                wishlist.getName(),
                wishlist.getDescription(),
                1L // 👈  Bruger-id skal sættes korrekt (fx fra session) -
                // Midlertidigt hardcoded userId, indtil vi har login/session
        );
        return "redirect:/";  // 👈Eller en side hvor du viser ønskelisten
    }

    @GetMapping("/list")
    public String showAllWishlists(Model model) {
        model.addAttribute("wishlists", wishlistService.getAllWishlists());
        return "wishlist-list"; //  svarer til wishlist-list.html
    }
}
