package com.cts.wishlist.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Track {
        @DBRef
        private Album album;
        private Integer duration_ms;
        private String href;
        @Id
        private String Id;
        private String name;
        private String preview_url;
        private String type;
        private String uri;
}
