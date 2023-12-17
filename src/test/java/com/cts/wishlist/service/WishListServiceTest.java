package com.cts.wishlist.service;

import com.cts.wishlist.model.Wishlist;
import com.cts.wishlist.repository.WishListRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WishListServiceTest {

    @Mock
    private WishListRepository mockWishListRepository;

    @InjectMocks
    private WishListService wishListServiceUnderTest;

    @Test
    void testSaveWishList() {
        Wishlist wishlist = new Wishlist();
        wishlist.setId("id");
        wishlist.setTrackName("trackName");
        wishlist.setArtistName("artistName");


        when(mockWishListRepository.save(wishlist)).thenReturn(wishlist);

        Wishlist result = wishListServiceUnderTest.saveWishList(wishlist);

        assertThat(result).isEqualTo(wishlist);

        assertEquals(result, wishlist);
    }

    @Test
    void testGetTrack() {

        Wishlist wishlist1 = new Wishlist();
        wishlist1.setId("id");
        wishlist1.setTrackName("trackName");
        wishlist1.setArtistName("artistName");
        Optional<Wishlist> wishlist = Optional.of(wishlist1);
        when(mockWishListRepository.findById("id")).thenReturn(wishlist);

        Wishlist result = wishListServiceUnderTest.getTrack("id");

        assertEquals(result, wishlist1);
    }

    @Test
    void testGetTrack_WishListRepositoryReturnsAbsent() {

        when(mockWishListRepository.findById("id")).thenReturn(Optional.empty());

        final Wishlist result = wishListServiceUnderTest.getTrack("id");

        assertEquals(result, null);
    }

    @Test
    void testDeleteTrack() {

        wishListServiceUnderTest.deleteTrack("id");

        verify(mockWishListRepository).deleteById("id");
    }
}
