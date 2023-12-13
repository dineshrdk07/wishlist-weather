package com.cts.wishlist.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class SimpleArtistResult {
    private String name;
}
