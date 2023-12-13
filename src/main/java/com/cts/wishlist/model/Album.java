package com.cts.wishlist.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class Album {
    private List<Image> images;
    private String name;
    private List<SimpleArtistResult> artists;
}
