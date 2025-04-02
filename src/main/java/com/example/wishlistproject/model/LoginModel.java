package com.example.wishlistproject.model;
//comments
public class LoginModel {

    public static class LoginForm {
        private String username;
        private String password;

        //Konstruktør
        public LoginForm() {}

        // Getters og Setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
