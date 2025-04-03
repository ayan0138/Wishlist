package com.example.wishlistproject.service;
import com.example.wishlistproject.model.User;
import com.example.wishlistproject.model.Wishlist;
import com.example.wishlistproject.repository.UserRepository;
import com.example.wishlistproject.repository.WishlistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    private final WishlistRepository wishlistRepository;
    private final UserRepository userRepository;

    public WishlistService(WishlistRepository wishlistRepository, UserRepository userRepository) {
        this.wishlistRepository = wishlistRepository;
        this.userRepository = userRepository;
    }

    public Wishlist createWishlist(String name, String description, String imageUrl,Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Bruger ikke fundet"));

        Wishlist wishlist = new Wishlist();
        wishlist.setName(name);
        wishlist.setDescription(description);
        wishlist.setImageUrl(imageUrl);
        wishlist.setUser(user);

        return wishlistRepository.save(wishlist);
    }

    public Wishlist saveWishlist(Wishlist wishlist){
       return wishlistRepository.save(wishlist); /** Save the wishlist object to the database **/
    }

    // Hent alle ønskesedler for en bestemt bruger
    public List<Wishlist> getWishlistsForUser(Long userId) {
        return wishlistRepository.findByUser_userId(userId); // matcher repository
    }

    public List<Wishlist> getAllWishlists() {
        return wishlistRepository.findAll();
    }
}
