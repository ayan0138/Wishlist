package com.example.wishlistproject.repository;

import com.example.wishlistproject.model.Wishlist;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface WishlistRepository extends JpaRepository <Wishlist, Long> {
    // Find alle ønskesedler for en bestemt bruger
    List<Wishlist> findUserById(Long userId);



}
