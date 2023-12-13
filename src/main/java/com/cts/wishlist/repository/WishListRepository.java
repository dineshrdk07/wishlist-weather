package com.cts.wishlist.repository;

import com.cts.wishlist.model.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface WishListRepository extends MongoRepository<Track,String> {
    Optional<Track> findById(String id);
}
