package com.cts.wishlist.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Wishlist {
    @Id
    private String userId;
    private String city;
}
