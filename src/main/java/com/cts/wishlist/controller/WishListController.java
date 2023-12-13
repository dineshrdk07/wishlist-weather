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

        @GetMapping("/search/{id}")
        public Wishlist getTrack(@PathVariable("id") String id){
            return wishListService.getTrack(id);
        }
        @DeleteMapping("/delete/{id}")
        public void deleteTrack(@PathVariable("id") String id){
             wishListService.deleteTrack(id);
        }
}
