package com.cts.wishlist.controller;

import com.cts.wishlist.model.Wishlist;
import com.cts.wishlist.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wishlist/v1")
public class WishListController {
        @Autowired
        private WishListService wishListService;

        @PostMapping("/create")
        public Wishlist saveTrack(@RequestBody Wishlist wishlist){
            return wishListService.saveWishList(wishlist);
        }

        @GetMapping("/search/{userId}")
        public Wishlist getTrack(@PathVariable("userId") String userId){
            return wishListService.getCity(userId);
        }
        @DeleteMapping("/delete/{userId}")
        public void deleteTrack(@PathVariable("userId") String id){
             wishListService.deleteCity(id);
        }
}
