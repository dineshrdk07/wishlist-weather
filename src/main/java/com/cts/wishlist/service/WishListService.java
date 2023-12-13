package com.cts.wishlist.service;

import com.cts.wishlist.model.Wishlist;
import com.cts.wishlist.repository.WishListRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class WishListService {
    @Autowired
    private WishListRepository wishListRepository;

    public Wishlist saveWishList(Wishlist wishlist){
        return wishListRepository.save(wishlist);
    }
    @Cacheable("wishlist")
    public Wishlist getTrack(String id){
         Optional<Wishlist> wishlist = wishListRepository.findById(id);
         if(wishlist.isPresent()){
             log.info("value from db");
             return wishlist.get();
         }
         return null;
    }
    public void deleteTrack(String id){
        log.info("track deleted "+ id);
        wishListRepository.deleteById(id);
    }

}
