package com.example.wishlistproject.controller;

import com.example.wishlistproject.model.User;
import com.example.wishlistproject.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UserController {
    @Autowired
    private UserService userService;

   @PostMapping("/register")
    public String registerUser(@RequestBody User user){
       boolean success = userService.createUser(user);
       return success ? "Bruger oprettet" : "Email eksisterer allerede.";


   }

   @PostMapping("/login")
    public String loginUser(@RequestBody User loginRequest, HttpSession session){
       User user = userService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());
       if (user != null){
           session.setAttribute("userId", user.getUserId());
           return "logiin succesfuld";

       }
       return "Forkert email eller adgangskode";

   }
   @GetMapping("/logout")
    public String logout(HttpSession session){
       session.invalidate();
       return "redirect:/login";
   }
}
