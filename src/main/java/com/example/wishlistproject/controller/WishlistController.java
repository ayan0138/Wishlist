package com.example.wishlistproject.controller;

import com.example.wishlistproject.model.Wishlist;
import com.example.wishlistproject.service.WishlistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/") // Previously ("/wishlist") -> removed!
public class WishlistController {

    private final WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    // 👇 GET: Displays the form to create a wishlist
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("wishlist", new Wishlist());
        return "create-wishlist"; // corresponds to create-wishlist.html
    }

    // 👇 POST: Processes the form for creating a wishlist
    @PostMapping("/create")
    public String createWishlist(@ModelAttribute Wishlist wishlist, Model model) {
        wishlistService.createWishlist(
                wishlist.getName(),
                wishlist.getDescription(),
                1L // User-id should be set correctly (e.g., from session)
        );
        return "redirect:/wishlist/list"; // Redirect to wishlist view
    }

    @GetMapping("/list")
    public String showAllWishlists(Model model) {
        model.addAttribute("wishlists", wishlistService.getAllWishlists());
        return "wishlist-list"; // corresponds to wishlist-list.html
    }

    // 👇 GET: Displays the login form
    @GetMapping("/login")
    public String showLoginForm() {
        return "login-front";  // This returns login.html
    }

    // 👇 POST: Handles the login form submission
    @PostMapping("/login")
    public String processLogin(@RequestParam String email, @RequestParam String password, Model model) {
        // Here, you would validate the user credentials (e.g., check DB)
        if ("user@example.com".equals(email) && "password".equals(password)) {
            return "redirect:/wishlist/list";
        } else {  // Modal doesn't work currently
            model.addAttribute("error", "Invalid email or password");
            return "login-front";  // Reload login page with error message
        }
    }

    // 👇 GET: Displays the welcome page after successful login
    @GetMapping("/welcome")
    public String showWelcomePage() {
        return "welcome";  // This renders the welcome page after login
    }
}