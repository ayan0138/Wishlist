package com.example.wishlistproject.controller;


import com.example.wishlistproject.model.LoginModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String showLoginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());  // Sender LoginForm til visningen
        return "login";  // Returnerer login.html
    }

    @PostMapping
    public String processLogin(@ModelAttribute LoginForm loginForm, Model model) {
        // Validér login
        if ("admin".equals(loginForm.getUsername()) && "password123".equals(loginForm.getPassword())) {
            return "redirect:/wishlist/list";  // Redirect ved succes
        } else {
            model.addAttribute("error", "Ugyldigt brugernavn eller adgangskode");
            return "login";  // Send formularen tilbage med fejlmeddelelse
        }
    }
}


