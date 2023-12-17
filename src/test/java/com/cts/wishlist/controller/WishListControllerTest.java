package com.cts.wishlist.controller;

import com.cts.wishlist.model.Wishlist;
import com.cts.wishlist.service.WishListService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(WishListController.class)
class WishListControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WishListService mockWishListService;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testSaveTrack() throws Exception {

        Wishlist wishlist = new Wishlist();
        wishlist.setId("id");
        wishlist.setTrackName("trackName");
        wishlist.setArtistName("artistName");
        when(mockWishListService.saveWishList(wishlist)).thenReturn(wishlist);


        String requestBody = mapper.writeValueAsString(wishlist);
        MockHttpServletResponse response = mockMvc.perform(post("/wishlist/v1/create")
                .content(requestBody).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();


        assertEquals(response.getStatus(), HttpStatus.OK.value());
    }

    @Test
    void testGetTrack() throws Exception {

        Wishlist wishlist = new Wishlist();
        wishlist.setId("id");
        wishlist.setTrackName("trackName");
        wishlist.setArtistName("artistName");
        when(mockWishListService.getTrack("id")).thenReturn(wishlist);


        MockHttpServletResponse response = mockMvc.perform(get("/wishlist/v1/search/{id}", "id")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();


        assertEquals(response.getStatus(), HttpStatus.OK.value());

    }

    @Test
    void testDeleteTrack() throws Exception {

        MockHttpServletResponse response = mockMvc.perform(delete("/wishlist/v1/delete/{id}", "id")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertEquals(response.getStatus(), HttpStatus.OK.value());
        verify(mockWishListService).deleteTrack("id");
    }
}
