package com.cts.wishlist.repository;

import com.cts.wishlist.model.Wishlist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface WishListRepository extends MongoRepository<Wishlist,String> {
    Wishlist findByUserId(String userId);
    Wishlist deleteByUserId(String userId);
}
