package com.example.wishlistproject.controller;

import com.example.wishlistproject.model.Wishlist;
import com.example.wishlistproject.service.WishlistService;
import jakarta.servlet.http.HttpSession;
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
    public String createWishlist(@ModelAttribute Wishlist wishlist, HttpSession session, Model model) {
        Object userIdObj = session.getAttribute("userId");

        if (userIdObj == null) {
            return "redirect:/login"; //dette sker hvis brugeren ikke er logget ind
        }

        Long userId = Long.valueOf(userIdObj.toString());

        wishlistService.createWishlist(
                wishlist.getName(),
                wishlist.getDescription(),
                userId
        );
        return "redirect:/list";  // Man kan se sin ønseklister
    }

    @GetMapping("/list")
    public String showUserWishlists(HttpSession session,Model model) {
        Object userIdObj = session.getAttribute("userId");

        if (userIdObj == null){
            return "redirect:/login";
        }
        Long userId = Long.valueOf(userIdObj.toString());
        model.addAttribute("wishlists", wishlistService.getWishlistsForUser(userId));
        return "wishlist-list"; //  svarer til wishlist-list.html
    }
}
//gg