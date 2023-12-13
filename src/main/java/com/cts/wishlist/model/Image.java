package com.cts.wishlist.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Image {
    private String url;
    private Integer height;
    private Integer width;
}
